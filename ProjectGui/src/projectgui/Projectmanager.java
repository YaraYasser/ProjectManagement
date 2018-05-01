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
    public void createtask(){
        ParentTaskObject = new Task();
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
     
          facadeObject.UpdateFile(accessor.ManagerFilePath, LinesToBeUpdated, LinesUpdated);
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
