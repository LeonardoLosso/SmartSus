package Entidades;

/**
 *
 * @author Leo
 */
public class Vacina extends Item{

    @Override
    public String getSubstancia() {
        return "VACINA PARA: " + this.getFinalidade();
    }

    @Override
    public int getDosagem() {
        return -1;
    }
   
}