package br.gov.sp.fatec.nemo.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curriculo")
public class Curriculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "curriculo_id")
    @JsonIgnore
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "curriculo_nome")
    private String nome;

    @NotBlank
    @Column(name = "curriculo_datanascimento")
    private Date dataNascimento;

    @NotBlank
    @Column(name = "curriculo_genero")
    private String genero;

    @Email
    @Column(name = "curriculo_email")
    private String email;

    @NotBlank
    @Column(name = "curriculo_telefone1")
    private String telefone1;

    @NotBlank
    @Column(name = "curriculo_telefone2")
    private String telefone2;

    @NotBlank
    @Column(name = "curriculo_telefone3")
    private String telefone3;

    @NotBlank
    @Column(name = "curriculo_cidade")
    private String cidade;

    @NotBlank
    @Column(name = "curriculo_codpostal")
    private String codPostal;

    @NotBlank
    @Column(name = "curriculo_estado")
    private String estado;

    @NotBlank
    @Column(name = "curriculo_pais")
    private String pais;

    @NotBlank
    @Column(name = "curriculo_latitude")
    private Float latitude;

    @NotBlank
    @Column(name = "curriculo_longitude")
    private Float longitude;

    @NotBlank
    @Column(name = "curriculo_descdeficiencia")
    private String descDeficiencia;

    @NotBlank
    @Column(name = "curriculo_escolaridade")
    private String escolaridade;

    @NotBlank
    @Column(name = "curriculo_pretensaosalarial")
    private String pretensaoSalarial;

    @NotBlank
    @Column(name = "curriculo_modelotrabalho")
    private String modeloTrabalho;

    @OneToMany(mappedBy = "curriculo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Curso> cursos;

    @OneToMany(mappedBy = "curriculo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "curriculo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Habilidade> habilidade;

    private enumJornadaDesejada jornadaDesejada;
    private enumPeriodoDisponivel periodoDisponivel;
    private enumContratoDesejado contratoDesejado;
    private enumTipoTrabalho tipoTrabalho;



}