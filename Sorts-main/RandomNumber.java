import java.util.Random;

public class RandomNumber{
    private static final int MIN = 0;
    private static final int MAX = 3000;

    public static Integer[] generateRandomNumbers(int size){
        Integer[] numbers = new Integer[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            numbers[i] = random.nextInt((MAX - MIN) + 1) + MIN;
        }

        return numbers;
    }
}