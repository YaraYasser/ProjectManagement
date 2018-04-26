/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import javax.swing.JTextField;


/**
 *
 * @author DELL_PC
 */
public abstract class Member extends AbstractFunction{
    
    protected  Task t;
    public FileFacade facadeObject = new FileFacade();
    protected JTextField ID;
    protected JTextField ParentFirstName;
    protected JTextField ParentLastName;
    protected JTextField ParentEmail;
    protected JTextField ParentPhone;
    protected JTextField ParentPassword;
    protected JTextField LocalChangedEmail;
    protected String Department;
    
    public String MemberType; // is this the best way to save the member type???
    protected static Member instance;
    
    protected Member(){
    
    }
  
    public void fillClassData(JTextField MemberIDEnteredData,JTextField FirstNameEnteredData,JTextField LastNameEnteredData,JTextField EmailEnteredData,JTextField PhoneEnteredData,JTextField LocalPassword,String type){
    ID = MemberIDEnteredData;
    ParentFirstName = FirstNameEnteredData;
    ParentLastName = LastNameEnteredData;
    ParentEmail = EmailEnteredData;
    ParentPhone = PhoneEnteredData;
    ParentPassword = LocalPassword;
    MemberType = type;
    }
    @Override
    public abstract void add();

    @Override
    public abstract void update();
    public abstract boolean isNull();
    @Override
    public abstract void remove();
     public abstract void setDataToBeUpdated(JTextField ChangedEmail);
}
