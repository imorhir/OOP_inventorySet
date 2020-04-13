package shop.ui;

public interface UIBuilder {
	
	public abstract Object toUIList(String heading);
	
	public abstract void add(String prompt, Object action);

}
