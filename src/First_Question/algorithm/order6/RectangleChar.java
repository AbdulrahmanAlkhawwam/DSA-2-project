package First_Question.algorithm.order6;

import First_Question.files.writeFile;

import java.io.IOException;

public class RectangleChar {
    static char[][] Rec2D;
    static String[] Rec = {
            "----------------------------------------------------------------------",
            "|A                  |B                  |C                           |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "|                   |                   |                            |",
            "----------------------------------------------------------------------",
            "|D                            |E                                     |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             ----------------------------------------",
            "|                             |F                                     |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "|                             |                                      |",
            "---------------------------------------------------------------------- "
    };


    public static char[][] getRec2D() {
        return Rec2D;
    }

    public static String[] getRec() {
        return Rec;
    }

    public static void convertStingtochar(String[] Rec){
        int maxLength = 0;
        for (String row : Rec) {
            if (row.length() > maxLength) {
                maxLength = row.length();
            }
        }


        Rec2D = new char[Rec.length][maxLength];


        for (int i = 0; i < Rec.length; i++) {
            Rec2D[i] = Rec[i].toCharArray();
        }}
    public static char[][] flipRectangle(char rectangle [][]) throws IOException {
        int row=rectangle.length;
        int col=rectangle[0].length;
//        System.out.println(row);
//        System.out.println(col);

        char[][] flipped = new char[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {


                if(rectangle[i][j]=='|'){
                    rectangle[i][j]='-';
                } else if (rectangle[i][j]=='-') {
                    rectangle[i][j]='|';

                }

                flipped[j][row-1-i] =rectangle[i][j];

            }
        }
        flipped[0][0]='-';
        flipped[0][flipped[0].length-1]='-';
        flipped[flipped.length-1][0]='-';
        flipped[flipped.length-1][flipped[0].length-1]='-';

        writeFile.writeToFile(flipped,"src/First_Question/files/order3/form");

        return flipped;
    }


//    void printRectangle(char [][]Rec){
//        for (int i = 0; i < Rec.length; i++) {
//            for (int j = 0; j < Rec[0].length; j++) {
//                System.out.print(Rec[i][j]);
//            }
//            System.out.println();
//        }
//    }

}




