
package Entidades;

public class Remedio extends Item{
    private String substancia;
    private int dosagem;

    public String getSubstancia() {
        return substancia;
    }

    public void setSubstancia(String substancia) {
        this.substancia = substancia;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }
}
