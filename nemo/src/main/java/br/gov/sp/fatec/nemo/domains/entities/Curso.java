package br.gov.sp.fatec.nemo.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "curso_id")
    @JsonIgnore
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "curso_nomecurso")
    private String curso;

}

