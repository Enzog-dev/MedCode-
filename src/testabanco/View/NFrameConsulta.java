
package testabanco.View;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NFrameConsulta extends JFrame{
   public NFrameConsulta(){ 
    Color cor = new Color(211,211,211);
   
    Container c = getContentPane();
    setLocation(100,50);
    setTitle("Clinica MedCode");
    setSize(800,800);
    setUndecorated(true);
    c.setBackground (cor);
    setDefaultCloseOperation(NFramePaciente.DISPOSE_ON_CLOSE);

    getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,3));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public static void main(String arg[]){
   new NFramePaciente().show();
   }
}