package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.usecases.interfaces.FindCandidateUseCase;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.hibernate.jpa.TypedParameterValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
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

    //GET CANDIDATE BY NAME
    @GetMapping("nemo/v1/candidate/name")
    List<Candidate> candidateByName(String name){
        return candidateRepository.findCandidateByName(name);
    }

    //GET CANDIDATE BY EMAIL
    @GetMapping("nemo/v1/candidate/email")
    List<Candidate> candidateByEmail(String email){
        return candidateRepository.findCandidateByEmail(email);
    }

    //GET CANDIDATE BY EMAIL
    @GetMapping("nemo/v1/candidate/cpf")
    List<Candidate> candidateByCpf(String cpf){
        return candidateRepository.findCandidateByCpf(cpf);
    }

    //GET CANDIDATE BY PHONE
    @GetMapping("nemo/v1/candidate/phone")
    List<Candidate> candidateByPhone(String phone){
        return candidateRepository.findCandidateByPhone(phone);
    }

    //GET CANDIDATE BY GENDER
    @GetMapping("nemo/v1/candidate/gender")
    List<Candidate> candidateByGender(String gender){
        return candidateRepository.findCandidateByGender(gender);
    }

    //GET CANDIDATE BY BIRTHDAY
    @GetMapping("nemo/v1/candidate/birthday")
    List<Candidate> candidateByBirthday(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthday){
        return candidateRepository.findCandidateByBirthday(birthday);
    }

    //GET CANDIDATE BY COUNTRY
    @GetMapping("nemo/v1/candidate/country")
    List<Candidate> candidateByCountry(String country){
        return candidateRepository.findCandidateByCountry(country);
    }

    //GET CANDIDATE BY CITY
    @GetMapping("nemo/v1/candidate/city")
    List<Candidate> candidateByCity(String city){
        return candidateRepository.findCandidateByCity(city);
    }

    //GET CANDIDATE BY NEIGHBORHOOD
    @GetMapping("nemo/v1/candidate/neighborhood")
    List<Candidate> candidateByNeighborhood(String neighborhood){
        return candidateRepository.findCandidateByNeighborhood(neighborhood);
    }

    //GET CANDIDATE BY STREET
    @GetMapping("nemo/v1/candidate/street")
    List<Candidate> candidateByStreet(String street){
        return candidateRepository.findCandidateByStreet(street);
    }

    //GET CANDIDATE BY HOMENUMBER
    @GetMapping("nemo/v1/candidate/homeNumber")
    List<Candidate> candidateByHomeNumber(Integer home_number){
        return candidateRepository.findCandidateByHomeNumber(home_number);
    }

    //GET CANDIDATE BY COMPLEMENT
    @GetMapping("nemo/v1/candidate/complement")
    List<Candidate> candidateByComplement(String complement){
        return candidateRepository.findCandidateByComplement(complement);
    }

    //GET CANDIDATE BY ZIPCODE
    @GetMapping("nemo/v1/candidate/zipcode")
    List<Candidate> candidateByZipCode(String zipcode){
        return candidateRepository.findCandidateByZipCode(zipcode);
    }

    //GET CANDIDATE BY LATITUDE
    @GetMapping("nemo/v1/candidate/latitude")
    List<Candidate> candidateByLatitude(Double latitude){
        return candidateRepository.findCandidateByLatitude(latitude);
    }

    //GET CANDIDATE BY LONGITUDE
    @GetMapping("nemo/v1/candidate/longitude")
    List<Candidate> candidateByLongitude(Double longitude){
        return candidateRepository.findCandidateByLongitude(longitude);
    }



}
