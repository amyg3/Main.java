import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException 
    {
        File text = new File("SampleTweets.txt");
        Scanner scnr = new Scanner(text);
        ArrayList<TweetMessage> messages = new ArrayList<TweetMessage>();

        String user = "";
        String timestamp = "";
        String message = "";
        ArrayList<String> hashtags = new ArrayList<>();
        ArrayList<String> usertags = new ArrayList<>();
        String likes = "";

        String unimportant = "";
        String unimportant2 = "";

        int index = 0;
        while(scnr.hasNextLine())
        {
            String line = scnr.nextLine();
            index++;

            if(line.trim().length() > 0) 
            {
                Pattern x = Pattern.compile("^@.*$");
                Matcher a = x.matcher(line);
                Pattern y = Pattern.compile("^.*PM.*$");
                Pattern p = Pattern.compile("^.*AM.*$");
                Matcher b = y.matcher(line);
                Matcher o = p.matcher(line);
                Pattern z = Pattern.compile("^.*Likes");
                Matcher c = z.matcher(line);
                Pattern q = Pattern.compile("^.*Retweets$");
                Pattern w = Pattern.compile("^.*Quote Tweets$");
                Matcher g = q.matcher(line);
                Matcher h = w.matcher(line);
                
                if(a.find() == true)
                {   
                    user = a.group(); 
                }
                else if(b.find() == true)
                    timestamp = b.group();
                else if(o.find() == true)
                {
                    timestamp = o.group();
                    
                }    
                else if(c.find() == true) 
                {
                    String matched = c.group();
                    likes = matched.substring(0, matched.indexOf(" "));
                }
                else if(g.find())
                    unimportant = g.group();
                else if(h.find())
                    unimportant2 = h.group();
                else if(index>2)
                {
                    message = line;
                }

                Pattern hashTagPattern = Pattern.compile("#\\S*");
                Matcher hashTagMatcher = hashTagPattern.matcher(message);
                while (hashTagMatcher.find() && hashtags.contains(hashTagMatcher.group())==false)
                {
                    hashtags.add(hashTagMatcher.group());
                }

                Pattern userTagPattern = Pattern.compile("@\\S*");
                Matcher userTagMatcher = userTagPattern.matcher(message);
                while (userTagMatcher.find() && usertags.contains(userTagMatcher.group())==false) 
                {
                    usertags.add(userTagMatcher.group());
                }

            } 
            else 
            {
                TweetMessage m = new TweetMessage(user, timestamp, message, hashtags, usertags, likes);
                messages.add(m);
                index = 0;
            }

        }

        for(int i = 0; i < messages.size(); i++)
        {
            System.out.println("User: "+messages.get(i).getUser());
            System.out.println("Timestamp: "+messages.get(i).getTimestamp());
            System.out.println("Message: "+messages.get(i).getMessage());
            
            System.out.println("Likes: "+messages.get(i).getLikes());
            System.out.println();
        }
        
        System.out.println("Hashtags:");
        for(int j = 0; j < hashtags.size(); j++)
        {
            System.out.println(hashtags.get(j));
        }
        System.out.println();
        System.out.println("Usertags:");
        for(int k = 0; k < usertags.size(); k++)
        {
            System.out.println(usertags.get(k));
        }   
        
    }

}
