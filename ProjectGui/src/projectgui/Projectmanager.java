/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;
import java.util.ArrayList;

public class Projectmanager extends Member{
    Project projectObject;
    Department D;
    ArrayList<Member>member=new ArrayList<>();
     String TaskID ;
    
     private Projectmanager(){
     
     }
    public static synchronized Member getInstance() {
       if (instance == null) {
          instance = new Projectmanager();
       }

       return instance;
    }       
    
    public void createproject(){
        projectObject = new Project();
    }
 

    @Override
    public void add() {
       ArrayList<String> Lines = new ArrayList<String>();
       String ID = ParentID; 
       String Frist_Name =ParentFirstName;
       String Last_Name =ParentLastName;
       String email =ParentEmail;
       String phone =ParentPhone;
       String password =ParentPassword;
       Lines.add(ID);
       Lines.add(Frist_Name);
       Lines.add(Last_Name);
       Lines.add(email);
       Lines.add(phone);
       Lines.add(password);
  
         facadeObject.Add(accessor.ManagerFilePath,Lines);
    
        
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
     
          facadeObject.UpdateFile(accessor.ManagerFilePath, LinesToBeUpdated, LinesUpdated,6);
          instance.ParentEmail =  LocalChangedEmail;
           instance.ParentPhone = instance.LocalChangedphone;
           instance.ParentPassword = instance.LocalChangedPassword;
      }

    @Override
    public boolean isNull() {
        if(instance != null){
        return false;
        }
        return true;    
    }
    @Override
    public void setDataToBeUpdated(ArrayList<String> NewData) {
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
   
    facadeObject.remove(accessor.ManagerFilePath,linesToRemove);
    }

    @Override
    public void AssignTask(String parMemberID, String parMemberTaskID) {
        ArrayList<String> DataToBeAdded = new ArrayList<String>();
        ArrayList<String> TasksData = new ArrayList<String>();
      if(ParentID.equalsIgnoreCase(parMemberID)){ 
        TasksData = facadeObject.getDataByID(accessor.TaskPathFile,parMemberTaskID, 6);
        TaskID = TasksData.get(0);
        Task tempTask = new Task();        
        tempTask.id = parMemberTaskID;
       tempTask.name = TasksData.get(1);
        tempTask.date_start = TasksData.get(2);
        tempTask.date_finish = TasksData.get(3);
        tempTask.status = TasksData.get(4);
       tempTask.MemberId = parMemberID;
       ParentTaskObject.add(tempTask);
      }
        DataToBeAdded.add(parMemberID);
        DataToBeAdded.add(parMemberTaskID);
    facadeObject.Add(accessor.FileTaskManagerRelationPath,DataToBeAdded);
    }

    @Override
    public ArrayList<String> getDataByID(String ID) {
     return facadeObject.getDataByID(accessor.ManagerFilePath,ID, 6);
    }

    @Override
    public void Remove_MemberTask_Relation(String parMemberID, String parTaskID) {
    
             ArrayList<String> linesToRemove = new ArrayList<String>();
    linesToRemove.add(parMemberID);
    linesToRemove.add( parTaskID );
    
    facadeObject.removeRelation(accessor.FileTaskManagerRelationPath,linesToRemove);
  
    }

  
    
}
