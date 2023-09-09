import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int numberOfRuns = 10; // Количество запусков

        for (int i = 0; i < numberOfRuns; i++) {
            long delayInMillis = i * 1000; // Интервал в 1 секунду
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        // Запускаем блокнот
                        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                        pb.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, delayInMillis);
        }
    }
}