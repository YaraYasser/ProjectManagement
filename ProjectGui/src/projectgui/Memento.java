/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.util.List;

/**
 *
 * @author yara
 */
public class Memento {
   AbstractFunction UserAction;
   String state;

    public Memento() {
   state = "";
    }
   
   
   
   public void setMomento(AbstractFunction action,String ActionType){
       
   UserAction = action;
   state = ActionType;
   }
   
   public AbstractFunction getMemento(){
    return UserAction;
    
   }
   
   public String getActionType(){
   return state;
   }
           
}
