package Name_Generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Playground 
{
    // Choosing the Regular Names
    public static String[] choice_Regular_Names(int gender) throws IOException
    {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        List<String> listOfLast = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/Regular_Male_Names.txt"));
        BufferedReader bf2 = new BufferedReader(new FileReader("Name_Generator/Regular_Last_Names.txt"));

        if (gender == 2)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/Regular_Female_Names.txt"));
        }

        // read entire line as string
        String line = bf.readLine();
        String line2 = bf2.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        while (line2 != null) {
            listOfLast.add(line2);
            line2 = bf2.readLine();
        }
       
        // closing bufferreader object
        bf.close();
        bf2.close();
       
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        String[] array2 = listOfLast.toArray(new String[0]);
 
        Random rand = new Random();
        String[] fullNames = new String[6];
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < fullNames.length; i++) {
            int ran = rand.nextInt(array.length);
            int ran2 = rand.nextInt(array2.length);
            fullNames[i] = array[ran] + " " + array2[ran2];
        }

        System.out.println(fullNames[1]);

        return fullNames;
    }

    public static void toPrint(String[] list)
    {
        for (String names: list)
        {
            System.out.println(names);
        }

        System.out.println(list.length);
        System.out.println(list[1]);
    }

    // to handle exceptions include throws
    public static void main(String[] args) throws IOException
    {
        // /* --------------------------------------First and Last name picking------------------------------------------- */
        // // list that holds strings of a file
        // List<String> listOfStrings = new ArrayList<String>();
        // List<String> listOfLast = new ArrayList<String>();

        // int gender = 2;

        // // load data from file
        // BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/Regular_Male_Names.txt"));
        // BufferedReader bf2 = new BufferedReader(new FileReader("Name_Generator/Regular_Last_Names.txt"));

        // if (gender == 1)
        // {
        //     bf = new BufferedReader(new FileReader("Name_Generator/Regular_Female_Names.txt"));
        // }

        // // read entire line as string
        // String line = bf.readLine();
        // String line2 = bf2.readLine();
       
        // // checking for end of file
        // while (line != null) {
        //     listOfStrings.add(line);
        //     line = bf.readLine();
        // }
        // while (line2 != null) {
        //     listOfLast.add(line2);
        //     line2 = bf2.readLine();
        // }
       
        // // closing bufferreader object
        // bf.close();
        // bf2.close();
       
        // // storing the data in arraylist to array
        // String[] array = listOfStrings.toArray(new String[0]);
        // String[] array2 = listOfLast.toArray(new String[0]);
 
        // Random rand = new Random();
        // String output = "";
        // String[] fullNames = new String[10];
       
        // // printing each line of file 
        // // which is stored in array
        // for (int i = 0; i < 10; i++) {
        //     int ran = rand.nextInt(array.length);
        //     int ran2 = rand.nextInt(array2.length);
        //     output = array[ran] + " " + array2[ran2];
        //     fullNames[i] = array[ran] + " " + array2[ran2];
        //     System.out.println(output);
        // }

        //System.out.println(fullNames[9]);

        /* ------------------------------------------------------------------------------------------------ */
        
        System.out.println(Arrays.toString(choice_Regular_Names(1)));
        toPrint(choice_Regular_Names(1));

    }    
}
