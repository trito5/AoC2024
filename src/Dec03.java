import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static utils.FileReader.readToString;
import static utils.FileReader.splitOnRegexTo2dStringList;
import static utils.FileReader.toStringList;

public class Dec03 {

    public static void run() {
        List<String> input = toStringList("files/3.txt");
        String input2 = readToString("files/3.txt");
        System.out.println("part 1 : " + part1(input));
        System.out.println("part 2: " + part2(input2));
    }

    public static String part1(List<String> input) {
        var tot = 0;
        for (int i = 0; i < input.size(); i++) {
            var row = input.get(i).split("mul\\(");
            for (int j = 0; j < row.length; j++) {
                var chunk = row[j].split("\\)")[0];
                try {
                    var left = chunk.split(",")[0];
                    var right = chunk.split(",")[1];
                    var l = Integer.parseInt(left);
                    var r = Integer.parseInt(right);
                    tot += l * r;
                } catch (Exception e) {
                    //Do nothing
                }
            }

        }
        return String.valueOf(tot);
    }

    public static String part2(String input) {
        var tot = 0;
        var doCommand = true;
        LinkedList<String> commands = new LinkedList<>();
        commands.add(input);
        String regex = "mul\\(|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);

        while (!commands.isEmpty()) {
            var line = commands.pop();

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                var m = matcher.group();
                var p = matcher.start();
                if (m.charAt(2) == 'l') {
                    if (doCommand) {
                        var row = line.substring(p).split("mul\\(");
                        try {
                            var chunk = row[1].split("\\)")[0];
                            var left = Integer.parseInt(chunk.split(",")[0]);
                            var right = Integer.parseInt(chunk.split(",")[1]);
                            tot += left * right;
                            String s = line.substring(p + 1);
                            commands.add(s);
                        } catch (Exception e) {
                            String s = line.substring(p + 1);
                            commands.add(s);
                        }
                    } else {
                        String s = line.substring(p + 1);
                        commands.add(s);
                    }

                } else if (m.charAt(2) == 'n') {
                    doCommand = false;
                    String s = line.substring(p + 1);
                    commands.add(s);
                } else if (m.charAt(2) == '(') {
                    doCommand = true;
                    String s = line.substring(p + 1);
                    commands.add(s);
                }
            }
        }

        return String.valueOf(tot);
    }

}
