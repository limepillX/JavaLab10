import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManagement {

    public static String getOneLine(String text){
        System.out.println(text);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static ArrayList<String> readData() {
        ArrayList<String> data = new ArrayList<String>();

        System.out.println("Please, enter the data or type 'stop' to finish");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        data.add(input);

        while (true) {
            input = in.nextLine();
            if (input.equals("stop")) {
                break;
            }
            data.add(input);
        }

        return data;

    }

    public static ArrayList<String> readDataFromFile(String filePath) {
        ArrayList<String> data = new ArrayList<String>();

        boolean is_url = filePath.startsWith("http:") || filePath.startsWith("https:");
        if (is_url){
            //read from web
            try {
                java.net.URL url = new java.net.URL(filePath);
                Scanner urlReader = new Scanner(url.openStream());
                while (urlReader.hasNextLine()) {
                    String line = urlReader.nextLine();
                    data.add(line);
                }
                urlReader.close();
                return data;

            } catch (java.io.IOException e) {
                System.out.println("An error occurred.");
                return data;
            }
        }

        // Check if file exists
        File file = new File(filePath);
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                data.add(line);
            }
            fileReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return data;
        }
    }

    public static void writeDataToFile(String filePath, ArrayList<String> data) {
        File file = new File(filePath);
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            for (String line : data) {
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (java.io.IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
