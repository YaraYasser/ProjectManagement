/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javax.swing.JLabel;
import projectgui.Desktop;
import projectgui.WebEng;
import projectgui.Department;
import projectgui.Android;

/**
 *
 * @author yara
 */
public class DepartmentFactory {

   public  JLabel llabetdep;
   public String LanguageType;
    public DepartmentFactory(String LanguageType,JLabel llabetdep) {
        this.LanguageType=LanguageType;
        this.llabetdep=llabetdep;
        
    }
    public DepartmentFactory(String LanguageType) {
        this.LanguageType=LanguageType;
        
    }
    
  public Department getDept(String Language){
        if(Language.equalsIgnoreCase("Android"))
        {
            return new Android(llabetdep);
        }
        
        else if(Language.equalsIgnoreCase("WEB"))
        {
            return new WebEng(llabetdep);
        }
        else if(Language.equalsIgnoreCase("Desktop"))
        {
            return new Desktop(llabetdep);
        }
       //
        
        return null;
   

  }
}