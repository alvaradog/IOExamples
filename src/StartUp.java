
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StartUp {
    
    public static void main(String[] args) throws IOException {
        File data = new File("src" + File.separatorChar
                + "contactList.txt");
        
        List<String> lines = new ArrayList();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            lines.add(line);
            System.out.println("First eteration readin every line from file");
            while (line != null) {
                System.out.println(line);
                line = in.readLine();// strips out any carriage return chars
                lines.add(line);
            }
            
        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                
            }
        }
        
        System.out.println("\nWriting into file: " + data.getAbsolutePath());
        boolean append = true;   // you can change this

        // This is where we setup our streams (append = false means overwrite)
        // new FileWriter() creates the file if doesn't exit
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(data, append)));
        out.print("");
        out.println("Samantha Gregory");
        out.println("8445 East Loomis Road");
        out.println("Milwaukee, WI 55511");
        out.close();
        
        System.out.println("Second Contact: extracting name and State");
        String [] cityStateZipLine = lines.get(5).split(" ");
        System.out.println(lines.get(3) + " State: " + cityStateZipLine[1].toString());
    }
    
}
