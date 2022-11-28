package Entidades;

import java.sql.Time;

public class Agenda {
    private Paciente paciente;
    private Funcionario funcionario;
    private String data;
    private Time hora;
    private UnidadeUbs unidade;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public UnidadeUbs getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeUbs unidade) {
        this.unidade = unidade;
    }
    
}
