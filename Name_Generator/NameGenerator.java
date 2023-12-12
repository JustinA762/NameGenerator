package Name_Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
         * Dragus
         * Orcus
         * Rabidus
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
        if (lowerCase.equals("dragus"))
            result = 9;
        if (lowerCase.equals("orcus"))
            result = 10;
        if (lowerCase.equals("rabidus"))
            result = 11;
        

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

    public static int choice_Character(String character)
    {
        /*
         * family
         * happiness
         * purpose
         * survival
         * 
         */

        String lowerCase = character.toLowerCase();
        int result = 0;

        if (lowerCase.equals("family"))
            result = 1;
        if (lowerCase.equals("happiness"))
            result = 2;
        if (lowerCase.equals("purpose"))
            result = 3;
        if (lowerCase.equals("survival"))
            result = 4;

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

    // Names contains certain characters to make a name catchy
    public static String[] contains(String [] names, String cases)
    {
        String temp = "";
        String[] lower = new String[names.length];

        //System.out.println(Arrays.toString(names));

        for (int i = 0; i<names.length; i++)
        {
            temp = names[i].toLowerCase();
            lower[i] = temp;
        }

        //System.out.println(Arrays.toString(lower));

        HashSet<String> set = new HashSet<String>();

        // Going through word list
        for (int i = 0; i<lower.length; i++)
        {
            if (lower[i].contains(cases))
            {
                //System.out.println("Wow!" + i);
                set.add(lower[i]);
            }
        }
        int i=0;
        String[] output = new String[set.size()];

        // Capitalize first letter
        for (String ele:set)
        {
            output[i++] = ele.substring(0, 1).toUpperCase() + ele.substring(1);
        }
        //System.out.println(Arrays.toString(output));
        return output;
    }

    // First Names gathered into one output file. Last names too 
    public static void gatherAllToOutput(String name) throws IOException
    {
        HashSet<String> theNames = new HashSet<String>();
        String output = new File("").getAbsolutePath() + "\\Name_Generator\\names\\output.txt";

        if (name == "first")
        {
            theNames.add(new File("").getAbsolutePath() + "\\Name_Generator\\names\\Country_and_Region");
            theNames.add(new File("").getAbsolutePath() + "\\Name_Generator\\names\\Noble");
            theNames.add(new File("").getAbsolutePath() + "\\Name_Generator\\names\\Race");
            theNames.add(new File("").getAbsolutePath() + "\\Name_Generator\\names\\Regular");
            output = new File("").getAbsolutePath() + "\\Name_Generator\\names\\outputFirstNames.txt"; 
        }
        if (name == "last")
        {
            theNames.add(new File("").getAbsolutePath() + "\\Name_Generator\\names\\Last_Names");
            output = new File("").getAbsolutePath() + "\\Name_Generator\\names\\outputLastNames.txt";
        }
        
        // You need the specific filepath, not just the output.txt!
        PrintWriter pw = new PrintWriter(output);

        //int count = 0;
        String names[] = new String[theNames.size()];
        names = theNames.toArray(new String[0]);

        for (String fileFirstNames: names)
        {
            File dir = new File(fileFirstNames);

            String[] fileNames = dir.list();
            //System.out.println(Arrays.toString(fileNames));

            // pw --> output.txt
            // br --> going through the files in directory
            for (String fileName : fileNames) 
            {
                File f = new File(dir, fileName);
                BufferedReader br = new BufferedReader(new FileReader(f));
    
                String line = br.readLine();
                while (line != null) 
                {
                    //pw.println(line + " - " + count++);
                    pw.println(line);
                    line = br.readLine();
                }
                pw.flush();
            }
            //System.out.println("Reading from all files" + " in directory " + dir.getName() + " Completed");
        }
    }

    // File to String Array
    public static String[] fileToArray(String filepath) throws IOException
    {
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(filepath));
        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        String[] array = listOfStrings.toArray(new String[0]);

        //System.out.println(Arrays.toString(array) + "\n" + array.length);

        return array;
    }

    public static String[] getCatchyNames(String name, String cases) throws IOException
    {
        String[] inital = fileToArray("Name_Generator/names/outputFirstNames.txt");

        if (name == "first")
        {
            // Gather first/last names to one file, output
            gatherAllToOutput("first");
            // Take one file and convert it to String Array
            inital = fileToArray("Name_Generator/names/outputFirstNames.txt");
        }
        if (name == "last")
        {
            // Gather first/last names to one file, output
            gatherAllToOutput("last");
            // Take one file and convert it to String Array
            inital = fileToArray("Name_Generator/names/outputLastNames.txt");
        }

        HashSet<String> listOfStrings = new HashSet<String>();

        // Getting all the names that has the case
        listOfStrings.addAll(Arrays.asList(contains(inital, cases)));

            
        String output[] = new String[listOfStrings.size()];
        output = listOfStrings.toArray(new String[0]);
        //System.out.println(Arrays.toString(output));
        //System.out.println(output.length);

        return output;
    }

    // Gathers the first and last catchy names, putting it together
    public static String[] fullCatchyNameByCase(String cases) throws IOException
    {
        String[] thefirst = getCatchyNames("first", cases);
        String[] thelast = getCatchyNames("last", cases);

        Integer[] randNumFirst = randomNum(thefirst.length, thefirst);
        Integer[] randNumLast = randomNum(thelast.length, thelast);

        String[] newfirst = new String[thefirst.length];
        String[] newlast = new String[thelast.length];

        for (int i = 0; i < thefirst.length; i++) {
            int ran = randNumFirst[i];
            //System.out.println(ran);
            newfirst[i] = thefirst[ran];
        }

        for (int i = 0; i < thelast.length; i++) {
            int ran = randNumLast[i];
            //System.out.println(ran);
            newlast[i] = thelast[ran];
        }

        int len = Math.min(thefirst.length, thelast.length);
        //System.out.println(thefirst.length + "\n" + thelast.length);

        String fullName[] = new String[len];

        for (int i=0; i<len; i++)
            fullName[i] = newfirst[i] + " " + newlast[i];
            
        return fullName;
    }

    public static String[] fullCatchyName(int character) throws IOException 
    {
        HashSet<String> listOfStrings = new HashSet<String>();

        /* Catchy Name Cases */
        // if (character == 1) // Family
        // {
        //     listOfStrings.addAll(Arrays.asList(inital));
        //     //System.out.println(listOfStrings + " \n" + listOfStrings.size());
        // }
        if (character == 2) // Happiness
        {
            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("s")));
            System.out.println("s - " + fullCatchyNameByCase("s").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("sh")));
            System.out.println("sh - " + fullCatchyNameByCase("sh").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("l")));
            System.out.println("l - " + fullCatchyNameByCase("l").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("r")));
            System.out.println("r - " + fullCatchyNameByCase("r").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("m")));
            System.out.println("m - " + fullCatchyNameByCase("m").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("n")));
            System.out.println("n - " + fullCatchyNameByCase("n").length);
        }
        if (character == 3) // Purpose
        {
            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("us")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "us").length);
            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("ia")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "ia").length);
            //System.out.println(listOfStrings.size());
        }
        if (character == 4) // Survival
        {
            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("k")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "k").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("t")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "t").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("z")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "z").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("x")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "x").length);

            listOfStrings.addAll(Arrays.asList(fullCatchyNameByCase("r")));
            // System.out.println(listOfStrings + " \n" + contains(inital, "r").length);
            //System.out.println(listOfStrings.size());
        }

        String output[] = new String[listOfStrings.size()];
        output = listOfStrings.toArray(new String[0]);
        //System.out.println(Arrays.toString(output));

        return output;
    }

    public static String[] region_Names(int region) throws IOException
    {
        HashSet<String> listOfStrings = new HashSet<String>();
        HashSet<String> listOfStrings2 = new HashSet<String>();
        HashSet<String> listOfStrings3 = new HashSet<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Neutral_Names.txt"));
        BufferedReader bf2 = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Neutral_Names.txt"));
        BufferedReader bf3 = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Neutral_Names.txt"));

        if (region == 1) // Land of Green
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Reach_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Cordelia_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Becura_Names.txt"));
        }
        if (region == 2) // Fortitude
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Blooms_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Becura_Names.txt"));
        }
        if (region == 3) // Agni
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Agni_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Agraci_Names.txt"));
        }
        if (region == 4) // Vitality
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Country_and_Region/Elven_Names.txt"));
        }
        if (region == 5) // Obscurity
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Demon_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Race/Dark_Elf_Names.txt"));
        }
        if (region == 6) // Arcadia
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Angel_Names.txt"));
        if (region == 7) // Dragon Lair
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Dragonite_Names.txt"));

        String line = bf.readLine();
        String line2 = bf2.readLine();
        String line3 = bf3.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        while (line2 != null) {
            listOfStrings2.add(line2);
            line2 = bf2.readLine();
        }

        while (line3 != null) {
            listOfStrings3.add(line3);
            line3 = bf3.readLine();
        }

        bf.close();
        bf2.close();
        bf3.close();

        String[] array = listOfStrings.toArray(new String[0]);
        String[] array2 = listOfStrings2.toArray(new String[0]);
        String[] array3 = listOfStrings3.toArray(new String[0]);
        String[] output = listOfStrings.toArray(new String[0]);

        //System.out.println(Arrays.toString(array));
        //System.out.println(array.length);

        //System.out.println(Arrays.toString(array2));
        //System.out.println(array2.length);

        //System.out.println(Arrays.toString(array3));
        //System.out.println(array3.length);

        if (region == 1)
        {
            listOfStrings.addAll(listOfStrings2);
            listOfStrings.addAll(listOfStrings3);
            output = listOfStrings.toArray(new String[0]);
        }
        if (region == 2)
        {
            listOfStrings.addAll(listOfStrings2);
            output = listOfStrings.toArray(new String[0]);
        }
        if (region == 3)
        {
            listOfStrings.addAll(listOfStrings2);
            output = listOfStrings.toArray(new String[0]);
        }
        if (region == 4)
            output = listOfStrings.toArray(new String[0]);
        if (region == 5)
        {
            listOfStrings.addAll(listOfStrings2);
            output = listOfStrings.toArray(new String[0]);
        }
        if (region == 6)
            output = listOfStrings.toArray(new String[0]);
        if (region == 7)
            output = listOfStrings.toArray(new String[0]);

        System.out.println("Region: " + output.length);

        return output;
    }   

    public static String[] race_Names(int race) throws IOException
    {
        HashSet<String> listOfStrings = new HashSet<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Neutral_Names.txt"));
       
        if (race == 1) // Human
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Human_Names.txt"));
        if (race == 2) // Demihuman
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Demihuman_Names.txt"));
        if (race == 3) // Elf
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Elf_Names.txt"));
        if (race == 4) // Orc
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Orc_Names.txt"));
        if (race == 5) // Demon
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Demon_Names.txt"));
        if (race == 6) // Angel
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Angel_Names.txt"));
        if (race == 7) // Dark Elf
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Dark_Elf_Names.txt"));
        if (race == 8) // Dragonite
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Dragonite_Names.txt"));
        if (race == 9 || race == 10 || race == 11) // Creed
            bf = new BufferedReader(new FileReader("Name_Generator/names/Race/Creed_Names.txt"));
       
        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        String[] output = listOfStrings.toArray(new String[0]);
        System.out.println("Race: " + output.length);

        return output;
    }      

    public static String[] roles_Names(int role, int gender) throws IOException
    {
        // list that holds strings of a file
        HashSet<String> listOfStrings = new HashSet<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Male_Names.txt"));

        // load data from file
        if (gender == 1)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Male_Names.txt"));
        }
        if (gender == 2)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Female_Names.txt"));
        }
        if (gender == 3)
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Regular/Regular_Neutral_Names.txt"));
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

        System.out.println("Regular: " + array.length);

        return array;
    }

    public static String[] combineArrays(String[] one, String[] two)
    {
        HashSet<String> comb = new HashSet<String>();

        comb.addAll(Arrays.asList(one));
        comb.addAll(Arrays.asList(two));

        String output[] = new String[comb.size()];
        output = comb.toArray(new String[0]);

        return output;
    }

    // Choosing the Regular Names
    public static String[] choice_First_Names(int region, int race, int role, int gender) throws IOException
    {
        List<String> totalNames = new ArrayList<String>();

        List<String> rolesNames = Arrays.asList(roles_Names(role, gender));
        List<String> regionNames = Arrays.asList(region_Names(region));
        List<String> raceNames = Arrays.asList(race_Names(race));
        
        totalNames.addAll(rolesNames);
        totalNames.addAll(regionNames);
        totalNames.addAll(raceNames);
        String[] output = totalNames.toArray(new String[0]);
        System.out.println("Total: " + output.length + "\n----------------------------------");

        String[] firstNames = new String[totalNames.size()];
        Integer[] randNum = randomNum(firstNames.length, output);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < firstNames.length; i++) {
            int ran = randNum[i];
            //System.out.println(ran);
            firstNames[i] = output[ran];
        }

        return firstNames;
    }

    public static String[] choice_Nicknames(int race) throws IOException
    {
        // list that holds strings of a file
        List<String> listOfNick = new ArrayList<String>();
        List<String> listOfNick2 = new ArrayList<String>();
        List<String> listOfNick3 = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Nicknames/Blood_Thirsty_Nicknames.txt"));
        BufferedReader bf2 = new BufferedReader(new FileReader("Name_Generator/names/Nicknames/Fantasy_Nicknames.txt"));
        BufferedReader bf3 = new BufferedReader(new FileReader("Name_Generator/names/Nicknames/Nicknames.txt"));

        if (race == 9 || race == 10 || race == 11)
            bf = new BufferedReader(new FileReader("Name_Generator/names/Nicknames/Heavy_Words.txt"));

        // read entire line as string
        String line = bf.readLine();
        String line2 = bf2.readLine();
        String line3 = bf3.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfNick.add(line);
            line = bf.readLine();
        }

        while (line2 != null) {
            listOfNick2.add(line2);
            line2 = bf2.readLine();
        }

        while (line3 != null) {
            listOfNick3.add(line3);
            line3 = bf3.readLine();
        }
       
        // closing bufferreader object
        bf.close();
        bf2.close();
        bf3.close();
    
        // storing the data in arraylist to array
        String[] output = listOfNick.toArray(new String[0]);

        System.out.println("BTN: " + listOfNick.size());
        System.out.println("Fantasy: " + listOfNick2.size());
        System.out.println("NN: " + listOfNick3.size());

        if (race == 9 || race == 10 || race == 11)
            output = listOfNick.toArray(new String[0]);
        else    
        {
            listOfNick.addAll(listOfNick2);
            listOfNick.addAll(listOfNick3);
            output = listOfNick.toArray(new String[0]);
        }
        System.out.println("Total: " + output.length + "\n----------------------------------");
 
        String[] nickNames = new String[listOfNick.size()];
        Integer[] randNum = randomNum(nickNames.length, output);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < nickNames.length; i++) {
            int ran = randNum[i];
            nickNames[i] = output[ran];
        }

        return nickNames;
    }

    public static String[] choice_Last_Name(int region, int role) throws IOException
    {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        List<String> listOfStrings2 = new ArrayList<String>();
        List<String> listOfStrings3 = new ArrayList<String>();
        List<String> listOfStrings4 = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Regular_Last_Names.txt"));
        BufferedReader bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Regular_Last_Names.txt"));
        BufferedReader bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Regular_Last_Names.txt"));
        BufferedReader bf4 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Regular_Last_Names.txt"));

        // load data from file
        if ((region == 1 && role == 1) || (region == 1 && role == 2)) // Land of Green
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Sword_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Water_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Warrior_Last_Names.txt"));
            bf4 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Regular_Last_Names.txt"));
        }
        if ((region == 1 && role == 3)) // Land of Green
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Noble/Noble_Last_Names.txt"));
        }
        if (region == 2) // Fortitude
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Wind_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Thunder_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Warrior_Last_Names.txt"));
        }
        if (region == 3) // Agni
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Fire_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Divine_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Warrior_Last_Names.txt"));
        }
        if (region == 4) // Vitality
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Divine_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Warrior_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Wind_Last_Names.txt"));
        }   
        if (region == 5) // Obscurity
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Fire_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Divine_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Dark_Last_Names.txt"));
        }
        if (region == 6) // Arcadia
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Divine_Last_Names.txt"));
        }
        if (region == 7) // Dragon Lair
        {
            bf = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Thunder_Last_Names.txt"));
            bf2 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Water_Last_Names.txt"));
            bf3 = new BufferedReader(new FileReader("Name_Generator/names/Last_Names/Fire_Last_Names.txt"));
        }

        // read entire line as string
        String line = bf.readLine();
        String line2 = bf2.readLine();
        String line3 = bf3.readLine();
        String line4 = bf4.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        while (line2 != null) {
            listOfStrings2.add(line2);
            line2 = bf2.readLine();
        }

        while (line3 != null) {
            listOfStrings3.add(line3);
            line3 = bf3.readLine();
        }

        while (line4 != null) {
            listOfStrings4.add(line4);
            line4 = bf4.readLine();
        }
       
        // closing bufferreader object
        bf.close();
        bf2.close();
        bf3.close();
        bf4.close();

        // storing the data in arraylist to array
        String[] output = listOfStrings.toArray(new String[0]);
       
        if ((region == 1 && role == 1) || (region == 1 && role == 2)) // Land of Green
        {
            listOfStrings.addAll(listOfStrings2);
            listOfStrings.addAll(listOfStrings3);
            listOfStrings.addAll(listOfStrings4);
            output = listOfStrings.toArray(new String[0]);
            System.out.println("Land of Green (Regular): " + output.length);
        }
        if ((region == 1 && role == 3)) // Land of Green
        {
            output = listOfStrings.toArray(new String[0]);
            System.out.println("Land of Green (Noble): " + output.length);
        }
        if (region == 2 || region == 3 || region == 4 || region == 5 || region == 7) // Fortitude
        {
            listOfStrings.addAll(listOfStrings2);
            listOfStrings.addAll(listOfStrings3);
            output = listOfStrings.toArray(new String[0]);
            System.out.println("Multi: " + output.length);
        }
        if (region == 6) // Arcadia
        {
            output = listOfStrings.toArray(new String[0]);
            System.out.println("Arcadia: " + output.length);
        }
 
        String[] lastNames = new String[listOfStrings.size()];
        Integer[] randNum = randomNum(lastNames.length, output);
       
        // printing each line of file 
        // which is stored in array
        for (int i = 0; i < lastNames.length; i++) {
            int ran = randNum[i];
            lastNames[i] = output[ran];
        }
        System.out.println("Total: " + output.length + "\n----------------------------------");

        return lastNames;
    } 

    public static String[] fullNameWithNickname(String[] first, String[] nick, String[] last)
    {
        int thefirstcom = Math.min(first.length, last.length);
        int theseccom = Math.min(thefirstcom, nick.length);
        String[] fullname = new String[theseccom];

        for (int i=0; i<theseccom; i++)
        {
            fullname[i] = first[i] + " '" + nick[i] + "' " + last[i];
        }

        return fullname;
    }

    public static String[] fullNameWithoutNickname(String[] first, String[] last)
    {
        int thefirstcom = Math.min(first.length, last.length);
        String[] fullname = new String[thefirstcom];

        for (int i=0; i<thefirstcom; i++)
        {
            fullname[i] = first[i] + " " + last[i];
        }

        return fullname;
    }

    public static void toPrint(int region, int race, int role, int gender, int character) throws IOException
    {
        String[] fullNameWithoutNick = fullNameWithoutNickname(choice_First_Names(region, race, role, gender), choice_Last_Name(region, role));
        String[] fullNameWithNick = fullNameWithNickname(choice_First_Names(region, race, role, gender), choice_Nicknames(race), choice_Last_Name(region, role));
        String[] fullCatchyNames = fullCatchyName(character);

        String[] regularName = new String[5];
        String[] specificName = new String[5];
        String[] catchyName = new String[10];
        String[] fullName = new String[20];
        
        for (int i=0; i < regularName.length; i++)
        {
            regularName[i] = fullNameWithoutNick[i];
        }

        for (int i=0; i < specificName.length; i++)
        {
            specificName[i] = fullNameWithNick[i];
        }

        for (int i=0; i < catchyName.length; i++)
        {
            catchyName[i] = fullCatchyNames[i];
        }

        for (int i=0; i < fullName.length; i++)
        {
            if (i <= 4)
                fullName[i] = regularName[i];
            else if (4 < i && i <= 9)
                fullName[i] = specificName[i-5];
            else
                fullName[i] = catchyName[i-10];
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

        System.out.println("What is your social class?");
        System.out.println("--------------------");
        System.out.println("* Low");
        System.out.println("* Middle");
        System.out.println("* Upper");
        System.out.println("--------------------");
        String role = scanner.nextLine();

        System.out.println("What is your Gender?");
        System.out.println("--------------------");
        System.out.println("* Male");
        System.out.println("* Female");
        System.out.println("* Neutral");
        System.out.println("--------------------");
        String gender = scanner.nextLine();

        System.out.println("What's important to your character?");
        System.out.println("--------------------");
        System.out.println("* Family");
        System.out.println("* Happiness");
        System.out.println("* Purpose");
        System.out.println("* Survival");
        System.out.println("--------------------");
        String character = scanner.nextLine();
        System.out.println("--------------------" + "\n");

        System.out.println("----------------------------------");
        toPrint(choice_Region(region), choice_Race(race), choice_Class(role), choice_Gender(gender), choice_Character(character));
        System.out.println("----------------------------------");
        
    }
}
