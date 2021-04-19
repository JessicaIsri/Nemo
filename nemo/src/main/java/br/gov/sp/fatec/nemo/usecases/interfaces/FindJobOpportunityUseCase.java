package br.gov.sp.fatec.nemo.usecases.interfaces;

import br.gov.sp.fatec.nemo.domains.entities.JobOpportunity;

import java.util.List;

public interface FindJobOpportunityUseCase {
    List<JobOpportunity> findJobOpportunity();
}
