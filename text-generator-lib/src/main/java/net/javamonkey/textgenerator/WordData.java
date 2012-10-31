/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javamonkey.textgenerator;

import org.apache.commons.lang3.Validate;

/**
 *
 * @author mcory
 */
public final class WordData {
    
    public WordData(final String word, final int count) {
        Validate.notBlank(word, "Word must be provided.");
        Validate.isTrue(count > 0, "Count must be greater than zero.");
        
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
    
    private final String word;
    private final int count;
}
