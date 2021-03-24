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
public class CandidateSkillPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fk_can_id")
    private Long candidateId;

    @Column(name = "fk_skill_id")
    private Long skillId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkillPK)) return false;

        CandidateSkillPK that = (CandidateSkillPK) o;

        if (getCandidateId() != null ? !getCandidateId().equals(that.getCandidateId()) : that.getCandidateId() != null)
            return false;
        return getSkillId() != null ? getSkillId().equals(that.getSkillId()) : that.getSkillId() == null;
    }

    @Override
    public int hashCode() {
        int result = getCandidateId() != null ? getCandidateId().hashCode() : 0;
        result = 31 * result + (getSkillId() != null ? getSkillId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CandidateSkillPK{" +
                "candidateId=" + candidateId +
                ", skillId=" + skillId +
                '}';
    }


}
