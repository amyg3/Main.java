import java.util.ArrayList;

public class TweetMessage implements Message
{
    private String user;
    private String timestamp;
    private String message;
    private ArrayList<String> hashtags;
    private ArrayList<String> usertags;
    private String likes;

    public TweetMessage(String u, String t, String m, ArrayList<String> h, ArrayList<String> us, String l)
    {
        user=u;
        timestamp=t;
        message=m;
        hashtags=h;
        usertags=us;
        likes=l;
    }
    // Returns the Twitter handle of the poster
  	public String getUser()
    {
        return user;
    }
	
  	// Returns the timestamp of the tweet
  	public String getTimestamp()
	{
        return timestamp;
    }

  	// Returns the plain text of the Tweet
  	public String getMessage()
    {
        return message;
    }
	
  	// Returns an ArrayList containing all of the 
  	// hashtags (if any) in the tweet 
  	public ArrayList<String> getHashTags()
    {
        return hashtags;
    }

    // Returns an ArrayList containing all of the 
  	// user tags (if any) in the tweet 
  	public ArrayList<String> getUserTags()
    {
        return usertags;
    }
	
  	// Returns the number of likes
  	public String getLikes()
    {
        return likes;
    }
}
