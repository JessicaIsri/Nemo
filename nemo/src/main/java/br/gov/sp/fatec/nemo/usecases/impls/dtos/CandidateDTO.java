package br.gov.sp.fatec.nemo.usecases.impls.dtos;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import br.gov.sp.fatec.nemo.domains.entities.CandidateSkill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

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

    private List<CandidateSkill> skills;

    private int points;

    private Double distance;


    public CandidateDTO fromCandidateDTO(Candidate candidate){
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId(candidate.getId());
        candidateDTO.setName(candidate.getName());
        candidateDTO.setEmail(candidate.getEmail());
        candidateDTO.setCpf(candidate.getCpf());
        candidateDTO.setPhone(candidate.getPhone());
        candidateDTO.setGender(candidate.getGender());
        candidateDTO.setBirthday(candidate.getBirthday());
        candidateDTO.setCountry(candidate.getCountry());
        candidateDTO.setCity(candidate.getCity());
        candidateDTO.setNeighborhood(candidate.getNeighborhood());
        candidateDTO.setStreet(candidate.getStreet());
        candidateDTO.setHomeNumber(candidate.getHomeNumber());
        candidateDTO.setComplement(candidate.getComplement());
        candidateDTO.setZipCode(candidate.getZipCode());
        candidateDTO.setLatitude(candidate.getLatitude());
        candidateDTO.setLongitude(candidate.getLongitude());
        candidateDTO.setSkills(candidate.getSkills());

        return candidateDTO;
    }

}
