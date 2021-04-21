package br.gov.sp.fatec.nemo.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateFormationPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fk_can_id")
    private Long candidateId;

    @Column(name = "fk_inst_id")
    private Long institutionId;

    @Column(name = "fk_course_id")
    private Long courseId;

    @Override
    public String toString() {
        return "CandidateFormationPK{" +
                "candidateId=" + candidateId +
                ", institutionId=" + institutionId +
                ", courseId=" + courseId +
                '}';
    }



}