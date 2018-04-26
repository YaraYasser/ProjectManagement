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
    
    public void Add(String FilePath,ArrayList<String> Lines){
    
        try {
     
          File f=new File(FilePath);
          FileWriter writer = new FileWriter(f.getAbsoluteFile(), true);
           BufferedWriter bw=new BufferedWriter(writer);
            for(String x:Lines)
            {
                bw.write(x);
                 bw.newLine();
            }
            bw.close();
}
       
        catch(IOException ex){
            }
    }
    
    public void UpdateFile(String FilePath,String LineToBeUpdated,String UpdatedValue){
  ArrayList<String>Lines=new ArrayList<>();
           File fileToBeModified = new File(FilePath);
         
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
             
            String newContent = oldContent.replaceAll(LineToBeUpdated, UpdatedValue);
             
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
    File tempFile = new File("/home/yara/Documents/4year/OODP/temp.txt");
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
}