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
 * @author yara
 */
public class IDE  extends Software{
    String CompilerLanguage;
     String ide="null";
     String id;
     FileFacade facade = new FileFacade();
     protected StringAccessor accessor = new StringAccessor();
     public IDE(String ide,String id)
    {
        this.ide=ide;
        this.id=id;
    }
    @Override
    public void add() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ArrayList<String> arr = new ArrayList<String>();
     arr.add(id);
     arr.add(ide);
     
     facade.Add(accessor.ResourcePath, arr);
    }

    @Override
    public void update(String Id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ArrayList<String> arr = new ArrayList<String>();
     arr.add(id);
     arr.add(ide);
     
     facade.remove(accessor.ResourcePath, arr);
    }

   
}