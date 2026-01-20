import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class PersonReader {
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
            return;

        Path file = chooser.getSelectedFile().toPath();

        System.out.printf("%-8s %-12s %-12s %-6s %4s%n",
                "ID#", "Firstname", "Lastname", "Title", "Yob");
        System.out.println("==============================================");

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");
                System.out.printf("%-8s %-12s %-12s %-6s %4s%n",
                        p[0].trim(),
                        p[1].trim(),
                        p[2].trim(),
                        p[3].trim(),
                        p[4].trim());
            }
        }
    }
}