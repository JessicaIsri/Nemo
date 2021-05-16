package br.gov.sp.fatec.nemo.domains.entities;

import br.gov.sp.fatec.nemo.domains.utils.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @NotNull
    private Double pretensionSalary;

    @OneToOne
    @JoinColumn(name = "desired_journey_fk", referencedColumnName = "id")
    private DesiredJourney desiredJourney;

    @OneToOne
    @JoinColumn(name = "available_period_fk", referencedColumnName = "id")
    private AvailablePeriod availablePeriod;

    @OneToOne
    @JoinColumn(name = "work_modality_fk", referencedColumnName = "id")
    private WorkModality workModality;

    @OneToMany(mappedBy = "candidate",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CandidateSkill> skills;

    @OneToMany(mappedBy = "candidate",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CandidateFormation> formations;

    @OneToMany(mappedBy = "candidate",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CandidateExp> experiences;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;

        Candidate candidate = (Candidate) o;

        if (getId() != null ? !getId().equals(candidate.getId()) : candidate.getId() != null) return false;
        if (getName() != null ? !getName().equals(candidate.getName()) : candidate.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(candidate.getEmail()) : candidate.getEmail() != null) return false;
        if (getCpf() != null ? !getCpf().equals(candidate.getCpf()) : candidate.getCpf() != null) return false;
        if (getPhone() != null ? !getPhone().equals(candidate.getPhone()) : candidate.getPhone() != null) return false;
        if (getGender() != null ? !getGender().equals(candidate.getGender()) : candidate.getGender() != null)
            return false;
        if (getBirthday() != null ? !getBirthday().equals(candidate.getBirthday()) : candidate.getBirthday() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(candidate.getCountry()) : candidate.getCountry() != null)
            return false;
        if (getCity() != null ? !getCity().equals(candidate.getCity()) : candidate.getCity() != null) return false;
        if (getNeighborhood() != null ? !getNeighborhood().equals(candidate.getNeighborhood()) : candidate.getNeighborhood() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(candidate.getStreet()) : candidate.getStreet() != null)
            return false;
        if (getHomeNumber() != null ? !getHomeNumber().equals(candidate.getHomeNumber()) : candidate.getHomeNumber() != null)
            return false;
        if (getComplement() != null ? !getComplement().equals(candidate.getComplement()) : candidate.getComplement() != null)
            return false;
        if (getZipCode() != null ? !getZipCode().equals(candidate.getZipCode()) : candidate.getZipCode() != null)
            return false;
        if (getLatitude() != null ? !getLatitude().equals(candidate.getLatitude()) : candidate.getLatitude() != null)
            return false;
        if (getLongitude() != null ? !getLongitude().equals(candidate.getLongitude()) : candidate.getLongitude() != null)
            return false;
        return getSkills() != null ? getSkills().equals(candidate.getSkills()) : candidate.getSkills() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCpf() != null ? getCpf().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getNeighborhood() != null ? getNeighborhood().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getHomeNumber() != null ? getHomeNumber().hashCode() : 0);
        result = 31 * result + (getComplement() != null ? getComplement().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getLatitude() != null ? getLatitude().hashCode() : 0);
        result = 31 * result + (getLongitude() != null ? getLongitude().hashCode() : 0);
        result = 31 * result + (getSkills() != null ? getSkills().hashCode() : 0);
        return result;
    }



}
