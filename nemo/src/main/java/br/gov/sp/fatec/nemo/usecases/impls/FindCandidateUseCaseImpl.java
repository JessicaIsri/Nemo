package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.entities.CandidateSkill;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.domains.repositories.interfaces.GeometryCandidate;
import br.gov.sp.fatec.nemo.usecases.impls.dtos.CandidateDTO;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindCandidateUseCaseImpl implements FindCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

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
        Double kilometers) throws Exception {
        Set<Candidate> candidates = null;
        Set<GeometryCandidate> geometryCandidates = null;
        if (hability != null) {
            candidates = candidateRepository.findAllBySkills_Skill_DescriptionIn(hability);

        } else {
            throw new Exception("Habilidades são Obrigatórias para essa pesquisa");
        }

        if (latitude != null && longitude != null) {
            List<Long> ids = candidates.stream().map(Candidate::getId).collect(Collectors.toList());
            candidates = candidateRepository.findRadiusCandidate(longitude, latitude, ids, kilometers);
            geometryCandidates = candidateRepository.findRadiusCandidateInterface(longitude, latitude, ids, kilometers);
        }

        List<CandidateDTO> classify = classifyCandidate(candidates, hability, geometryCandidates);
        Collections.sort(classify, new SortById());
        return classify;
    }

    private List<CandidateDTO> classifyCandidate(Set<Candidate> candidates, List<String> hability, Set<GeometryCandidate> geometryCandidateSet) {
        return candidates.stream().map(candidate -> {
            Integer points = 0;
            CandidateDTO candidateDTO = new CandidateDTO().fromCandidateDTO(candidate);

            if (hability != null){
                Integer skills = candidate.getSkills()
                    .stream()
                    .filter(f -> hability.contains(f.getSkill().getDescription())).collect(Collectors.toList()).size();

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
                if (distance >= 0 && distance <= 20){
                    points += 50;
                } else if (distance >= 20 && distance <= 50){
                    points += 30;
                }
                else{
                    points += 15;
                }


            } else {
                points += 50;
            }



            candidateDTO.setPoints(points);

            return candidateDTO;
        }).collect(Collectors.toList());
    }
}

class SortById implements Comparator<CandidateDTO> {
    public int compare(CandidateDTO candidateDTO, CandidateDTO candidateDTO2) {
        return (int) candidateDTO2.getPoints() - (int) candidateDTO.getPoints();
    }
}
