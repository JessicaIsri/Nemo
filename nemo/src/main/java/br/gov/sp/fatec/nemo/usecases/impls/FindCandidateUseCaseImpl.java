package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if (latitude != null && longitude != null) {
            List<Long> ids = candidates.stream().map(Candidate::getId).collect(Collectors.toList());
            candidates = candidateRepository.findRadiusCandidate(longitude, latitude, ids, kilometers);
        }
        return candidates;
    }
}
