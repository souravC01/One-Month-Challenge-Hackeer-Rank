import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        double positive = 0;
        double zero = 0;
        double negative = 0;

        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == 0){
                //zero
                zero++;
            }
            else if(arr.get(i) > 0){
                //positive
                positive++;
            } else if (arr.get(i) < 0) {
                //negative
                negative++;
            }

        }
        System.out.println(String.format("%.6f",positive/arr.size()));
        System.out.println(String.format("%.6f",negative/arr.size()));
        System.out.println(String.format("%.6f",zero/arr.size()));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}
