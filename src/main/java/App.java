import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Desktop\\TRABAJOS UTPL\\Programacion\\VirtualThreadsJava\\src\\main\\urls_parcial1.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String url = scanner.nextLine();
            Runnable task = new UrlProcessor(url);
            Thread.ofVirtual().start(task);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Proceso completado.");
    }
}
