import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import sort.*;

public class Main {

 private static final String CSV_PATH =
            "C:\\Users\\dfgon\\Downloads\\Sorts-main\\resultados.csv";
    public static void main(String[] args) throws Exception {

        int[] sizes = {10, 50, 100, 200, 500, 1000, 1500, 2000, 2500, 3000};

        String csvPath = "resultados.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath))) {
            bw.write("n,algoritmo,caso,tiempo_ns");
            bw.newLine();

            for (int n : sizes) {

                
                Integer[] numbers = RandomNumber.generateRandomNumbers(n);
                FileManager.writeToFile("numeros.txt", numbers);

               
                Integer[] base = FileManager.readFromFile("numeros.txt");

               
                measureAndWrite(bw, n, "GnomeSort", base);
                measureAndWrite(bw, n, "MergeSort", base);
                measureAndWrite(bw, n, "QuickSort", base);
                measureAndWrite(bw, n, "RadixSort", base);
                measureAndWrite(bw, n, "InsertionSort", base);

                System.out.println("Listo n=" + n);
            }
        }

        System.out.println(" CSV generado: " + csvPath);
    }

    private static void measureAndWrite(BufferedWriter bw, int n, String name, Integer[] base) throws IOException {

        
        Integer[] copy1 = base.clone();
        long t1 = System.nanoTime();
        sortByName(name, copy1);
        long t2 = System.nanoTime();
        bw.write(n + "," + name + ",desordenado," + (t2 - t1));
        bw.newLine();

        
        Integer[] ordered = base.clone();
        Arrays.sort(ordered);

        long t3 = System.nanoTime();
        sortByName(name, ordered);
        long t4 = System.nanoTime();
        bw.write(n + "," + name + ",ordenado," + (t4 - t3));
        bw.newLine();
    }

    private static void sortByName(String name, Integer[] arr) {
        switch (name) {
            case "GnomeSort" -> GnomeSort.sort(arr);
            case "MergeSort" -> MergeSort.sort(arr);
            case "QuickSort" -> QuickSort.sort(arr);
            case "RadixSort" -> RadixSort.sort(arr);
            case "InsertionSort" -> InsertionSort.sort(arr);
            default -> throw new IllegalArgumentException("Sort no reconocido: " + name);
        }
    }
}
