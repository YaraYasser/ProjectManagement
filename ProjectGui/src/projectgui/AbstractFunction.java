/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.util.ArrayList;

/**
 *
 * @author compac
 */
public abstract class AbstractFunction {
       protected StringAccessor accessor = new StringAccessor(); 
  
        abstract public void add();
        abstract public void update();
        abstract public void remove();
        abstract public ArrayList<String> getDataByID(String ID);
     
    
}
