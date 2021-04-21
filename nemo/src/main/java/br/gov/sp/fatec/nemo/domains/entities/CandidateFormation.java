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
@Table(name = "candidate_formation")
public class CandidateFormation implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private CandidateFormationPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_can_id")
    @JsonIgnore
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("institutionId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_inst_id")
    private Institution institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_course_id")
    private Course course;

    @NotNull
    private LocalDate dt_start;

    @NotNull
    private LocalDate dt_end;

    @Override
    public String toString() {
        return "formations{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", institution=" + institution +
                ", course=" + course +
                '}';
    }


}