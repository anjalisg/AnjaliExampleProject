//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Lab16e
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram(new char[]{'a','b','c'},"H:\\APCSA\\Unit10-2016\\Unit10-Assignments\\Lab16e\\lab16e1.dat");
		test.loadAndAnalyzeFile();
		out.println("Letter occurring most : "+test.mostFrequent());
		out.println("Letter occurring least : "+test.leastFrequent());
		out.println("\n");
		out.println(test);


		//more test cases
		Histogram test1 = new Histogram(new char[]{'d','e','a'},"H:\\APCSA\\Unit10-2016\\Unit10-Assignments\\Lab16e\\lab16e2.dat");
		test.loadAndAnalyzeFile();
		out.println("Letter occurring most : "+test1.mostFrequent());
		out.println("Letter occurring least : "+test1.leastFrequent());
		out.println("\n");
		out.println(test1);
		
		Histogram test2 = new Histogram(new char[]{'x','a','r', 'q'},"H:\\APCSA\\Unit10-2016\\Unit10-Assignments\\Lab16e\\lab16e3.dat");
		test.loadAndAnalyzeFile();
		out.println("Letter occurring most : "+test2.mostFrequent());
		out.println("Letter occurring least : "+test2.leastFrequent());
		out.println("\n");
		out.println(test2);
	}
}