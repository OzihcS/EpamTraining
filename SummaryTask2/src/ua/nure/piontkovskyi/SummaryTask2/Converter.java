package ua.nure.piontkovskyi.SummaryTask2;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Converter {


    private List<Sentence> sentences = new ArrayList<>();
    private int wordLength;

    /**
     * @param wordLength
     */
    public Converter(int wordLength) {
        this.wordLength = wordLength;
    }

    /**
     * @param fileName
     * @throws FileNotFoundException
     */
    public void getInput(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName), "UTF-8");
        while (scanner.hasNextLine()) {
            sentences.add(new Sentence(scanner.nextLine().split(" ")));
        }
        scanner.close();
    }

    /**
     * @return
     */
    public String convert() {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("([\u0430\u043E\u044D\u0438\u0443\u044B\u0435\u0451\u044E\u044F" +
                "\u0410\u041E\u042D\u0418\u0423\u042B\u0415u\0401\u042E\u042F]*)", Pattern.UNICODE_CHARACTER_CLASS);
        for (Sentence sentence : sentences) {
            for (Word word : sentence.getSentence()) {
                if (word.getWord().length() == wordLength) {
                    Matcher m = p.matcher(word.getWord());
                    m.find();
                    if (!m.group().equals("")) {
                        sb.append(word.toString()).append(" ");
                    }
                } else {
                    sb.append(word.toString()).append(" ");
                }
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Converter c = new Converter(7);
        c.getInput(args[0]);
        System.out.println(c.convert());
    }
}