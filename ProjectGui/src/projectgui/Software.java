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
public abstract class Software extends Resource{
    @Override
    public abstract void add();

    @Override
    public abstract void update(String Id);
    
}