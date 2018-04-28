/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import projectgui.Department;

/**
 *
 * @author yara
 */
public class Desktop extends Department{

 String language;
    JLabel Name;
    public Desktop(JLabel Name)
    {
        this.Name=Name;
    }
    @Override
    public void returnimage()
    {
        ImageIcon icon=new ImageIcon("/home/yara/Documents/4year/OODP/Project/desktop.jpg");
        Name.setIcon(icon);
    }

    @Override
    public String returnlanguage() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        name = "C# , C++ , Java ";
        return  name;
    }
    
}
