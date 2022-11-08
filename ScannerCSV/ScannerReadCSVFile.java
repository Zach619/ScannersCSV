import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Average each row of ten test scores
 */
public class ScannerReadCSVFile
{
    public void run() throws FileNotFoundException {
        // Mr. Jaffe's code to read data from a file
        // Instantiate a File object
        File dataFile = new File("TestScoresByClass.csv");

        // Instantiate a Scanner object that uses the file
        Scanner scanner = new Scanner(dataFile);

        // Set the delimiter as a new-line character so we can read the
        // data one line at a time
        scanner.useDelimiter("\n");
        int lines = 1;
        while (scanner.hasNext()) {
            // Read the next line of the file
            String line = scanner.nextLine();
            Scanner scanner1 = new Scanner(line);
            scanner1.useDelimiter(","); 
            int sumNum = 0;
            String classNumber = scanner1.next();
            if (lines == 1) {
                System.out.println("Class Avg. Scores");
            }else{
                while (scanner1.hasNext()){
                    //returns true if there is another token 

                    int number = scanner1.nextInt();
                    if (number <= 999) { // adds all up if condition is met
                        sumNum += number; // adds test scores
                    }else{
                        classNumber = scanner1.next(); //returns next token
                    }
                }
                System.out.println(classNumber + ":" + (sumNum/10));
            }
            lines++; // continues line and does not stop :d:9:0
        }
    }

    public static void main (String[] args) {
        try {
            ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("There's an error someplace. Try using the debugger to find it!");

        }
    }
}
