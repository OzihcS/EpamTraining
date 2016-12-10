package ua.nure.piontkovskyi.Practice6.Part1;

import java.util.ArrayList;
import java.util.List;

public class WordContainer {

    private List<Word> arr = new ArrayList<>();

    public List<Word> getArr() {
        return arr;
    }

    public void add(Word word) {
        for (Word w : arr) {
            if (w.getWord().equals(word.getWord())) {
                w.setFrequency(w.getFrequency() + 1);
                continue;
            }
        }
        arr.add(word);
    }
}
