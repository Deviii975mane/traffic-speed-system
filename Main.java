
import java.util.Queue;
import java.util.LinkedList;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {

        SpeedCalculator calc = new SpeedCalculator();
        TrafficAPIService api = new TrafficAPIService();

        Queue<TrafficData> vehicleQueue = new LinkedList<>();

        System.out.println("Fetching data from API...\n");

        String apiData = api.getTrafficData();
        System.out.println("API Response: " + apiData);

        // JSON PARSING
        JsonObject obj = JsonParser.parseString(apiData).getAsJsonObject();
        int age = obj.get("age").getAsInt();

        // LOGIC
        String traffic;

        if (age > 50) {
            traffic = "high";
        } else if (age > 30) {
            traffic = "medium";
        } else {
            traffic = "low";
        }

        int speed = 60;

        TrafficData data = new TrafficData(traffic, speed);
        vehicleQueue.add(data);

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