package Second_Question.algorithm;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralTree {
    static String filePath = "src/Second_Question/Files/GeneralTree";
    static String filePathEx="src/Second_Question/Files/GeneEX";
    public GeneralTreeNode root;

    public void printGeneralTree(GeneralTreeNode root , int level) {

        String indent = "   ";

        System.out.print(indent.repeat(level) + root.getName() + "\n");

        for (GeneralTreeNode child : root.getChildren())
            printGeneralTree(child ,level + 1);
    }

    public GeneralTreeNode newNode(char key)
    {
        GeneralTreeNode temp = new GeneralTreeNode(key);
        return temp;
    }



    public void CreateTree ()
    {
        root = newNode('A');
        (root.getChildren()).add(newNode('B'));
        (root.getChildren()).add(newNode('C'));
        (root.getChildren()).add(newNode('D'));
        (root.getChildren().get(0).getChildren()).add(newNode('E'));
        (root.getChildren().get(0).getChildren()).add(newNode('F'));
        (root.getChildren().get(1).getChildren()).add(newNode('G'));
        (root.getChildren().get(2).getChildren()).add(newNode('H'));
        (root.getChildren().get(2).getChildren()).add(newNode('I'));
        (root.getChildren().get(2).getChildren()).add(newNode('J'));
        (root.getChildren().get(2).getChildren().get(2).getChildren()).add(newNode('K'));
    }

    public String TreeToString(GeneralTreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeToStringConverter(root, sb);
        return sb.toString();
    }

    public void TreeToStringConverter(GeneralTreeNode node, StringBuilder sb) {

        if (node!= null && node.getChildren().isEmpty() == false) {

            sb.append(node.getName());
            sb.append("->");

            boolean isFirstChild = true;

            for (GeneralTreeNode child : node.getChildren()) {
                if (!isFirstChild) {
                    sb.append(",");
                }
                sb.append(child.getName());
                isFirstChild = false;
            }
            sb.append("\n");

            for (GeneralTreeNode child : node.getChildren()) {
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

    public GeneralTreeNode Export (List <String> input)
    {

        Map<String, GeneralTreeNode> nodes = new HashMap<>();
       // GeneralTreeNode GTroot=newNode(input.get(0).charAt(0));

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
                nodes.get(parentName).getChildren().add(nodes.get(childName));
            }
        }

        printGeneralTree(nodes.get("A") ,0);
        return nodes.get("A");
    }

}
