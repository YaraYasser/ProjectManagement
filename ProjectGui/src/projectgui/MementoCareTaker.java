/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.util.LinkedList;

/**
 *
 * @author yara
 */
public class MementoCareTaker {
 private final LinkedList<Memento> UserActions;
    private final LinkedList<Memento> UserRemovedActions;

    public MementoCareTaker() {
    UserActions = new LinkedList<>();
    UserRemovedActions = new LinkedList<>();
    }
    
 public void Save(AbstractFunction action,String ActionType){
 if(UserActions.size()>5){
 UserActions.remove(0);
 }
 Memento memntoObject = new Memento();
 memntoObject.setMomento(action,ActionType);
 UserActions.addLast(memntoObject);
 }
 public AbstractFunction restore(){
     
     UserRemovedActions.add(UserActions.getLast());
     if(UserRemovedActions.size() > 5){
     UserRemovedActions.remove(0);
     }
     
 Memento returnedData = UserActions.getLast();
 return returnedData.getMemento();
 }
 
 public AbstractFunction RedoRestoredData(){
  Memento returnedData = UserRemovedActions.get(UserRemovedActions.size()-1);
  return returnedData.getMemento();
 }
 public String getLastActionType(){
 Memento temp = UserActions.get(UserActions.size()-1);
 return temp.getActionType();
 }
}
