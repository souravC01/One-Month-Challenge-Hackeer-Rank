import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {

        arr.sort(null);

        long minSum = 0;
        long maxSum = 0;



        for (int i = 0; i < 4; i++) {
            minSum += arr.get(i);
        }


        for (int i = 1; i <= 4 ; i++) {
            maxSum += arr.get(i);
        }

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) throws IOException {

//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//        miniMaxSum(a);


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
