package com.example.task1;

public class TextConvertToAnagram {

    /**
     * start a process of converting - split text for anagram into individual words and create array of words
     * @return built anagram
     */
    public static String convertToAnagram(String textForAnagram, String filterForAnagram) {
        String[] wordsForAnagram = textForAnagram.split(" ");
        symbolsInWordsReverse(wordsForAnagram, filterForAnagram);

        return buildOfAnagram(wordsForAnagram);
    }

    /**
     * loop which direct each word to reverse
     */
    public static void symbolsInWordsReverse(String[] words, String filter) {
        for (int i = 0; i < words.length; i++) {
            words[i] = symbolsReverse(words[i], filter);
        }
    }

    /**
     * reverse each word taking into account filter symbols - keep position of symbols from filter
     * check each symbol - doesn't take into account digits and non alphabetic symbols
     * @return reversed and filtered word
     */
    public static String symbolsReverse(String word, String filter) {
        char[] symbols = word.toCharArray();

        if (filter.isEmpty()) {
            for (int i = 0, j = symbols.length - 1; i < j; i++, j--) {
                while (Character.isAlphabetic(symbols[i]) && i < j) {
                    i++;
                }
                while (Character.isAlphabetic(symbols[i]) && j > i) {
                    j--;
                }
                char tmp = symbols[i];
                symbols[i] = symbols[j];
                symbols[j] = tmp;
            }
        } else {
            for (int i = 0, j = symbols.length - 1; i < j; i++, j--) {
                while (filterCheck(symbols[i], filter.toCharArray()) && i < j) {
                    i++;
                }
                while (filterCheck(symbols[j], filter.toCharArray()) && j > i) {
                    j--;
                }
                char tmp = symbols[i];
                symbols[i] = symbols[j];
                symbols[j] = tmp;
            }
        }
        return new String(symbols);
    }

    /**
     * checking symbols - comparison with symbols from filter
     * @return true symbol anf filter are equal and false if no
     */
    public static boolean filterCheck(char symbolToCheck, char[] filterSymbols) {
        for (char filterSymbol : filterSymbols) {
            if (filterSymbol == symbolToCheck) {
                return true;
            }
        }
        return false;
    }

    /**
     * building anagram from reversed words
     * @return built anagram
     */
    public static String buildOfAnagram(String[] wordsAfterReverse) {
        StringBuilder resultString = new StringBuilder();
        int lastIndex = wordsAfterReverse.length - 1;

        for (int i = 0; i < lastIndex; i++) {
            resultString.append(wordsAfterReverse[i]).append(" ");
        }
        resultString.append(wordsAfterReverse[lastIndex]);

        return resultString.toString();
    }
}

