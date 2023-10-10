package Name_Generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NameGenerator 
{

    public static int choice_Region(String region)
    {
        // Region name requirements
        /* 
         * Land of Green (Reach, Cordelia, Becura)
         * Fortitude (Blooms, Becura)
         * Agni (Agni, Agraci)
         * Vitality (Elven)
         * Obscurity
         * Arcadia
         * Dragon Lair
         * 
         */
        String lowerCase = region.toLowerCase();
        int result = 0;

        if (lowerCase.equals("land of green"))
            result = 1;
        if (lowerCase.equals("fortitude"))
            result = 2;
        if (lowerCase.equals("agni"))
            result = 3;
        if (lowerCase.equals("vitality"))
            result = 4;
        if (lowerCase.equals("obscurity"))
            result = 5;
        if (lowerCase.equals("arcadia"))
            result = 6;
        if (lowerCase.equals("dragon lair"))
            result = 7;

        return result;
    }

    public static int choice_Race(String race)
    {
        // Race name requirements
        /*
         * Human
         * Demihuman
         * Elf
         * Orc
         * Demon
         * Angel
         * Dark Elf
         * Dragonite
         * Creed *****
         * 
         */

        String lowerCase = race.toLowerCase();
        int result = 0;

        if (lowerCase.equals("human"))
            result = 1;
        if (lowerCase.equals("demihuman"))
            result = 2;
        if (lowerCase.equals("elf"))
            result = 3;
        if (lowerCase.equals("orc"))
            result = 4;
        if (lowerCase.equals("demon"))
            result = 5;
        if (lowerCase.equals("angel"))
            result = 6;
        if (lowerCase.equals("dark elf"))
            result = 7;
        if (lowerCase.equals("dragonite"))
            result = 8;

        return result;
    }

    public static int choice_Class(String role)
    {
        // Role name requirements
        /*
         * Low
         * Middle
         * Upper
         */

        String lowerCase = role.toLowerCase();
        int result = 0;

        if (lowerCase.equals("low"))
            result = 1;
        if (lowerCase.equals("middle"))
            result = 2;
        if (lowerCase.equals("upper"))
            result = 3;

        return result;
    }

    public static int choice_Gender(String gender)
    {
        // Gender name requirements
        /*
         * Male
         * Female
         * Neutral
         * 
         */

        String lowerCase = gender.toLowerCase();
        int result = 0;

        if (lowerCase.equals("male"))
            result = 1;
        if (lowerCase.equals("female"))
            result = 2;
        if (lowerCase.equals("neutral"))
            result = 3;

        return result;
    }

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

    public static String[] contains()
    {
        String[] list = new String[10];
        return list; 
    }

    // Choosing the Regular Names
    public static String[] choice_First_Names(int region, int race, int role, int gender) throws IOException
    {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Male_Names.txt"));

        // load data from file
        if (gender == 1)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Male_Names.txt"));
        }
        if (gender == 2)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular_Female_Names.txt"));
        }
        if (gender == 1 && role == 3)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Noble/Noble_Male_Names.txt"));
        }
        if (gender == 2 && role == 3)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Noble/Noble_Female_Names.txt"));
        }

        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
 

        String[] firstNames = new String[10];
        Integer[] randNum = randomNum(firstNames.length, array);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < firstNames.length; i++) {
            int ran = randNum[i];
            //System.out.println(ran);
            firstNames[i] = array[ran];
        }

        return firstNames;
    }

    public static String[] choice_Nicknames() throws IOException
    {
        // list that holds strings of a file
        List<String> listOfNick = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Nicknames.txt"));

        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfNick.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array = listOfNick.toArray(new String[0]);
 
        String[] nickNames = new String[4];
        Integer[] randNum = randomNum(nickNames.length, array);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < nickNames.length; i++) {
            int ran = randNum[i];
            nickNames[i] = array[ran];
        }

        return nickNames;
    }

    public static String[] choice_Last_Name(int role) throws IOException
    {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Last_Names.txt"));

        // load data from file
        if (role == 1 || role == 2)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Last_Names.txt"));
        }
        if (role == 3)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Noble/Noble_Last_Names.txt"));
        }

        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
 
        String[] lastNames = new String[10];
        Integer[] randNum = randomNum(lastNames.length, array);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < lastNames.length; i++) {
            int ran = randNum[i];
            lastNames[i] = array[ran];
        }

        return lastNames;
    } 

    public static void toPrint(int region, int race, int role, int gender) throws IOException
    {
        String[] firstName = choice_First_Names(region, race, role, gender);
        String[] nickName = choice_Nicknames();
        String[] lastName = choice_Last_Name(role);
        String[] regularName = new String[6];
        String[] specificName = new String[4];
        String[] fullName = new String[10];
        
        for (int i=0; i < regularName.length; i++)
        {
            regularName[i] = firstName[i] + " " + lastName[i];
        }

        for (int i=0; i < specificName.length; i++)
        {
            specificName[i] = firstName[i + 6] + " '" + nickName[i] + "' " + lastName[i + 6];
        }

        for (int i=0; i < fullName.length; i++)
        {
            if (i <= 5)
                fullName[i] = regularName[i];
            else
                fullName[i] = specificName[i-6];
        }
        
        for (String names: fullName)
        {
            System.out.println(names);
        }

        //System.out.println(list.length);
        //System.out.println(list[1]);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        //  Land of Green
                // * Reach
                // * Cordelia
                // * New Becura
        //  Fortitude
                // * Blooms
                // * Becura
        //  Agni 
                // * Agni
                // * Agraci
        //  Vitality
                // * Vinez
                // * Elven
        //  * Obscurity
        //  * Arcadia
        //  * Dragon Lair

        System.out.println("What Region is your character from?");
        System.out.println("-----------------------------------");
        System.out.println("* Land of Green");
        System.out.println("* Fortitude");
        System.out.println("* Agni");
        System.out.println("* Vitality");
        System.out.println("* Obscurity");
        System.out.println("* Arcadia");
        System.out.println("* Dragon Lair");
        System.out.println("-----------------------------------");
        String region = scanner.nextLine();
        choice_Region(region);

        //  * Human
        //  * Demihuman
        //  * Elf
        //  * Orc
        //  * Demon
        //  * Angel
        //  * Dark Elf
        //  * Dragonite
        //  * Creed *****

        System.out.println("What is your Race?");
        System.out.println("------------------");
        System.out.println("* Human");
        System.out.println("* Demihuman");
        System.out.println("* Elf");
        System.out.println("* Orc");
        System.out.println("* Demon");
        System.out.println("* Angel");
        System.out.println("* Dark Elf");
        System.out.println("* Dragonite");
        System.out.println("* Dragus");
        System.out.println("* Orcus");
        System.out.println("* Rabidus");
        System.out.println("------------------");
        String race = scanner.nextLine();
        choice_Race(race);

        //  * Low
        //  * Middle
        //  * Upper

        System.out.println("What is your social class?");
        System.out.println("--------------------");
        System.out.println("* Low");
        System.out.println("* Middle");
        System.out.println("* Upper");
        System.out.println("--------------------");
        String role = scanner.nextLine();
        choice_Class(role);

        //  * Male
        //  * Female
        //  * Neutral

        System.out.println("What is your Gender?");
        System.out.println("--------------------");
        System.out.println("* Male");
        System.out.println("* Female");
        System.out.println("* Neutral");
        System.out.println("--------------------");
        String gender = scanner.nextLine();
        choice_Gender(gender);
        System.out.println("--------------------" + "\n");

        System.out.println("----------------------------------");
        toPrint(choice_Region(region), choice_Race(race), choice_Class(role), choice_Gender(gender));
        System.out.println("----------------------------------");
        
    }
}
