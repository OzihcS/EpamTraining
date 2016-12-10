package ua.nure.piontkovskyi.SummaryTask2;

/**
 *
 */
public class Word {

    private String word;

    /**
     * @param word
     */
    Word(String word) {
        this.word = word;
    }

    /**
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return word;
    }
}