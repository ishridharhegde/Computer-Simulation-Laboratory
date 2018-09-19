package cslab1;
import java.util.*;

/*5. Roll a die 200 times. Count occurence of each face.
        Also find the probability distribution */

public class Problem5 
{
    Random rand = new Random();
    
    //Function ton generate numbers between 0 to 6
    int randBetween0to6()
    {
        return rand.nextInt(5)+1;
    }
}
