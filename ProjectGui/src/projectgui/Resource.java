/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgui;

/**
 *
 * @author yara
 */
public abstract class Resource {
  int ID;
  String Name;
  double Price;
  public double getPrice(){
return Price;
}
  public abstract void add();
  public abstract void update(String Id);
  
}
