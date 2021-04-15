package br.gov.sp.fatec.nemo.domains.entities;

/*IMPORT ENUMS*/
import br.gov.sp.fatec.nemo.domains.enums.*;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Stter
@NoArgsConstructor
@AllArgsConstructor

public class Curriculo{
    private String nome;
    private Date dataNascimento;
    private String genero;
    private String email;
    private String telefone1, telefone2, telefone3;
    private String cidade, codPostal, estado, pais, latitude,longitude;
    private String descDeficiencia;
    private String escolaridade;
    private ArrayList<> cursos;
    private String pretensaoSalarial;
    private enumJornadaDesejada jornadaDesejada;
    private enumPeriodoDisponivel periodoDisponivel;
    private enumContratoDesejado contratoDesejado;
    private ArrayList<> habilidades;
    private ArrayList<> experiencias;
    private enumTipoTrabalho tipoTrabalho;


    //CADASTRAR CURRICULO
    public Curriculo cadastrarCurriculo(String nome,Date dataNascimento,String genero,String email,String telefone1,String telefone2, String telefone3, String cidade, String codPostal, String estado,
                                   String pais,String latitude,String longitude,String descDeficiencia,String escolaridade,
                                   ArrayList cursos,String pretensaoSalarial,enum jornadaDesejada,enum periodoDisponivel,
                                   enum contratoDesejado,ArrayList habilidades,ArrayList experiencias,enum tipoTrabalho){


        Curriculo curriculo = new Curriculo(this.nome,
                this.dataNascimento,
                this.genero,
                this.email,
                this.telefone1,
                this.telefone2,
                this.telefone3,
                this.cidade,
                this.codPostal,
                this.estado,
                this.pais,
                this.latitude,
                this.longitude,
                this.descDeficiencia,
                this.escolaridade,
                this.cursos,
                this.pretensaoSalarial,
                this.jornadaDesejada,
                this.periodoDisponivel,
                this.contratoDesejado,
                this.habilidades,
                this.experiencias,
                this.tipoTrabalho);


    }

    //CONSULTA DE CURRÍCULO

    public void consultaNome(String nome){

    }

}