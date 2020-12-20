import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Day19RuleNode {


    public static final Pattern END_NODE = Pattern.compile("\".\"");
    public List<List<String>> rules = new ArrayList<>();
    public String letter;

    public Day19RuleNode(List<List<String>> rules) {
        this.rules = rules;
    }

    public Day19RuleNode(String letter) {
        this.letter = letter;
    }

    public static Day19RuleNode makeRuleNode(String rule) {
        // is it the end node?
        if (END_NODE.matcher(rule).matches()) {
            return new Day19RuleNode(rule.replace("\"", ""));
        }
        List<List<String>> rulesList = new ArrayList<>();
        // Split on the "or" pipe if present
        String[] split = rule.trim().split("\\|");
        for (String s : split) {
            // add the split arrays to the array for arrays all the way down.
            rulesList.add(asList(s.trim().split("\\s")));
        }
        return new Day19RuleNode(rulesList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day19RuleNode that = (Day19RuleNode) o;
        return Objects.equals(rules, that.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rules);
    }
}
