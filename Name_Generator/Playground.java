package Name_Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Playground 
{
    public static Integer[] randomNum(int length, String[] array)
    {
        Random rand = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();

        while (set.size() < length)
        {
            set.add(rand.nextInt(array.length));
        }

        Integer[] randNum = set.toArray(new Integer[0]);

        return randNum;
    }

    

    public static void main(String[] args) throws IOException
    {
        // String[] exam = {"banana", "apples", "blueberries", "pears"};
        // String[] exam2 = {"peas", "beans", "potato", "1", "3", "apples"};

        // System.out.println(Arrays.toString(fullNameWithNickname(choice_First_Names(1, 1, 1, 1), choice_Nicknames(1), choice_Last_Name(1, 1))));
        // System.out.println(Arrays.toString(fullNameWithoutNickname(choice_First_Names(1, 1, 1, 1), choice_Last_Name(1, 1))));

    }
}
