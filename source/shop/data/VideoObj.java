package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO  
    return this._director;
  }

  public String title() {
    // TODO  
    return this._title;
  }

  public int year() {
    // TODO  
    return this._year;
  }

  public boolean equals(Object thatObject) {
    // TODO  
	  if(thatObject == null) {
		  return false;
	  }
	  if(!(thatObject instanceof VideoObj))
	    {
		  return false;
		}
	  VideoObj videoObject = (VideoObj) thatObject;
	  if(this._year  != videoObject._year) return false;
	  if(this._director != null && !this._director.equalsIgnoreCase(videoObject._director)) return false;
	  if(this._title != null && !this._title.equalsIgnoreCase(videoObject._title)) return false;
	  return true;  
  }

  public int hashCode() {
	  int result = 17;
		
	  result = 31 * result + (this._title == null ? 0 :this._title.hashCode());
	  result = 31 * result + this._year;
	  result = 31 * result + (this._director == null ? 0 :this._director.hashCode());
	  return result;
  }

  public int compareTo(Object thatObject) {
	  if (!(thatObject instanceof VideoObj || thatObject == null)) {
		  throw new  ClassCastException("incompatible type");
	  }
	  
	  VideoObj videoObject = (VideoObj)thatObject;
	  if (this._title.compareTo(videoObject._title)!=0) {
		  return this._title.compareTo(videoObject._title);
	  }
	  if( this._year < videoObject._year) {
		  return -1;
	  }
	  if (this._year > videoObject._year){
		return 1;  
	  }
	  if(this._director.compareTo(videoObject._director) != 0)
	  {
		  return this._director.compareTo(videoObject._director);
	  }
	  
		  
    return 0;
  }

  public String toString() {
	  StringBuffer buffer = new StringBuffer();
	    buffer.append(this._title);
	    buffer.append(" (");
	    buffer.append(this._year);
	    buffer.append(") : ");
	    buffer.append(this._director);
	    return buffer.toString();
  }
}
