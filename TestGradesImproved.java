import java.util.Scanner;
import java.text.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter; 


public class TestGradesImproved {
  static void fileCreation(){
    System.out.println("\n\nNow a file will be created, written, and read for you with your grade information.\n");
    try {
      File grade = new File("finalgrade.txt");
      if (grade.createNewFile()) {
        System.out.println("File created: " + grade.getName() + "\n");
      } else {
        System.out.println("File already exists.\n");
      }
    } catch (IOException e) {
      System.out.println("An error has occurred.\n");
      e.printStackTrace();
      }
     try {
      FileWriter myWriter = new FileWriter("finalgrade.txt");
      myWriter.write("\nWriting added to file: You have passed the class! The classes you have yet to take are Art and Wood Shop.");
      myWriter.close();
      System.out.println("\nSuccessfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("\nAn error has occurred.");
      e.printStackTrace();
    }
     try {
      File grade = new File("finalgrade.txt");
      Scanner myReader = new Scanner(grade);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("\nGoodbye!");
  }

  public static void testGradesImproved(String args[])
  {
    
    int grades[] = new int[6];
    int i;
    float total=0, avg;
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> teacher = new ArrayList<String>();
    teacher.add("Mrs. Smith");
    teacher.add("Mr. Oliver");
    teacher.add("Mz. Jacobs");
    teacher.add("Ms. Dokolas");
    teacher.add("Mr. Adams");
    teacher.add("Mx. Vanenkevort");
    teacher.add("Dr. Carol");
    teacher.add("Mrs. Vreeke");

    System.out.println("\n\nWelcome to the final grade determination program!\n\n");

   System.out.println("Enter name:");
   String name = scanner.nextLine();
  
   System.out.println("Enter the title of your class:");
   String classTitle = scanner.nextLine();

   System.out.println("\n\n");

   TeacherName teachername = new TeacherName();
   System.out.println(name + ", your teacher for " + classTitle + " is " + teacher.get(teachername.x));

   System.out.println("\n");

   MoreClasses finishedclasses = new MoreClasses(); 
    finishedclasses.taughtby();
    System.out.println(finishedclasses.taught + " and " + finishedclasses.previousClass);

    System.out.println("The grading scale is as follows:\n" + "A = 90-100" + "\n" + "B = 80-89.9" + "\n" + "C = 70-79.9" + "\n" + "D = 60-69.9" + "\n" + "F = 0-59.9 \n\n" );

    NumberofTests testNumber = new NumberofTests();
    System.out.println("You have taken a total of " + testNumber.x + " tests this semester.");

    System.out.println("Please enter the percent grade you recieved on each test as an integer with no symbols.\n\n");

    for(i=0; i<6; i++){
      System.out.println("Enter Grade of Test " + (i+1) + ":");
      grades[i] = scanner.nextInt();
      total = total + grades[i];
    }
  
    avg = total/6;
    System.out.println("\nYour grade is: ");
    if(avg>=90)
    {
      System.out.println("A");
    }
    else if(avg>=80 && avg<90)
    {
      System.out.println("B");
    }
    else if(avg>=70 && avg<80)
    {
      System.out.println("C");
    }
    else if(avg>=60 && avg<70)
    {
      System.out.println("D");
    }
    else
    {
      System.out.println("F");
    }
    System.out.println("\n");

    TeacherAccess findScores = new TeacherAccess();
    findScores.setClassScores("The Class Average is: 84 (B)");
    System.out.println(findScores.getClassScores());

    System.out.println("\n\nCongratulations on finishing your class! Thank you for using this final grade determination program.\n\n");

    Courses theCourses = new Courses();  
    Courses theArt = new Art(); 
    Courses theWoodShop = new WoodShop();  
    theCourses.classestotake();
    theArt.classestotake();
    theWoodShop.classestotake();

    fileCreation();
 
  }
}

   class Courses 
   {
  public void classestotake() {
    System.out.println("While you have finished this course, you still have a few yet to take.");
    }
    }

class Art extends Courses {
  public void classestotake() {
    System.out.println("You still have to take: Art");
    }
    }

class WoodShop extends Courses {
  public void classestotake() {
    System.out.println("You still have to take: Wood Shop");
    }
    }

class TaughtClasses {
  protected String taught = "Health";       
  public void taughtby() {                    
    System.out.println("The other classes you have taken with Mr. Adams are ");
  }
}

class MoreClasses extends TaughtClasses {
  protected String previousClass = "Food Sciences.\n";   
}
