/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Apr 2019
 * Created for: ICS4U
 * This program creates all the magic squares with magic number 15 (numbers
 * from 1 to 9)
 *
 ****************************************************************************/

import java.util.Scanner;
import java.util.Arrays;

public class MagicSquares
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[9];

        // Gets values for array
        for (int i = 0; i < 9; i++)
        {
            System.out.print("Enter the value at " + (i+1) + " : ");
            if (scanner.hasNextInt())
            {
                int j = scanner.nextInt();
                System.out.print(j + "\n");
                array[i] = j;
            }
        }

        // Checks if array is a magic square
        if (checkMagicSquare(array) == true)
        {
            System.out.print("Is a magic square\n");
        }
        else
        {
            System.out.print("Is not a magic square\n");
        }

        // Creates new magic square with numbers from 1-9
        int arr[] = {1,2,3,4,5,6,7,8,9};

        // Creates magic square
        createMagicSquare(arr, 0);
    }

    // Checks if array is a magic sqaure
    public static boolean checkMagicSquare(int arr[])
    {
        if (arr.length == 9)
        {
            // Checks if sums of sides and diagonals are equal to each other
            if (arr[0] + arr[3] + arr[6] == arr[1] + arr[4] + arr[7]
                && arr[1] + arr[4] + arr[7] == arr[2] + arr[5] + arr[8]
                && arr[0] + arr[3] + arr[6] == arr[2] + arr[5] + arr[8]
                && arr[0] + arr[1] + arr[2] == arr[3] + arr[4] + arr[5]
                && arr[3] + arr[4] + arr[5] == arr[6] + arr[7] + arr[8]
                && arr[0] + arr[1] + arr[2] == arr[6] + arr[7] + arr[8]
                && arr[0] + arr[4] + arr[8] == arr[2] + arr[4] + arr[6])
            {
                return true;
            }
        }
        return false;
    }
    public static void createMagicSquare(int arr[], int index)
    {
        // Creates magic square
    	if(index == arr.length)
        {
            boolean magic = checkMagicSquare(arr);
            if(magic == true)
            {
                System.out.print("\n" + Arrays.toString(arr));
            }
        }
        else
        {
            for(int count = index; count <= arr.length-1; count++)
            {
                // Swaps elements in the array, and repeats process until
                // the numbers create a magic square

                // Note : Very brute force
                swapElements(arr, index, count);
                createMagicSquare(arr, index + 1);
                swapElements(arr, index, count);
            }
        }
    }
    public static void swapElements(int[] currentSquare, int currentInd, int iteration)
    {
        // swaps elements in array
        int temp = currentSquare[currentInd];
        currentSquare[currentInd] = currentSquare[iteration];
        currentSquare[iteration] = temp;
    }
}
