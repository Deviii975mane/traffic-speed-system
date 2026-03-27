
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic level: ");
        String traffic = sc.nextLine();

        System.out.print("Enter speed: ");
        int speed = sc.nextInt();

        TrafficData data = new TrafficData(traffic, speed);

        SpeedCalculator calc = new SpeedCalculator();

        int safeSpeed = calc.getSafeSpeed(data.trafficLevel);
        String status = calc.checkStatus(data.speed, safeSpeed);

        System.out.println("Safe Speed: " + safeSpeed);
        System.out.println("Status: " + status);
    }
}