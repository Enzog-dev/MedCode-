
package testabanco.View;

import javax.swing.JTextField;

public class AplicacaoTextConsulta extends AplicacaoLabelConsulta{
    public JTextField Tx1, Tx2,Tx3,Tx4,Tx5,Tx6,Tx7;
		

		public AplicacaoTextConsulta()
		{
			Tx1 = new JTextField(); // CPF
        		Tx1.setBounds(205, 120, 160, 25);

                        Tx2 = new JTextField(); // id consulta
        		Tx2.setBounds(205, 160, 160, 25);

                        Tx3 = new JTextField(); // hora
        		Tx3.setBounds(205, 200, 160, 25);

        		Tx4 = new JTextField(); // tipo consulta
        		Tx4.setBounds(205, 240, 160, 25);

                        Tx5 = new JTextField(); // id triagem
        		Tx5.setBounds(205, 280, 160, 25);

        		Tx6 = new JTextField(); // diagnostico
        		Tx6.setBounds(205, 320, 160, 25);

        		Tx7 = new JTextField(); // CRM médico
        		Tx7.setBounds(205, 360, 160, 25);

                    getContentPane().add(Tx1);
                    getContentPane().add(Tx2);
                    getContentPane().add(Tx3);
                    getContentPane().add(Tx4);
                    getContentPane().add(Tx5);
                    getContentPane().add(Tx6);
                    getContentPane().add(Tx7);
                                }

		public static void main(String arg[])
		{
			new AplicacaoTextConsulta().show();
		}

    
}