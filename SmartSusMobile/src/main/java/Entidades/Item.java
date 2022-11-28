package Entidades;

/**
 *
 * @author Leo
 */
public abstract class Item {
    private int id;
    private String nome;
    private String finalidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
    
    public abstract String getSubstancia();
    public abstract int getDosagem();
}
