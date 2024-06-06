package algo;

public class Rectangle {
   public String name;
    public int width;
    public int height;
   public boolean root=false;

    public Rectangle() {
    }

    public Rectangle(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }
    public Rectangle(String name, int width, int height, boolean root) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.root=root;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public String getName () {  return name ;   }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", is root="+ root +
                '}';
    }
}
