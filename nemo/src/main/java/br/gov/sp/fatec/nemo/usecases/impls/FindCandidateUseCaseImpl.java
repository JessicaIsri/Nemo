package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
