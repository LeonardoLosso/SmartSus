package DadosGlobaisTemporarios;

import Entidades.Paciente;
import Entidades.UnidadeUbs;
import Entidades.Usuario;

/**
 *
 * @author Leo
 */
public class Logado {
    private static Usuario user;
    private static UnidadeUbs upa;
    private static Paciente paciente;

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

    public static Paciente getPaciente() {
        return paciente;
    }

    public static void setPaciente(Paciente paciente) {
        Logado.paciente = paciente;
    }
    
}
