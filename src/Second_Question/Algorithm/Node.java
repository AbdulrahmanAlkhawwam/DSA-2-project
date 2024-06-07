package Second_Question.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public char key;
    public List<Node> children;

    Node(char x)
    {
        key = x;
        children = new ArrayList<Node>();
    }
}