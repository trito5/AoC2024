import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import static utils.FileReader.toStringList;

public class Dec02 {

    public static void run() {
        List<String> input = toStringList("files/2.txt");
        System.out.println("part 1 : " + part1(input));
        System.out.println("part 2: " + part2(input));
    }

    public static String part1(List<String> input) {
        List<String> safe = new ArrayList<>();
        for (String s : input) {
            List<Integer> levels = getLevels(s);
            var alt = new LinkedList<List<Integer>>();
            alt.add(levels);
            findSafeLevels(s, alt, safe);
        }
        return String.valueOf(safe.size());
    }

    public static String part2(List<String> input) {
        List<String> safe = new ArrayList<>();
        for (String s : input) {
            List<Integer> levels2 = getLevels(s);
            var alt = getAlternatives(levels2);
            findSafeLevels(s, alt, safe);
        }
        return String.valueOf(safe.size());
    }

    private static List<Integer> getLevels(String s) {
        var nums = s.split("\s+");
        return Arrays.stream(nums)
            .mapToInt(Integer::parseInt)
            .boxed()
            .toList();
    }

    private static void findSafeLevels(final String s, final LinkedList<List<Integer>> alt, final List<String> safe) {
        boolean isIncreasing;
        while (!alt.isEmpty()) {
            final List<Integer> lvl = alt.pop();
            if (lvl.size() != new HashSet<>(lvl).size()) {
                continue;
            }

            isIncreasing = lvl.get(0) < lvl.get(1);
            var unsafe = false;

            for (int i = 0; i < lvl.size() - 1; i++) {
                if ((Math.abs(lvl.get(i) - lvl.get(i + 1)) > 3) ||
                    (isIncreasing && lvl.get(i) > lvl.get(i + 1)) ||
                    (!isIncreasing && lvl.get(i) < lvl.get(i + 1)))
                {
                    unsafe = true;
                    break;
                }
            }
            if (!unsafe) {
                safe.add(s);
                alt.clear();
            }
        }
    }

    private static LinkedList<List<Integer>> getAlternatives(List<Integer> levels) {
        LinkedList<List<Integer>> alternatives = new LinkedList<>();
        alternatives.add(levels);
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> newLevel = new ArrayList<>(levels);
            newLevel.remove(i);
            alternatives.add(newLevel);
        }
        return alternatives;
    }
}
