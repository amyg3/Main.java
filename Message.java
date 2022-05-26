import java.util.ArrayList;

public interface Message 
{
  	// Returns the Twitter handle of the poster
  	public String getUser();
	
  	// Returns the timestamp of the tweet
  	public String getTimestamp();
	
  	// Returns the plain text of the Tweet
  	public String getMessage();
	
  	// Returns an ArrayList containing all of the 
  	// hashtags (if any) in the tweet 
  	public ArrayList<String> getHashTags();

    // Returns an ArrayList containing all of the 
  	// user tags (if any) in the tweet 
  	public ArrayList<String> getUserTags();
	
  	// Returns the number of likes
  	public String getLikes();
}
