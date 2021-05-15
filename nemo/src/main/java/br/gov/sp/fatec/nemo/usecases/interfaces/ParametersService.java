package br.gov.sp.fatec.nemo.usecases.interfaces;

import br.gov.sp.fatec.nemo.domains.entities.Parameters;

import java.util.Optional;

public interface ParametersService {
    public Parameters saveParameter(Parameters parameters);

    public Optional<Parameters> findById(Long id);
}
