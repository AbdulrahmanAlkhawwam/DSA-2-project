package First_Question.algorithm;

public class converter {
    // Vars & Attributes
    public String string ;
    public Node node ;

    // Constructors
    public converter (String string , Node node){
        this.string = string ;
        this.node = node ;
    }
    public converter (){
        this.string = null ;
        this.node = null ;
    }


    // convert String to Binary Tree
    public static Node convert (String input){
        // first: check if input is not null
        // second: check if input is string for a binary tree
        // third: check if input string is for to side or one
        // forth: build each side
        // fifth: check if the output is true
        Node output = new Node ();
        return output ;
    }

    // convert Binary Tree to String
    public static String convert(Node input){
        // first: check if input is not null
        // second: read node for each side every time
        // third: build string
        // forth: check if the output is true
        String output = "";
        return output ;
    }

    public static boolean isNull (String input){
        boolean output = false ;
        return output ;
    }

    public static boolean isNull (Node input){
        boolean output = false ;
        return output ;
    }
}
