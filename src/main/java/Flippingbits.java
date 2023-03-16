import java.io.*;
import java.util.stream.IntStream;

public class Flippingbits {
    public static long flippingBits(long n) {

        return ~n & 0xFFFFFFFFL;
    }



    public static void main(String[] args) throws IOException {
        String outputPath = "S:/Java/output.txt"; // replace "output.txt" with your desired file name
        System.setProperty("OUTPUT_PATH", outputPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
