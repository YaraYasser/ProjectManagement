/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yara
 */
public class FileFacade {
    StringAccessor accessor = new StringAccessor();
    public void Add(String FilePath,ArrayList<String> Lines){
    
   
        File f=new File(FilePath);
        try (FileWriter writer = new FileWriter(f.getAbsoluteFile(), true); BufferedWriter bw = new BufferedWriter(writer)) {
            
            for(String x:Lines)
            {
                bw.write(x);
                 bw.newLine();
            }
}
       
        catch(IOException ex){
            }
    }
    
    public void UpdateFile(String FilePath,ArrayList<String> LineToBeUpdated,ArrayList<String> UpdatedValue,int MaxNumberOfLinesForEachProject){
           
  ArrayList<String>Lines=new ArrayList<>();
    File fileToBeModified = new File(FilePath);
    String newContent = "";     
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
             
             for (int i=0;i< LineToBeUpdated.size();i++) {
                
             newContent = oldContent.replace(LineToBeUpdated.get(i), UpdatedValue.get(i));
             oldContent = newContent;    
            }
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }



    }
    public void remove(String FilePath, ArrayList<String> linesToRemove){
    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
 try{
    boolean Checker=false;
    String currentLine;
    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
    while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
        for (String string : linesToRemove) {
    if(trimmedLine.equals(string)){ 
        Checker = true;
        break;}
            
        }
        if(Checker){
        Checker = false;
        continue;
        }
    
    writer.write(currentLine + System.getProperty("line.separator"));
    
   }
    writer.close(); 
reader.close(); 
boolean successful = tempFile.renameTo(inputFile);

 }
 catch(Exception ex){
 
 }
    }
    public boolean ChickExistence(String FilePath,String UserName,String Password){
    boolean BothCheck=false;
    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
    try{
   
        boolean UserNameCheck=false;
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
         String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(UserName)){ 
        UserNameCheck = true;
        }
        else if(trimmedLine.equals(Password)){
          if(UserNameCheck == true){
            BothCheck = true;
          
            }
        }
    
        }
   
    reader.close(); 


    }
    catch(Exception ex){
 
    }
  return BothCheck;      
    }
    public void setMemberDataAfterSignIN(Member EnteredMember,String FilePath,String UserName,String Password,String type)
    {
        String Id = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        String phone = "";
        String password = "";
       
    boolean BothCheck=false;
    int counter =1;
    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
    try{
        
        boolean UserNameCheck=false;
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
        if(counter == 1){
        Id = currentLine.trim();
        }
        else if(counter == 2){
        firstName = currentLine.trim();
        }
        else if(counter == 3){
        lastName = currentLine.trim();
        }
        else if(counter == 4){
        email = currentLine.trim();
        }
         else if(counter == 5){
        phone = currentLine.trim();
        }
         else if(counter == 6){
        password = currentLine.trim();
        counter=0;
        }
       
         String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(UserName)){ 
        UserNameCheck = true;
        }
        else if(trimmedLine.equals(Password)){
          if(UserNameCheck == true){
            BothCheck = true;
          
            }
        }
        else if((UserNameCheck == true)&& (counter == 5)){
            counter++;
        continue;
        }
        else{
            if((BothCheck == false) && (counter == 0)){
            UserNameCheck = false;
            Id = "";
            firstName = "";
            lastName = "";
            email = "";
            phone = "";
            password = "";
            }
            } 
    if(BothCheck == true){
      EnteredMember.fillClassData(Id, firstName, lastName,email, phone, password, type);
      break;
    }
      counter++;
     
        }
     
    reader.close(); 


    }
    catch(Exception ex){
 
    }
   
    
    
        
    }
    
    
    public Member getMemberTasks(String RelationFilePath,Member CurrentMember){
    
         String TaskId = "";
        String TaskName = "";
        String TaskStart_Date = "";
        String TaskEnd_Date = "";
        String TaskStatus = "";
        String MemberAsignedID = "";
       ArrayList<String> TasksIDs = new ArrayList<>();
    boolean Checker =false;
    int counter =1;
    File inputFile = new File(RelationFilePath);
    try{
        
        boolean IDCheck=false;
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
           if((counter == 1)&& (CurrentMember.ParentID.equalsIgnoreCase(currentLine.trim()))){
        Checker = true;
       
           }
    
           else if(Checker==true){
           
           TasksIDs.add(currentLine.trim());
               counter = 0;
               Checker = false;
           }
           else if(counter == 2){
           counter =0;
           }
           counter++;
       }
    reader.close(); 


    
    }
    catch(Exception ex){
 
    }
   // get the tasks data 
   
    boolean taskIDChecker=false;
    int taskCounter =1;
    File taskInputFile = new File(accessor.TaskPathFile);
    File tempFile = new File(accessor.TempFilePath);
    Task tempTask = new Task();
    try{
        
        boolean UserNameCheck=false;
        String currentTaskLine;
        BufferedReader reader = new BufferedReader(new FileReader(taskInputFile));
  
       while((currentTaskLine = reader.readLine()) != null) {
           for (String TasksID : TasksIDs) {
               
        if((taskCounter == 1) && (TasksID.equalsIgnoreCase(currentTaskLine.trim()))){
        taskIDChecker = true;
        tempTask.id = TasksID;
        break;
        }
        else if (taskCounter > 1){
        break;
        }
      
           }
           
           if((taskIDChecker==true) && (taskCounter == 2)){
           tempTask.name = currentTaskLine.trim();
           }
           else if((taskIDChecker==true) && (taskCounter == 3)){
           tempTask.date_start = currentTaskLine.trim();
           }
           else if((taskIDChecker==true) && (taskCounter == 4)){
           tempTask.date_finish = currentTaskLine.trim();
           }
           else if((taskIDChecker==true) && (taskCounter == 5)){
           tempTask.status = currentTaskLine.trim();
           }
           else if((taskIDChecker==true) && (taskCounter == 6)){
           tempTask.MemberId = currentTaskLine.trim();
           taskIDChecker = false;
           taskCounter = 0;
           CurrentMember.ParentTaskObject.add(tempTask);
           }
           if(taskCounter == 6){
           taskCounter = 0;
           }
           
           taskCounter++;    
           }
    reader.close(); 


    }
    catch(Exception ex){
 
    }
    return CurrentMember;
    }
   public String getMemberName(String FilePath,String MemberID){
   
    String firstName = "";
    String lastName = "";
        
    int counter =1;
    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
    try{
        
        boolean Checker=false;
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
        if(counter == 1){
        if(MemberID.equalsIgnoreCase(currentLine.trim()))
           Checker = true;
        }
        else if((counter == 2)&& (Checker == true)){
        firstName = currentLine.trim();
        }
        else if((counter == 3) && (Checker == true)){
        lastName = currentLine.trim();
        }
      if(counter == 6){
      counter =1;
      }
      else{
       counter++;
      }
        }
       
    reader.close(); 
   
    }
    catch(Exception ex){
 
    }
    String FullName = firstName + " " + lastName;
    return FullName;     
   } 
   
   public ArrayList<Task> getMemberTasks(String ParMembetID) {
   String LocalId = "";
   String Local_date_start = "";
   String Local_date_finish = "";
   String LocalName = "";
   String Local_status = "";
   ArrayList<Task> ReturnedTasksArrayList = new ArrayList<>();
    int counter =1;
    File inputFile = new File(accessor.TaskPathFile);
    File tempFile = new File(accessor.TempFilePath);
    try{
      
        String currentLine;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
        if(counter == 1){
        LocalId = currentLine.trim();
        }
        else if(counter == 2){
        LocalName = currentLine.trim();
        }
        else if(counter == 3){
        Local_date_start = currentLine.trim();
        }
        else if(counter == 4){
        Local_date_finish = currentLine.trim();
        }
         else if(counter == 5){
        Local_status = currentLine.trim();
        }
         else if(counter == 6){
        if(ParMembetID.equalsIgnoreCase(currentLine.trim())){
            Task tempTasObject = new Task(LocalId, LocalName, Local_date_start, Local_date_finish, Local_status, ParMembetID);
            ReturnedTasksArrayList.add(tempTasObject);
        }
        counter = 1;
         }
        counter++;
        }
       
       
    
    reader.close(); 
   
    }
    catch(Exception ex){
 
    }
   
   return ReturnedTasksArrayList;
   }
   
  
   
