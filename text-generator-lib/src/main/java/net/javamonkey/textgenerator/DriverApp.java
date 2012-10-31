/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javamonkey.textgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mcory
 */
public class DriverApp {
    public static final WordDataCountComparator WORD_DATA_COUNT_COMPARATOR = new WordDataCountComparator();
    public static void main(final String... args) {
        final DriverApp app = new DriverApp();
        app.loadFromResource("/StringTokenizerDescription.txt");
        final Collection<WordData> wordData = app.parseText();
        System.err.println("Word data: " + wordData.size());
        final int totalWordCount = app.getTotalWordCount(wordData);
        System.err.println("Total Word Count: " + totalWordCount);
        System.err.println("===================");
        for (final WordData wd : wordData) {
            System.err.println("\tWord: '" + wd.getWord() + "'");
            System.err.println("\tCount: " + wd.getCount());
            System.err.println("===================");
        }
    }
    
    public void loadFromResource(final String resourceName) {
        final InputStream resStream = getClass().getResourceAsStream(resourceName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resStream));
        final StringBuffer sb = new StringBuffer();
        
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        this.text = sb.toString();
    }
    
    public Collection<WordData> parseText() {
        final List<WordData> res = Parser.parse(text);
        if (res != null) {
            Collections.sort(res, WORD_DATA_COUNT_COMPARATOR);
        }
        return res;
    }

    public int getTotalWordCount(final Collection<WordData> wordData) {
        int res = 0;
        for (final WordData wd : wordData) {
            res += wd.getCount();
        }
        return res;
    }
    
    private String text;
}
