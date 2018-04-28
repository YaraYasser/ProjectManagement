/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javafx.scene.control.RadioButton;
import javax.swing.*;

/**
 *
 * @author compac
 */
public class Proxi implements registration{
            RealRegisteration realObj;
            JRadioButton Admin;
             String LocalID;
             String LocalFirstName;
             String LocalLastName;
             String LocalEmail;
             String LocalPhone;
             String LocalPassword;
             JRadioButton LocalAdmin;
             String ManagerFilePath = "/home/yara/Documents/4year/OODP/Project/Manager.txt";
             String NormalMemberFilePath = "/home/yara/Documents/4year/OODP/Project/NormalM.txt";
     public Proxi()
     {}
     public Proxi(String IDEntered,String FirstNameEnteredData,String LastNameEnteredData,String EmailEnteredData,String PhoneEnteredData,String Password,JRadioButton EnteredAdmin) {
    LocalID = IDEntered;
    LocalFirstName = FirstNameEnteredData;
    LocalLastName = LastNameEnteredData;
    LocalEmail = EmailEnteredData;
    LocalPhone = PhoneEnteredData;
    LocalPassword = Password;
    Admin = EnteredAdmin;
    }  
     
@Override
    public void setData() {
        // check for admin or member
        
   if(Admin.isSelected()){
   realObj = new RealRegisteration(LocalID,LocalFirstName, LocalLastName, LocalEmail, LocalPhone,LocalPassword, "ProjectManager");
   }
   else{
   realObj = new RealRegisteration(LocalID,LocalFirstName, LocalLastName, LocalEmail, LocalPhone,LocalPassword, "NormalMember");

   }
      realObj.setData();
    }

    @Override
    public boolean isNull() {
   
        return false;
    }

    public boolean CheckAuthonticationForAdmin(String Email,String Password) {
    FileFacade FileChecker = new FileFacade();
    boolean checker = FileChecker.ChickExistence(ManagerFilePath,Email, Password);
    if(checker == true){
    MemberFactory admin = new MemberFactory();
    Member adminMember = admin.getmember("ProjectManager");
    FileChecker.setMemberDataAfterSignIN(adminMember,ManagerFilePath, Email,Password,"ProjectManager");
    }
    return checker;
    }
    
    public boolean CheckAuthonticationForMember(String Email,String Password) {
        
    FileFacade FileChecker = new FileFacade();
    boolean checker = FileChecker.ChickExistence(NormalMemberFilePath,Email, Password);
     if(checker == true){
    MemberFactory NormalMemberFactory = new MemberFactory();
    Member NormalMember = NormalMemberFactory.getmember("NormalMember");
    FileChecker.setMemberDataAfterSignIN(NormalMember, NormalMemberFilePath, Email, Password, "NormalMember");
    }
    return checker;
    
    }
    
}
