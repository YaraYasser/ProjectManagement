/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import projectgui.InterfaceDecorator;

/**
 *
 * @author yara
 */
public class CoreFunctionality extends InterfaceDecorator{
  
    public ArrayList<JComboBox> GetRegistertationDate(JComboBox Day,JComboBox Month,JComboBox Year){
         for(int i=1;i<=31;i++)
        {
        Day.addItem(i);
                }
        Month.addItem("Jan");
        Month.addItem("Feb");
        Month.addItem("Mar");
        Month.addItem("April");
        Month.addItem("May");
        Month.addItem("June");
        Month.addItem("July");
        Month.addItem("Augest");
        Month.addItem("Sep");
        Month.addItem("Oct");
        Month.addItem("Nov");
        Month.addItem("Dec");

        for(int i=1995;i<=2018;i++)
        {
        Year.addItem(i);
                }
        ArrayList<JComboBox> ReturnDateInfo = new ArrayList<JComboBox>();
        ReturnDateInfo.add(Day);
        ReturnDateInfo.add(Month);
        ReturnDateInfo.add(Year);
        return ReturnDateInfo;
    }
}
