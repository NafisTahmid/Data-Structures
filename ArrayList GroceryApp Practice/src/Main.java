import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<String> groceries = new ArrayList<>();
        boolean flag = true;
        while(flag) {
            printInstructions();
            switch(Integer.parseInt(scanner.nextLine())) {
                case 1-> addElements(groceries);
                case 2 -> removeElements(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }


    }

    private static void addElements(ArrayList<String> groceries) {
        System.out.println("Please enter items separated by commas: ");
        String[] items = scanner.nextLine().split(",");

        for(String i : items) {
            String trimmed = i.trim();
            if (groceries.indexOf(trimmed) < 0) {
                groceries.add(trimmed);
            }
        }
    }

    private static void removeElements(ArrayList<String> groceries) {
        System.out.println("Please enter items separated by commas: ");
        String[] items = scanner.nextLine().split(",");

        for(String i : items) {
            String trimmed = i.trim();
            groceries.remove(trimmed);

        }
    }

    private static void printInstructions() {

        String textBlock = """
                Available actions:

                0 - to shutdown

                1 - to add item(s) to list (comma delimited list)

                2 - to remove any items (comma delimited list)

                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}