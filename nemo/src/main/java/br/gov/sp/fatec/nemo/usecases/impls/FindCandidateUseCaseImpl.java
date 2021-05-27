package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.domains.repositories.interfaces.GeometryCandidate;
import br.gov.sp.fatec.nemo.usecases.impls.dtos.CandidateDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindCandidateUseCaseImpl {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> findCandidate(
            String gender,
            String country,
            String city,
            String zipCode,
            String skill,
            Double longitude,
            Double latitude,
            Double kilometers,
            String availablePeriod,
            String course,
            String institution,
            String workModality,
            Double pretensionSalary,
            String desiredJourney,
            String companyName
    ) {
        List<Candidate> candidates = candidateRepository.findCandidateByAnyParams(gender, country, city, zipCode, availablePeriod,
                workModality,
                pretensionSalary,
                desiredJourney,
                companyName);
        if (skill != null) {
            List<Long> ids = candidates.stream().map(Candidate::getId).collect(Collectors.toList());
            candidates = candidateRepository.findCandidateBySkillAndId(ids, skill);
        }
        if (institution != null || course != null) {
            List<Long> ids = candidates.stream().map(Candidate::getId).collect(Collectors.toList());
            candidates = candidateRepository.findCandidateByCourseAndInstitutionAndId(ids, course, institution);
        }
        if (latitude != null && longitude != null) {
            List<Long> ids = candidates.stream().map(Candidate::getId).collect(Collectors.toList());
            candidates = candidateRepository.findRadiusCandidate(longitude, latitude, ids, kilometers);
        }
        return candidates;
    }

    @SneakyThrows
    public List<CandidateDTO> findCandidateV2(
        List<String> hability,
        Double longitude,
        Double latitude,
        Double kilometers) throws Exception {
        List<Candidate> candidates = null;
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
        classify.sort(new SortById());
        return classify;
    }

    private List<CandidateDTO> classifyCandidate(List<Candidate> candidates, List<String> hability, Set<GeometryCandidate> geometryCandidateSet) {
        return candidates.stream().map(candidate -> {
            int points = 0;
            CandidateDTO candidateDTO = new CandidateDTO().fromCandidateDTO(candidate);

            if (hability != null) {
                int skills = (int) candidate.getSkills()
                        .stream()
                        .filter(f -> hability.contains(f.getSkill().getDescription())).count();

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
