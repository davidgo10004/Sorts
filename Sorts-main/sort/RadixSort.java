package sort;


public class RadixSort {
    
    /**
     * Ordena un arreglo de enteros usando Radix Sort.
     * Nota: Este algoritmo funciona específicamente con Integer, no con genéricos.
     *
     * @param array 
     */
    public static void sort(Integer[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        
        int max = getMax(array);
        
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }
    
    /**
     * Encuentra el valor máximo en el arreglo.
     */
    private static int getMax(Integer[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    /**
     * Realiza counting sort basado en el dígito representado por exp.
     * 
     * @param array arreglo a ordenar
     * @param exp exponente que representa la posición del dígito (1, 10, 100, ...)
     */
    private static void countingSortByDigit(Integer[] array, int exp) {
        int n = array.length;
        Integer[] output = new Integer[n]; // Arreglo de salida
        int[] count = new int[10]; // Contador para dígitos 0-9
        
        
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }
        
        
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }
        
       
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
       
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }
        
      
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
    
    /**
     * Sobrecarga para trabajar con Comparable<T> cuando T es Integer.
     * Convierte a Integer[] internamente.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        
        if (!(array[0] instanceof Integer)) {
            throw new IllegalArgumentException(
                "RadixSort solo funciona con arrays de Integer. " +
                "Para otros tipos, use un algoritmo de comparación como MergeSort o QuickSort."
            );
        }
        
       
        Integer[] intArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = (Integer) array[i];
        }
        
        sort(intArray);
        
       
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) intArray[i];
        }
    }
}
