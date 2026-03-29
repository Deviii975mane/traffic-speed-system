
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SpeedCalculator calc = new SpeedCalculator();
        Queue<TrafficData> vehicleQueue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] trafficLevels = { "low", "medium", "high" };

        System.out.print("Enter number of vehicles to simulate: ");
        int n = sc.nextInt();

        System.out.println("\nGenerating vehicle data automatically...\n");

        // GENERATE DATA
        for (int i = 1; i <= n; i++) {

            String traffic = trafficLevels[rand.nextInt(3)];
            int speed = rand.nextInt(100);

            TrafficData data = new TrafficData(traffic, speed);

            System.out.println(
                    "Vehicle " + i +
                            " → Traffic: " + traffic +
                            ", Speed: " + speed);

            vehicleQueue.add(data);
        }

        // PROCESS QUEUE
        System.out.println("\n--- PROCESSING VEHICLES ---");

        while (!vehicleQueue.isEmpty()) {
            TrafficData v = vehicleQueue.poll();

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