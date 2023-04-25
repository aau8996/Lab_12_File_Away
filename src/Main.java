import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Initializing counts to zero
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        Scanner input = null;


        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showSaveDialog(null); // Makes dialog appear
        String path = jfc.getSelectedFile().getAbsolutePath(); // Gets path of selected file
        String fileName = jfc.getSelectedFile().getName(); // Gets name of selected file
        File inputFile = new File(path);

        if (inputFile.exists()){ // Makes sure that the file exists before continuing
            try{
                input = new Scanner(inputFile);
                // Defining buffered reader to define the chosen file
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.equalsIgnoreCase("")) {
                        // Only count non-white space characters
                        String replaceAll = line.replaceAll("\\s+", "");
                        charCount += replaceAll.length();
                        wordCount += line.split(" ").length; // Splits words at white space
                    }
                    lineCount++; // Increment line count before looping
                }
                input.close();
            }catch(Exception ex){
                System.out.println("Error. File may not be found.");
            }
            // Outputting file summary
            System.out.println("File Name: " + fileName);
            System.out.println("Line Count: " + lineCount);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Character count: " + charCount);
        }
    }
}