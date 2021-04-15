package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.CandidateSkill;
import br.gov.sp.fatec.nemo.domains.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
