/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.util.ArrayList;

/**
 *
 * @author DELL_PC
 */
public abstract class Member extends AbstractFunction{
    
    protected ArrayList<Task> ParentTaskObject;
    public FileFacade facadeObject = new FileFacade();
    protected String ParentID;
    protected String ParentFirstName;
    protected String ParentLastName;
    protected String ParentEmail;
    protected String ParentPhone;
    protected String ParentPassword;
    protected String LocalChangedEmail;
    protected String Department;
    protected String LocalChangedPassword;
    protected String LocalChangedphone;
    public String MemberType; // is this the best way to save the member type???
    protected static Member instance;
    
    protected Member(){
    ParentTaskObject = new ArrayList<>();
    }
  
    public void fillClassData(String MemberIDEnteredData,String FirstNameEnteredData,String LastNameEnteredData
            ,String EmailEnteredData,String PhoneEnteredData,String LocalPassword,String type){
    ParentID = MemberIDEnteredData;
    ParentFirstName = FirstNameEnteredData;
    ParentLastName = LastNameEnteredData;
    ParentEmail = EmailEnteredData;
    ParentPhone = PhoneEnteredData;
    ParentPassword = LocalPassword;
    MemberType = type;
    }
    public String getMemberID(){
    return ParentID;
    }
    
    @Override
    public abstract void add();

    @Override
    public abstract void update();
    
    public abstract boolean isNull();
    
    @Override
    public abstract void remove();
    
    public abstract void setDataToBeUpdated(ArrayList<String> NewData);
    
    public abstract void AssignTask(String parMemberID,String parMemberTask);
    
    public abstract void Remove_MemberTask_Relation(String parMemberID,String parTaskID);
    
    
    
}
