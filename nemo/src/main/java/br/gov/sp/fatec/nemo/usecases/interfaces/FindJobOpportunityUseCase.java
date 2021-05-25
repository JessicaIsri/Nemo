package br.gov.sp.fatec.nemo.usecases.interfaces;

import br.gov.sp.fatec.nemo.domains.entities.JobOpportunity;
import br.gov.sp.fatec.nemo.usecases.dtos.JobOpportunityCriteria;

import java.util.List;

public interface FindJobOpportunityUseCase {
    List<JobOpportunity> findJobOpportunity(JobOpportunityCriteria criteria);

    JobOpportunity findById(Long id) throws Exception;

    public JobOpportunity save(JobOpportunity jobOpportunity);
}
