package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT DISTINCT c FROM Candidate c " +
            "INNER JOIN FETCH c.skills s " +
            "INNER JOIN FETCH s.skill sk " +
            "WHERE (:gender is null or c.gender = :gender) and " +
            "(:country is null or c.country = :country) and (:city is null or c.city = :city) and " +
            "(:zip_code is null or c.zipCode = :zip_code) and " +
            "(:skill is null or sk.description = :skill) and " +
            "(:availablePeriod is null or c.availablePeriod = :availablePeriod)"

    )
    List<Candidate> findCandidateByAllParams(
            @Param("gender") String gender,
            @Param("country") String country,
            @Param("city") String city,
            @Param("zip_code") String zipCode,
            @Param("skill") String skill,
            @Param("availablePeriod") String availablePeriod
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
    @Query(value="select * from public.candidate where can_id = :id ", nativeQuery = true)
    Candidate findCandidateById(@Param("id") Long id);

    //FIND BY NAME
    List<Candidate> findCandidateByName(@Param("name") String name);

    //FIND BY EMAIL
    List<Candidate> findCandidateByEmail(@Param("email") String email);

    //FIND BY CPF
    List<Candidate> findCandidateByCpf(@Param("cpf") String cpf);

    //FIND BY PHONE
    List<Candidate> findCandidateByPhone(@Param("phone") String phone);

    //FIND BY GENDER
    List<Candidate> findCandidateByGender(@Param("gender") String gender);

    //FIND BY BIRTHDAY
    List<Candidate> findCandidateByBirthday(@Param("birthday") LocalDate birthday);

     //FIND BY COUNTRY
    List<Candidate> findCandidateByCountry(@Param("country") String country);

    //FIND BY CITY
    List<Candidate> findCandidateByCity(@Param("city") String city);

    //FIND BY NEIGHBORHOOD
    List<Candidate> findCandidateByNeighborhood(@Param("neighborhood") String neighborhood);

    //FIND BY STREET
    List<Candidate> findCandidateByStreet(@Param("street") String street);

    //FIND BY HOMENUMBER
    //Cast(:home_number as integer)
    @Query(value="select * from candidate where home_number = :home_number", nativeQuery = true)
    List<Candidate> findCandidateByHomeNumber(@Param("home_number") Integer home_number);

    //FIND BY COMPLEMENT
    List<Candidate> findCandidateByComplement(@Param("complement") String complement);

    //FIND BY ZIPCODE
    List<Candidate> findCandidateByZipCode(@Param("zipCode") String zipCode);

    //FIND BY LATITUDE
    @Query(value="select * from candidate where latitude = :latitude", nativeQuery = true)
    List<Candidate> findCandidateByLatitude(@Param("latitude") Double latitude);

    //FIND BY LONGITUDE
    @Query(value="select * from candidate where longitude = :longitude", nativeQuery = true)
    List<Candidate> findCandidateByLongitude(@Param("longitude") Double longitude);



    //FIND BY PRETENTIONSALARY
    @Query(value="select * from candidate where pretentionSalary = :pretentionSalary", nativeQuery = true)
    List<Candidate> findCandidateByPretentionSalary(@Param("pretentionSalary") String pretentionSalary);

    //***

    //FIND BY DESIREDJOURNEY
    @Query(value="select * from candidate c where c.desired_journey = :desired_journey", nativeQuery = true)
    List<Candidate> findCandidateByDesiredJourney(@Param("desired_journey") String desired_journey);

    //FIND BY AVAILABLEPERIOD
    @Query(value="select * from candidate where available_period = :available_period", nativeQuery = true)
    List<Candidate> findCandidateByAvailablePeriod(@Param("available_period") String available_period);

    //FIND BY WORKMODALITY
    @Query(value="select * from candidate where work_modality = :work_modality", nativeQuery = true)
    List<Candidate> findCandidateByWorkModality(@Param("work_modality") String work_modality);





}
