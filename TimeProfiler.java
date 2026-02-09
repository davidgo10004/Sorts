public class TimeProfiler {
    //tiempo de ejecucion de un algoritmo

    public static long measure(Runnable task){
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }
}
