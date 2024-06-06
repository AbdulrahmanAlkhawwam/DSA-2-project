package Form4and5;

import algo.Rectangle;
import java.util.ArrayList;

public class MergeRectangle {
    ArrayList<Rectangle> currentHIGHTPapers = new ArrayList<>();
    ArrayList<Rectangle>currentWidthPapers=new ArrayList<>();
    int count=0;
    public void canFormRectangleHight(ArrayList<Rectangle> papers) {
        currentHIGHTPapers = new ArrayList<>(papers);
        MergePaperHight();
    }
    public void canFormRectangleWidth(ArrayList<Rectangle> papers) {
        currentWidthPapers = new ArrayList<>(papers);
        MergePaperWidth();
    }

    public void MergePaperHight() {


        boolean merged = true;

        while (merged) {
            //merged = false;




            // Merge papers with same height
            for (int i = 0; i < currentHIGHTPapers.size(); i++) {
                for (int j = i + 1; j < currentHIGHTPapers.size(); j++) {
                    if (currentHIGHTPapers.get(i).getHeight() == currentHIGHTPapers.get(j).getHeight()) {

                        Rectangle newPaper = new Rectangle("new", currentHIGHTPapers.get(i).getWidth() + currentHIGHTPapers.get(j).getWidth(), currentHIGHTPapers.get(i).getHeight());


                        currentHIGHTPapers.remove(j);
                        currentHIGHTPapers.remove(i);
                        currentHIGHTPapers.add(newPaper);
                        MergePaperHight();
                        count++;
                    }
                }
            }

            for (int i = 0; i < currentHIGHTPapers.size(); i++) {
                for (int j = i + 1; j < currentHIGHTPapers.size(); j++) {
                    if (currentHIGHTPapers.get(i).getWidth() == currentHIGHTPapers.get(j).getWidth()) {
                        Rectangle newPaper = new Rectangle("new", currentHIGHTPapers.get(i).getWidth(), currentHIGHTPapers.get(i).getHeight() + currentHIGHTPapers.get(j).getHeight());




                        currentHIGHTPapers.remove(j);
                        currentHIGHTPapers.remove(i);
                        currentHIGHTPapers.add(newPaper);
                        MergePaperHight();
                        count++;


                    }
                }
            }



            merged=false;
        }

    }

    public void MergePaperWidth() {


        boolean merged = true;

        while (merged) {
            //merged = false;




            // Merge papers with same height
            for (int i = 0; i < currentWidthPapers.size(); i++) {
                for (int j = i + 1; j < currentWidthPapers.size(); j++) {
                    if (currentWidthPapers.get(i).getHeight() == currentWidthPapers.get(j).getHeight()) {
                        Rectangle newPaper = new Rectangle("new", currentWidthPapers.get(i).getWidth() + currentWidthPapers.get(j).getWidth(), currentWidthPapers.get(i).getHeight());


                        currentWidthPapers.remove(j);
                        currentWidthPapers.remove(i);
                        currentWidthPapers.add(newPaper);
                        MergePaperWidth();
                        count++;
                    }
                }
            }

            for (int i = 0; i < currentWidthPapers.size(); i++) {
                for (int j = i + 1; j < currentWidthPapers.size(); j++) {
                    if (currentWidthPapers.get(i).getWidth() == currentWidthPapers.get(j).getWidth()) {
                        Rectangle newPaper = new Rectangle("new", currentWidthPapers.get(i).getWidth(), currentWidthPapers.get(i).getHeight() + currentWidthPapers.get(j).getHeight());




                        currentWidthPapers.remove(j);
                        currentWidthPapers.remove(i);
                        currentWidthPapers.add(newPaper);
                        MergePaperWidth();
                        count++;


                    }
                }
            }



            merged=false;
        }

    }
//    public void print ()
//    {
//        if (currentHIGHTPapers.size() == 1) {
//            System.out.println("Rectangle can be formed");
//        } else {
//            canFormRectangleWidth();
//
//
//        }
//    }
}

