package br.gov.sp.fatec.nemo.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "candidate")
@Data
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "can_id")
    private Long id;

    @NotBlank
    @Column(name = "can_name")
    private String name;

    @Email
    private String email;

    @CPF
    private String cpf;

    @NotBlank
    private String phone;

    @NotBlank
    private String gender;

    @NotNull
    private LocalDate birthday;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String street;

    @NotBlank
    @Column(name = "home_number")
    private String homeNumber;

    @NotBlank
    private String complement;

    @NotBlank
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull
    private Float latitude;

    @NotNull
    private Float longitude;

    @OneToMany(mappedBy = "candidate")
    private Set<CandidateSkill> skills;

}
