import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {

        //Sum of Diagonals of an Array
        // n x n Matrix

        // Left Diagonal sum
        int sumLeftDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
               sumLeftDiagonal += arr.get(i).get(i);
        }

//        Right Diagonal Sum
        int sumRightDiagonal = 0;
        for (int i = 0, j = arr.size()-1; i < arr.size(); i++,j--) {
            sumRightDiagonal += arr.get(i).get(j);

        }

        return Math.abs(sumLeftDiagonal-sumRightDiagonal);

    }




    public static void main(String[] args) throws IOException {
        String outputPath = "S:/Java/output.txt"; // replace "output.txt" with your desired file name
        System.setProperty("OUTPUT_PATH", outputPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
