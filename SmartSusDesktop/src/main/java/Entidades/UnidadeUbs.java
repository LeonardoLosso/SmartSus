package Entidades;

/**
 *
 * @author Leo
 */
public class UnidadeUbs {
 private String nome;
 private int id;
 private Endereco endereco;

    
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
