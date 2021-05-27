package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameters, Long> {

}
