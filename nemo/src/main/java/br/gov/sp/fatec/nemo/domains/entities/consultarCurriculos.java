package br.gov.sp.fatec.nemo.domains.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Stter
@NoArgsConstructor
@AllArgsConstructor


public class consultarCurriculos(){


    static ArrayList<Curriculo> curriculos = new ArrayList<Curriculo>();


    //CONSULTA POR NOME
    public void consultaNome(String nome){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getNome() == nome){
                return curriculo
            }
        }
    }

    //CONSULTA POR DATA NASCIMENTO
    public void consultaNome(Date dataNascimento){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getDataNascimento() == nome){
                return curriculo
            }
        }
    }

    //CONSULTA POR GENERO
    public void consultaGenero(String genero){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getGenero() == genero){
                return curriculo
            }
        }
    }

    //CONSULTA POR EMAIL
    public void consultaEmail(String email){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getEmail() == email){
                return curriculo
            }
        }
    }
    //CONSULTA POR TELEFONE1
    public void consultaTelefone1(String telefone1){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getTelefone1() == telefone1){
                return curriculo
            }
        }
    }
    //CONSULTA POR TELEFONE2
    public void consultaTelefone2(String telefone2){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getTelefone2() == telefone2){
                return curriculo
            }
        }
    }
    //CONSULTA POR TELEFONE3
    public void consultaTelefone3(String telefone3){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getTelefone3() == telefone3){
                return curriculo
            }
        }
    }

    //CONSULTA POR CIDADE
    public void consultaCidade(String cidade){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getCidade() == cidade){
                return curriculo
            }
        }
    }

    //CONSULTA POR COD POSTAL
    public void consultaCodPostal(String codPostal){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getCodPostal() == codPostal){
                return curriculo
            }
        }
    }

 //CONSULTA POR ESTADO
    public void consultaEstado(String estado){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getEstado() == estado){
                return curriculo
            }
        }
    }

    //CONSULTA POR PAÍS
    public void consultaPais(String pais){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getPais() == pais){
                return curriculo
            }
        }
    }

    //CONSULTA POR LATITUDE
    public void consultaLatitude(String latitude){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getLatitude() == latitude){
                return curriculo
            }
        }
    }

    //CONSULTA POR LONGITUDE
    public void consultaLongitude(String longitude){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getLongitude() == longitude){
                return curriculo
            }
        }
    }


//CONSULTA POR DEFICIENCIA
    public void consultaDeficiencia(String deficiencia){
        for(Curriculo curriculo: curriculos){
            if(curriculo.getDeficiencia() == deficiencia){
                return curriculo
            }
        }
    }


//CONSULTA POR CURSOS
    public void consultaCursos(ArrayList cursos){
        for(Curriculo curriculo: curriculos){
            for(int i=0;i<cursos.size();i++)
            {
                if(curriculo.getCursos() == cursos.get(i)){
                    return curriculo
                }
            }

        }
    }









}