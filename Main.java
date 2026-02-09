
public class Main {
    public static void main(String[] args){
        
        Integer[] numbers = RandomNumber.generateRandomNumbers(10);
        
        String filePath = "numeros.txt";
        FileManager.writeToFile(filePath, numbers);

        System.out.println("Números aleatorios generados:");
        for(Integer num : numbers){
            System.out.println(num);
        }

        System.out.println("Los números aleatorios han sido escritos en el archivo: " + filePath);

    }
}
