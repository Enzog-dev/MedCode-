
package testabanco.View;

import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JRootPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NFramePrincipal extends JFrame{
    public NFramePrincipal(){ 
    Color cor = new Color(211,211,211);
   
    Container c = getContentPane();
    setLocation(100,50);
    setTitle("Clinica MedCode");
    setSize(800,800);
    setUndecorated(true);
    c.setBackground (cor);
    setDefaultCloseOperation(NFrameEnfermeiro.DISPOSE_ON_CLOSE);

    getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,3));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public static void main(String arg[]){
   new NFramePrincipal().show();
   }
}
    
