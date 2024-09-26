package utils;

public class Timer {
    private long startTime;
    private long endTime;

    // Método para iniciar o timer usando nanoTime para maior precisão
    public void start() {
        startTime = System.nanoTime();
    }

    // Método para parar o timer usando nanoTime
    public void stop() {
        endTime = System.nanoTime();
    }

    // Método para obter o tempo de execução em nanosegundos
    public long getElapsedTimeInNano() {
        return endTime - startTime;
    }

    // Método para obter o tempo de execução em milissegundos (conversão)
    public long getElapsedTimeInMillis() {
        return (endTime - startTime) / 1_000_000;
    }

    // Método para obter o tempo de execução em segundos (conversão)
    public double getElapsedTimeInSeconds() {
        return (endTime - startTime) / 1_000_000_000.0;
    }
}
