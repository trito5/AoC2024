import java.util.LinkedList;
import java.util.List;
import utils.Node;
import static utils.Common.createNodes;
import static utils.Common.getNeighboursDown;
import static utils.Common.getNeighboursLeft;
import static utils.Common.getNeighboursLeftDown;
import static utils.Common.getNeighboursLeftUp;
import static utils.Common.getNeighboursRight;
import static utils.Common.getNeighboursRightDown;
import static utils.Common.getNeighboursRightUp;
import static utils.Common.getNeighboursUp;
import static utils.FileReader.toStringList;

public class Dec04 {

    public static void run() {
        List<String> input = toStringList("files/4.txt");
        List<String> input2 = toStringList("files/4.txt");
        System.out.println("part 1 : " + part1(input));
        System.out.println("part 2: " + part2(input2));
    }

    public static String part1(List<String> input) {
        var tot = 0;
        LinkedList<Node> popper = new LinkedList<>();
        var nodes = createNodes(input);

        for (Node node : nodes) {
            if (node.c == 'X') {
                popper.add(node);
            }
        }

        while (!popper.isEmpty()) {

            var pop = popper.pop();
            tot += checkList(getNeighboursLeft(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursLeftUp(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursUp(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursRightUp(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursRight(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursRightDown(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursDown(nodes, pop, 3)) ? 1 : 0;
            tot += checkList(getNeighboursLeftDown(nodes, pop, 3)) ? 1 : 0;
        }

        return String.valueOf(tot);
    }

    public static String part2(List<String> input) {
        var tot = 0;
        LinkedList<Node> popper = new LinkedList<>();
        var nodes = createNodes(input);
        for (Node node : nodes) {
            if (node.c == 'A') {
                popper.add(node);
            }
        }
        while (!popper.isEmpty()) {
            var pop = popper.pop();
            var lu = pop.getLeftUpNeighbor(nodes);
            var rd = pop.getRightDownNeighbor(nodes);
            if (checkX(lu, rd)) {
                var ld = pop.getLeftDownNeighbor(nodes);
                var ru = pop.getRighttUpNeighbor(nodes);
                if (checkX(ld, ru)) {
                    tot++;
                }
            }
        }

        return String.valueOf(tot);
    }

    private static boolean checkList(List<Node> nodes) {
        return nodes.size() == 3 && nodes.get(0).c == 'M' && nodes.get(1).c == 'A' && nodes.get(2).c == 'S';
    }

    private static boolean checkX(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return false;
        }
        return (n1.c == 'M' && n2.c == 'S') || n1.c == 'S' && n2.c == 'M';
    }

}
