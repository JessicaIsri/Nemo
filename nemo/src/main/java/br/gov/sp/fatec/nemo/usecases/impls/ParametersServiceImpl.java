package br.gov.sp.fatec.nemo.usecases.impls;

import br.gov.sp.fatec.nemo.domains.entities.Client;
import br.gov.sp.fatec.nemo.domains.entities.Parameters;
import br.gov.sp.fatec.nemo.domains.repositories.ParameterRepository;
import br.gov.sp.fatec.nemo.usecases.interfaces.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ParametersServiceImpl implements ParametersService {
    @Autowired
    ParameterRepository parameterRepository;


    public Parameters saveParameter(Parameters parameters){
        Client auth = (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return parameterRepository.saveAndFlush(parameters);
    }

    public Optional<Parameters> findById(Long id){
        return parameterRepository.findById(id);
    }

}
