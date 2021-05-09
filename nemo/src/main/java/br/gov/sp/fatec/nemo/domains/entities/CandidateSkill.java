package br.gov.sp.fatec.nemo.domains.entities;

import br.gov.sp.fatec.nemo.domains.enums.SkillLevel;
import br.gov.sp.fatec.nemo.domains.utils.PostgreSQLEnumType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_skill")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class CandidateSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private CandidateSkillPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("candidateId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "fk_can_id")
    @JsonIgnore
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skillId")
    @JoinColumn(name = "fk_skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", columnDefinition = "skill_level")
    @Type(type = "pgsql_enum")
    private SkillLevel skillLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkill)) return false;

        CandidateSkill that = (CandidateSkill) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCandidate() != null ? !getCandidate().equals(that.getCandidate()) : that.getCandidate() != null)
            return false;
        if (getSkill() != null ? !getSkill().equals(that.getSkill()) : that.getSkill() != null) return false;
        return getSkillLevel() == that.getSkillLevel();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCandidate() != null ? getCandidate().hashCode() : 0);
        result = 31 * result + (getSkill() != null ? getSkill().hashCode() : 0);
        result = 31 * result + (getSkillLevel() != null ? getSkillLevel().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                '}';
    }


    public CandidateSkillPK getId() {
        return id;
    }

    public void setId(CandidateSkillPK id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }
}
