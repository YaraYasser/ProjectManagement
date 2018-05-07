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
public class Available_developer  {

    
   
    public ArrayList get_availableMember(ArrayList<String> Lines) throws FileNotFoundException, IOException
    {
         ArrayList<String>T_MR=new ArrayList<>();
        ArrayList<String>T_M=new ArrayList<>();
         ArrayList<String>result=new ArrayList<>();
        File file =new File("C:\\Users\\lenovoo\\Desktop\\MemberTaskRelation.txt");
          BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lenovoo\\Desktop\\MemberTaskRelation.txt"));  
          String str;   
          while((str=br.readLine()) !=null)
          {         
              T_MR.add(str);
          }
        for(int i=0 ;i<T_MR.size();i=i+2)
        {  
            T_M.add(T_MR.get(i)+"\r\n");
        }
        for(int j=0 ;j<Lines.size();j++)
        {
             String line=Lines.get(j).trim();
             //String[] datarow =line.split(",");
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