package ui;
import java.util.ArrayList;
import java.util.List;
public abstract class TheBuilder {

		  private final List _menu;
		  public TheBuilder() {
		    _menu = new ArrayList();
		  }
		  public Object toUIList(String heading) {
		    if (null == heading)
		      throw new IllegalArgumentException();
		    if (_menu.size() < 1)
		      throw new IllegalStateException();
		    UIChoice.Pair[] array = new UIChoice.Pair[_menu.size()];
		    for (int i = 0; i < _menu.size(); i++)
		      array[i] = (UIChoice.Pair) (_menu.get(i));
		    if (this instanceof UIFormBuilder)
		    {
		    	return new UIForm(heading, array);
		    }
		    else
		    {
		    	return new UIMenu(heading, array);
		    }
		  }
		  public void add(String prompt, Object action) {
		    if(this instanceof UIMenuBuilder) {
			 if (null == action)
		      throw new IllegalArgumentException();
		    _menu.add(new UIChoice.Pair(prompt, (UIMenuAction)action));
		    }
		    else {
		    	 _menu.add(new UIForm.Pair(prompt, (UIFormTest)action));
		    }
		    
		  }

		}

