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
        		"0.27", "1.14", "2.28", "2.96", "4.18", "4.88", "6.04", "6.75", "7.89", "8.66", "9.82", "10.49", "11.64", "12.42", "13.48", "14.22", "15.38", "17.31", "19.09", "21.00", "22.87", "24.74", "26.64", "27.12", "27.52", "28.03", "28.45", "28.90", "29.39", "30.36", "31.36", "32.22", "33.16", "34.12", "35.06", "36.02", "36.90", "37.83", "38.82", "39.76", "40.69", "41.56", "42.52", "43.47", "44.44", "45.32", "46.25", "47.22", "48.12", "49.08", "50.03", "50.96", "51.86", "52.81", "53.74", "54.68", "55.62", "56.57", "57.49", "58.46", "59.40", "60.34", "60.81", "61.28", "62.21", "62.65", "63.10", "64.14", "64.56", "64.96", "65.93", "66.37", "66.85", "67.84", "68.25", "68.72", "69.74", "70.15", "70.58", "71.55", "72.01", "72.47", "73.46", "73.91", "74.42", "75.32", "76.20", "77.17", "77.61", "78.13", "79.08", "80.04", "80.98", "81.38", "81.86", "82.87", "83.76", "84.71", "85.13", "85.64", "86.58", "87.52", "88.46", "90.35", "91.12", "92.24", "92.97", "94.12", "94.85", "95.93", "96.73", "97.89", "98.55", "99.71", "100.46", "101.62", "102.37", "103.50", "104.19", "105.36", "106.09", "107.21", "107.91", "109.15", "109.82", "111.05", "111.71", "112.84", "113.60", "114.75", "115.46", "116.64", "117.32", "118.46", "119.16", "120.33", "122.23", "124.17", "126.02", "127.87", "129.73", "131.62", "133.66", "135.35", "137.25", "139.10", "140.99", "142.83", "143.24", "143.78", "144.25", "144.66", "145.20", "145.60", "146.11", "146.59", "147.00", "147.57", "147.97", "148.45", "148.87", "149.41", "149.88", "150.39", "151.26", "151.70", "152.16", "153.13", "153.58", "154.08", "155.01", "155.48", "155.88", "156.88", "157.78", "158.25", "158.69", "159.69", "160.12", "160.56", "161.53", "161.96", "162.39", "163.38", "163.86", "164.37", "165.27", "165.77", "166.26", "167.19", "167.62", "168.09", "169.06", "169.50", "169.93", "170.93", "171.42", "171.89", "172.36", "172.79", "173.30", "173.71", "174.21", "174.70", "175.10", "175.54", "176.02", "176.52", "176.95", "177.46", "177.93", "178.36", "178.89", "179.38", "180.31", "181.26", "182.20", "182.64", "183.14", "183.54", "184.04", "184.98", "186.01", "186.41", "186.89", "187.32", "187.75", "188.68", "189.72", "190.19", "190.60", "191.04", "191.56", "192.04", "192.50", "192.94", "193.77", "194.94",
        };
        
        
        for (int i = 0; i < timeData.length; i++) {
        	double xCoordinate = minValue + (random.nextDouble() * (maxValue - minValue));
            
        	double yCoordinate = minValue + (random.nextDouble() * (maxValue - minValue));

            int motionNum = possibleValues[random.nextInt(possibleValues.length)];
            int musicNum = 1;

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
