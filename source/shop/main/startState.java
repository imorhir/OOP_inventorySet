package shop.main;

import java.util.Iterator;

import shop.command.Command;
import shop.data.Data;
import shop.data.Record;
import shop.data.Video;
import shop.ui.TheBuilder;
import shop.ui.UI;
import shop.ui.UIChoice;
import shop.ui.UIBuilder;
import shop.ui.UIBuilderFactory;
import shop.ui.UIMenuAction;

public class startState implements State {

	 Control _control;
	 UI _ui;
	  static final int number=10;
	  UIChoice[] _m = new UIChoice[number];
	  startState(Control control, UI ui) {
	    _control = control;
	    _ui = ui;
	  TheBuilder m =  UIBuilderFactory.newUIMenuBuilder();
	    m.add("Default",new UIMenuAction() {
	    	public Object run() {
	    	  _ui.displayError("doh!");
	    		return _control.START.run();
	    	}
	    	});
	    m.add("Add/Remove copies of a video",new UIMenuAction() {
	    	public Object run() {
	          
	    	  String[] result1 = _ui.processForm(_control._getVideoForm);
	          Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
	         TheBuilder f =  UIBuilderFactory.newUIFormBuilder() ;
	          f.add("Number of copies to add/remove", _control._numberTest);
	          String[] result2 = _ui.processForm((UIChoice) f.toUIList(""));
	          Command c = Data.newAddCmd(_control._inventory, v,Integer.parseInt(result2[0]));
	          if (! c.run()) {
	        	  _ui.displayError("Command failed");
	        	  }
	          return _control.START.run();
	          }
	    	});
	    
	    m.add("Check in a video",new UIMenuAction() {
	    	public Object run() {
	         String[] result1 = _ui.processForm(_control._getVideoForm);
	         Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
	         if(_control._inventory.get(v) == null)
	         {
	        	 _ui.displayError("no video exist with that name\n");
	         }
	         Command c = Data.newInCmd(_control._inventory, v);
	         if(!c.run())
	         {
	        	 _ui.displayError("Command failed");
	        	
	         }
	         return _control.START.run();
	         }
	    	});
	  
	    m.add("Check out a video",
	    	      new UIMenuAction() {
	    	        public Object run() {
	    	        	 String[] result1 = _ui.processForm(_control._getVideoForm);
	    	             Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
	    	             if(_control._inventory.get(v) == null)
	    	             {
	    	            	 _ui.displayError("no video exist with that name\n");
	    	             }
	    	             Command c = Data.newOutCmd(_control._inventory, v);
	    	             if(!c.run())
	    	             {
	    	            	 _ui.displayError("Command failed");
	    	            	
	    	             } 
	    	             return _control.START.run();
	    	        }
	    	      });
	  
	    m.add("Print the inventory",
	    	      new UIMenuAction() {
	    	        public Object run() {
	    	        _ui.displayMessage(_control._inventory.toString());
	    	        return _control.START.run();
	    	        }
	    	        
	    	      });
	    	    m.add("Clear the inventory",
	    	      new UIMenuAction() {
	    	        public Object run() {
	    	          if (!Data.newClearCmd(_control._inventory).run()) {
	    	            _ui.displayError("Command failed");
	    	          }
	    	          return _control.START.run();
	    	        }
	    	      });
	    	    m.add("Undo",
	    	      new UIMenuAction() {
	    	        public Object  run() {
	    	          if (!Data.newUndoCmd(_control._inventory).run()) {
	    	            _ui.displayError("Command failed");
	    	          }
	    	          return _control.START.run();
	    	        }
	    	      });
	    	    m.add("Redo",
	    	      new UIMenuAction() {
	    	        public Object run() {
	    	          if (!Data.newRedoCmd(_control._inventory).run()) {
	    	            _ui.displayError("Command failed");
	    	          }
	    	          return _control.START.run();
	    	        }
	    	      });
	    	    m.add("Print top ten all time rentals in order",
	    	    	      new UIMenuAction() {
	    	    	        public Object run() {
	    	    	        	Iterator<Record> iters = _control._inventory.iterator((Record r1, Record r2)
	    	    	        	->{return r2.numOut() - r1.numOut();});
	    	    	        	/////////////////////////////////////////////////
	    	    	        	StringBuilder StrOutPut = new StringBuilder();
	    	    	            int count = 1;
	    	    	            while (iters.hasNext() && count <= 10)
	    	    	            {
	    	    	                Record r = iters.next();
	    	    	                StrOutPut.append("( " + r.video().title() + " : " + r.video().director() + " : " + r.video().year() + " [ " + r.numOwned() + ", " + r.numOut() + ", " + r.numRentals() + " ] )\n");
	    	    	                count++;
	    	    	            }
	    	    	           _ui.displayMessage(StrOutPut.toString());
	    	    	           return _control.START.run();
	    	    	        }
	    	    	      });
	    	    	          
	    	    	    m.add("Exit",
	    	    	      new UIMenuAction() {
	    	    	        public Object run() {
	    	    	         return _control.EXIT.run();
	    	    	        }
	    	    	      });
	    	    	    
	    	    	    m.add("Initialize with bogus contents",
	    	    	    	      new UIMenuAction() {
	    	    	    	        public Object run() {
	    	    	    	          Data.newAddCmd(_control._inventory, Data.newVideo("a", 2000, "m"), 1).run();
	    	    	    	          Data.newAddCmd(_control._inventory, Data.newVideo("b", 2000, "m"), 2).run();
	    	    	    	          Data.newAddCmd(_control._inventory, Data.newVideo("c", 2000, "m"), 3).run();
	    	    	    	          Data.newAddCmd(_control._inventory, Data.newVideo("d", 2000, "m"), 4).run();
	    	    	    	          Data.newAddCmd(_control._inventory, Data.newVideo("e", 2000, "m"), 5).run();
	    	    	    	          return _control.START.run();	
	    	    	    	        }
	    	    	      });

	    _m[number-1] = (UIChoice) m.toUIList("welcone to Issam`s Video");
	  }

public State run() {
			
			return (State) _ui.processMenu(_m[number-1]);
		}






}
