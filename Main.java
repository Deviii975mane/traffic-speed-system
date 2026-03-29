import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SpeedCalculator calc = new SpeedCalculator();

        Queue<TrafficData> vehicleQueue = new LinkedList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        // INPUT PHASE
        for (int i = 1; i <= n; i++) {
            System.out.println("\nVehicle " + i);

            System.out.print("Enter traffic level: ");
            String traffic = sc.nextLine();

            System.out.print("Enter speed: ");
            int speed = sc.nextInt();
            sc.nextLine();

            TrafficData data = new TrafficData(traffic, speed);

            vehicleQueue.add(data); // ADD TO QUEUE
        }

        // PROCESSING PHASE
        System.out.println("\n--- PROCESSING VEHICLES ---");

        while (!vehicleQueue.isEmpty()) {
            TrafficData v = vehicleQueue.poll(); // REMOVE ONE BY ONE

            int safeSpeed = calc.getSafeSpeed(v.trafficLevel);
            String status = calc.checkStatus(v.speed, safeSpeed);

            System.out.println(
                    "Traffic: " + v.trafficLevel +
                            ", Speed: " + v.speed +
                            ", Safe Speed: " + safeSpeed +
                            ", Status: " + status);
        }

        sc.close();
    }
}
