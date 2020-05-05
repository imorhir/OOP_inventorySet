package ui;

import java.io.BufferedReader;   
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

 final class TextUI implements UI{
  final BufferedReader _in;
  final PrintStream _out;

  TextUI() {
    _in = new BufferedReader(new InputStreamReader(System.in));
    _out = System.out;
  }

  public Object displayMessage(String message) {
    _out.println(message);
    return 1;
  }

  public Object displayError(String message) {
    _out.println(message);
    return 1;
  }

  private String getResponse() {
    String result;
    try {
      result = _in.readLine();
    } catch (IOException e) {
      throw new UIError(); // re-throw UIError
    }
    if (result == null) {
      throw new UIError(); // input closed
    }
    return result;
  }

  public Object processMenu(UIChoice menu) {
    _out.println(menu.getHeading());
    _out.println("Enter choice by number:");
    
    for (int i = 1; i < menu.size(); i++) {
      _out.println("  " + i + ". " + menu.getPrompt(i));
    }

    String response = getResponse();
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
	for(int i=0; i <v.length;i++ ) 
	{
	    _out.printf(form.getPrompt(i) + ": ");
		String d = getResponse();
		if(((UIForm) form).checkInput(i, d) == false)
	        {
	        _out.println("Invalid Input");
	            i--;
	        }
	        else
	        {
	           
	        
	        	v[i]=d;
	        }
	 }
    return v;
    
    }


  }

