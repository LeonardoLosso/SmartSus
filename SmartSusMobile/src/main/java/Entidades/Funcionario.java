package Entidades;


/**
 *
 * @author Leo
 */
public class Funcionario extends Pessoa {
//-------------[ATRIBUTOS]------------------
    private int  documento, matricula;
    private String exp;
//------------------------------------------

//--------------[GET E SET]-----------------
    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public String getExp() {
        return exp;
    }
    public void setExp(String exp) {
        this.exp = exp;
    }
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula=matricula;
    }
}
