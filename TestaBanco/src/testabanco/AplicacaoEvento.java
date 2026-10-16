package testabanco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DENISE NEVES
 */
    public class AplicacaoEvento extends AplicacaoButton implements ActionListener
	{
                Usuario usuario= new Usuario();
                ConexaoDB conn = new ConexaoDB();    
                usuarioDAO usuarioBD;
                  
                
		AplicacaoEvento()
		{
		        //Usuario usuario = new Usuario();
                        
                        B1.addActionListener(this);// Adiciona ações ao botão
			B2.addActionListener(this);
			B3.addActionListener(this);
			B4.addActionListener(this);
			B5.addActionListener(this);
			B6.addActionListener(this);
                   
			
		}
		public void actionPerformed(ActionEvent e)//
		{
                        //Incluir usuario
			if(e.getSource()==B1)
			{
                            usuario.setCodigo(Integer.parseInt(Tx1.getText()));
                            usuario.setNome(Tx2.getText());
                            usuario.setSenha(Tx3.getText());
                            
                                                 
                            usuarioBD = new usuarioDAO();
                            usuarioBD.insert(usuario);
                            
                            // limpar campos
                            Tx1.setText("");
			    Tx2.setText("");
			    Tx3.setText("");       
                            
                           
			}
                        // Altera o usuario
			if(e.getSource()==B2)
			{
			if ((usuario.getNome() == "") || (usuario.getCodigo() == 0)) {
                            JOptionPane.showMessageDialog(null, "Primeiro consulte o Usuário");
                        }
                        else
                        {
                            
                                usuarioBD = new usuarioDAO();
                                
                                usuario.setNome(Tx2.getText());
                                usuario.setPeriodo(Tx3.getText());
                                
                                usuarioBD.update(usuario);
                                
                                // limpar campos
                                Tx1.setText("");
                                Tx2.setText("");
                                Tx3.setText(""); 
                                
                                                       
                        }    
                        }
                        //Consulta o usuario
			if (e.getSource() == B3)
			{
			    if (Tx1.getText() == "") {
                            JOptionPane.showMessageDialog(null, "Digitar o código do Usuario para consultar");
                            }
                            else
                            {	                                        
                            
                            usuarioBD = new usuarioDAO();
                            usuario.setCodigo(Integer.parseInt(Tx1.getText()));
                            usuarioBD.consulta(usuario);
                            
                            Tx2.setText(usuario.getNome());
                            Tx3.setText(usuario.getPeriodo());
                                                                                                     	
			    
                          }
                        }    
                        // Exclui o usuario
			if(e.getSource()==B4)
			{
			if ((Tx2.getText() == "") || (usuario.getCodigo() == 0)) {
                            JOptionPane.showMessageDialog(null, "Primeiro consulte o Usuário");
                        }
                        
                        else
                        {
                            
                                usuarioBD = new usuarioDAO();
                              
                                usuarioBD.delete(Integer.parseInt(Tx1.getText()));
                             
                                
                                // limpar campos
                                Tx1.setText("");
                                Tx2.setText("");
                                Tx3.setText(""); 
                                
                                                      
                        }    	
                        }				
                       // Sair da aplicação
			if (e.getSource() == B5)
			{				
				this.dispose();
			}
                        
                        // Lista todos os usuários
			if (e.getSource() == B6)
                                                       
			{ 
                                                    
                            usuarioBD = new usuarioDAO();
                            ArrayList dados = usuarioBD.listaUsuario();
                            NFrame Fx = new Lista(dados);
			    Fx. show();
                            
                 }                        
				
		}
public static void main(String arg[])
		{
			new AplicacaoEvento().show();
		}
		       
}
