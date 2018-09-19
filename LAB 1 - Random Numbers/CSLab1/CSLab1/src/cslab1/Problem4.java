package cslab1;
import java.util.*;

/*4.Flip a coin 50 times and count the number of head and tail.
    Also find probability of distribution of head and tail*/
        
public class Problem4
{
    Random rand = new Random();
    
    //Function to generate random number either 1 or 2
    int randomNumber1or0()
    {
        return(rand.nextInt()%2);
    }
    
}
