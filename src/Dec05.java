import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static utils.FileReader.toStringList;

public class Dec05 {

    public static void run() {
        List<String> input = toStringList("files/5.txt");
        System.out.println("part 1 : " + part1(input));
        System.out.println("part 2: " + part2(input));
    }

    public static String part1(List<String> input) {
        int tot = 0;
        var readRules = true;
        Map<Integer, List<Integer>> rules = new HashMap<>();
        for (String line : input) {
            if (line.isEmpty()) {
                readRules = false;
                continue;
            }
            if (readRules) {
                getRules(line, rules);
            } else {
                List<Integer> pages = getPages(line);
                var newPages = new ArrayList<>(pages);
                var sorted = swapPositions(newPages, rules);
                if (sorted.equals(pages)) {
                    tot += sorted.get(sorted.size() / 2);
                }
            }
        }
        return String.valueOf(tot);
    }


    public static String part2(List<String> input) {
        var tot = 0;
        var readRules = true;
        Map<Integer, List<Integer>> rules = new HashMap<>();

        for (String line : input) {
            if (line.isEmpty()) {
                readRules = false;
                continue;
            }
            if (readRules) {
                getRules(line, rules);
            } else {
                List<Integer> pages = getPages(line);;
                var newPages = new ArrayList<>(pages);
                var sorted = swapPositions(newPages, rules);
                if (!sorted.equals(pages)) {
                    tot += sorted.get(sorted.size() / 2);
                }
            }
        }

        return String.valueOf(tot);
    }

    private static void getRules(final String line, final Map<Integer, List<Integer>> rules) {
        var first = Integer.parseInt(line.split("\\|")[0]);
        var second = Integer.parseInt(line.split("\\|")[1]);
        var list = rules.get(first);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(second);
        list.sort(Comparator.comparing(Integer::valueOf));
        rules.put(first, list);
    }

    private static List<Integer> swapPositions(List<Integer> pages, Map<Integer, List<Integer>> rules) {
        int swap = 0;
        for (int i = 0; i < pages.size() - 1; i++) {
            var page = pages.get(i);
            var next = pages.get(i + 1);
            if (rules.get(next) != null && rules.get(next).contains(page)) {
                pages.set(i, next);
                pages.set(i + 1, page);
                swap++;
            }
        }
        if (swap > 0) {
            swapPositions(pages, rules);
        }
        return pages;
    }
    private static List<Integer> getPages(final String line) {
        return Arrays.stream(line.split("\\,"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
