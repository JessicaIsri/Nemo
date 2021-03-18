package br.gov.sp.fatec.nemo.domain.entities;

import br.gov.sp.fatec.nemo.domain.enums.SkillLevel;
import br.gov.sp.fatec.nemo.domain.utils.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "candidate_skill")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Data
public class CandidateSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CandidateSkillPK id;

    @ManyToOne
    @MapsId("candidateId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_can_id")
    private Candidate candidate;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "fk_skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", columnDefinition = "skill_level")
    @Type(type = "pgsql_enum")
    private SkillLevel skillLevel;
}
