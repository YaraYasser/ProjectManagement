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
    String TempFilePath = "/home/yara/Documents/4year/OODP/temp.txt";
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
    
    public void UpdateFile(String FilePath,ArrayList<String> LineToBeUpdated,ArrayList<String> UpdatedValue){
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
             
            //Replacing oldString with newString in the oldContent
             for (int i=0;i<LineToBeUpdated.size();i++) {
                
             newContent = oldContent.replaceAll(LineToBeUpdated.get(i), UpdatedValue.get(i));
                 
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
    File tempFile = new File(TempFilePath);
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
    File tempFile = new File(TempFilePath);
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
    File tempFile = new File(TempFilePath);
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
        }
       counter++;
       
         String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(UserName)){ 
        UserNameCheck = true;
        }
        else if(trimmedLine.equals(Password)){
          if(UserNameCheck == true){
            BothCheck = true;
          
            }
        }
        else{
            UserNameCheck = false;
            Id = "";
            firstName = "";
            lastName = "";
            email = "";
            phone = "";
            password = "";
            } 
    
        }
       EnteredMember.fillClassData(Id, firstName, lastName,email, phone, password, type);
   
    reader.close(); 


    }
    catch(Exception ex){
 
    }
        
    }
   public String getMemberName(String FilePath,String MemberID){
   
    String firstName = "";
    String lastName = "";
        
    int counter =1;
    File inputFile = new File(FilePath);
    File tempFile = new File(TempFilePath);
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
   ArrayList<Task> ReturnedTasksArrayList = new ArrayList<Task>();
    int counter =1;
    File inputFile = new File("/home/yara/Documents/4year/OODP/Project/Task.txt");
    File tempFile = new File(TempFilePath);
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
public ArrayList<String> getProjectData(String ParProjectID) {
   
    int MaxNumberOfLinesForEachProject = 5;
    ArrayList<String> ReturnedProjectData = new ArrayList<String>();
    int counter =1;
    File inputFile = new File("/home/yara/Documents/4year/OODP/Project/Project.txt");
    File tempFile = new File(TempFilePath);
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
        else if(counter > MaxNumberOfLinesForEachProject){
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
}