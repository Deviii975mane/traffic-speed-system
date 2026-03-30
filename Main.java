
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        SpeedCalculator calc = new SpeedCalculator();
        TrafficAPIService api = new TrafficAPIService();

        Queue<TrafficData> vehicleQueue = new LinkedList<>();

        System.out.println("Fetching data from API...\n");

        // CALL API
        String apiData = api.getTrafficData();

        System.out.println("API Response: " + apiData);

        // CONVERT API DATA → TRAFFIC LEVEL (DUMMY LOGIC)
        String traffic;

        if (apiData != null && apiData.contains("age")) {
            traffic = "medium";
        } else {
            traffic = "low";
        }

        // TEMP SPEED (until real data comes)
        int speed = 60;

        // CREATE OBJECT
        TrafficData data = new TrafficData(traffic, speed);

        // ADD TO QUEUE
        vehicleQueue.add(data);

        // PROCESS QUEUE
        System.out.println("\n--- PROCESSING VEHICLE ---");

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
    }
}