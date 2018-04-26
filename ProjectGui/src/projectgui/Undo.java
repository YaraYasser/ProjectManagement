/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import projectgui.TaskSwitchController;
import projectgui.CommandInterface;

/**
 *
 * @author yara
 */
public class Undo implements CommandInterface{
  TaskSwitchController taskswitcher ;
    public Undo(TaskSwitchController switcher) {
        taskswitcher = switcher;
    }

    
    @Override
    public void excute() {
    taskswitcher.delete();
    }

    
}
