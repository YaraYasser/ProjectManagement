/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gui;
import javafx.scene.control.RadioButton;
import javax.swing.*;
import projectgui.*;
/**
 *
 * @author yara
 */
public class RegisterationFactory {
    JTextField MemberIDLocal;
    JTextField FirstNameLocal;
    JTextField LastNameLocal;
    JTextField EmailLocal;
    JTextField Phonelocal;
    JTextField PasswordLocal;
    JRadioButton MemberType;
    RegisterationFactory(JTextField MemberID,JTextField TxtBox_FirstName,JTextField TxtBox_LastName,JTextField TxtBox_Email,JTextField TxtBox_Phone,JTextField TxtBox_Password,JRadioButton Admin){
    MemberIDLocal = MemberID;
    FirstNameLocal = TxtBox_FirstName;
    LastNameLocal = TxtBox_LastName;
    EmailLocal = TxtBox_Email;
    Phonelocal = TxtBox_Phone;
    PasswordLocal = TxtBox_Password;
    MemberType = Admin;
    }
    public  registration getregister(){
    if((FirstNameLocal.toString().isEmpty()) || (LastNameLocal.toString().isEmpty()) || (EmailLocal.toString().isEmpty()) || (Phonelocal.toString().isEmpty()) || (PasswordLocal.toString().isEmpty())){
    return new NullRegisteration();
    }
    return new ProxiRegistration(MemberIDLocal,FirstNameLocal, LastNameLocal, EmailLocal, Phonelocal, PasswordLocal, MemberType);
    }
}
