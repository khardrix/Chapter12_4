/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                        Chapter 12: Problem 4                                             *****
 *****__________________________________________________________________________________________________________*****
 *****                   4.  Write a program to input a text file one String at a time,                         *****
 *****         storing each String in an array and then output the Strings backward to a second text file.      *****
 *****                           Assume the file stores no more than 1000 Strings.                              *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.io.*;
import java.util.Scanner;

public class Chapter12_4 {

    public static void main(String[] args) {

        // Local Variables
        String[] words = new String[1_000];
        String fileName = "NetworkingProject.txt";
        String newFileName = "BackwardsText.txt";
        PrintWriter writer = null;
        Scanner reader = null;

        try{
            writer = new PrintWriter(newFileName);
            reader = new Scanner(new File(fileName));

            for(int i = 0; i < 1_000; i++) {
                if (reader.hasNext()) {
                    words[i] = reader.useDelimiter(" ").next();
                }
            }

            for(int j = 0; j < 1_000; j++){
                writer.println(words[words.length-(j+1)]);
            }
        }
        catch(Exception e){
            System.out.println(e + "\n");
            e.printStackTrace();
        }
        finally {
            if(writer != null) {
                writer.flush();
                writer.close();
            }

            if(reader != null) {
                reader.close();
            }
        }
    }
}
