/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.awt.TextField;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.JTextField;
import projectgui.Member;

/**
 *
 * @author DELL_PC
 */
public class NormalMember extends Member {
    public int duration;
    public int noOfTasks;
    
     
    public static synchronized Member getInstance() {
       if (instance == null) {
          instance = new NormalMember();
       }

       return instance;
    }       
    

    @Override
    public void add() {
      ArrayList<String> Lines = new ArrayList<String>();
              
       String Frist_Name = (ParentFirstName.getText());
       String Last_Name = ParentLastName.getText();
       String email = ParentEmail.getText();
       String phone = ParentPhone.getText();
       String passwordd = ParentPassword.getText();
       Lines.add(Frist_Name);
       Lines.add(Last_Name);
       Lines.add(email);
       Lines.add(phone);
      Lines.add(passwordd);
     String FilePath = "/home/yara/Documents/4year/OODP/NormalM.txt";
     facadeObject.Add(FilePath,Lines);
    }

    @Override
    public void update() { 
     facadeObject.UpdateFile("/home/yara/Documents/4year/OODP/NormalM.txt", instance.ParentEmail.getText(), LocalChangedEmail.getText());
      instance.ParentEmail =  LocalChangedEmail;
     //instance.ParentPhone = ChangedMobile;
    // instance.ParentPassword = Changedpassword;
    }

    @Override
    public boolean isNull() {
        if(instance == null){
        return true;
        }
      return false;
    }
     public void changetaskstatus(){
        
    }
     public void setDataToBeUpdated(JTextField ChangedEmail/*,JTextField ChangedMobile,JTextField Changedpassword*/){
    LocalChangedEmail = ChangedEmail;
  //  LocalChangedMobile = ChangedMobile;
    //LocalChangedpassword = Changedpassword;
     
     }

    @Override
    public void remove() {
         
    ArrayList<String> linesToRemove = new ArrayList<String>();
    linesToRemove.add(ParentFirstName.getText());
    linesToRemove.add(ParentLastName.getText());
    linesToRemove.add(ParentEmail.getText());
    linesToRemove.add(ParentPhone.getText());
    linesToRemove.add(ParentPassword.getText());
   
    facadeObject.remove("/home/yara/Documents/4year/OODP/NormalM.txt",linesToRemove);
   
    }
}
