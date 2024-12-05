package utils;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static List<Node> createNodes(List<String> input) {
        List<Node> nodes = new ArrayList<>();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(y).length(); x++) {
                Node n = new Node(x, y, input.get(y).charAt(x));
                nodes.add(n);
            }
        }
        return nodes;
    }

    public static void drawNodes(List<Node> nodes) {
        int row = 0;
        for (Node n : nodes) {
            if (n.y != row) {
                System.out.println();
                row = n.y;
            }
            System.out.printf(String.valueOf(n.c));
        }
    }

    public static List<Node> getNeighboursLeft(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        for (int i = me.x -1 ; i >= me.x - times; i--) {
            Node temp = new Node(i, me.y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursRight(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        for (int i = me.x + 1; i <= me.x + times; i++) {
            Node temp = new Node(i, me.y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursUp(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        for (int i = me.y - 1; i >= me.y - times; i--) {
            Node temp = new Node(me.x, i);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursDown(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        for (int i = me.y + 1; i <= me.y + times; i++) {
            Node temp = new Node(me.x, i);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursLeftUp(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        var y = me.y;
        for (int i = me.x -1 ; i >= me.x - times; i--) {
            y = y - 1;
            Node temp = new Node(i, y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursRightUp(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        var y = me.y;
        for (int i = me.x + 1; i <= me.x + times; i++) {
            y = y - 1;
            Node temp = new Node(i, y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursLeftDown(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        var y = me.y;
        for (int i = me.x -1 ; i >= me.x - times; i--) {
            y = y + 1;
            Node temp = new Node(i, y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }

    public static List<Node> getNeighboursRightDown(List<Node> nodes, Node me, int times) {
        List<Node> neighbours = new ArrayList<>();
        var y = me.y;
        for (int i = me.x + 1; i <= me.x + times; i++) {
            y = y + 1;
            Node temp = new Node(i, y);
            if (nodes.contains(temp)) {
                int index = nodes.indexOf(temp);
                neighbours.add(nodes.get(index));
            }
        }
        return neighbours;
    }
}
