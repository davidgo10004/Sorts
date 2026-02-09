import java.io.*;
import java.util.*;

public class FileManager {

    public static void writeToFile(String filePath, Integer[] numbers) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Integer n : numbers) {
                bw.write(n.toString());
                bw.newLine();
            }
        }
    }

    public static Integer[] readFromFile(String filePath) throws IOException {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) list.add(Integer.parseInt(line));
            }
        }

        return list.toArray(new Integer[0]);
    }
}
