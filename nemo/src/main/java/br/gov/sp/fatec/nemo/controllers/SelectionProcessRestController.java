package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.controllers.dtos.SelectionProcessCandidateDTO;
import br.gov.sp.fatec.nemo.usecases.impls.FindSelectionProcessCandidateUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SelectionProcessRestController {

    @Autowired
    private FindSelectionProcessCandidateUseCaseImpl findSelectionProcessCandidateUseCase;

    @GetMapping(value = "nemo/v1/selection/jobOpportunity/{id}", produces = "application/json")
    public ResponseEntity<SelectionProcessCandidateDTO> getSelectionProcessByJobOpportunity(@PathVariable("id") Long jobOpportunityId) {
        return Optional
                .ofNullable(findSelectionProcessCandidateUseCase.findSelectionProcessCandidateByJobId(jobOpportunityId))
                .map(selection -> ResponseEntity.ok().body(selection))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
