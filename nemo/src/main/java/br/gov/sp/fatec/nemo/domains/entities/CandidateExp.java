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

    @EmbeddedId
    private CandidateExpPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_can_id")
    @JsonIgnore
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_post_id")
    private Post post;

    @NotNull
    private LocalDate dt_start;

    @NotNull
    private LocalDate dt_end;

    @NotNull
    private String description;





}