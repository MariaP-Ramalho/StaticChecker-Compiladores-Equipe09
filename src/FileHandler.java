package src;

import java.io.*;

public class FileHandler {
    public static void readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int lineNumber = 1;

        while ((line = reader.readLine()) != null) {
            System.out.printf("%4d: %s%n", lineNumber++, line);
        }

        reader.close();
    }
}
