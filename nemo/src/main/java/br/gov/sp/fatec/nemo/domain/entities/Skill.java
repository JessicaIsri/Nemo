package br.gov.sp.fatec.nemo.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "skill_id")
    private Long id;

    @NotBlank
    private String description;

    @OneToMany(mappedBy = "skill")
    private Set<CandidateSkill> candidateSkillSet;
}