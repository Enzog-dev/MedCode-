package testabanco.Model;

public class Enfermeiro {
    private String coren;
    private String nome;
    private String id;
    
    public Enfermeiro(String coren, String nome, String id) {
        this.coren= coren;
        this.nome= nome;
        this.id= id;
    }
    public Enfermeiro() {
        this.coren = "";
        this.nome = "";
        this.id = "";
    } 
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
