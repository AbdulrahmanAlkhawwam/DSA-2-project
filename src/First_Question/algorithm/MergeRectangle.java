package First_Question.algorithm;

import java.util.ArrayList;

public class MergeRectangle {
    ArrayList<Node> currentHIGHTPapers = new ArrayList<>();
    ArrayList<Node>currentWidthPapers=new ArrayList<>();
    int count=0;
    public void canFormRectangleHight(ArrayList<Node> papers) {
        currentHIGHTPapers = new ArrayList<>(papers);
        MergePaperHight();
    }
    public void canFormRectangleWidth(ArrayList<Node> papers) {
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
                    if (currentHIGHTPapers.get(i).getHigh() == currentHIGHTPapers.get(j).getHigh()) {
                        Node newPaper = new Node('n', currentHIGHTPapers.get(i).getWidth() + currentHIGHTPapers.get(j).getWidth(), currentHIGHTPapers.get(i).getHigh());
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
                        Node newPaper = new Node('n', currentHIGHTPapers.get(i).getWidth(), currentHIGHTPapers.get(i).getHigh() + currentHIGHTPapers.get(j).getHigh());
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
                    if (currentWidthPapers.get(i).getHigh() == currentWidthPapers.get(j).getHigh()) {
                        Node newPaper = new Node('n', currentWidthPapers.get(i).getWidth() + currentWidthPapers.get(j).getWidth(), currentWidthPapers.get(i).getHigh());
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
                        Node newPaper = new Node('n', currentWidthPapers.get(i).getWidth(), currentWidthPapers.get(i).getHigh() + currentWidthPapers.get(j).getHigh());
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
}

