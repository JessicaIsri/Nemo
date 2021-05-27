package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.enums.SkillLevel;
import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;
import br.gov.sp.fatec.nemo.usecases.impls.FindCandidateUseCaseImpl;
import br.gov.sp.fatec.nemo.usecases.impls.dtos.CandidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateRestController {

    @Autowired
    private FindCandidateUseCaseImpl findCandidateUseCase;

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping(value = "nemo/v1/candidate", produces = "application/json")
    public ResponseEntity<List<Candidate>> getCandidate(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String zipCode,
            @RequestParam(required = false) String skill,
            @RequestParam(required = false) Double longitude,
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double kilometers,
            @RequestParam(required = false) String availablePeriod,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String institution,
            @RequestParam(required = false) String workModality,
            @RequestParam(required = false) Double pretensionSalary,
            @RequestParam(required = false) String desiredJourney,
            @RequestParam(required = false) String companyName
    ) {
        return Optional
                .ofNullable(findCandidateUseCase.findCandidate(gender, country, city, zipCode, skill, longitude, latitude, kilometers, availablePeriod, course, institution, workModality, pretensionSalary, desiredJourney,
                        companyName))
                .map(candidate -> ResponseEntity.ok().body(candidate))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "nemo/v2/candidate", produces = "application/json")
    public ResponseEntity<List<CandidateDTO>> getCandidateV2(
        @RequestParam(required = false) List<String> hability,
        @RequestParam(required = false) Double longitude,
        @RequestParam(required = false) Double latitude,
        @RequestParam(required = false) Double kilometers,
        @RequestParam(required = false) Long idParameter,
        @RequestParam(required = false) List<SkillLevel> skillLevels

    ) throws Exception {
        return Optional
            .ofNullable(findCandidateUseCase
                .findCandidateV2(hability, longitude, latitude, kilometers, idParameter, skillLevels))
                .map(candidateDTOS -> ResponseEntity.ok().body(candidateDTOS))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("nemo/v1/candidate/")
    public ResponseEntity<Candidate> criarCandidate(@RequestBody CandidateRequest candidate) {
        try {
            Candidate newCandidate = candidate.toCandidate();
            candidateRepository.save(newCandidate);
            return ResponseEntity.ok().body(newCandidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
