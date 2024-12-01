import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static utils.FileReader.toStringList;

public class Dec01 {

    public static void run() {
        List<String> input = toStringList("files/1.txt");
        System.out.println("part1: " + part1(input));
        System.out.println("part2: " + part2(input));
    }

    public static String part1(List<String> input) {
        int tot = 0;
        List<Integer> left = parseInput(input, 0);
        List<Integer> right = parseInput(input, 1);

        for (int i = 0; i < left.size(); i++) {
            tot = tot + Math.abs(left.get(i) - right.get(i));
        }

        return String.valueOf(tot);
    }

    public static String part2(List<String> input) {
        int tot = 0;
        List<Integer> left = parseInput(input, 0);
        List<Integer> right = parseInput(input, 1);

        for (Integer i : left) {
            List<Integer> matching = right.stream().filter(r -> Objects.equals(r, i)).toList();
            tot += (matching.size() * i);
        }
        return String.valueOf(tot);
    }

    private static List<Integer> parseInput(final List<String> input, int pos) {
        List<Integer> rowList = new ArrayList<>();
        for (String line : input) {
            rowList.add(Integer.parseInt(line.split("\s+")[pos]));
        }
        Collections.sort(rowList);
        return rowList;
    }
}
