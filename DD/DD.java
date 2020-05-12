package DD;
// Задание №9
//Дан двумерный массив («сетка») символов и слово. Найдите все вхождения данного слова в сетке.
// Слово может быть найдено во всех 8 направлениях (вверх, вниз, вправо, влево  и по диагоналям) в любой точке.
// Говорят, слово «лежит в направлении», если все символы совпадают в этом направлении (не в зигзагообразной форме)
import java.io.*;

import java.util.*;

public class DD

{
    static int R, C;

    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };

    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };



    static boolean search2D(char[][] grid, int row,

                            int col, String word)

    {


        if (grid[row][col] != word.charAt(0))

            return false;



        int len = word.length();


        for (int dir = 0; dir < 8; dir++)

        {


            int k, rd = row + x[dir], cd = col + y[dir];

            for (k = 1; k < len; k++)

            {


                if (rd >= R || rd < 0 || cd >= C || cd < 0)

                    break;



                if (grid[rd][cd] != word.charAt(k))

                    break;

                rd += x[dir];

                cd += y[dir];

            }


            if (k == len)

                return true;

        }

        return false;

    }



    static void patternSearch(char[][] grid, String word)

    {


        for (int row = 0; row < R; row++)

        {

            for (int col = 0; col < C; col++)

            {

                if (search2D(grid, row, col, word))

                    System.out.println("pattern found at " + row +

                            ", " + col);

            }

        }

    }


    public static void main(String args[])

    {

        R = 3;

        C = 13;

        char[][] grid = {{'A','S','A','Z','I','N','G','P','R','O','G','R','A'},

                {'E','A','A','S','I','N','C','P','M','A','S','E','U'},

                {'P','M','A','C','I','N','G','P','R','O','G','R','Z'}};

        patternSearch(grid, "MAS");

        System.out.println();

        patternSearch(grid, "GOR");

    }

}
