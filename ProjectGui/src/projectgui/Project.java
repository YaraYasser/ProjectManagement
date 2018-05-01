/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.util.ArrayList;
import projectgui.*;

/**
 *
 * @author DELL_PC
 */
public class Project extends AbstractFunction{
    int id;
    String langua;
  
    Department objDepartment ;
   int ProjectLinesInFileRequired = 5; 
   protected String project_id;
   protected String project_Name;
   protected String project_Tasks;
   protected String project_Desc;
   protected String dep; 
   protected ArrayList<String> OldData = new ArrayList<String>();
    FileFacade facade = new FileFacade();
    
   
    public String getProjectDescription(){
    return project_Desc;
    }
    public void getTask()
    {
    // return list of tasks 
        
    }
    public Project(String project_id,String project_Name,String dep, String project_Tasks, String project_Desc)
    {
        this.project_id=project_id;
        this.project_Name=project_Name;
        this.dep=dep;
       
        this.project_Tasks=project_Tasks;
        this.project_Desc=project_Desc;
    }
    public Project()
    {
    project_id = "";
    project_Name = "";
    project_Tasks = "";
    project_Desc = "";
    dep = ""; 
    }
    @Override
    public void add() {
       
         ArrayList<String> ElementsToBeAdded = new ArrayList<String>();
         ElementsToBeAdded.add(project_id);
         ElementsToBeAdded.add(project_Name);
         ElementsToBeAdded.add(dep);
         ElementsToBeAdded.add(project_Tasks);
         ElementsToBeAdded.add(project_Desc);
    facade.Add(accessor.ProjectFilePath, ElementsToBeAdded);
         
    }

    @Override
    public void update() {
       
      
        ArrayList<String> NewLines=new ArrayList<>();
        NewLines.add(project_id);
        NewLines.add(project_Name);
        NewLines.add(dep);
        NewLines.add(project_Tasks);
        NewLines.add(project_Desc);
         facade.UpdateFile(accessor.ProjectFilePath, OldData, NewLines);
     
    
    }

    @Override
    public void remove() {
    ArrayList<String>Lines=new ArrayList<>();
          
    ArrayList<String> LinesToBeRemoved = new ArrayList<String>();
         LinesToBeRemoved.add(project_id);
         LinesToBeRemoved.add(project_Name);
         LinesToBeRemoved.add(dep);
         LinesToBeRemoved.add(project_Tasks);
         LinesToBeRemoved.add(project_Desc);
    facade.remove(accessor.ProjectFilePath, LinesToBeRemoved);
    
       
    }


    @Override
    public ArrayList<String> getDataByID(String ID) {
    OldData = facade.getDataByID(ID,ProjectLinesInFileRequired); 
    return OldData;
    }
}
