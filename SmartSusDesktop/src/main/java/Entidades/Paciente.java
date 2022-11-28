package Entidades;

/**
 *
 * @author Leo
 */
public class Paciente extends Pessoa{
//-------------[ATRIBUTOS]------------------
    private int filaOnline;
//------------------------------------------
    
//--------------[GET E SET]-----------------
    public int getFilaOnline() {
        return filaOnline;
    }

    protected void setFilaOnline(int filaOnline) {
        this.filaOnline = filaOnline;
    }
//------------------------------------------
}
