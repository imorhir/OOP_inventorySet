package main;

import ui.TheBuilder;
import ui.UI;
import ui.UIChoice;
import ui.UIBuilder;
import ui.UIBuilderFactory;
import ui.UIMenuAction;

final class ExitedState implements State {
		  public State run() {
		    return this;
		  }
		}

		final class ExitState implements State {
		  Control _control;
		  UI _ui;
		 
		  UIChoice _m;
		  ExitState(Control control, UI ui) {
		    _control = control;
		    _ui = ui;

		    TheBuilder m =  UIBuilderFactory.newUIMenuBuilder() ;
		    
		    m.add("Default", new UIMenuAction() { public Object run() {return this;} });
		    m.add("Yes",
		      new UIMenuAction() {
		        public Object run() {
		          return _control.EXITED;
		        }
		      });
		    m.add("No",
		      new UIMenuAction() {
		        public Object run() {
		          return _control.START.run();
		        }
		      });
		   
		    _m = (UIChoice) m.toUIList("Are you sure you want to exit?");
		  }
		  public State run() {
		    return (State) _ui.processMenu(_m);
		  }
		}

	
	

	

