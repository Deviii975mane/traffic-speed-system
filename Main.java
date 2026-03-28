
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SpeedCalculator calc = new SpeedCalculator();

        ArrayList<TrafficData> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nVehicle " + i);

            System.out.print("Enter traffic level: ");
            String traffic = sc.nextLine();

            System.out.print("Enter speed: ");
            int speed = sc.nextInt();
            sc.nextLine();

            TrafficData data = new TrafficData(traffic, speed);
            vehicles.add(data);

            int safeSpeed = calc.getSafeSpeed(data.trafficLevel);
            String status = calc.checkStatus(data.speed, safeSpeed);

            System.out.println("Safe Speed: " + safeSpeed);
            System.out.println("Status: " + status);
        }

        System.out.println("\n--- SUMMARY ---");

        for (TrafficData v : vehicles) {
            int safeSpeed = calc.getSafeSpeed(v.trafficLevel);
            String status = calc.checkStatus(v.speed, safeSpeed);

            System.out.println(
                    "Traffic: " + v.trafficLevel +
                            ", Speed: " + v.speed +
                            ", Status: " + status);
        }

        sc.close();
    }
}