import java.util.*;
import java.util.Scanner;

public class CityRoadNetwork {

    private static Map<String, Set<String>> network = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add City");
            System.out.println("2. Add Road");
            System.out.println("3. Display Road Network");
            System.out.println("4. Find Shortest Route");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCity(scanner);
                    break;
                case 2:
                    addRoad(scanner);
                    break;
                case 3:
                    displayNetwork();
                    break;
                case 4:
                    findShortestRoute(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addCity(Scanner scanner) {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        network.put(city, new HashSet<>());
        System.out.println("City added!");
    }

    private static void addRoad(Scanner scanner) {
        System.out.print("Enter the first city: ");
        String city1 = scanner.nextLine();
        System.out.print("Enter the second city: ");
        String city2 = scanner.nextLine();
        network.get(city1).add(city2);
        network.get(city2).add(city1); // Assuming an undirected graph
        System.out.println("Road added between " + city1 + " and " + city2 + "!");
    }

    private static void displayNetwork() {
        System.out.println("Road Network:");
        for (Map.Entry<String, Set<String>> entry : network.entrySet()) {
            System.out.print(entry.getKey() + " -> [" + String.join(", ", entry.getValue()) + "]");
            System.out.println();
        }
    }

    private static void findShortestRoute(Scanner scanner) {
        System.out.print("Enter the starting city: ");
        String startCity = scanner.nextLine();
        System.out.print("Enter the destination city: ");
        String endCity = scanner.nextLine();

        // This is a placeholder; a proper shortest path algorithm (e.g., BFS) is needed here.
        // For simplicity, it just assumes a direct route exists.
        System.out.println("Shortest route: " + startCity + ", " + endCity);

    }
}