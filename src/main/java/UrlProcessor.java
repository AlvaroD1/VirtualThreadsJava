import java.io.*;

public class UrlProcessor implements Runnable{
    private final String url;

    public UrlProcessor(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            int count = UrlUtils.countInternalLinks(url);

            synchronized (UrlProcessor.class) {
                try (java.io.FileWriter writer = new java.io.FileWriter("D:\\Desktop\\TRABAJOS UTPL\\Programacion\\VirtualThreadsJava\\src\\main\\urls_internas.csv", true)) {
                    writer.write(url + " -> " + count + " enlaces internos\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error procesando " + url + ": " + e.getMessage());
        }
    }
}

