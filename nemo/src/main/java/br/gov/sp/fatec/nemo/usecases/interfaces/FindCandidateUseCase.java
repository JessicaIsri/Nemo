package br.gov.sp.fatec.nemo.usecases.interfaces;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;

import java.util.List;

public interface FindCandidateUseCase {
    List<Candidate> findCandidate(String gender, String country, String city, String zipCode, String skill, Double longitude, Double latitude, Double kilometers);
}
