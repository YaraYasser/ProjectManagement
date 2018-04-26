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
public class ProxiRegistration extends registration{
            RealRegisteration realObj;
            JRadioButton Admin;
             JTextField LocalID;
             JTextField LocalFirstName;
             JTextField LocalLastName;
             JTextField LocalEmail;
             JTextField LocalPhone;
             JTextField LocalPassword;
             JRadioButton LocalAdmin;
     public ProxiRegistration()
     {}
     public ProxiRegistration(JTextField IDEntered,JTextField FirstNameEnteredData,JTextField LastNameEnteredData,JTextField EmailEnteredData,JTextField PhoneEnteredData,JTextField Password,JRadioButton EnteredAdmin) {
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
    
}
