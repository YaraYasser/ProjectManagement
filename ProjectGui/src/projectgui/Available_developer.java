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

/**
 *
 * @author lenovoo
 */
public class Available_developer extends AbstractDeveloper{

    StringAccessor access=new StringAccessor();
    FileFacade facade =new  FileFacade();

 
   
    public ArrayList get_availableMember(ArrayList<String> Lines) throws FileNotFoundException, IOException
{
         ArrayList<String>T_MR=new ArrayList<>();
        ArrayList<String>T_M=new ArrayList<>();
        ArrayList<String>res=new ArrayList<>();
         ArrayList<String>result=new ArrayList<>();
       
    
        String s=access.FileTaskMemberRelationPath;
       T_MR =facade.getfile(s);
        for(int i=0 ;i<T_MR.size();i=i+2)
        {  
            T_M.add(T_MR.get(i)+"\r\n");
        }
        for(int j=0 ;j<Lines.size();j++)
        {
             String line=Lines.get(j).trim();
             int count=0;
            for(int i=0 ;i<T_M.size();i++)
            {    
                String sstr=T_M.get(i).trim();
                if(line.equals(sstr))
                {
                    count++;
                    
                } 
            }
            if(count<2)
               {
                   result.add(Lines.get(j));
               }
        }
        return result;
    
    }
    
}