public ArrayList<String> getDataByID(String FilePath,String ParProjectID,int MaxNumberOfLinesForEachProject) {
   
    
    ArrayList<String> ReturnedProjectData = new ArrayList<>();
    int counter =1;
    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
    boolean checker = false;
        String currentLine;
        
    try{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
  
       while((currentLine = reader.readLine()) != null) {
        if(counter == 1){
            if(ParProjectID.equalsIgnoreCase( currentLine.trim())){
                checker = true; 
        ReturnedProjectData.add(currentLine.trim());
            }
        }
        else if(counter <= MaxNumberOfLinesForEachProject){
        if(checker == true){
        ReturnedProjectData.add(currentLine.trim());
        }
        
        }
       if(counter == MaxNumberOfLinesForEachProject){
        counter = 0;
        }
        counter++;
       }
    
    reader.close(); 
   
    }
    catch(Exception ex){
 
    }
   
   return ReturnedProjectData;
   
}

public void removeRelation(String FilePath, ArrayList<String> linesToRemove){

    File inputFile = new File(FilePath);
    File tempFile = new File(accessor.TempFilePath);
        BufferedReader reader;
    BufferedWriter writer; 
    boolean Checker=false;
    String currentLine;
    int Counter = 1;    
    String tempForSavingFirstID = "";
    try{
    reader = new BufferedReader(new FileReader(inputFile));
    writer = new BufferedWriter(new FileWriter(tempFile));
    
    while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
        for (int i =0;i<linesToRemove.size();i++) {
    if((trimmedLine.equals(linesToRemove.get(i))) &&(Checker==false)){ 
        Checker = true;
        Counter++;
        break;}
            
        }
        if((Checker==true) &&(Counter == 3)){
        tempForSavingFirstID = "";
        Checker = false;
        Counter = 1;
        continue;
        }
        else if(Checker){
        tempForSavingFirstID = trimmedLine.trim();
        Checker = false;
        
        continue;
        }
        else{
        if(!tempForSavingFirstID.isEmpty()){
        
       writer.write(tempForSavingFirstID + System.getProperty("line.separator"));
       tempForSavingFirstID = "";
        }
        }
    
    writer.write(currentLine + System.getProperty("line.separator"));
    
   }
    writer.close(); 
    reader.close();
    
boolean successful = tempFile.renameTo(inputFile);
    }
    
    catch(Exception ex){
            
            
            }
    
    
    
}

 public ArrayList getfile(String NormalMemberFilePath) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ArrayList<String> Lines =new ArrayList<>();
      ArrayList<String> IDS =new ArrayList<>();
     BufferedReader br = null;  
     
        try {
            br = new BufferedReader(new FileReader(NormalMemberFilePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
          String str;   
       
        try {
            while((str=br.readLine()) !=null)
            {
                Lines.add(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
          return Lines;
    }


}