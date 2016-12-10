package ua.nure.piontkovskyi.Practice4.Part4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Iterable<String> {

    private Matcher matcher;

    Parser(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(fileName), "CP1251");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            matcher = Pattern.compile("\\p{javaUpperCase}.*?\\.").matcher(sb);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ParserIterator(matcher);
    }

    private static class ParserIterator implements Iterator<String> {

        private Matcher matcher;

        ParserIterator(Matcher matcher) {
            this.matcher = matcher;
        }

        @Override
        public boolean hasNext() {
            return matcher.find();
        }

        @Override
        public String next() {
            return matcher.group();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
