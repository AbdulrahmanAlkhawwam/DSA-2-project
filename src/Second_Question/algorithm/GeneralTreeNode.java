package Second_Question.algorithm;
import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    private char name;
    private List<GeneralTreeNode> children;

    GeneralTreeNode(char name)
    {
        this.name = name;
        children = new ArrayList<GeneralTreeNode>();
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List<GeneralTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<GeneralTreeNode> children) {
        this.children = children;
    }
}