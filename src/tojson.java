import java.util.Random;

public class tojson {
    public static void main(String[] args) {
        String[] timeData = {
        		"0.67", "2.00", "3.65", "5.21", "6.85", "8.34", "10.10", "11.58", "13.15", "13.93", "14.77", "15.64", "16.40", "17.15", "17.99", "18.83", "19.50", "20.39", "21.14", "21.92", "22.70", "23.44", "24.26", "25.02", "25.85", "27.49", "29.12", "30.67", "32.22", "33.78", "35.34", "36.91", "38.55", "40.13", "41.76", "43.39", "44.95", "46.51", "48.08", "51.33", "52.09", "52.90", "53.33", "54.48", "55.26", "56.09", "56.48", "57.65", "58.43", "59.22", "59.68", "60.90", "61.64", "62.47", "62.89", "63.96", "65.61", "67.23", "68.76", "70.38", "71.99", "73.54", "75.13", "76.70", "77.46", "78.31", "79.12", "79.92", "80.68", "81.48", "82.33", "83.14", "83.89", "84.67", "85.53", "86.27", "87.06", "87.81", "88.62", "89.46", "91.06", "92.62", "94.23", "95.75", "97.18", "98.98", "100.51", "102.13", "103.52", "105.38", "106.93", "108.59", "110.11", "111.71", "114.95", "115.31", "116.47", "118.05", "118.49", "119.66", "120.42", "121.30", "121.66", "122.82", "123.57", "124.41", "124.85", "125.99", "126.75", "127.60", "128.04", "129.14", "130.02", "130.77", "131.13", "132.33", "133.19", "133.94", "134.39", "135.53", "136.34", "137.18", "137.55", "138.73", "139.54", "140.38", "140.73", "141.88", "142.74", "143.49", "143.86", "145.04", "145.84", "146.70", "147.07", "148.26", "149.01", "149.88", "150.30", "151.37", "152.14", "153.05", "153.42", "154.55", "155.37", "156.17", "156.57", "157.77", "158.58", "159.40", "159.80", "160.95", "161.82", "162.53", "162.99", "164.05",
        };
        double minValue = 0.15;
        double maxValue = 0.85;
        double[] timeDoubleData = new double[timeData.length];
        for (int i = 0; i < timeData.length; i++) {
            timeDoubleData[i] = Double.parseDouble(timeData[i]);
        }

        JsonData[] jsonDataArray = new JsonData[timeData.length];
        Random random = new Random();
        int[] possibleValues = {1, 2, 3};
        
        for (int i = 0; i < timeData.length; i++) {
        	double xCoordinate = minValue + (random.nextDouble() * (maxValue - minValue));
            
        	double yCoordinate = minValue + (random.nextDouble() * (maxValue - minValue));

            int motionNum = possibleValues[random.nextInt(possibleValues.length)];
            int musicNum = 2;

            jsonDataArray[i] = new JsonData(musicNum, motionNum, xCoordinate, yCoordinate, timeDoubleData[i]);
        }

        for (JsonData data : jsonDataArray) {
            System.out.println(data.toJsonString()+",");
        }
    }
}

class JsonData {
    private int musicNum;
    private int motionNum;
    private double xCoordinate;
    private double yCoordinate;
    private double appearTime;

    public JsonData(int musicNum, int motionNum, double xCoordinate, double yCoordinate, double appearTime) {
        this.musicNum = musicNum;
        this.motionNum = motionNum;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.appearTime = appearTime;
    }

    public String toJsonString() {
        return String.format(
            "{\"MusicNum\": %d, \"MOTION_NUM\": %d, \"X-COORDINATE\": %f, \"Y-COORDINATE\": %f, \"APPEAR_TIME\": %f}",
            musicNum, motionNum, xCoordinate, yCoordinate, appearTime
        );
    }
}
