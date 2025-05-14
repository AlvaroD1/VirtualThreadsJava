import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlUtils {
    public static int countInternalLinks(String url) {
    int count = 0;
    try {
        // Realiza la petición HTTP GET a la URL
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Lee el contenido de la página
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        // Busca las URLs internas (que contienen la URL base)
        String pageContent = content.toString();
        String[] links = pageContent.split("href=\"");

        // Contamos cuántos enlaces internos contienen la URL base
        for (String link : links) {
            if (link.contains(url)) {
                count++;
            }
        }

        in.close();
    } catch (IOException e) {
        System.err.println("Error al procesar la URL " + url + ": " + e.getMessage());
    }

    return count;
}
}
