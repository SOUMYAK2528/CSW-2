import java.io.*;
import java.util.*;

public class FileHandling {
    static void SortbyFname() {
        ArrayList<String[]> rows = new ArrayList<String[]>();
        try {
            BufferedReader unsort = new BufferedReader(new FileReader("output.csv"));
            FileWriter sort = new FileWriter("SortedFistName.csv");

            String line = "";
            unsort.readLine();

            while ((line = unsort.readLine()) != null) {
                String[] columns = line.split(",");
                rows.add(columns);
            }

        } catch (IOException e) {
            System.out.println(e);
        }

       

    }

    static void SortbyLname() {

    }

    static void SortbyregdNo() {

    }

    public static void main(String[] args) throws IOException {
        // open the uncleaned file and create a buffered reader object
        BufferedReader uncleaned = new BufferedReader(new FileReader("uncleaned.csv"));

        // create a filewriter object to store the cleaned data
        FileWriter cleaned = new FileWriter("output.csv");

        String rows = "";

        // Readline method is used to read each line of the uncleaned file
        // and return it as a String
        while ((rows = uncleaned.readLine()) != null) {
            // split the line into columns using comma as delimeter
            String[] columns = rows.split(",");

            // create a new array to store the data after necessary removal of columns
            String[] updatedColumns = new String[2];

            for (int i = 0; i < 2; i++) {
                updatedColumns[i] = columns[i];
            }
            // after cleaning write it to cleaned csv
            cleaned.write(String.join(",", updatedColumns) + "\n");

        }

        cleaned.close();
        uncleaned.close();

        Scanner sc = new Scanner(System.in);
        System.out.println("SORT THE CLEANED FILE BY");
        System.out.println("1.FIRST NAME");
        System.out.println("2.LAST NAME ");
        System.out.println("3.REGD NO.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                SortbyFname();
                break;
            case 2:
                SortbyLname();
                break;
            case 3:
                SortbyregdNo();
                break;
        }

    }
}