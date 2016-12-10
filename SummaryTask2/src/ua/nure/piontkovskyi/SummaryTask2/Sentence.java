package ua.nure.piontkovskyi.SummaryTask2;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Sentence {

    private List<Word> sentence = new ArrayList<>();

    /**
     *
     * @param s
     */
    public Sentence(String[] s) {
        for (int i = 0; i < s.length; i++) {
            sentence.add(new Word(s[i]));
        }
    }

    /**
     *
     * @return
     */
    public List<Word> getSentence() {
        return sentence;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w : sentence) {
            sb.append(w).append(" ");
        }
        return sb.toString();
    }
}
