import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, String description, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%s) -> %d", name, description, distance);
    }


}

public class Main {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
        Place dhaka = new Place("Dhaka", "Capital city", 243);
        addPlace(placesToVisit,dhaka);
        addPlace(placesToVisit, new Place("Bogura", "Cultural capital", 113));
        addPlace(placesToVisit, new Place("Shylet", "Sufi city", 448));
        addPlace(placesToVisit, new Place("Cox's Bazar", "Top beach destination", 644));
        addPlace(placesToVisit, new Place("Chittagong", "Most romantic destination", 494));
        addPlace(placesToVisit, new Place("St. Martin Island", "Best island", 565));
        addPlace(placesToVisit, new Place("Sonargoan", "Historical capital", 282));
        addPlace(placesToVisit, new Place("Lawachara national park", "Top family destination", 397));
        addPlace(placesToVisit, new Place("Jaflong", "Top instagrammable destination", 508));
        addPlace(placesToVisit, new Place("Paharpur", "Top solo travel destination", 103));
        addPlace(placesToVisit, new Place("Comilla", "Most beautiful town", 351));
        addPlace(placesToVisit, new Place("Barisal", "Top place to explore locals", 424));
        addPlace(placesToVisit, new Place("Sundarbans", "most popular destination", 251));
        placesToVisit.addFirst(new Place("Rajshahi", "Top backpacking destination", 0));

        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = placesToVisit.listIterator();
        boolean quitLoop = false;
        boolean forward = true;
        printMenu();

        while (!quitLoop) {

            if (!iterator.hasPrevious()) {
                System.out.println("Originating at: " + iterator.next());
                forward = true;
            }

            if (!iterator.hasNext()) {
                System.out.println("Final: " + iterator.previous());
                forward = false;

            }
            System.out.println("Please enter a value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);
            switch(menuItem) {

                case "F":
                    System.out.println("Traveller wants to go forward");
                    if (!forward) {
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                        
                    }
                    break;

                case "B":
                    System.out.println("Traveller wants to go backward");
                    if (forward) {
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());


                    }
                    break;

                case "L":
                    System.out.println(placesToVisit);
                    break;

                case "M":
                    printMenu();
                    break;


                default:
                    quitLoop = true;
                    break;
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place) {

        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }

        for (Place p : list) {
            if (place.name().equalsIgnoreCase(p.name())) {
                System.out.println("Found duplicate: " + place);
                return;
            }

        }

        int matchedIndex = 0;
        for (Place p: list) {
            if (place.distance() < p.distance()) {
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }

        list.add(place);
    }

    private static void printMenu() {
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }



}

