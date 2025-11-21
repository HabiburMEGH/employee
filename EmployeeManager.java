//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

        // Task2 fix: check argument count
        if (args.length != 1) {
            System.out.println("Error: Incorrect number of arguments.");
            return; // terminate early
        }

        try {
            if (args[0].equals("l")) {
                System.out.println("Loading data ...");
                for (String emp : readEmployeesFromFile()) {  // temp variable removed
                    System.out.println(emp);
                }
                System.out.println("Data Loaded.");

            } else if (args[0].equals("s")) {
                System.out.println("Loading data ...");
                String[] employeeArray = readEmployeesFromFile();
                Random rand = new Random();
                System.out.println(employeeArray[rand.nextInt(employeeArray.length)]);  // temp variable removed
                System.out.println("Data Loaded.");

            } else if (args[0].contains("+")) {
                System.out.println("Loading data ...");
                List<String> employeeList = new ArrayList<>(Arrays.asList(readEmployeesFromFile()));
                employeeList.add(args[0].substring(1));  // temp variable removed
                writeEmployeesToFile(employeeList);
                System.out.println("Data Loaded.");

            } else if (args[0].contains("?")) {
                System.out.println("Loading data ...");
                String searchName = args[0].substring(1);
                boolean found = false;
                for (String emp : readEmployeesFromFile()) {  // temp variable removed
                    if (emp.equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }
                System.out.println("Data Loaded.");

            } else if (args[0].contains("c")) {
                System.out.println("Loading data ...");
                char[] characterArray = String.join(",", readEmployeesFromFile()).toCharArray();  // temp variable removed
                boolean inWord = false;
                int spaceCount = 0;
                for (char c : characterArray) {
                    if (c == ' ') {
                        if (!inWord) {
                            spaceCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(spaceCount + " word(s) found " + characterArray.length);
                System.out.println("Data Loaded.");

            } else if (args[0].contains("u")) {
                System.out.println("Loading data ...");
                String targetEmployee = args[0].substring(1);
                String[] employeeArray = readEmployeesFromFile();
                for (int i = 0; i < employeeArray.length; i++) {
                    if (employeeArray[i].equals(targetEmployee)) {
                        employeeArray[i] = "Updated";
                    }
                }
                writeEmployeesToFile(new ArrayList<>(Arrays.asList(employeeArray)));
                System.out.println("Data Updated.");

            } else if (args[0].contains("d")) {
                System.out.println("Loading data ...");
                String[] employeeArray = readEmployeesFromFile();
                List<String> employeeList = new ArrayList<>(Arrays.asList(employeeArray));
                employeeList.remove(args[0].substring(1));  // temp variable removed
                writeEmployeesToFile(employeeList);
                System.out.println("Data Deleted.");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

    }

    // ----------------------
    // Methods for reading and writing file
    // ----------------------

    private static String[] readEmployeesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
        String lineData = reader.readLine();
        reader.close();
        return lineData.split(",");
    }

    private static void writeEmployeesToFile(List<String> employees) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
        writer.write(String.join(",", employees));
        writer.close();
    }

}
