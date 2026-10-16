/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

/**
 *
 * @author DENISE NEVES
 */
public class Usuario {

      private int codigo;
      private String nome;
      private String periodo;
      private String senha;

    public Usuario(int codigo, String nome, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario (){
        this.codigo = 0;
        this.nome = "";
        this.senha = "";
    }
    public Usuario (String login, String senha){
        this.codigo = 0;
        this.nome = login;
        this.periodo = "";
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

     

}
