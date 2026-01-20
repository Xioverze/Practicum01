import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader {
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected");
            return;
        }

        Path file = chooser.getSelectedFile().toPath();

        System.out.printf("%-8s %-12s %-25s %8s%n",
                "ID#", "Name", "Description", "Cost");
        System.out.println("======================================================");

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.printf("%-8s %-12s %-25s %8s%n",
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim());
            }
        }
    }
}
