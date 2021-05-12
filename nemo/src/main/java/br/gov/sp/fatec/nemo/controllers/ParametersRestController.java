package br.gov.sp.fatec.nemo.controllers;

import br.gov.sp.fatec.nemo.domains.entities.Parameters;
import br.gov.sp.fatec.nemo.usecases.interfaces.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ParametersRestController {

    @Autowired
    private ParametersService parametersService;

    @PostMapping(value = "nemo/v1/parameters")
    public ResponseEntity<Parameters> saveParameter(
        @RequestBody Parameters parameters
    ) {
        Parameters parameterSave = parametersService.saveParameter(parameters);
        return ResponseEntity.ok().body(parameters);
    }

}
