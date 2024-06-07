package Second_Question.Algorithm;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralTree {
    static String filePath = "src/Second_Question/Files/GeneralTree";
    static String filePathEx="src/Second_Question/Files/GeneEX";
    public Node root;

    public void printGeneralTree(Node root , int level) {

        String indent = "   ";

        System.out.print(indent.repeat(level) + root.key + "\n");

        for (Node child : root.children)
            printGeneralTree(child ,level + 1);
    }

    public Node newNode(char key)
    {
        Node temp = new Node(key);
        return temp;
    }



    public void CreateTree ()
    {
        root = newNode('A');
        (root.children).add(newNode('B'));
        (root.children).add(newNode('C'));
        (root.children).add(newNode('D'));
        (root.children.get(0).children).add(newNode('E'));
        (root.children.get(0).children).add(newNode('F'));
        (root.children.get(1).children).add(newNode('G'));
        (root.children.get(2).children).add(newNode('H'));
        (root.children.get(2).children).add(newNode('I'));
        (root.children.get(2).children).add(newNode('J'));
        (root.children.get(2).children.get(2).children).add(newNode('K'));
    }

    public String TreeToString(Node root) {

        StringBuilder sb = new StringBuilder();
        TreeToStringConverter(root, sb);
        return sb.toString();
    }

    public void TreeToStringConverter(Node node, StringBuilder sb) {

        if (node!= null && node.children.isEmpty() == false) {

            sb.append(node.key);
            sb.append("->");

            boolean isFirstChild = true;

            for (Node child : node.children) {
                if (!isFirstChild) {
                    sb.append(",");
                }
                sb.append(child.key);
                isFirstChild = false;
            }
            sb.append("\n");

            for (Node child : node.children) {
                TreeToStringConverter(child, sb);
            }
        }
    }

    public List<String> ConvertFileToList()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePathEx));

            List <String> lines = new ArrayList<>();

            String currentLine;

            while ((currentLine = br.readLine())!= null) {
                lines.add(currentLine);
            }
            br.close();

            return lines;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Import (String treeString)
    {
        try {

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(treeString);
            bufferedWriter.close();
            System.out.println("Text has been written to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while trying to write to the file.");
            e.printStackTrace();
        }
    }

    public Node Export (List <String> input)
    {

        Map<String, Node> nodes = new HashMap<>();
       // Node GTroot=newNode(input.get(0).charAt(0));

        for (String line : input) {

            String[] parts = line.split("->");
            String parentName = parts[0];

            if (!nodes.containsKey(parentName)) {
                nodes.put(parentName, newNode((parentName.charAt(0))));
            }
            String[] childrenNames = parts[1].split(",");

            for (String childName : childrenNames) {
                childName = childName.trim();

                if (!nodes.containsKey(childName)) {
                    nodes.put(childName, newNode(childName.charAt(0)));
                }
                nodes.get(parentName).children.add(nodes.get(childName));
            }
        }

        printGeneralTree(nodes.get("A") ,0);
        return nodes.get("A");
    }

}
