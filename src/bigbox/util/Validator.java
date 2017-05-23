package bigbox.util;

import java.util.Scanner;

public class Validator
{
	public static void displayMenu()
    {
        System.out.println("list  -List all stores");
        System.out.println("div   -List all stores for a division");
        System.out.println("add   -Add a store");
        System.out.println("del   -Delete a store");
        System.out.println("help  -Show this menu");
        System.out.println("exit  -Exit this application");
        System.out.println();
    }
        
	public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();        // read the first string on the line
        sc.nextLine();               // discard the rest of the line
        return s;
    }
	
	public static String getLine(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();        // read the whole line
        return s;
    }

    public static String getString(Scanner sc, String prompt, int length)
    {
        String s="";
        boolean isValid=false;
        while (!isValid) {
            System.out.print(prompt);
        	s = sc.next();        // read the first string on the line
        	if (s.length()==length) {
        		isValid = true;
        	}
        	else
        		System.out.println("Error! length. Should be "+length+" characters.  Try again.");
        	sc.nextLine();               // discard the rest of the line
        }
        return s;
    }

	public static String getStringNumeric(Scanner sc, String prompt, int length)
    {
        String s="";
        boolean isValid=false;
        while (!isValid) {
            System.out.print(prompt);
        	if (sc.hasNextInt()) {   // even though this is a String, the values should be numeric
	        	s = sc.next();        // read the first string on the line
	        	if (s.length()==length) {
	        		if (isPositive(s))
	        			isValid = true;
	        		else
	        			System.out.println("Error!  Value should be positive (>=0).");
	        	}
	        	else
	        		System.out.println("Error! length. Should be "+length+" characters.  Try again.");
        	}
        	else
        		System.out.println("Error! Should be a numeric value.  Try again.");
        	sc.nextLine();               // discard the rest of the line
        }
        return s;
    }

    public static int getInt(Scanner sc, String prompt)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    public static String getValidContinueInput(Scanner sc) {
    	boolean isValid=false;
    	String i = "";
    	while (isValid == false)
    	{
    		System.out.println("Would you like to continue? (y/n)");
    		i = sc.next();

    		if ((i.equalsIgnoreCase("y"))|| (i.equalsIgnoreCase("n")))
    			isValid = true;
    		else
    		{
    			System.out.println("Please enter y or n!");
    			isValid=false;
    		}
    	}
    	return i;
    }
    private static boolean isPositive(String s) {
    	int i = Integer.parseInt(s);
    	return isPositive(i);
    }
    private static boolean isPositive(int i) {
    	boolean positive = false;
    	if (i>=0) {
    		positive=true;
    	}
    	return positive;	
    }
}