package shop.ui;

public interface UI {
  public Object processMenu(UIChoice menu); 
  public String[] processForm(UIChoice form);
  public Object displayMessage(String message);
  public Object displayError(String message);
}