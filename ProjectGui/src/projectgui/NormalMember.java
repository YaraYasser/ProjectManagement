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
    public void AssignTask(String parMemberID, String parMemberTaskID) {
        ArrayList<String> DataToBeAdded = new ArrayList<String>();
        ArrayList<String> TasksData = new ArrayList<String>();
       
        TasksData = facadeObject.getDataByID(accessor.NormalMemberFilePath,parMemberTaskID, 6);
         Task tempTask = new Task();        
        tempTask.id = parMemberTaskID;
       tempTask.name = TasksData.get(1);
        tempTask.date_start = TasksData.get(2);
        tempTask.date_finish = TasksData.get(3);
        tempTask.status = TasksData.get(4);
       tempTask.MemberId = parMemberID;
       ParentTaskObject.add(tempTask);
       
        DataToBeAdded.add(parMemberID);
        DataToBeAdded.add(parMemberTaskID);
    facadeObject.Add(accessor.FileTaskMemberRelationPath,DataToBeAdded);
    }

    @Override
    public ArrayList<String> getDataByID(String ID) {
   return facadeObject.getDataByID(accessor.NormalMemberFilePath,ID, 6);
    }

    @Override
    public void Remove_MemberTask_Relation(String parMemberID, String parTaskID) {
    
            ArrayList<String> linesToRemove = new ArrayList<String>();
    linesToRemove.add(parMemberID);
    linesToRemove.add(parTaskID);
    
    facadeObject.removeRelation(accessor.FileTaskMemberRelationPath,linesToRemove);
   
        
    }

    
    
    
}
