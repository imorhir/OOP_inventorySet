package shop.ui;

public abstract class UIChoice {
	  private final String _heading;
	  private final Pair[] _options;
	  static final class Pair <P,T> {
		    final P Intial;
		    final T Actions;
			

		    Pair(P thePrompt, T theTest) {
		      Intial = thePrompt;
		      Actions = theTest;
		    }
		  }
	  	UIChoice(String heading, Pair[] menu) {
		    _heading = heading;
		    _options = menu;
		  }
		  public int size() {
		    return _options.length;
		  }
		  public String getHeading() {
		    return _heading;
		  }
		  public String getPrompt(int i) {
		    return (String) _options[i].Intial;
		  }
}
