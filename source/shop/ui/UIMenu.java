package shop.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * @see UIMenuBuilder
 */
final class UIMenu extends UIChoice {
	  private final String _heading;
	  private final Pair[] _options;

	  
	  
	  UIMenu(String heading, Pair[] menu) {
		  super(heading,menu);
	    _heading = heading;
	    _options = menu;
	  }
	
	  
	  public Object runAction(int i) {
		  UIMenuAction a = (UIMenuAction) _options[i].Actions;
		   return  a.run(); // remove return!!!
		  }
	}
