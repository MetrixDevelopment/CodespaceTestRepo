import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileReading {

    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        readFile(employees);
        displayEmployees(employees);
        writeFile(employees);
    }// end method main

    static void displayEmployees(ArrayList<String> employees) {

        for(String employee: employees)
            System.out.println(employee);
    }// end method displayEmployees

    public static void writeFile(ArrayList<String> employees) {
        Path path = Paths.get("/Users/deanbrown/OneDrive - Forth Valley College/BSc Software development Year 2/Java Tutorial/JavaProgramming/");

                try {
                    BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

                    for(String employee: employees) {
                        bw.write(employee);
                        bw.newLine();
                    }// end for

                    bw.close();
                }
                catch (IOException e) {
                    System.out.println("Error reading file.");
                    System.out.println(0);
                }
    }// end method writeFile

    static void readFile (ArrayList<String> employees) {

        String line = "";
        Path path = Paths.get("/Users/deanbrown/OneDrive - Forth Valley College/BSc Software development Year 2/Java Tutorial/JavaProgramming/emplopyees.txt");

        try{
            BufferedReader fileInput = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
            line = fileInput.readLine();
            while (line != null) {
                employees.add(line);
                line = fileInput.readLine();
            }// end while

            fileInput.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }// end method readFile

}// end class fileReading
