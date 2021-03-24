package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Client;
import br.gov.sp.fatec.nemo.domains.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = clientRepository.findClientByClientId(s);
        if(client == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(client.getClientId(), client.getClientSecret(), Collections.emptyList());
    }
}
