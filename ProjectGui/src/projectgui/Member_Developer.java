/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovoo
 */
public class Member_Developer extends AbstractDeveloper{
   
    StringAccessor access=new StringAccessor();
    FileFacade facade =new  FileFacade();

    public Member_Developer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public ArrayList get_developer() 
    {
        
        ArrayList<String>Lines=new ArrayList<>();
    ArrayList<String>RIDS=new ArrayList<>(); 
        ArrayList<String>Final=new ArrayList<>();
     String ss=access.NormalMemberFilePath;
   //  RIDS= facade.ge(ss);
     RIDS =facade.getfile(ss);
     for(int i=0;i<RIDS.size();i=i+6)
          {
              Lines.add(RIDS.get(i)+"\r\n");
             
          }
          Available_developer devobject=new Available_developer();
       
       try {
           Final= devobject.get_developer(Lines);
       } catch (IOException ex) {
           Logger.getLogger(Member_Developer.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       return Final;
      
           
          
    }
    public void get_Task() throws IOException
    {
    
           ArrayList<String>Lines=new ArrayList<>();
    ArrayList<String>IDS=new ArrayList<>();
        File file =new File("C:\\Users\\lenovoo\\Desktop\\Task.txt");
          BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lenovoo\\Desktop\\Task.txt"));  
          String str;   
          while((str=br.readLine()) !=null)
          {         
              Lines.add(str);
          }
          for(int i=0;i<Lines.size();i=i+6)
          {
              IDS.add(Lines.get(i)+",");
               for(int j=i+5;j<=i+5;j++)
                {
                    IDS.add(Lines.get(j)+",");
                }            
          }
             
          
    }
    
}