package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.entities.JobOpportunity;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.domains.repositories.JobOpportunityRepository;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindJobOpportunityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindJobOpportunityUseCaseImpl implements FindJobOpportunityUseCase {

    @Autowired
    private JobOpportunityRepository jobOpportunityRepository;

    @Override
    public List<JobOpportunity> findJobOpportunity(
        Long id
    ) {
        List<JobOpportunity> jos = jobOpportunityRepository.findJobOpportunityByAllParams(id);
        return jos;
    }
}

