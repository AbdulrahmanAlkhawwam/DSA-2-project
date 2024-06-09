package First_Question.files;

import First_Question.algorithm.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class readFile {
    public static String readFileAsString(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
        }
        return stringBuilder.toString();
    }
    //////////////////////// third order ////////////////////////
    public static Node readDrawing (String filename) {
        String[] drawing;
        try (BufferedReader reader = new BufferedReader(new FileReader( filename))) {
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                i++;
            }
            reader.close();
            BufferedReader reader1 = new BufferedReader(new FileReader(filename));
            drawing = new String[i];
            Arrays.fill(drawing, " ");
            i = 0;
            while ((line = reader1.readLine()) != null) {
                drawing[i] = line;
                i++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int ind = 0;
        Node temp;
        List<Node> rectangles = parseDrawing(drawing);
        Node[] r = rectangles.toArray(new Node[0]);
        for (int i = 0; i < r.length; i++) {
            if (r[i].isRoot) {
                ind = i;
            }
        }
        for (int i = 1; i < ind; i++) {
            if (r[i].getName()=='|' || r[i].getName()=='-') {
                temp = r[i];
                r[i] = r[i - 1];
                r[i - 1] = temp;
            }
        }
        for (int i = ind + 1; i < r.length; i++) {
            if (r[i].getName()=='|' || r[i].getName()=='-') {
                temp = r[i];
                r[i] = r[i - 1];
                r[i - 1] = temp;
            }
        }
        temp = r[0];
        r[0] = r[ind];
        for (int i = ind; i > 1; i--) {
            r[i] = r[i - 1];
        }
        if(r.length>1)
            r[1] = temp;
        Node root;
        Node root1 = new Node();
        root = root1.buildTree(r);
        return root;
    }
    public static List<Node> parseDrawing (String[]drawing){
        List<Node> rectangles = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        for (int row = 1; row < drawing.length - 1; row++) {
            for (int col = 1; col < drawing[row].length() - 1; col++)
                if (Character.isLetter(drawing[row].charAt(col)))
                    visited.put(String.valueOf(drawing[row].charAt(col)), false);
        }
        findRectangles(drawing, visited, rectangles);
        return rectangles;
    }
    private static void findRectangles (String[]drawing, Map visited, List < Node > rectangles){
        boolean found = true, found2 = true, map = false;
        for (int row = 1; row < drawing.length - 1; row++) {
            for (int col = 1; col < drawing[row].length() - 1; col++) {
                if (Character.isLetter(drawing[row].charAt(col))) {
                    map = (boolean) visited.get(String.valueOf(drawing[row].charAt(col)));
                    if (!map) {
                        found = true;
                        char name = drawing[row].charAt(col);
                        int width = findWidth(drawing, row, col);
                        int height = findHeight(drawing, row, col);
                        visited.replace(String.valueOf(drawing[row].charAt(col)),true);
                        rectangles.add(new Node(name, width, height, false));
                    }
                } else if ((drawing[row].charAt(col)=='|') && found) {
                    if ((drawing[drawing.length - 2].charAt(col)=='|') && row == 1)
                        rectangles.add(new Node(drawing[row].charAt(col), 0, 0, true));
                    else
                        rectangles.add(new Node(drawing[row].charAt(col), 0, 0, false));
                    found = false;
                } else if ((drawing[row].charAt(col)=='-') && found2) {
                    if (drawing[row].startsWith("-") && drawing[row].endsWith("-")) {
                        rectangles.add(new Node(drawing[row].charAt(col), 0, 0, true));
                    } else
                        rectangles.add(new Node(drawing[row].charAt(col), 0, 0, false));
                    found2 = false;
                }
            }
            found2 = true;
            found = false;
        }
    }
    private static int findWidth (String[]drawing,int row, int col){
        int start = col;
        while (col < drawing[row].length() && drawing[row].charAt(col) != '|') {
            col++;
        }
        return col - start + 1;
    }
    private static int findHeight (String[]drawing,int row, int col){
        int start = row;
        int f = 1;
        while (row < drawing.length && drawing[row].charAt(col) != '-') {
            if (drawing[row].contains("-")) {
                f++;
            }
            row++;
        }
        return row - start + 1 ;
    }
}
