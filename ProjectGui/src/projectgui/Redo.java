/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;
import projectgui.*;

/**
 *
 * @author yara
 */
public class Redo implements CommandInterface{
    TaskSwitchController taskswitcher;
    public Redo(TaskSwitchController st) {
        
        taskswitcher = st;
    }
    
    @Override
    public void excute() {
     taskswitcher.add();
    }

    
    
}
