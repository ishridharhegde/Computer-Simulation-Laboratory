/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cslab1;
import java.util.*;

public class CSLab1 
{ 
    public static void main(String[] args)
    {
        System.out.println("\t$$ CS Lab 1 $$");
        
        //1. Generate 10 random numbers
        System.out.println("\n1. Generate 10 random numbers.\nSolution:");
        Problem1 obj1 = new Problem1();     //Object of the problem 1 solution class
        for (int i = 0; i < 10; i++)
            System.out.println("\t"+obj1.randomNumber());
        
        //2. Generate 10 random numbers between 0 to 1
        System.out.println("\n2. Generate 10 random numbers between 0 to 1\nSolution:");
        Problem2 obj2 = new Problem2();
        for (int i = 0; i < 10; i++)
            System.out.println("\t"+obj2.randomBetween0and1());
        
        //3.Generate 10 normally distributed random numbers
        double randNum;
        System.out.println("\n3.Generate 10 normally distributed random numbers\nSolution:");
        Problem3 obj3 = new Problem3();
        for (int i = 0; i < 10; ) 
        {
            randNum = obj3.normallyDistributedNumber();
            if(randNum<0 || randNum>1)      //Print only if no's are between 0 and 1
                continue;
            System.out.println("\t"+randNum);
            i++;
        }
 
        /*4.Flip a coin 50 times and count the number of head and tail.
            Also find probability of distribution of head and tail*/
        int coinToss,headCount=0; float probOfTail,probOfHead; String toss;
        System.out.println("\n4. Flip a coin 50 times and count the number of head and tail.\n" +
            "Also find probability of distribution of head and tail.\nSolution:");
        Problem4 obj4 = new Problem4();
        for (int i = 0; i < 50; i++) 
        {
            coinToss= obj4.randomNumber1or0();
            if(coinToss==1)
            {
                headCount++; toss="Heads";
            }
            else
                toss="Tails";
            System.out.println("\t"+toss);
        }
        probOfHead = headCount/50.0f;
        probOfTail = 1 - probOfHead;
        System.out.print("\tProbabiliy of head = "+probOfHead+"\n\tProbability of Tail = "+probOfTail);         
        
       /*5. Roll a die 200 times. Count occurence of each face.
        Also find the probability distribution */
       int randNumber,count1=0,count2=0,count3=0,count4=0,count5=0,count6=0; 
       float probOf1,probOf2,probOf3,probOf4,probOf5,probOf6;
       Problem5 obj5 = new Problem5();
       System.out.println("\n\n5. Roll a die 200 times. Count occurence of each face."
               + " Also find probability distribution of each of them.\nSolution:");
        for (int i = 0; i < 200; i++)
        {
            randNumber = obj5.randBetween0to6();
            switch(randNumber)
            {
                case 0: count1++; break;
                case 1: count2++; break;
                case 2: count3++; break;
                case 3: count4++; break;
                case 4: count5++; break;
                case 5: count6++; break;
                
            }
            System.out.print("\t"+(++randNumber));
        }
        
       probOf1 = count1/200.0f;
       probOf2 = count2/200.0f;
       probOf3 = count3/200.0f;
       probOf4 = count4/200.0f;
       probOf5 = count5/200.0f;
       probOf6 = count6/200.0f;
       
       System.out.println("\tFollowing are the counts:\n\t 1: "+count1+"\n\t 2: "+count2+"\n\t 3: "+count3+"\n\t 4: "+count4+"\n\t 5: "+count5+"\n\t 6: "+count6);
       System.out.println("\tFollowing are the probabilities:\n\t 1: "+probOf1+"\n\t 2: "+probOf2+"\n\t 3: "+probOf3+"\n\t 4: "+probOf4+"\n\t 5: "+probOf5+"\n\t 6: "+probOf6);
   
    }  
}



