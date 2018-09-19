package abelbaker;
import java.util.Random;

public class RandomTimeGenerator 
{
    Random rand = new Random(); //Random class object
    
    //Function to return a random number between 1 to 15
    int getRandom(int lowerLimit, int upperLimit)
    {
        return rand.nextInt(upperLimit)+lowerLimit;
    }
}
