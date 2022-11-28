package Entidades;

import BD.DAO.FuncionarioDAO;

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

    public void setMatricula() {
        FuncionarioDAO f = new FuncionarioDAO();
        int m = (int) (Math.random() * (9999999-1000000));
        while(f.confereMatricula(m)){
            m = (int) (Math.random() * (9999999-1000000));
        }
        this.matricula=m;
        System.out.println(this.matricula);
    }
    public void setMatricula(int matricula){
        this.matricula=matricula;
    }
    @Override
    public String toString(){
        return String.format("%d  '%s'  %-30s %-15s %s",this.getMatricula(), 
                this.getTipo(), this.getNome(), this.getExp(), this.getTelefone());
    }
}
