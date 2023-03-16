import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SparseArrays {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        int found = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            found = 0;
            for (int j = 0; j < strings.size();j++){
                 if(queries.get(i).equals(strings.get(j))){
                     found++;
                 }
            }
            result.add(found);
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
//
//        List<String> a = new ArrayList<>();
//
//        a.add("aba");
//        a.add("baba");
//        a.add("aba");
//        a.add("xzxb");
//
//        List<String> b = new ArrayList<>();
//
//        b.add("aba");
//        b.add("xzxb");
//        b.add("ab");
//
//
//        List<Integer> num = matchingStrings(a,b);
//
//        System.out.println(num);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = matchingStrings(strings, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

