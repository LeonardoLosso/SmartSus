package DadosGlobaisTemporarios;

import Entidades.Funcionario;
import Entidades.UnidadeUbs;
import Entidades.Usuario;

/**
 *
 * @author Leo
 */
public class Logado {
    private static Usuario user;
    private static UnidadeUbs upa;
    private static Funcionario funcionario;

    public static Usuario getUser() {
        return user;
    }
    public static void setUser(Usuario user) {
        Logado.user = user;
    }

    public static UnidadeUbs getUpa() {
        return upa;
    }

    public static void setUpa(UnidadeUbs upa) {
        Logado.upa = upa;
    }

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario funcionario) {
        Logado.funcionario = funcionario;
    }
    
}
