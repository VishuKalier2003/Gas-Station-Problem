/* There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i]...You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations... Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique...
 * Eg 1: Gas = [1, 2, 3, 4, 5]  Cost = [3, 4, 5, 1, 2]       Station = 3 (index)
 * Eg 2: Gas = [2, 3, 4]        Cost = [3, 4, 3]             Station = -1 (not possible)
 * Eg 3: Gas = [5, 1, 2, 3, 4]  Cost = [4, 4, 1, 5, 1]       Station = 4 (index)
 * Eg 4: Gas = [5, 8, 2, 8]     Cost = [6, 5, 6, 6]          Station = 3 (index)
 * Eg 5: Gas = [5, 5, 1, 3, 4]  Cost = [8, 1, 7, 1, 1]       Station = 3 (index)
 * Eg 6: Gas = [3, 1, 1]        Cost = [1, 2, 2]             Station = 0 (index)
*/
import java.util.*;
public class GasStation
{
    public int GasCircularCircuit(int gas[], int cost[])
    {
        int possible[] = new int[gas.length];     // Possible Gas Consumption...
        int i = 0, sum = 0;
        do
        {
            possible[i] = gas[i] - cost[i];    // Gas Consumption formula used...
            sum = sum + possible[i];           // Sum of entire cycle calculated...
            i++;
        }while(i < gas.length);
        System.out.println("The Consumption Array : ");
        for(int j = 0; j < possible.length; j++)
            System.out.print(possible[j]+", ");
        System.out.println();
        if(sum >= 0)              // If sum greater than zero, then traversal is possible...
        {
            int index = 0;
            for(int j = possible.length-1; j >= 0; j--)     // Traversing from backwards...
            {
                if(j == possible.length-1 && possible[j] < 0)
                {   // If first element encountered is zero...
                    while(possible[j] < 0)
                        j--;     // Finding the first positive element...
                    index = j;
                    break;
                }
                if(possible[j] < 0)     // If any value comes negative...
                {   // Negative value means that if the current index is the starting point then the circuit will never be complete...
                    index = j+1;
                    break;      // We find the first negative value and exit the loop...
                }
            }
            return index;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the number of Stations : ");
        x = sc.nextInt();
        int[] Gas = new int[x];
        int[] Travel = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the Gas data of "+(i+1)+" station : ");
            a = sc.nextInt();
            Gas[i] = a;
            System.out.print("Enter the Travel data of "+(i+1)+" station : ");
            a = sc.nextInt();
            Travel[i] = a;
        }
        System.out.println("The Gas Station Array ");     // Gas Station array...
        for(int i = 0; i < x; i++)
            System.out.print(Gas[i]+", ");
        System.out.println();
        System.out.println("The Travel Cost Array ");      // Cost Expenditure array...
        for(int i = 0; i < x; i++)
            System.out.print(Travel[i]+", ");
        System.out.println();
        GasStation station = new GasStation();     // Object created...
        x = station.GasCircularCircuit(Gas, Travel);        // Function call...
        System.out.println("The Gas Station Index : "+x);
        if(x >= 0)
            System.out.println("The Circular Travel is possible !!");
        else
            System.out.println("The Circular Travel is not possible !!");
        sc.close();
    }
}
