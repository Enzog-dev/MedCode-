
package testabanco.View;

import javax.swing.JTextField;

public class AplicacaoTextEnfermeiro extends AplicacaoLabelEnfermeiro{
     public JTextField Tx1, Tx2,Tx3;
		

		public AplicacaoTextEnfermeiro()
		{
			Tx1 = new JTextField();
			this.Tx1 = Tx1;
			Tx1.setBounds(190,130,100,25);
                      
			Tx2 = new JTextField();
			this.Tx2 = Tx2;
			Tx2.setBounds(190,170,150,25);
                        
                        Tx3 = new JTextField();
			this.Tx3 = Tx3;
			Tx3.setBounds(190,200,150,25);

						
			getContentPane().add(Tx1);
			getContentPane().add(Tx2);
                        getContentPane().add(Tx3);
			
		}

		public static void main(String arg[])
		{
			new AplicacaoTextEnfermeiro().show();
		}
    
    
}
