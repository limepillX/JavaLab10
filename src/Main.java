import java.util.ArrayList;

// Task 4, 6
public class Main {
    public static void task4() {
        ArrayList<String> file_input = DataManagement.readDataFromFile("src/input.txt");
        ArrayList<String> filtered_input = new ArrayList<String>();

        for (String line : file_input) {
            if (line.getBytes()[line.getBytes().length - 1] == '5') {
                filtered_input.add(line);
            }
        }
        DataManagement.writeDataToFile("src/output.txt", filtered_input);
    }

    public static void task5() {
        ArrayList<String> input = DataManagement.readData();
        System.out.println("User input:");
        for (String line : input) {
            System.out.println(line);
        }

        ArrayList<String> file_input = DataManagement.readDataFromFile("src/input.txt");
        file_input.addAll(input);

        System.out.println("Writing user input to file");
        DataManagement.writeDataToFile("src/input.txt", file_input);
    }

    public static void task6() {
        String number = DataManagement.getOneLine("Enter the number: ");

        System.out.println("Downloading file...");
        ArrayList<String> http = DataManagement.readDataFromFile("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        System.out.println("File downloaded!");

        ArrayList<String> printed = new ArrayList<String>();
        System.out.println("Found lines:");
        for (String line : http) {
            String[] parts = line.split("\t");
            if (parts[0].startsWith(number) && !printed.contains(parts[0])) {
                System.out.println(parts[1]);
                printed.add(parts[0]);
            }
        }
    }

    public static void main(String[] args) {
        task6();
    }
}
