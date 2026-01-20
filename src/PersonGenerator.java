import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PersonGenerator {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean more;
        do {
            String id = SafeInput.getNonZeroLenString(in, "id");
            String first = SafeInput.getNonZeroLenString(in, "first name");
            String last = SafeInput.getNonZeroLenString(in, "last name");
            String title = SafeInput.getNonZeroLenString(in, "title");
            int yob = SafeInput.getInt(in, "year of birth");

            records.add(String.format("%s, %s, %s, %s, %d",
                    id, first, last, title, yob));
            // lmao the YNConfirm has a typo in it, are we supposed to fix this?
            more = SafeInput.getYNConfirm(in, "add another person?");
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
