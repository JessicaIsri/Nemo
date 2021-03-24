package br.gov.sp.fatec.nemo.domains.repositories;

import br.gov.sp.fatec.nemo.domains.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findClientByClientId(String id);
}
