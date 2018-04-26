/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import projectgui.Department;
import projectgui.Department;

/**
 *
 * @author yara
 */
public class Android extends Department{

    String language;
    JLabel Name;
    public Android(JLabel Name)
    {
        this.Name=Name;
    }
    @Override
    public void returnimage()
    {
        ImageIcon icon=new ImageIcon("E:\\4th year\\2\\design pattern\\ProjectGui\\ProjectGui\\android.jpg");
        Name.setIcon(icon);
    }

    @Override
    public String returnlanguage() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        name ="Java";
        return name;
    }
    
    
}
