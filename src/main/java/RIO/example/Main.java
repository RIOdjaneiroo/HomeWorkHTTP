package RIO.example;

import RIO.example.client.HttpImageStatusCli;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello and welcome!");
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();




    }
}