import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        int[] result= new int[100];

        // Count keys (Number of times the number in the arr is found)
        for (int i = 0; i < arr.size(); i++) {
            result[arr.get(i)] += 1;
        }

        List<Integer> list1 = new ArrayList<>(Collections.nCopies(100,0));

        for (int i = 0; i < list1.size(); i++) {
            list1.set(i,result[i]);
        }
        return list1;
    }



    public static void main(String[] args) throws IOException {
        String outputPath = "S:/Java/output.txt"; // replace "output.txt" with your desired file name
        System.setProperty("OUTPUT_PATH", outputPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
