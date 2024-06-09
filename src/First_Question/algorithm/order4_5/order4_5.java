package First_Question.algorithm.order4_5;

import First_Question.algorithm.MergeRectangle;
import First_Question.algorithm.Node;
import First_Question.files.writeFile;

import java.io.IOException;
import java.util.ArrayList;

public class order4_5 {
    public void creatTree(ArrayList<Node> nodesList, Node root, String filename) throws IOException {
        answer(nodesList);
        writeFile.drawTree(root,filename);
    }
    public static void answer(ArrayList<Node> nodes){
        int t=0 ;
        MergeRectangle rectangularPaper = new MergeRectangle();
        rectangularPaper.canFormRectangleHight(nodes);
        rectangularPaper.canFormRectangleWidth(nodes);
        if (rectangularPaper.currentHIGHTPapers.size()==1&&rectangularPaper.currentWidthPapers.size()==1){
            System.out.println("Rectangle can be formed");
        }
        else if(rectangularPaper.currentHIGHTPapers.size()==1){
            System.out.println("Rectangle can be formed by H");
            t++;
        }
        else if(rectangularPaper.currentWidthPapers.size()==1){
            System.out.println("Rectangle can be formed by W");
            t++;
        }
        else{
            System.out.println("Rectangle cant be formed");
        }
        if(t==1){
            rectangularPaper.canFormRectangleWidth(nodes);
        }
        System.out.println("all Rectangle can be form is: "+(rectangularPaper.count+nodes.size()));
    }
}
