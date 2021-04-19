package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import br.gov.sp.fatec.nemo.domains.repositories.CandidateRepository;

@RestController
public class CandidateRestController {



    @Autowired
    private FindCandidateUseCase findCandidateUseCase;

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
        @RequestParam(required = false) Double kilometers
    ) {
        return Optional
            .ofNullable(findCandidateUseCase.findCandidate(gender, country, city, zipCode, skill, longitude, latitude, kilometers))
            .map(candidate -> ResponseEntity.ok().body(candidate))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //POST CANDIDATE
    private static List<Candidate> LoadItemsFromDb(){
        List<Candidate> object = new ArrayList<Candidate>();
        return object;
    }

    private List<Candidate> candidatos = LoadItemsFromDb();

    public String addCandidate(Candidate candidate){
        candidatos.add(candidate);
        return "Candidato cadastrado com sucesso!";
    }

    @PostMapping("nemo/v1/candidate/add")
    public String criarCandidate(@RequestBody Candidate candidate){
        return addCandidate(candidate);
    }


    //GET CANDIDATE BY ID
    @GetMapping("nemo/v1/candidate/{id}")
    public Candidate candidateById(@PathVariable(value="id") Long id){
        return candidateRepository.findCandidateById(id);
    }



}
