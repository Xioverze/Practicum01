import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProductWriter {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean more;
        do {
            String id = SafeInput.getNonZeroLenString(in, "id");
            String name = SafeInput.getNonZeroLenString(in, "name");
            String desc = SafeInput.getNonZeroLenString(in, "description");
            double cost = SafeInput.getDouble(in, "cost");

            records.add(String.format("%s, %s, %s, %.1f",
                    id, name, desc, cost));

            more = SafeInput.getYNConfirm(in, "add another product");
        } while (more);

        String fileName = SafeInput.getNonZeroLenString(in, "output file name");
        Path file = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String r : records) {
                writer.write(r);
                writer.newLine();
            }
        }

        System.out.println("\nfile saved.");
    }
}
