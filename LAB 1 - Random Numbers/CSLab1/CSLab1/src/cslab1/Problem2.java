package cslab1;
import java.util.*;

//2. Generate 10 random numbers between 0 to 1
public class Problem2 
{
    Random rand = new Random();
    
    //Function to generate a random number between 0 to 1
    double randomBetween0and1()
    {
        return rand.nextDouble();
    }
}
