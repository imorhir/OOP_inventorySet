
package shop.ui;

import javax.swing.JOptionPane;
//import java.io.IOException;

final  class PopupUI implements UI {
  PopupUI() {}

  public Object displayMessage(String message) {
	   JOptionPane.showMessageDialog(null,message);
   return 1;
  }

  public Object displayError(String message) { //change return to void ??
     JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
  return 0;
  }

  public Object processMenu(UIChoice menu) { /// return type void???
    StringBuffer b = new StringBuffer();
    b.append(menu.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i < menu.size(); i++) {
      b.append("  " + i + ". " + menu.getPrompt(i));
      b.append("\n");
    }

    //String response = JOptionPane.showInputDialog(b.toString());
    String response=JOptionPane.showInputDialog(null, b.toString(),"Video Store Selection Menu:", JOptionPane.QUESTION_MESSAGE);
    int selection;
    try {
      selection = Integer.parseInt(response, 10);
      if ((selection < 0) || (selection >= menu.size()))
        selection = 0;
    } catch (NumberFormatException e) {
      selection = 0;
    }

    return ((UIMenu) menu).runAction(selection);
    
  }

  
  public String[] processForm(UIChoice form) {
	  
	  String[] v = new String[form.size()];
		for(int i=0; i <v.length;i++ ) {
			
			String ans = JOptionPane.showInputDialog(form.getPrompt(i));
	        
	        if(((UIForm)form).checkInput(i, ans) == false)
	        {
	            JOptionPane.showMessageDialog(null, "Invalid Input");
	            i--;
	        }
	        else
	        {
	            v[i] = ans;
	        }
			
		}
	    return v;
  }


}
