/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

/**
 *
 * @author yara
 */
public class NullRegisteration extends registration{

       RealRegisteration realObj;
     ButtonGroup MemberType;
     Member memberObject;
    
    @Override
    public void setData() {
      
    }

    @Override
    public boolean isNull() {
 return true;
    }
    
}
