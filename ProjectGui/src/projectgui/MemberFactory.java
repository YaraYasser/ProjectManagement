/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

import javax.swing.JTextField;
import projectgui.*;


/**
 *
 * @author DELL_PC
 */
public class MemberFactory {
      StringAccessor accessor;

    public MemberFactory() {
    accessor = new StringAccessor();
    }
      
     public Member getmember()
    {  
        Member returnedObj;
        Member AccessObj = Projectmanager.getInstance();
        if((AccessObj.MemberType).equalsIgnoreCase(accessor.ManagerType))
        {
           returnedObj =  Projectmanager.getInstance();
        }
        else if((AccessObj.MemberType).equalsIgnoreCase(accessor.MemberType))
        {
              returnedObj =  NormalMember.getInstance();
        }
        else
        {
            return new NullMember();
        }
        return returnedObj;
        
    }
    
    public Member getmember(String membertype)
    {
        Member obj;
        if(membertype.equalsIgnoreCase(accessor.ManagerType))
        {
           obj=  Projectmanager.getInstance();
        }
        else if(membertype.equalsIgnoreCase(accessor.MemberType))
        {
              obj=  NormalMember.getInstance();
        }
        else
        {
            return new NullMember();
        }
        return obj;
        
    }
}
