import java.io.*;

public class Pangrams {

    public static String pangrams(String s) {
        //Easiest and most dumb way
        s = s.toLowerCase();

        boolean a = (s.contains("a") && s.contains("b") && s.contains("c") && s.contains("d") && s.contains("e") && s.contains("f")
                && s.contains("g") && s.contains("h") && s.contains("i") && s.contains("j") && s.contains("k")&& s.contains("l") && s.contains("m")
                && s.contains("n") && s.contains("o") && s.contains("p")&& s.contains("q") && s.contains("r") && s.contains("s")
                && s.contains("t") && s.contains("u")&& s.contains("v") && s.contains("w") && s.contains("x") && s.contains("y") && s.contains("z"));

        if(a)
            return "pangram";
        else
            return "not pangram";

    }

    public static void main(String[] args) throws IOException {
        String outputPath = "S:/Java/output.txt"; // replace "output.txt" with your desired file name
        System.setProperty("OUTPUT_PATH", outputPath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        String s = bufferedReader.readLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
