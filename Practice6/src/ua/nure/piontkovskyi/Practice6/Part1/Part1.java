package ua.nure.piontkovskyi.Practice6.Part1;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Part1 {

    private WordContainer container;
    private String[] arr;

    public Part1() {
        this.arr = read();
        container = new WordContainer();
        fill();
    }

    public final String[] read() {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in, "CP1251");
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
            break;
        }
        sc.close();
        return sb.toString().split(" ");
    }

    public final void fill() {
        for (int i = 0; i < arr.length; i++) {
            container.add(new Word(arr[i]));
        }
        Collections.sort(container.getArr(), new CompareByFrequency());
    }

    public String output() {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Word> iterator = container.getArr().iterator(); iterator
                .hasNext(); ) {
            Word word = iterator.next();
            sb.append(word.getWord() + ":" + word.getFrequency()
                    + System.lineSeparator());

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        System.out.println(part1.output());
    }

}
