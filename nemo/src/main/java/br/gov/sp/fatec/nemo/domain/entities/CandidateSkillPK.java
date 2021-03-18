package br.gov.sp.fatec.nemo.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CandidateSkillPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fk_can_id")
    private Long candidateId;

    @Column(name = "fk_skill_id")
    private Long skillId;


}
