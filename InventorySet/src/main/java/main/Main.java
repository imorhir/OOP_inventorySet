package main;

import ui.UI;
import ui.UIFactory; 
//import state.ui.main.Control;
import data.Data;

public class Main {
  private Main() {}
 
	  
	 
  public static void main(String[] args) {
	//UI ui = UIFactory.newPopUpUI();
	  UI ui = UIFactory.newPopUpUI();
	  Control control = new Control(Data.newInventory(), ui);
	  control.run();
  
  }
}
