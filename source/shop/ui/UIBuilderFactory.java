package shop.ui;

public class UIBuilderFactory {
	
	public static UIMenuBuilder newUIMenuBuilder()
	{
		return new UIMenuBuilder();
	}
	public static UIFormBuilder newUIFormBuilder()
	{
		return new UIFormBuilder();
	}


}
