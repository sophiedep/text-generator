/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javamonkey.textgenerator.core;

import net.javamonkey.textgenerator.core.WordData;
import java.util.Comparator;

/**
 *
 * @author mcory
 */
public class WordDataCountComparator implements Comparator<WordData> {

    @Override
    public int compare(WordData o1, WordData o2) {
        return (Integer.compare(o1.getCount(), o2.getCount()));
    }
    
}
