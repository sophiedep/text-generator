/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javamonkey.textgenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author mcory
 */
public final class Parser {
    private Parser() { }
    
    public static List<WordData> parse(final String str) {
        Validate.notBlank(str, "String must be provided.");
        
        final String alphaOnlyLC = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase().trim();
        final Map<String, Integer> wordMap = buildWordMap(alphaOnlyLC);
        final Set<Entry<String, Integer>> wordMapEntrySet = wordMap.entrySet();
        final List<WordData> res = new ArrayList<WordData>(wordMapEntrySet.size());
        for (final Map.Entry<String, Integer> entry : wordMapEntrySet) {
            final WordData wordData = new WordData(entry.getKey(), entry.getValue());
            res.add(wordData);
        }
        return res;
    }
    
    private static Map<String, Integer> buildWordMap(final String alphaOnlyLC) {
        final String[] parts = alphaOnlyLC.split("\\s");
        final Map<String, Integer> res = new HashMap<String, Integer>(parts.length);
        
        for (final String part : parts) {
            if (StringUtils.isBlank(part)) {
                continue;
            }
            
            final Integer count;
            if (res.containsKey(part)) {
                count = res.get(part) + 1;
            } else {
                count = 1;
            }
            
            res.put(part, count);
        }
        
        return res;
    }
}
