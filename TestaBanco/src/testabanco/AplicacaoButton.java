/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author DENISE NEVES
 */
public class AplicacaoButton extends AplicacaoText{
    JButton B1, B2, B3,B4,B5,B6;
		
		public AplicacaoButton()
		{
					
			B1 =new JButton("Incluir");
			B1.setSize(80, 40);
			B1.setLocation(10,420);
			B1.setMnemonic(KeyEvent.VK_I);

			B2 =new JButton("Alterar");
			B2.setSize(80, 40);
			B2.setLocation(100,420);
			B2.setMnemonic(KeyEvent.VK_A);

			B3 =new JButton("Consultar");
			B3.setSize(90,40);
			B3.setLocation(200,420);
			B3.setMnemonic(KeyEvent.VK_C);

			B4 = new JButton("Excluir");
			B4.setSize(80, 40);
			B4.setLocation(310, 420);
			B4.setMnemonic(KeyEvent.VK_E);


			B5 = new JButton("Sair");
			B5.setSize(80, 40);
			B5.setLocation(400, 420);
			B5.setMnemonic(KeyEvent.VK_S);

	                B6 = new JButton("TODOS");
			B6.setSize(90, 50);
			B6.setLocation(380, 120);
			B6.setMnemonic(KeyEvent.VK_T);
			
                        getContentPane().add(B1);
			getContentPane().add(B2);
			getContentPane().add(B3);
			getContentPane().add(B4);
			getContentPane().add(B5);
			getContentPane().add(B6);
			}

		
		public static void main(String arg[])
		{
			new AplicacaoButton().show();
		}

                    
}
