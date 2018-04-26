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
public class RemoteControl {
    CommandInterface command;
    public void setCommand(CommandInterface EnteredCommand){
    command = EnteredCommand;
    }
    public void ButtonControl(){
    command.excute();
    }
}
