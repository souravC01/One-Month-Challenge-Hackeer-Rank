import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {

        int uniqueCount = 0;
        int found;
        List<Integer> nums;
        List<Integer> result = new ArrayList<>();
        nums = a;


        for (int i = 0; i < nums.size(); i++) {
            found = 0;
            for (int j = 0; j < a.size(); j++) {
                if (nums.get(i).equals(a.get(j))) {
                    found++;
                }
            }
            result.add(found);
        }

//        System.out.println(result);

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 1){
//                System.out.println(a.get(i));
                uniqueCount = a.get(i);
                break;
            }

        }
        return uniqueCount;
    }


    public static void main(String[] args) throws IOException {


//        List<Integer> a = new ArrayList<>();
//
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(3);
//        a.add(2);
//        a.add(1);
//
//        int n = lonelyinteger(a);
//        System.out.println(n);

        String outputPath = "S:/Java/output.txt"; // replace "output.txt" with your desired file name
        System.setProperty("OUTPUT_PATH", outputPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));


        int n = Integer.parseInt(bufferedReader.readLine().trim());


        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
