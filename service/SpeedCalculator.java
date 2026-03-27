public class SpeedCalculator {

    public int getSafeSpeed(String traffic) {
        if (traffic.equalsIgnoreCase("high"))
            return 30;
        else if (traffic.equalsIgnoreCase("medium"))
            return 50;
        else
            return 70;
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