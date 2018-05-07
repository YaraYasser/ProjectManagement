/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import projectgui.*;
import java.util.ArrayList;




/**
 *
 * @author DELL_PC
 */
public class Task extends AbstractFunction{
  
  public String id;
  public String name;
 public  String date_start;
  public String date_finish;
  public String status;
  public String MemberId;
  String PrivateChanged_StartDate;
  String PrivateChanged_EndDate;
  String PrivateChanged_Status;
   FileFacade facade = new FileFacade();
 // protected JTextField status;
  public boolean  bool =true;
//  String TID =id.getText();
  protected ArrayList<Member>m= new ArrayList<>();
  protected ArrayList<Resource> r=new ArrayList<>();
    public Task(String id,String name,String date_start,String date_finish,String status,String MemberID)
        {
            this.id=id;
            this.name=name;
            this.date_finish=date_finish;
            this.date_start=date_start;
            this.status=status;
            this.MemberId = MemberID;
            
        }
     public Task()
     {
        
     }

   
//    public String Change_status(){
//        if(status=="Done")
//        {
//            status="Done";
//          
//        }
//        else if(status=="pending")
//        {
//            status="pending";
//         
//        }
//         return status;
//    }
     
    public String getTaskID(){
    return id;
    }
    
      public String getStartDate(){
    return date_start;
    }

    public String getEndDate(){
    return date_finish;
    }
    
    public String getName(){
    return name;
    }
  
    public String getStatus(){
    return status;
    }
    
    public String getMemberID(){
    return MemberId;
    }
    
      
    
    public void add_resource(){
        
    }
    
    @Override
    public void add() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      String ID =id;
       String Name =name;
       String form_date =date_start;
       String to_date =date_finish;
       String Status =status;
       String MemberID = MemberId;
     ArrayList<String> arr = new ArrayList<String>();
     arr.add(ID);
     arr.add(Name);
     arr.add(form_date);
     arr.add(to_date);
     arr.add(Status);
     arr.add(MemberID);
     
     facade.Add(accessor.TaskPathFile, arr);
    }

    @Override
    public void update() {  
        ArrayList<String> TasksOldData = new ArrayList<>();
        
        TasksOldData = facade.getDataByID(accessor.TaskPathFile,id, 6);        
        ArrayList<String> UpdatedLines = new ArrayList<>();
   UpdatedLines.add(id);
   UpdatedLines.add(name);
   UpdatedLines.add(date_start);
   UpdatedLines.add(date_finish);
   UpdatedLines.add(status);
   UpdatedLines.add(MemberId);
     
          facade.UpdateFile(accessor.TaskPathFile, TasksOldData, UpdatedLines,6);
        
            
    }

  @Override
    public void remove() {
      
          // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           ArrayList<String>Lines=new ArrayList<>();
         String  RID=id;
        String  Taskname = name;
        String startDate = date_start;
        String EndDate = date_finish;
        String LocalStatus = status;
        String MemberID = MemberId;
        
      Lines.add(RID);
      Lines.add(Taskname);
      Lines.add(startDate);
      Lines.add(EndDate);
      Lines.add(LocalStatus);
      Lines.add(MemberID);
      
     
      facade.remove(accessor.TaskPathFile, Lines);
      
    }
    public String getMembersNames(String MemberID){
     return facade.getMemberName(accessor.NormalMemberFilePath, MemberID);

    }

    @Override
    public ArrayList<String> getDataByID(String ID) {
    return facade.getDataByID(accessor.TaskPathFile,ID, 6);
    
    }
}
