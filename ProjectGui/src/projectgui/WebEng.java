package projectgui;



import javax.swing.ImageIcon;
import javax.swing.JLabel;
import projectgui.Department;
import projectgui.Department;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yara
 */
public class WebEng extends Department{
   String language;
    JLabel Name;
    String WebImageIcon = "/home/yara/Documents/4year/OODP/Project/ProjectGui/web.png";
    public WebEng(JLabel Name)
    {
        this.Name=Name;
    }
    @Override
    public void returnimage()
    {
        ImageIcon icon=new ImageIcon(WebImageIcon);
        Name.setIcon(icon);
    }

    @Override
    public String returnlanguage() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         name =" Html ,Css...";
        return name;
    }
    
    
}
