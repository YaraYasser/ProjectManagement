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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovoo
 */
public class URL extends Software {
    

    String url;
    String id;
     public URL(String url,String id)
    {
        this.url=url;
        this.id=id;
    }
    @Override
    public void add() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try{
        Path p = Paths.get("C:\\Users\\lenovoo\\Desktop\\resource.txt");
          File f=new File("C:\\Users\\lenovoo\\Desktop\\resource.txt");
          FileWriter writer = new FileWriter(f.getAbsoluteFile(), true);
           BufferedWriter bw=new BufferedWriter(writer);
           String s=id+",";
           bw.write(s );           
           bw.write(url );
           bw.newLine();
           bw.close();
           writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    @Override
    public void update(String Id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<String>Lines=new ArrayList<>();
           File file =new File("C:\\Users\\lenovoo\\Desktop\\resource.txt");
          BufferedReader br = null;
      try {
          br = new BufferedReader(new FileReader("C:\\Users\\lenovoo\\Desktop\\resource.txt"));
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
      }
          String str;
      try {
          while((str=br.readLine()) !=null)
          {
              
              Lines.add(str);
          }
         // String UpadetString = Id + " OS ";
             for (int i=0 ;i<Lines.size();i++)
            {
               String line=Lines.get(i).trim();
               String[] datarow =line.split(",");
               if(datarow[0].equals(Id))
               {
                   Lines.remove(i);
               }   
            }
             PrintWriter Pwriter = new PrintWriter(file);
          Pwriter.print("");
           Pwriter.close();
            
          File f=new File("C:\\Users\\lenovoo\\Desktop\\resource.txt");
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
    public void delete(String Id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}