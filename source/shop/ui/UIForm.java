package shop.ui;

import java.util.ArrayList; 
import java.util.List;

/**
 * @see UIFormBuilder
 */
final class  UIForm extends UIChoice {
	  private final String _heading;
	  private final Pair[] _options;

	  
	  
	  UIForm(String heading,Pair[] menu) {
		  super(heading,menu);
	    _heading = heading;
	    _options = menu;
	  }
	
	  public boolean checkInput(int i, String input) {
	    if (null == _options[i])
	      return true;
	    UIFormTest a = (UIFormTest) _options[i].Actions;
	    a.run(input);
	    return a.run(input);
	  }
	  
	 
	}

 
	
 

 

