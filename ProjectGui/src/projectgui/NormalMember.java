/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;


import java.util.ArrayList;
import projectgui.*;

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
       
       String ID = ParentID;       
       String Frist_Name = ParentFirstName;
       String Last_Name = ParentLastName;
       String email = ParentEmail;
       String phone = ParentPhone;
       String passwordd = ParentPassword;
       Lines.add(ID);
       Lines.add(Frist_Name);
       Lines.add(Last_Name);
       Lines.add(email);
       Lines.add(phone);
      Lines.add(passwordd);
     facadeObject.Add(accessor.NormalMemberFilePath,Lines);
    }

    @Override
    public void update() { 
     ArrayList<String> LinesToBeUpdated = new ArrayList<String>();
     LinesToBeUpdated.add(instance.ParentEmail);
     LinesToBeUpdated.add(instance.ParentPhone);
     LinesToBeUpdated.add(instance.ParentPassword);
     
     ArrayList<String> LinesUpdated = new ArrayList<String>();
     LinesUpdated.add(instance.LocalChangedEmail);
     LinesUpdated.add(instance.LocalChangedphone);
     LinesUpdated.add(instance.LocalChangedPassword);
     
     facadeObject.UpdateFile(accessor.NormalMemberFilePath, LinesToBeUpdated, LinesUpdated);
      instance.ParentEmail =  LocalChangedEmail;
     instance.ParentPhone = instance.LocalChangedphone;
     instance.ParentPassword = instance.LocalChangedPassword;
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
     @Override
     public void setDataToBeUpdated(ArrayList<String> NewData){
    LocalChangedEmail = NewData.get(0);
    LocalChangedphone = NewData.get(1);
    LocalChangedPassword = NewData.get(2);
     
     }

    @Override
    public void remove() {
         
    ArrayList<String> linesToRemove = new ArrayList<String>();
    linesToRemove.add(ParentFirstName);
    linesToRemove.add(ParentLastName);
    linesToRemove.add(ParentEmail);
    linesToRemove.add(ParentPhone);
    linesToRemove.add(ParentPassword);
   
    facadeObject.remove(accessor.NormalMemberFilePath,linesToRemove);
   
    }

    @Override
    public void AssignTask(String parMemberID, String parMemberTask) {
        ArrayList<String> DataToBeAdded = new ArrayList<String>();
        DataToBeAdded.add(parMemberID);
        DataToBeAdded.add(parMemberTask);
    facadeObject.Add(accessor.FileTaskMemberRelationPath,DataToBeAdded);
    }

    @Override
    public ArrayList<String> getDataByID(String ID) {
   return facadeObject.getDataByID(ID, 6);
    }
    
    
}
