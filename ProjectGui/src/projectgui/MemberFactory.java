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
    
     public Member getmember()
    {
        Member obj;
        Member AccessObj = Projectmanager.getInstance();
        if(AccessObj.MemberType=="ProjectManager")
        {
           obj=  Projectmanager.getInstance();
        }
        else if(AccessObj.MemberType=="NormalMember")
        {
              obj=  NormalMember.getInstance();
        }
        else
        {
            return new NullMember();
        }
        return obj;
        
    }
    
    public Member getmember(String membertype)
    {
        Member obj;
        if(membertype=="ProjectManager")
        {
           obj=  Projectmanager.getInstance();
        }
        else if(membertype=="NormalMember")
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
