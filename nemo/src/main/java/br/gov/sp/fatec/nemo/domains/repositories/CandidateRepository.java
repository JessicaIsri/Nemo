package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT DISTINCT c FROM Candidate c " +
            "INNER JOIN FETCH c.skills s " +
            "INNER JOIN FETCH s.skill sk " +
            "WHERE (:gender is null or c.gender = :gender) and " +
            "(:country is null or c.country = :country) and (:city is null or c.city = :city) and " +
            "(:zip_code is null or c.zipCode = :zip_code) and " +
            "(:skill is null or sk.description = :skill)"
    )
    List<Candidate> findCandidateByAllParams(
            @Param("gender") String gender,
            @Param("country") String country,
            @Param("city") String city,
            @Param("zip_code") String zipCode,
            @Param("skill") String skill
    );

    @Query(value = "SELECT * FROM candidate where can_id in (:ids) and ST_Distance_Sphere(geom, ST_MakePoint(:longitude,:latitude))/1000 <= :kilometers",
        nativeQuery = true )
    List<Candidate> findRadiusCandidate(
        @Param("longitude") Double longitude,
        @Param("latitude") Double latitude,
        @Param("ids") List<Long> ids,
        @Param("kilometers") Double kilometers
    );

    //FIND BY ID
    @Query(value="select * from candidate where can_id = :id", nativeQuery = true)
    Candidate findCandidateById(@Param("id") Long id);
}
