
package testabanco;


import testabanco.View.AplicacaoEventoPrincipal;

public class TestaBanco {

    public static void main(String[] args) {
        conexao con = new conexao();
        con.obtemConexao();
        new AplicacaoEventoPrincipal().show();
    }
    
}
