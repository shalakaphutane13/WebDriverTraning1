package Assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CollectionTest {
static WebDriver driver;
	public static void main(String[] args) {
		System.out.println("Below is ArrayList Example");
	System.out.println("                                  ");

	ArrayList al=new ArrayList();
	al.add("Shalaka");
	al.add("Rahul");
	al.add("riya");
	al.add("Rai");
	al.add("Shalaka");
	al.add("Rahul");
	al.add("Shalaka");
	al.add("Rahul");

	Iterator itr=al.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
System.out.println("                                  ");
System.out.println("Below is HashSet Example");

		HashSet hs=new HashSet(); // creating hashSet
		 hs.add("Rachit");                 // adding elements
		 hs.add("Amit");
		 hs.add("jack");
		 hs.add("jack");
		 hs.add("jack");
		 hs.add("jack");
		 Iterator hsitr=hs.iterator();
		 while(hsitr.hasNext()){
		 System.out.println(hsitr.next());
		 }
		 
HashMap<String, Integer> map1 =new HashMap();
map1.put("Shalaka", 10);
map1.put("Pooja", 11);
map1.put("Pallavi", 15);
map1.put("Anu", 12);
map1.put("Rajashree", 9);
map1.put("Dhanashree", 2);
map1.put("Trasha", 1);	
map1.remove("Anu", 12);

System.out.println(map1);
	
	System.out.println("Size of map is  " + map1.size()+"and key of Trasha is "+map1.get("Trasha"));
	System.out.println("Value of key 1 is " + map1.replace("Trasha", 1));
	
	System.out.println("New map is below");
	System.out.println(map1);
	
	
	
	
	}

	}
	
	

