package com.mycompany.sistempakar;
import java.util.*;

public class InferenceForwardChaining {
    
    public static Set<String> doForwardChaining(List<Rule> rules, Set<String> facts)
    {
        // Apply forward chaining with loop detection
        Set<String> inferedFacts = new HashSet<>();
        while (true) {
            boolean infered = false;
            for (Rule rule : rules) {
            if (facts.containsAll(rule.getAntecedent()) && !inferedFacts.contains(rule.getConsequent())) {
                facts.add(rule.getConsequent());
                inferedFacts.add(rule.getConsequent());
                infered = true;
                break;
}
            }
            if (!infered) {
                break;
            }
        }
        
        return inferedFacts;
    }
      
}