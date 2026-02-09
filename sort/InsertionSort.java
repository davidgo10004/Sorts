package sort;

public class InsertionSort{
    public static <T extends Comparable<T>> void sort(T[] array){
        
        for(int i = 1; i < array.length; i++){
            T key = array[i];
            int j = i - 1;
            
            //mueve numeros mayores que key a una posicion a la izquierda
            while(j >= 0 && array[j].compareTo(key) > 0){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}