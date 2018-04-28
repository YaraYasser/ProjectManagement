/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javax.swing.*;

/**
 *
 * @author yara
 */
public class NullRegisteration implements registration{

       RealRegisteration realObj;
     ButtonGroup MemberType;
     Member memberObject;
    
    @Override
    public void setData() {
          throw new UnsupportedOperationException("set Data with null registeration"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNull() {
 return true;
    }
  
}
