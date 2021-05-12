package br.gov.sp.fatec.nemo.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_modality")
public class WorkModality implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @NotBlank
    private String name;

}