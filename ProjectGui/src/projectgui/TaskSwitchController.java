/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;
import  projectgui.*;
/**
 *
 * @author yara
 */
public class TaskSwitchController {
  AbstractFunction RequiredClassToCommand;

    public TaskSwitchController(AbstractFunction UsedClass) {
    RequiredClassToCommand = UsedClass;
    }
  
    public void add(){
      RequiredClassToCommand.add();
   }
   public void delete(){
   RequiredClassToCommand.remove();
   }
}
