/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import projectgui.*;

/**
 *
 * @author DELL_PC
 */
public class Project extends AbstractFunction{
    int id;
    String langua;
  
    Department objDepartment ;
    
    String Description;
   protected JTextField project_id;
   protected JTextField project_Name;
   protected JTextArea project_Tasks;
   protected JTextArea project_Desc;
   protected  String dep; 
  // private static int NumberOfLinesToBeRemoved = 5;
   
    public String getProjectDescription(){
    return Description;
    }
    public void getTask()
    {
    // return list of tasks 
        
    }
    public Project(JTextField project_id,JTextField project_Name,String dep, JTextArea project_Tasks, JTextArea project_Desc)
    {
        this.project_id=project_id;
        this.project_Name=project_Name;
        this.dep=dep;
       
        this.project_Tasks=project_Tasks;
        this.project_Desc=project_Desc;
    }
    public Project()
    {
    }
    @Override
    public void add() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String id=project_id.getText();
        String name=project_Name.getText();
        String depart =dep;
        String pTasks=project_Tasks.getText();
        String pDesc=project_Desc.getText();
       
        String FilePath = "/home/yara/Documents/4year/OODP/Project.txt";
         ArrayList<String> ElementsToBeAdded = new ArrayList<String>();
         ElementsToBeAdded.add(id);
         ElementsToBeAdded.add(name);
         ElementsToBeAdded.add(depart);
         ElementsToBeAdded.add(pTasks);
         ElementsToBeAdded.add(pDesc);
     FileFacade facade = new FileFacade();
    facade.Add(FilePath, ElementsToBeAdded);
         
    }

    @Override
    public void update() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         ArrayList<String>Lines=new ArrayList<>();
           File file =new File("/home/yara/Documents/4year/OODP/Project.txt");
          BufferedReader br = null;
      try {
          br = new BufferedReader(new FileReader("/home/yara/Documents/4year/OODP/Project.txt"));
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
      }
          String str;
        String  UID=project_id.getText();
      try {
          while((str=br.readLine()) !=null)
          {
              
              Lines.add(str);
          }
          String UpadetString = project_id.getText() +" , "+dep+" , "+ project_Name.getText()+" , "+ project_Tasks.getText()+" , "+ project_Desc.getText();
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
            
          File f=new File("/home/yara/Documents/4year/OODP/Project.txt");
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
       
      String id=project_id.getText();
        String name=project_Name.getText();
        String depart =dep;
        String pTasks=project_Tasks.getText();
        String pDesc=project_Desc.getText();
       
            ArrayList<String>Lines=new ArrayList<>();
           String FilePath = "/home/yara/Documents/4year/OODP/Project.txt";
         
            ArrayList<String> LinesToBeRemoved = new ArrayList<String>();
         LinesToBeRemoved.add(id);
         LinesToBeRemoved.add(name);
         LinesToBeRemoved.add(depart);
         LinesToBeRemoved.add(pTasks);
         LinesToBeRemoved.add(pDesc);
     FileFacade facade = new FileFacade();
    facade.remove(FilePath, LinesToBeRemoved);
    
       
    }
}
