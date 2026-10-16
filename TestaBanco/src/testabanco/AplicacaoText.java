/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

import javax.swing.JTextField;

/**
 *
 * @author DENISE NEVES
 */
public class AplicacaoText extends AplicacaoLabel{
    public JTextField Tx1, Tx2,Tx3;
		

		public AplicacaoText()
		{
			Tx1 = new JTextField();
			this.Tx1 = Tx1;
			Tx1.setBounds(190,120,150,20);

			Tx2 = new JTextField();
			this.Tx2 = Tx2;
			Tx2.setBounds(190,160,150,20);
                        
                        Tx3 = new JTextField();
			this.Tx3 = Tx3;
			Tx3.setBounds(190,190,150,20);

						
			getContentPane().add(Tx1);
			getContentPane().add(Tx2);
                        getContentPane().add(Tx3);
			
		}

		public static void main(String arg[])
		{
			new AplicacaoText().show();
		}

    
}
