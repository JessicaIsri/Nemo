package br.gov.sp.fatec.nemo.domain.repositories;

import br.gov.sp.fatec.nemo.domain.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT c FROM candidate c left join fetch c.skills s WHERE (:gender is null or c.gender = :gender) and " +
            "(:country is null or c.country = :country) and (:city is null or c.city = :city) and " +
            "(:zip_code is null or c.zip_code = :zip_code) and (:skill is null or s.skill.description = :skill)")
    List<Candidate> findCandidateByAllParams(
            @Param("gender") String gender,
            @Param("country") String country,
            @Param("city") String city,
            @Param("zip_code") String zipCode,
            @Param("skill") String skill
    );
}
