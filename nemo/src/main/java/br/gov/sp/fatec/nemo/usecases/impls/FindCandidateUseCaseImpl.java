package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCandidateUseCaseImpl implements FindCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findCandidate(String gender, String country, String city, String zipCode, String skill) {
        return candidateRepository.findCandidateByAllParams(gender, country, city, zipCode, skill);
    }
}
