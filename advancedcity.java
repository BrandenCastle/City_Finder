package City_Finder;
// EEGR 415

//import libraries
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
public class advancedcity {
// declare global variables
public static int[] pop = new int[1000];
public static int selection;
public static String[] city = new String[1000], state = new String[1000];

public static void main(String args[]) throws IOException {
// creates the arrays for populations, cities, and states
readfile("City_Finder/population.txt", pop);
readfilestring("City_Finder/cities.txt", city);
readfilestring("City_Finder/states.txt", state);
// opens the menu
menu();
}
// function for taking in file data for numbers
public static void readfile(String file, int[] data) throws
FileNotFoundException {
int i = 0;
try {// reads chosen file
File doc = new File(file);
Scanner str = new Scanner(doc);
while (str.hasNextLine()) {
data[i] = str.nextInt();
i++;
}
str.close();// closes file
} catch (FileNotFoundException e) {// happens when file location cannot be found
System.out.println("File not found");
e.printStackTrace();
}
}
// function for taking in file data for strings
public static void readfilestring(String file, String[] data) throws
FileNotFoundException {
int i = 0;
try {// reads chosen file
File doc = new File(file);
Scanner str = new Scanner(doc);
while (str.hasNextLine()) {
data[i] = str.nextLine();
i++;
}
str.close();// closes file
} catch (FileNotFoundException e) {// happens when file location cannot be found
System.out.println("File not found");
e.printStackTrace();
}
}
// main menu function
public static void menu() {
Scanner sc = new Scanner(System.in);
System.out.println("U.S. Cities Analytics");
System.out.println("------------------------ ");
System.out.println("1) Search by City");
System.out.println("2) Search by state");
System.out.println("3) Search by population");
System.out.println("4) Exit\n");
// prompts the user to enter a selection. if invalid, then asks again until
// valid
do {
System.out.print("Enter selection: ");
selection = sc.nextInt();
switch (selection) {
case 1:
searchbycity();
case 2:
searchbystate();
case 3:
searchbypop();
case 4:
System.out.println("goodbye");
System.exit(0);
default:
System.out.println("invalid selection");
}
} while (selection != 1 && selection != 2 && selection != 3 && selection !=
4);
sc.close();
}
// finds cities by direct name
public static void searchbycity() {
Scanner sc = new Scanner(System.in);
String name;
System.out.print("Enter the name of the city: ");
name = sc.nextLine();
for (int i = 0; i < 1000; i++) {
if (city[i].equalsIgnoreCase(name))
System.out.println(city[i] + ", " + state[i] + " " + "Population ("
+ pop[i] + ")\n");
}
menu();
sc.close();
}
// finds cities by state name
public static void searchbystate() {
Scanner sc = new Scanner(System.in);
String name;
System.out.print("Enter the name of the state: ");
name = sc.nextLine();
for (int i = 0; i < 1000; i++) {
if (state[i].equalsIgnoreCase(name))
System.out.println(city[i] + ", " + state[i] + " " + "Population ("
+ pop[i] + ")\n");
}
menu();
sc.close();
}
//// finds the cities by population
public static void searchbypop() {
Scanner sc = new Scanner(System.in);
int popmin, popmax;
System.out.print("Enter min and max range for population: ");
popmin = sc.nextInt();
popmax = sc.nextInt();
for (int i = 0; i < 1000; i++) {
if (pop[i] >= popmin && pop[i] <= popmax)
System.out.println(city[i] + ", " + state[i] + " " + "(Population "
+ pop[i] + ")\n");
}
menu();
sc.close();
}
}
