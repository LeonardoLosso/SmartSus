package Entidades;

/**
 *
 * @author Leo
 */
public class Usuario {
    private String senha, email, login;
    private char tipo;
    private Pessoa pessoa;
    private int id;
    

    public String getEmail() {
        return email;
    }
    public String getLogin() {
        return login;
    }
    public char getTipo() {
        return tipo;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public String getSenha() {
        return senha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
