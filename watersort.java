import java.util.Random;
import java.util.Scanner;
public class Watersort
{
    static Character red = new Character('r');
    static Character green = new Character('g');
    static Character blue = new Character('b');
    public static void main(String[]Args)
    {
        //WPS 1
        System.out.print("\f");
        int source = 0;
        int target = 0;
        StackAsMyArrayList bottle0 = new StackAsMyArrayList();
        StackAsMyArrayList bottle1 = new StackAsMyArrayList();
        StackAsMyArrayList bottle2 = new StackAsMyArrayList();
        StackAsMyArrayList bottle3 = new StackAsMyArrayList();
        StackAsMyArrayList bottle4 = new StackAsMyArrayList();
        
        StackAsMyArrayList[] bottles = new StackAsMyArrayList[5];
        bottles[0] = bottle0;
        bottles[1] = bottle1;
        bottles[2] = bottle2;
        bottles[3] = bottle3;
        bottles[4] = bottle4;
        
        
        bottle0.push(blue);
        bottle0.push(blue);
        bottle0.push(blue);
        bottle0.push(blue);
        
        bottle1.push(red);
        bottle1.push(red);
        bottle1.push(red);
        bottle1.push(red);
        
        bottle2.push(green);
        bottle2.push(green);
        bottle2.push(green);
        bottle2.push(green);
        
        //bottle3.push(bottle2.pop());
        //WPS 2
        Random rand = new Random();
        int min = 10;
        int max = 101;
        int num = rand.nextInt(max-min) + min;
        //System.out.println(num);
        showAll(bottles);
        for(int i = 0; i < num; i++)
        {
            scramblePuzzle(bottles);
            showAll(bottles);
            System.out.println("");
        }       
        
        //WPS 3
        Scanner input = new Scanner(System.in);
        boolean isSolved = false;
        try
        {
            while(!isSolved)
            {
                System.out.print("\nEnter source bottle number: ");
                source = input.nextInt();
                if(source < 0 || source > 4)
                {
                    System.out.print("Number out of range please try again: ");
                    source = input.nextInt();
                    while(source < 0 || source > 4)
                    {
                        System.out.print("Number out of range please try again: ");
                        source = input.nextInt();
                    }
                }
                if(bottles[source].peek() == null)
                {
                    System.out.print("The bottle is empty, pick another one: ");
                    source = input.nextInt();
                    while(bottles[source].peek() == null)
                    {
                        System.out.print("The bottle is empty, pick another one: ");
                        source = input.nextInt();
                    }
                }
                System.out.print("Enter target bottle number: ");
                target = input.nextInt();
                if(target < 0 || target > 4)
                {
                    System.out.print("Number out of range please try again: ");
                    target = input.nextInt();
                    while(target < 0 || target > 4)
                    {
                        System.out.print("Number out of range please try again: ");
                        target = input.nextInt();
                    }
                }
                
                if(bottles[source].peek() == bottles[target].peek() || bottles[target].peek() == null && bottles[target].getStackSize() < 4)
                {
                    if(bottles[target].getStackSize() >= 0 && bottles[target].getStackSize() < 4)
                    {
                        bottles[target].push(bottles[source].pop());
                        showAll(bottles);
                    }
                    else
                    {
                        System.out.println("Target Bottle is full!");
                    }
                }
                else
                {
                    System.out.println("Colours do not match!");
                }
                isSolved = solved(bottles);
            }
            if(solved(bottles))
            {
                System.out.println("\nCongratulations!!! Puzzle complete");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Invalid Input!");
        }
    }

    public static void showAll(StackAsMyArrayList[] bottles)
    {
         for(int i = 0; i < bottles.length; i++)
         {
             System.out.println("Bottle "+ i +": "+ bottles[i].toString());
         }
    }
    
    public static void scramblePuzzle(StackAsMyArrayList[] bottles)
    {
        Random rand = new Random();
        int min = 0;
        int max = 5;
        int num1 = rand.nextInt(max-min) + min;
        int num2 = rand.nextInt(max-min) + min;
        if(bottles[num1].getStackSize() != 0 && bottles[num1].getStackSize() <= 4 && bottles[num2].getStackSize() < 4 && num1 != num2)
        {
            bottles[num2].push(bottles[num1].pop());
        }
        System.out.println("From "+num1+" to "+num2);
    }
    
    public static boolean solved( StackAsMyArrayList bottles[])
    {
        int solvedCount = 0;
        boolean isSolved = false;
        for(int i = 0; i < bottles.length; i++)
         {
             if(bottles[i].getStackSize() == 4 && bottles[i].checkStackUniform() == true)
             {
                 solvedCount++;
             }
         }
         if(solvedCount == 3)
         {
             isSolved = true;
         }
         else
         {
             isSolved = false;
         }
         return isSolved;
    }
     
}