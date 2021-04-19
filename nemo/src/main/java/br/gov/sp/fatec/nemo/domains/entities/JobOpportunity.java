package br.gov.sp.fatec.nemo.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.br.CPF;
import br.gov.sp.fatec.nemo.domains.enums.SkillLevel;
import br.gov.sp.fatec.nemo.domains.enums.Availability;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_opportunity")
public class JobOpportunity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "jo_id")
    @JsonIgnore
    private Long id;

    @NotBlank
    @Column(name = "jo_name")
    private String joName;

    @NotBlank
    private String description;

    @NotBlank
    @Column(name = "contract_type")
    private String contractType;

    @NotBlank
    @Column(name = "working_hours")
    private Long workingHours;

    @NotBlank
    @Column(name = "salary_range_ini")
    private String salaryRangeIni;

    @NotBlank
    @Column(name = "salary_range_end")
    private String salaryRangeEnd;

    @NotBlank
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability", columnDefinition = "availability")
    @Type(type = "pgsql_enum")
    private Availability availability;

    @Column(name = "workplace_country")
    private String workplaceCountry;

    @Column(name = "workplace_city")
    private String workplaceCity;

    @Column(name = "workplace_neighborhood")
    private String workplaceNeighborhood;

    @Column(name = "workplace_street")
    private String workplaceStreet;

    @Column(name = "workplace_home_number")
    private String workplaceNumber;

    @Column(name = "workplace_complement")
    private String workplaceComplement;

    @Column(name = "workplace_zip_code")
    private String workplaceZipCode;

    @Column(name = "workplace_latitude")
    private Float workplaceLatitude;

    @Column(name = "workplace_longitude")
    private Float workplaceLongitude;

    @NotBlank
    @Column(name = "divulgation_ini")
    private LocalDateTime divulgationIni;

    @NotBlank
    @Column(name = "divulgation_end")
    private LocalDateTime divulgationEnd;

    @NotBlank
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @NotBlank
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

}
