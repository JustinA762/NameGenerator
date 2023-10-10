package Name_Generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Playground 
{
    // Choosing the Regular Names
    public static void main(String[] args)
    {
        String[] list = {"John", "Michael", "Justin", "James", "Sam", "Joe", "Joan"};
        String temp = "";
        String[] lower = new String[list.length];

        System.out.println(Arrays.toString(list));

        for (int i = 0; i<list.length; i++)
        {
            temp = list[i].toLowerCase();
            lower[i] = temp;
        }

        //System.out.println(Arrays.toString(lower));

        char[] charList = lower[0].toCharArray();
        HashSet<String> set = new HashSet<String>();
        int count = 0;

        // Going through word list
        for (int i = 0; i<lower.length; i++)
        {
            charList = lower[i].toCharArray();
            // Going through letters of each word list
            for (int j = 0; j<lower[i].length(); j++)
            {
                //System.out.print(charList[j] + " ");

                if (charList[j] == 'a')
                {
                    System.out.println("Detected!" + i);
                    //output[count] = lower[i];
                    set.add(lower[i]);
                    count++;
                }
                if (charList[j] == 'j' && charList[j+1] == 'o')
                {
                    System.out.println("Wow!" + i);
                    //output[count] = lower[i];
                    set.add(lower[i]);
                    count++;
                }
            }
        }
        int i=0;
        int j=0;
        String[] output = new String[count - 1];

        // Capitalize first letter
        for (String ele:set)
        {
            output[i++] = ele.substring(0, 1).toUpperCase() + ele.substring(1);
        }

        System.out.println(i);
        System.out.println(Arrays.toString(output));
    }
}
