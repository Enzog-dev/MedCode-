package testabanco.Model;

import java.time.LocalDateTime;

public class Triagem {
    private int id;
    private double temperatura;
    private int batimentos;
    private int pressao;
    private String sintomas;
    private LocalDateTime dataHora;

    private Paciente paciente;       // Associação com paciente
    private Enfermeiro enfermeiro;   // Associação com enfermeiro

    // Construtor padrão
    public Triagem() {
        this.id = 0;
        this.temperatura = 0.0;
        this.batimentos = 0;
        this.pressao = 0;
        this.sintomas = "";
        this.dataHora = LocalDateTime.now();
        this.paciente = new Paciente();
        this.enfermeiro = new Enfermeiro();
    }

    // Construtor com parâmetros
    public Triagem(int id, double temperatura, int batimentos, int pressao, String sintomas,
                   LocalDateTime dataHora, Paciente paciente, Enfermeiro enfermeiro) {
        this.id = id;
        this.temperatura = temperatura;
        this.batimentos = batimentos;
        this.pressao = pressao;
        this.sintomas = sintomas;
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.enfermeiro = enfermeiro;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
}
