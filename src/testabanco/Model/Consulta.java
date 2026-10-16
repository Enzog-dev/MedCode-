package testabanco.Model;

public class Consulta {
    private String cpf;
    private String id_consulta;
    private String hora;
    private String tipo_consulta;
    private String diagnostico;
    private String id_triagem;
    private String crm_medico;

    public Consulta(String cpf, String id_consulta, String hora,String tipo_consulta,String diagnostico,String id_triagem,String crm_medico   ) {
        this.cpf = cpf;
        this.id_consulta = id_consulta;
        this.hora= hora;
        this.tipo_consulta= tipo_consulta;
        this.id_triagem= id_triagem;
        this.diagnostico=diagnostico;
        this.crm_medico=crm_medico;
    }

    public Consulta() {
        this.cpf = "";
        this.id_consulta= "";
        this.hora = "";
        this.tipo_consulta= "";
        this.id_triagem= "";
        this.diagnostico= "";
        this.crm_medico= "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getId_triagem() {
        return id_triagem;
    }

    public void setId_triagem(String id_triagem) {
        this.id_triagem = id_triagem;
    }

    public String getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(String crm_medico) {
        this.crm_medico = crm_medico;
    }
}
    
    
