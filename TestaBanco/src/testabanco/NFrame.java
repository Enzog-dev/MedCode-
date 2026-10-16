/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testabanco;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author DENISE NEVES
 */
public class NFrame extends JFrame{
   public NFrame(){ 
    Color cor = new Color(169,169,169);
   
    Container c = getContentPane();
    setLocation(100,50);
    setTitle("A3-Controle de Gastos");
    setSize(800,500);
    setUndecorated(true);
    c.setBackground (cor);
    getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,3));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public static void main(String arg[]){
   new NFrame().show();
   }
}