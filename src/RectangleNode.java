public class RectangleNode {
    char name ;
    int high ;
    int width ;

    RectangleNode (char name , int high , int width){
        this. name = name ;
        this. high = high ;
        this. width = width ;
    }

    @Override
    public String toString() {
        return "RectangleNode{" +
                "name=" + name +
                ", high=" + high +
                ", width=" + width +
                '}';
    }
}
