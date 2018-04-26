/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import projectgui.Task;
import projectgui.Project;
import projectgui.Member;
import projectgui.Department;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *C:\\Users\\compac\\Desktop\\
 * @author DELL_PC
 */
public class Projectmanager extends Member{
    Project p;
    Department D;
    ArrayList<Member>member=new ArrayList<>();
      
     private Projectmanager(){
     
     }
    public static synchronized Member getInstance() {
       if (instance == null) {
          instance = new Projectmanager();
       }

       return instance;
    }       
    
    public void createproject(){
        p= new Project();
    }
    public void createtask(){
        t= new Task();
    }

    @Override
    public void add() {
       ArrayList<String> Lines = new ArrayList<String>();
  
        String Frist_Name =ParentFirstName.getText();
       String Last_Name =ParentLastName.getText();
       String email =ParentEmail.getText();
       String phone =ParentPhone.getText();
       String password =ParentPassword.getText();
       Lines.add(Frist_Name);
       Lines.add(Last_Name);
       Lines.add(email);
       Lines.add(phone);
       Lines.add(password);
  
        String FilePath = "/home/yara/Documents/4year/OODP/Manager.txt";
     facadeObject.Add(FilePath,Lines);
    
        
    }

    @Override
    public void update() {
         facadeObject.UpdateFile("/home/yara/Documents/4year/OODP/Manager.txt", instance.ParentEmail.getText(), LocalChangedEmail.getText());
          instance.ParentEmail =  LocalChangedEmail;     
      }

    @Override
    public boolean isNull() {
        if(instance != null){
        return false;
        }
        return true;    
    }

    @Override
    public void setDataToBeUpdated(JTextField ChangedEmail) {
  LocalChangedEmail = ChangedEmail;
    }

    @Override
    public void remove() {
      
    ArrayList<String> linesToRemove = new ArrayList<String>();
    linesToRemove.add(ParentFirstName.getText());
    linesToRemove.add(ParentLastName.getText());
    linesToRemove.add(ParentEmail.getText());
    linesToRemove.add(ParentPhone.getText());
    linesToRemove.add(ParentPassword.getText());
   
    facadeObject.remove("/home/yara/Documents/4year/OODP/Manager.txt",linesToRemove);
    }
    
}
