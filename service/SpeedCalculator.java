
import java.util.HashMap;

public class SpeedCalculator {

    HashMap<String, Integer> speedMap;

    public SpeedCalculator() {
        speedMap = new HashMap<>();
        speedMap.put("high", 30);
        speedMap.put("medium", 50);
        speedMap.put("low", 70);
    }

    public int getSafeSpeed(String traffic) {
        return speedMap.getOrDefault(traffic.toLowerCase(), 60);
    }

    public String checkStatus(int speed, int safeSpeed) {
        if (speed > safeSpeed + 20)
            return "DANGER";
        else if (speed > safeSpeed)
            return "WARNING";
        else
            return "SAFE";
    }
}