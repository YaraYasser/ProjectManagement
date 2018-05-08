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
import projectgui.Software;

/**
 *
 * @author yara
 */
    public class OS extends Software{
    String License;
     String os="null";
     FileFacade facade = new FileFacade();
     protected StringAccessor accessor = new StringAccessor();
  
  String id;
     public OS(String os,String id)
    {
        this.os=os;
        this.id=id;
    }

    @Override
    public void add() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
     ArrayList<String> arr = new ArrayList<String>();
     arr.add(id);
     arr.add(os);
     
     facade.Add(accessor.ResourcePath, arr);
    
    }

    @Override
    public void update(String Id) {
        

     ArrayList<String> arr = new ArrayList<String>();
     arr.add(id);
   
     facade.remove(accessor.ResourcePath, arr);
    }

}



   