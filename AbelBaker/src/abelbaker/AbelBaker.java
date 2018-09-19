
package abelbaker;

//Class to simulate Abel Baker queuing system
public class AbelBaker 
{
    //Minimum and Maximum service time for Able and Baker
    int AbleLowerLimit=1,AbleUpperLimit=6;
    int BakerLowerLimit=3, BakerUpperLimit = 12;
    
    int IAT[] = new int[10];       //Inter Arrival Time
    int AT[] = new int[10];         //Arrival Time
    int STAble[] = new int[10];       //Service Time of Able  
    int STBaker[] = new int [10];      //Service Time of Baker
    int SBeginAble[] = new int[10];     //Service Begin time of Able
    int SEndAble[] = new int[10];        //Service End time of Able
    int SBeginBaker[] = new int[10];     //Service Begin time of Baker
    int SEndBaker[] = new int[10];        //Service End time of Baker
    int waitingTime[] = new int[10];        //Waiting Time for the customer
    int timeInSystem[] = new int[10];        //Time spen by the user in the system
    int serverIdleTime[] = new int[10];
    
    RandomTimeGenerator randGen = new RandomTimeGenerator();
    
    //Function to get the Inter Arrival Time and Service Time
    void getIATandST()
    {
        IAT[0] = 0;
        STAble[0] = randGen.getRandom(AbleLowerLimit,AbleUpperLimit);
        STBaker[0] = randGen.getRandom(BakerLowerLimit,BakerUpperLimit);
        
        //Get the random number and assign it to IAT and ST variables
        for (int i = 1; i < 10; )    
        {
            IAT[i] = randGen.getRandom(1,10);
            STAble[i] = randGen.getRandom(AbleLowerLimit,AbleUpperLimit);
            STBaker[i] = randGen.getRandom(BakerLowerLimit,BakerUpperLimit);
            
        }
    }
    
    //Function to compute the arrival time based in the Inter Arrival Time 
    void computeArrivalTime()
    {
        AT[0] = 0;
        
        //Arrival time is the arrival time of previous customer plus the inter arrival time of the currnent customer
        for (int i = 1; i < 10; i++)
            AT[i] = AT[i] + IAT[i];       
    }
    
    //Function to simulate the Abel Baker system
    void simulate()
    {
        SBeginAble[0] = 0;
        SEndAble[0] = STAble[0];
        
        for(int i=1; i < 10; i++)
        {
            /*The customer will go to able if he arrives when Able is free
                    or just finishes serving the previous customer */
            
            if(AT[i] >= SEndAble[i-1])  
            {
                //Able is free and customer goes to him for service
                SBeginAble[i] = AT[i];
                SEndAble[i] = SBeginAble[i] + STAble[i];      
                
                SBeginBaker[i] = SEndBaker[i] = -1;     //When Able is giving service, baker does not interfere
                
                waitingTime[i] = 0;
                timeInSystem[i] = SEndAble[i] - AT[i];
                
            }
            else if(AT[i] < SEndAble[i-1] && AT[i] >= SEndBaker[i-1])            
            {
                //In this case Able is busy and Baker is free. So the customer will go to Baker
                SBeginBaker[i] = AT[i];
                SEndBaker[i] = SBeginBaker[i] + STBaker[i];
                
                SBeginAble[i] = SEndAble[i] = -1;    //When Baker is giving service, Able does not interfere
                
                waitingTime[i] = 0;
                timeInSystem[i] = SEndBaker[i] - AT[i];
            } 
            else if(AT[i] < SEndAble[i-1] && AT[i] < SEndBaker[i-1])
            {
              /* Both Able and Baker are busy. The customer has to wait now.
                  If Baker finishes first, the customer will go to him.
                    If Able finishes first, customer will go to him  */
                if((SEndAble[i-1]-AT[i]) < (SEndBaker[i-1]-AT[i]))
                {
                    //Able has finished his last task and is free. So customer will go to him               
                    SBeginAble[i] = SEndAble[i-1];
                    SEndAble[i] = SBeginAble[i] + STAble[i];
                    
                    waitingTime[i] = SBeginAble[i] - AT[i];
                    timeInSystem[i] = SEndAble[i] - AT[i];  
                }
                else
                {
                    //Baker has finished his last task and is free. So customer will go to him
                }
                
            }
        }
    }
    
    public static void main(String[] args) 
    {
                                                                                                                                                                                                                                                                                
    }
    
}
