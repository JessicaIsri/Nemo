package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.JobOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobOpportunity, Long> {

    @Query("SELECT DISTINCT j FROM JobOpportunity j WHERE (:jo_id is null or j.id = :jo_id)")
            List<JobOpportunity> findJobOpportunityByAllParams(
            @Param("id") Long id
    );


}
