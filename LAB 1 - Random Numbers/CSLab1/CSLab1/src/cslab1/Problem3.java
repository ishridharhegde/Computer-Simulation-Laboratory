
package cslab1;
import java.util.*;

//3.Generate 10 normally distributed random numbers
public class Problem3 
{
    Random rand = new Random();
    
    //Function to return normally generated random numbers
    double normallyDistributedNumber()
    {
        return rand.nextGaussian();
    }
}
