package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CandidateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String cpf;
    private String phone;
    private String gender;
    private LocalDate birthday;
    private String country;
    private String city;
    private String neighborhood;
    private String street;
    private String homeNumber;
    private String complement;
    private String zipCode;
    private Float latitude;
    private Float longitude;
    private Double pretensionSalary;
    private DesiredJourney desiredJourney;
    private AvailablePeriod availablePeriod;
    private WorkModality workModality;
    private List<CandidateSkill> skills;
    private List<CandidateFormation> formations;
    private List<CandidateExp> experiences;

    public Candidate toCandidate() {
        Candidate newCandidate = new Candidate();
        newCandidate.setName(name);
        newCandidate.setEmail(email);
        newCandidate.setCpf(cpf);
        newCandidate.setPhone(phone);
        newCandidate.setGender(gender);
        newCandidate.setBirthday(birthday);
        newCandidate.setCountry(country);
        newCandidate.setCity(city);
        newCandidate.setNeighborhood(neighborhood);
        newCandidate.setStreet(street);
        newCandidate.setHomeNumber(homeNumber);
        newCandidate.setComplement(complement);
        newCandidate.setZipCode(zipCode);
        newCandidate.setLatitude(latitude);
        newCandidate.setLongitude(longitude);
        newCandidate.setPretensionSalary(pretensionSalary);
        newCandidate.setDesiredJourney(desiredJourney);
        newCandidate.setAvailablePeriod(availablePeriod);
        newCandidate.setWorkModality(workModality);
        newCandidate.setSkills(skills);
        newCandidate.setFormations(formations);
        newCandidate.setExperiences(experiences);
        for (CandidateExp exp : experiences) {
            exp.setCandidate(newCandidate);
        }
        for (CandidateFormation formation : formations) {
            formation.setCandidate(newCandidate);
        }
        for (CandidateSkill skill : skills) {
            skill.setCandidate(newCandidate);
        }
        return newCandidate;
    }
}
