import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(String filePath, Integer[] numbers){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Integer number : numbers){
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
