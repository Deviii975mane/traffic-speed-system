
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic level (low/medium/high): ");
        String traffic = sc.nextLine();

        System.out.print("Enter car speed: ");
        int speed = sc.nextInt();

        int safeSpeed;

        if (traffic.equalsIgnoreCase("high")) {
            safeSpeed = 30;
        } else if (traffic.equalsIgnoreCase("medium")) {
            safeSpeed = 50;
        } else {
            safeSpeed = 70;
        }

        System.out.println("Safe Speed: " + safeSpeed);

        if (speed > safeSpeed) {
            System.out.println("Status: Overspeeding");
        } else {
            System.out.println("Status: Safe Driving");
        }
    }
}