package RIO.example.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static RIO.example.Utils.*;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {

        String stringUrl = START_URL + code + EXTENSION;
        HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode != 200) {
            throw new FileNotFoundException(String.format(STATUS_COD_NOT_EXIST_TEXT, code+ "  Error - " + responseCode));
        } else {
            return stringUrl;
        }

//        String stringUrl = START_URL + code + EXTENSION;
//        int responseCode = 0;
//        try {
//            HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
//            responseCode = connection.getResponseCode();
//        } catch (IOException e) {
//            throw new RuntimeException(String.format(STATUS_COD_NOT_EXIST_TEXT, code + "  Error - " + responseCode));
//        }

        //System.out.println("responseCode = " + responseCode);


//            if (responseCode!=200){
//                throw new Exception(String.format(STATUS_COD_NOT_EXIST_TEXT, code + "  Error - " +responseCode));
//            }
//            } catch (Exception e){
//                e.printStackTrace();
//                return STATUS_ERROR_CONNECTION;
//            }

//            if (responseCode == 404) {
//                throw new Exception(STATUS_COD_NOT_EXIST_TEXT + code);
//            }
//        return stringUrl;

//        HttpURLConnection connection = null;
//        try {
//            String stringUrl = START_URL + code + EXTENSION;
//            connection = (HttpURLConnection) new URL(stringUrl).openConnection();
//            int responseCode = connection.getResponseCode();
//            if (responseCode == 200) {
//                return stringUrl;
//
//
//            } else if (responseCode == 404) {
//                return null;
//            } else {
//                throw new FileNotFoundException(String.format(STATUS_COD_NOT_EXIST_TEXT, code + "  Error - " +responseCode));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (connection != null) {
//                connection.disconnect();
//            }
//        }
//    public static String getStatusImage(int code) throws IOException {
//        String url = "https://http.cat/" + code + ".jpg";
//        HttpURLConnection connection = null;
//            connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestMethod("GET");
//            int responseCode = connection.getResponseCode();
//            if (responseCode != 200) {
//                return "Error connection: ";
//            }
//        return url;
    }
    public static void main(String[] args) throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        try {
            String asd = httpStatusChecker.getStatusImage(2000);
            System.out.println(asd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
