package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.*;
import br.gov.sp.fatec.nemo.domains.enums.SkillLevel;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.domains.repositories.interfaces.GeometryCandidate;
import br.gov.sp.fatec.nemo.usecases.impls.dtos.CandidateDTO;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import br.gov.sp.fatec.nemo.usecases.interfaces.ParametersService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FindCandidateUseCaseImpl implements FindCandidateUseCase {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ParametersService parametersService;

    @Override
    public List<Candidate> findCandidate(
        String gender,
        String country,
        String city,
        String zipCode,
        String skill,
        Double longitude,
        Double latitude,
        Double kilometers
    ) {
        List<Candidate> candidates = candidateRepository.findCandidateByAllParams(gender, country, city, zipCode, skill);

        return candidates;
    }

    @SneakyThrows
    @Override
    public List<CandidateDTO> findCandidateV2(
        List<String> hability,
        Double longitude,
        Double latitude,
        Double kilometers,
        Long parameter,
        List<SkillLevel> skillLevels
    ) throws Exception {

        Set<Long> listIds = null;
        Set<Candidate> candidates = null;
        Set<GeometryCandidate> geometryCandidates = null;
        if (hability != null) {
            String habilityString = String.join(",", hability);
            listIds = candidateRepository.findCandidateWithoutGeom(habilityString);
            candidates = candidateRepository.findAllById(listIds).stream().collect(Collectors.toSet());

        } else {
            throw new Exception("Habilidades são Obrigatórias para essa pesquisa");
        }
        if (longitude != null && latitude != null) {
            geometryCandidates = candidateRepository.findRadiusCandidateInterface(
                longitude,
                latitude,
                listIds.stream().collect(Collectors.toList()),
                kilometers
            );
        }
        List<CandidateDTO> classify = null;
        if (parameter == null) {
            classify = classifyCandidate(candidates, hability, geometryCandidates);
        } else {
            classify = classifyCandidateWithParameter(candidates, hability, geometryCandidates, parameter);
        }

        Collections.sort(classify, new SortById());
        return classify;
    }

    private List<CandidateDTO> classifyCandidateWithParameter(
        Set<Candidate> candidates,
        List<String> hability,
        Set<GeometryCandidate> geometryCandidateSet,
        Long parameter
    ) throws Exception {
        Optional<Parameters> parameters = parametersService.findById(parameter);
        if (parameters.isPresent()) {
            return candidates.stream().map((candidate -> {
                Parameters param = parameters.get();
                Integer points = 0;
                CandidateDTO candidateDTO = new CandidateDTO().fromCandidateDTO(candidate);
                if (hability != null) {
                    List<CandidateSkill> skill = candidate.getSkills()
                        .stream()
                        .filter(f -> hability.contains(f.getSkill().getDescription() + "." + f.getSkillLevel())).collect(Collectors.toList());
                    Integer skills = skill.size();
                    points += (skills * param.getHability()) / hability.size();
                } else {
                    points += 50;
                }


                if (geometryCandidateSet != null) {
                    DistanceParameters distanceParameters = param.getDistanceParameters();
                    List<GeometryCandidate> geometryCandidate = geometryCandidateSet
                        .stream().filter(f -> f.getId().equals(candidate.getId()))
                        .collect(Collectors.toList());
                    Double distance = geometryCandidate.get(0).getKilometer();
                    candidateDTO.setDistance(distance);
                    if (distance >= distanceParameters.getStartLowDistance() && distance <= distanceParameters.getEndLowDistance()) {
                        points += distanceParameters.getLowDistanceValue();
                    } else if (distance >= distanceParameters.getStartMediumDistance() && distance <= distanceParameters.getEndMediumDistance()) {
                        points += distanceParameters.getMediumDistanceValue();
                    } else {
                        points += distanceParameters.getValueHighDistance();
                    }


                } else {
                    points += 50;
                }

                candidateDTO.setPoints(points);

                return candidateDTO;
            })).collect(Collectors.toList());
        } else {
            throw new Exception("Parametro não encontrado");
        }
    }

    private List<CandidateDTO> classifyCandidate(Set<Candidate> candidates, List<String> hability, Set<GeometryCandidate> geometryCandidateSet) {
        return candidates.stream().map(candidate -> {
            Integer points = 0;
            CandidateDTO candidateDTO = new CandidateDTO().fromCandidateDTO(candidate);

            if (hability != null) {

                List<CandidateSkill> skill = candidate.getSkills()
                    .stream()
                    .filter(f -> hability.contains(f.getSkill().getDescription() + "." + f.getSkillLevel())).collect(Collectors.toList());

                Integer skills = skill.size();
                points += (skills * 50) / hability.size();
            } else {
                points += 50;
            }


            if (geometryCandidateSet != null) {
                List<GeometryCandidate> geometryCandidate = geometryCandidateSet
                    .stream().filter(f -> f.getId().equals(candidate.getId()))
                    .collect(Collectors.toList());
                Double distance = geometryCandidate.get(0).getKilometer();
                candidateDTO.setDistance(distance);
                if (distance >= 0 && distance <= 20) {
                    points += 50;
                } else if (distance >= 20 && distance <= 50) {
                    points += 30;
                } else {
                    points += 15;
                }


            } else {
                points += 50;
            }


            candidateDTO.setPoints(points);

            return candidateDTO;
        }).collect(Collectors.toList());
    }


    private Integer buffHability(String hability) {
        Integer value = 0;
        switch (hability) {
            case "FIVE":
                value = 5;
                break;
            case "FOUR":
                value = 4;
                break;
            case "THREE":
                value = 3;
                break;
            case "TWO":
                value = 2;
                break;
            case "ONE":
                value = 1;
                break;
        }
        return value;
    }
}

class SortById implements Comparator<CandidateDTO> {
    public int compare(CandidateDTO candidateDTO, CandidateDTO candidateDTO2) {
        return (int) candidateDTO2.getPoints() - (int) candidateDTO.getPoints();
    }
}
