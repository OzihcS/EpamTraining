package ua.nure.piontkovskyi.Practice6.Part1;

import java.util.Comparator;

public class Word {

    private int frequency;
    private String word;

    public Word(String word) {
        frequency = 1;
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

}

class CompareByFrequency implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        return -(o1.getFrequency() - o2.getFrequency());
    }
}