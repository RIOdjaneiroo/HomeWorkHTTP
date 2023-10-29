package RIO.example.client;
import RIO.example.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            throw new IOException(String.format(Utils.STATUS_COD_NOT_EXIST_TEXT, code));
        }

        try (InputStream in = connection.getInputStream()) {
            Path outputPath = Path.of(Utils.DIRECTORY_FOR_SAVE + "status_image_" + code + Utils.EXTENSION);
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
    public static void main(String[] args) {
        try {
            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(205);
            System.out.println("Image downloaded successfully.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


