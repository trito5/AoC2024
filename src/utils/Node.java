package utils;

import java.util.List;

public class Node {
     public int x;
     public int y;
     public char c;

     public Node(int x, int y) {
          this.x = x;
          this.y = y;
     }

     public Node(int x, int y, char c) {
          this.x = x;
          this.y = y;
          this.c = c;
     }

     public Node getLeftNeighbor(List<Node> nodes) {
          Node temp = new Node(x - 1, y );
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getRightNeighbor(List<Node> nodes) {
          Node temp = new Node(x + 1, y);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getUpNeighbor(List<Node> nodes) {
          Node temp = new Node(x, y + 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getDownNeighbor(List<Node> nodes) {
          Node temp = new Node(x, y - 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getLeftUpNeighbor(List<Node> nodes) {
          Node temp = new Node(x - 1, y - 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getRighttUpNeighbor(List<Node> nodes) {
          Node temp = new Node(x + 1, y - 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getRightDownNeighbor(List<Node> nodes) {
          Node temp = new Node(x + 1, y + 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     public Node getLeftDownNeighbor(List<Node> nodes) {
          Node temp = new Node(x - 1, y + 1);
          if (nodes.contains(temp)) {
               int i = nodes.indexOf(temp);
               return nodes.get(i);
          }
          return null;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Node node = (Node) o;
          return x == node.x && y == node.y;
     }

     @Override
     public String toString() {
          return "Node{" +
                 "x=" + x +
                 ", y=" + y +
                 ", c=" + c +
                 '}';
     }
}
