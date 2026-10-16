
package testabanco.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



    public class AplicacaoEventoPrincipal extends AplicacaoButtonPrincipal implements ActionListener {


    public AplicacaoEventoPrincipal() {
        B1.addActionListener(this); // 
        B2.addActionListener(this); // 
        B3.addActionListener(this); //
        B4.addActionListener(this); //
        B5.addActionListener(this); //
    }

 public void actionPerformed(ActionEvent e) {

        if (e.getSource() == B1) {
            new AplicacaoEventoPaciente().show();
        }

        if (e.getSource() == B2) {
            new AplicacaoEventoEnfermeiro().show();
        }

        if (e.getSource() == B3) {
            new AplicacaoEventoMedico().show();
        }
        if (e.getSource() == B4) {
            new AplicacaoEventoTriagem().show();
        }
        if (e.getSource() == B5) {
            new AplicacaoEventoConsulta().show();
        }
    }

    public static void main(String[] args) {
        new AplicacaoEventoPrincipal().show();
    }
}

