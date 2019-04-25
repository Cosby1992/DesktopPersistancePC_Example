/**
 * This class is used for writing to and reading from a file on the desktop (not tested on mac).
 *
 * This class demonstrates a simple file output as well as input.
 *
 * @author Cosby
 * @since 25/04 - 2019
 *
 */

package dk.cosby.model;

import java.io.*;

public class FileUtils implements Serializable {


    private String fileSeparator = System.getProperty("file.separator");

    //no-arg constructor
    public FileUtils() {
    }

    /**
     * This method writes a string to a file on the desktop (creates one if needed).
     * @param text
     */
    public void writeToHDD(String text){

        String path = System.getProperty("user.home") + fileSeparator + "Desktop" + fileSeparator + "TheModernTypeWriterFile.txt";

        File file = new File(path);

        try {
            System.out.println("Initailizing BufferedWriter");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            System.out.println("Writing to file");
            writer.write(text);

            System.out.println("Closing writer");
            writer.close();
        } catch (IOException e){
            System.out.println("Mr. Mistaki");
            e.printStackTrace();
        }
    }

    /**
     * This method reads a file from the desktop with filename "TheModernTypeWriterFile.txt"
     * @return the text from the file
     */
    public String readFromHDD(){

        String returnString = "Something went wrong...";

        String file = System.getProperty("user.home") + fileSeparator + "Desktop" + fileSeparator + "TheModernTypeWriterFile.txt";

        try {
            System.out.println("Initailizing BufferedReader");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            System.out.println("Reading from file");


            StringBuilder builder = new StringBuilder();
            returnString = reader.readLine();
            while (returnString != null) {
                builder.append(returnString);
                builder.append("\n");
                returnString = reader.readLine();
            }

            returnString = builder.toString();

            System.out.println("Closing reader");
            reader.close();
        } catch (IOException e){
            System.out.println("Mr. Mistaki");
            e.printStackTrace();
        }

        return returnString;

    }




}
