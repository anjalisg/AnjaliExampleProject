//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
	}
	
	public void setName(String name)
	{
		myName = name;
	}	
	
	public void setGrades(String gradeList)
	{
		myGrades = new Grades(gradeList);
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);

	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}
//	public double[] getGrades() {
//		return myGrades.getGrades();
//	}
	public ArrayList<Double> getGrades(){
		return myGrades.getGrades();
	}
	
	
	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return getSum()/getNumGrades();
	}

 	public double getAverageMinusLow()
 	{	 	
 		return (getSum() - getLowGrade())/(getNumGrades()-1);
 	}	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();	
	}
	public int compareTo(Student param){
		if(this.getAverage() > param.getAverage())
			return 1;
		else if(this.getAverage() < param.getAverage())
			return -1;
		return 0;
	}
	
	public String toString()
	{
		return getName() + " = " + myGrades;
	}	
}