package br.gov.sp.fatec.nemo.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_exp")
public class CandidateExp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_can_id")
    @JsonIgnore
    private Candidate candidate;

    @NotBlank
    @Column(name = "fk_company_id")
    private String company;

    @NotBlank
    @Column(name = "fk_post_id")
    private String jobTitle;

    @NotNull
    @Column(name = "dt_start")
    private LocalDate dtStart;

    @NotNull
    @Column(name = "dt_end")
    private LocalDate dtEnd;

    @NotBlank
    private String description;

}