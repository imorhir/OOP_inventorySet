package shop.main;

import shop.ui.TheBuilder;
import shop.ui.UI;    
import shop.ui.UIChoice;
import shop.ui.UIBuilder;
import shop.ui.UIBuilderFactory;
//import shop.ui.UIMenu;
import shop.ui.UIMenuAction;
//import shop.ui.UIMenuBuilder;
import shop.ui.UIError;
//import shop.ui.UIForm;
import shop.ui.UIFormTest;
//import shop.ui.UIFormBuilder;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Video;
import shop.data.Record;
import shop.command.Command;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;



 class Control {
	  final State EXITED; 
	  final State EXIT;
	  final State START;
	  private State _state;
	   static int number = 10;
	   public static UIChoice[] _m = new UIChoice[number];
	  private UI _ui;
	  UIChoice _getVideoForm;
	   UIFormTest _numberTest;
	   UIFormTest _stringTest;
	   Inventory _inventory;
	   Control(Inventory inventory,UI ui) {
		START =   new startState(this,ui);
	    EXITED = new ExitedState();
	    EXIT = new ExitState(this,ui);
	    _ui = ui;
	    _inventory= inventory;
	    _state =  START;
	  
	    
	    UIFormTest yearTest = new UIFormTest() {
	        public boolean run(String input) {
	          try {
	            int i = Integer.parseInt(input);
	            return i > 1800 && i < 5000;
	          } catch (NumberFormatException e) {
	            return false;
	          }
	        }
	      };
	      
	    _numberTest = new UIFormTest() {
	        public boolean run(String input) {
	          try {
	            Integer.parseInt(input);
	            return true;
	          } catch (NumberFormatException e) {
	            return false;
	          }
	        }
	      };
	      
	    _stringTest = new UIFormTest() {
	        public boolean run(String input) {
	           return !"".equals(input.trim());
	          
	        }
	      };

	    TheBuilder f =  UIBuilderFactory.newUIFormBuilder() ;
	    f.add("Title", _stringTest);
	    f.add("Year", yearTest);
	    f.add("Director", _stringTest);
	    _getVideoForm =  (UIChoice) f.toUIList("Enter Video");
	  }
	  
	   boolean run() {
		 _state = _state.run();
		 if  (_state!= EXITED) {
			 return true;
		 }else {
			 _state= START;
			 return false;
		 }
		 
		 }
}



	