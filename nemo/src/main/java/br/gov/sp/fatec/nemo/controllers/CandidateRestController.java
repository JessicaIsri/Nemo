package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateRestController {

    @Autowired
    private FindCandidateUseCase findCandidateUseCase;

    @GetMapping(value = "nemo/v1/candidate", produces = "application/json")
    public ResponseEntity<List<Candidate>> getCandidate(
        @RequestParam(required = false) String gender,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String zipCode,
        @RequestParam(required = false) String skill,
        @RequestParam(required = false) Double longitude,
        @RequestParam(required = false) Double latitude,
        @RequestParam(required = false) Double kilometers
    ) {
        return Optional
            .ofNullable(findCandidateUseCase.findCandidate(gender, country, city, zipCode, skill, longitude, latitude, kilometers))
            .map(candidate -> ResponseEntity.ok().body(candidate))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

