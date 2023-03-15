import java.io.*;

public class TimeConversion {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = bufferedReader.readLine();

            String result = timeConversion(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }


    public static String timeConversion(String s) {
        String time = "";
        int Hr;

        String hr = s.substring(0, 2);   //07:05:45PM
        String min = s.substring(3, 5);
        String sec = s.substring(6, 8);
        String dst = s.substring(8, 10);
        String HrFor;
        Hr = Integer.parseInt(hr);

        if (Hr == 12) {
            if (dst.compareTo("PM") == 0) {
                //change nothing
                Hr = Integer.parseInt(hr);
                HrFor = String.format("%02d", Hr);
                time = String.format("%s:%s:%s", String.valueOf(HrFor), min, sec);
            } else if (dst.compareTo("AM") == 0) {
                //Convert to 0
                Hr = 0;
                HrFor = String.format("%02d", Hr);
                time = String.format("%s:%s:%s", String.valueOf(HrFor), min, sec);
            }
        } else if (Hr < 12) {
            if (dst.compareTo("AM") == 0) {
                Hr = Integer.parseInt(hr);
                HrFor = String.format("%02d", Hr);
                time = String.format("%s:%s:%s", String.valueOf(HrFor), min, sec);
            } else if (dst.compareTo("PM") == 0) {
                Hr += 12;
                HrFor = String.format("%02d", Hr);
                time = String.format("%s:%s:%s", String.valueOf(HrFor), min, sec);
            }
        }
        return time;
    }

}
