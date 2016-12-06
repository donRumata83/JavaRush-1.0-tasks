package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'w', 'd', 'e', 'e', 'l', 'k', 'e', 'k'},
                {'u', 'm', 'a', 'm', 'e', 'm', 'k', 'k'},
                {'l', 'n', 'o', 'o', 'o', 'v', 'k', 'k'},
                {'e', 'm', 'o', 'h', 'o', 'm', 'e', 'k'},
                {'m', 'l', 'o', 'o', 'o', 'h', 'k', 'k'},
                {'m', 'm', 'p', 'm', 'r', 'm', 'k', 'k'},
                {'e', 'o', 'e', 'e', 'j', 'j', 'e', 'k'}
        };

        List<Word> list = detectAllWords(crossword, "home", "same");
        for (Word word : list)
        {
            System.out.println(word);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {

        List<Word> wds = new ArrayList<Word>();
        Word word;
        char[] leter;
        for (String wd : words)
        {

            leter = wd.toCharArray();
            for (int i = 0; i < crossword.length; i++)
            {
                for (int j = 0; j < crossword[i].length; j++)
                {
                    if (crossword[i][j] == (int) leter[0])
                    {
                        word = new Word(wd);
                        word.setStartPoint(j, i);
                        searchRound(crossword, word, wds);
                    }
                }
            }

        }
        return wds;
    }

    public static void searchRound(int[][] crossword, Word word, List<Word> wds)
    {
        int startx = word.startY;
        int starty = word.startX;

        int[] x = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] y = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        for (int q1 = 0; q1 < x.length; q1++)
        {
            if (!isMatrixBorder(startx + x[q1], starty + y[q1], crossword))
            {
                if (crossword[startx + x[q1]][starty + y[q1]] == (int) word.text.charAt(1))
                {
                    Word word1 = searchAllLetters(crossword, word, x[q1], y[q1]);
                    if (!word1.text.equals("!"))
                    {
                        wds.add(word1);
                    }
                }
            }
        }


    }

    public static Word searchAllLetters(int[][] crossword, Word word, int i, int j)
    {
        boolean wordFound = true;
        String wd = word.text;
        char[] wordInChars = word.text.toCharArray();
        int startx = word.startY;
        int starty = word.startX;
        int endx = word.startY;
        int endy = word.startX;

        for (int q1 = 1; q1 < wordInChars.length; q1++)
        {
            if (!isMatrixBorder(endx + i, endy + j, crossword))
            {
                if (crossword[endx + i][endy + j] == (int) wordInChars[q1])
                {
                    endx += i;
                    endy += j;
                } else wordFound = false;
            } else wordFound = false;
        }
        if (wordFound)
        {
         Word word1 = new Word(wd);
         word1.setStartPoint(starty,startx);
         word1.setEndPoint(endy, endx);
         return word1;
        }
        else return new Word("!");

    }


    public static boolean isMatrixBorder(int i, int j, int[][] crossword)
    {
        boolean isOutOfBorder = false;
        int i1;
        try
        {
            i1 = crossword[i][j];
        }
        catch (Exception e)
        {
            isOutOfBorder = true;
        }
        return isOutOfBorder;
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

