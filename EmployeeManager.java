//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        //task2 fix: check argument count
if (args.length != 1) {
    System.out.println("Error: Incorrect number of arguments.");
    return; // terminate early
}

// Check arguments
      if (args[0].equals("l")) {
          System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
// l=lineData for better understanding
  String lineData = r.readLine();
  //e=employeeArray for better understanding
  String employeeArray[] = lineData.split(",");
for (String emp : employeeArray) {
System.out.println(emp);
}
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].equals("s")) {
System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
//change variable name l==lineData
String lineData = r.readLine();
System.out.println(lineData);
//e==employeeArray for better transperancy
String employeeArray[] = lineData.split(",");
Random rand = new Random();
int idx = rand.nextInt(employeeArray.length);
System.out.println(employeeArray[idx]);
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} 
   else if (args[0].contains("+")) 
    {
System.out.println("Loading data ...");
try 
{
BufferedWriter w = new BufferedWriter(new FileWriter("employees.txt", true));
//n== newemployee
String newemployee = args[0].substring(1);
w.write(", " + newemployee);
w.close();
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("?")) {
System.out.println("Loading data ...");
try 
{
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
//change variable name 
String lineData = r.readLine();
String employeeArray[] = lineData.split(",");
boolean found = false;
String s = args[0].substring(1);
for (int i = 0; i < employeeArray.length && !found; i++) {
if (employeeArray[i].equals(s)) {
System.out.println("Employee found!");
found = true;
}
}
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("c")) {
System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
//change variable
String lineData = r.readLine();
char[] chars = lineData.toCharArray();
boolean inWord = false;
int count = 0;
for (char c : chars) {
if (c == ' ') {
if (!inWord) {
count++;
inWord = true;
} 
  else {
inWord = false;
}
}
}
System.out.println(count + " word(s) found " + chars.length);
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("u")) {
System.out.println("Loading data ...");
try 
{
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
//change the variable name
String lineData = r.readLine();
String employeeArray[] = lineData.split(",");
String newemployee = args[0].substring(1);
for (int i = 0; i < employeeArray.length; i++) {
if (employeeArray[i].equals(newemployee)) {
employeeArray[i] = "Updated";
}
}
BufferedWriter w = new BufferedWriter(
new FileWriter("employees.txt"));
w.write(String.join(",", employeeArray));
w.close();
} 
catch (Exception e) {}
System.out.println("Data Updated.");
} else if (args[0].contains("d")) {
System.out.println("Loading data ...");
try 
{
BufferedReader r = new BufferedReader(
new InputStreamReader(
new FileInputStream("employees.txt")));
String lineData = r.readLine();
String employeeArray[] = lineData.split(",");
String n = args[0].substring(1);
List<String> employeeList = new ArrayList<>(Arrays.asList(employeeArray));
employeeList.remove(n);
BufferedWriter w = new BufferedWriter(new FileWriter("employees.txt"));
w.write(String.join(",", employeeList));

w.close();
} 
catch (Exception e) {}
System.out.println("Data Deleted.");
}
}
}
