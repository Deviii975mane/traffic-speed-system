
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SpeedCalculator calc = new SpeedCalculator();

        int n;
        System.out.print("Enter number of vehicles: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nVehicle " + i);

            System.out.print("Enter traffic level: ");
            String traffic = sc.nextLine();

            System.out.print("Enter speed: ");
            int speed = sc.nextInt();
            sc.nextLine();

            TrafficData data = new TrafficData(traffic, speed);

            int safeSpeed = calc.getSafeSpeed(data.trafficLevel);
            String status = calc.checkStatus(data.speed, safeSpeed);

            System.out.println("Safe Speed: " + safeSpeed);
            System.out.println("Status: " + status);
        }

        sc.close();
    }
}