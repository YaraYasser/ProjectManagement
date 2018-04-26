/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import projectgui.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import java.io.Writer;
import javax.swing.JLabel;




/**
 *
 * @author DELL_PC
 */
public class Task extends AbstractFunction{
  
  protected JTextField id;
  protected JTextField date_start;
  protected JTextField date_finish;
  protected JTextField name;
  protected JTextField status;
  protected JTextField MemberId;
 // protected JTextField status;
  public boolean  bool =true;
//  String TID =id.getText();
  protected ArrayList<Member>m= new ArrayList<>();
  protected ArrayList<Resource> r=new ArrayList<>();
    public Task(JTextField id,JTextField name,JTextField date_start,JTextField date_finish,JTextField status,JTextField MemberID)
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
    public void add_resource(){
        
    }

    @Override
    public void add() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      String ID =id.getText();
       String Name =name.getText();
       String form_date =date_start.getText();
       String to_date =date_finish.getText();
       String Status =status.getText();
       String MemberID = MemberId.getText();
     ArrayList<String> arr = new ArrayList<String>();
     arr.add(ID);
     arr.add(Name);
     arr.add(form_date);
     arr.add(to_date);
     arr.add(Status);
     arr.add(MemberID);
     String PathFile = "/home/yara/Documents/4year/OODP/Task.txt";
      FileFacade facade = new FileFacade();
      facade.Add(PathFile, arr);
    }

    @Override
    public void update() {  // Please Use Facade here 
         ArrayList<String>Lines=new ArrayList<>();
           File file =new File("/home/yara/Documents/4year/OODP/Task.txt");
          BufferedReader br = null;
      try {
          br = new BufferedReader(new FileReader("/home/yara/Documents/4year/OODP/Task.txt"));
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
      }
          String str;
        String  UID=id.getText();
      try {
          while((str=br.readLine()) !=null)
          {
              
              Lines.add(str);
          }
          String UpadetString = id.getText() +" , "+ name.getText()+" , "+ date_start.getText()+" , "+ date_finish.getText()+" , "+status.getText();
             for (int i=0 ;i<Lines.size();i++)
            {
               String line=Lines.get(i).trim();
               String[] datarow =line.split(" , ");
               if(datarow[0].equals(UID))
               {
                   Lines.set(i,UpadetString );
               }   
            }
             PrintWriter Pwriter = new PrintWriter(file);
          Pwriter.print("");
           Pwriter.close();
            
          File f=new File("/home/yara/Documents/4year/OODP/Task.txt");
          FileWriter writer = new FileWriter(f.getAbsoluteFile(), true);
           BufferedWriter bw=new BufferedWriter(writer);
            for(String x:Lines)
            {
                bw.write(x);
                 bw.newLine();
            }
            bw.close();
             
      } catch (IOException ex) {
          Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
      }
          
            
    }

  @Override
    public void remove() {
      
          // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           ArrayList<String>Lines=new ArrayList<>();
           String Path = "/home/yara/Documents/4year/OODP/Task.txt";
         
        String  RID=id.getText();
        String  Taskname = name.getText();
        String startDate = date_start.getText();
        String EndDate = date_finish.getText();
        String LocalStatus = status.getText();
        String MemberID = MemberId.getText();
        
      Lines.add(RID);
      Lines.add(Taskname);
      Lines.add(startDate);
      Lines.add(EndDate);
      Lines.add(LocalStatus);
      Lines.add(MemberID);
      
      FileFacade facade = new FileFacade();
      facade.remove(Path, Lines);
      
    }
}
