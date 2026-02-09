public class Main {
    public static void main(String[] args){
        Integer[] numbers = RandomNumber.generateRandomNumbers(10);
        System.out.println("Números aleatorios generados:");
        for(Integer num : numbers){
            System.out.println(num);
        }
    }
}
