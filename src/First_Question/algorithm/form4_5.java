package First_Question.algorithm;

import First_Question.files.writeFile;

import java.io.IOException;
import java.util.ArrayList;

public class form4_5 {
    public static void creatTree(ArrayList<Node> nodesList, Node root, String filename) throws IOException {
        answer(nodesList);
        writeFile.drawTree(root,filename);
    }
    public static String answer(ArrayList<Node> nodes){
        String output = "";
        int t=0 ;
        MergeRectangle rectangularPaper = new MergeRectangle();
        rectangularPaper.canFormRectangleHight(nodes);
        rectangularPaper.canFormRectangleWidth(nodes);
        if (rectangularPaper.currentHIGHTPapers.size()==1&&rectangularPaper.currentWidthPapers.size()==1){
            output = "Rectangle can be formed / \n";
        }
        else if(rectangularPaper.currentHIGHTPapers.size()==1){
            output = "Rectangle can be formed by H / \n";
            t++;
        }
        else if(rectangularPaper.currentWidthPapers.size()==1){
            output = "Rectangle can be formed by W / \n";
            t++;
        }
        else{
            output = "Rectangle cant be formed / \n";
        }
        if(t==1){
            rectangularPaper.canFormRectangleWidth(nodes);
        }
        output +="all Rectangle can be form is: "+(rectangularPaper.count+nodes.size());
        System.out.println(output);
        return output ;
    }

}
