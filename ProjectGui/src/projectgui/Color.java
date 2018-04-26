/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectgui;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import static java.awt.Color.red;
import javax.swing.JFrame;

/**
 *
 * @author yara
 */
public class Color extends OptionalDecorator{
    
//javax.swing.JFrame
//  protected JButton DarkGary;
    JFrame frm;
    String color;
  public  Color(JFrame frm, String color )
  {
     this.frm=frm;
    this.color=color;
  }
 @Override
 public  void changeBackgroud()
 {
     if(color.equals("pink"))
     {
          Container pane=frm.getContentPane();
             pane.setBackground(java.awt.Color.pink);
             
     }
     
     
 }



   

   
 

   
    
}
