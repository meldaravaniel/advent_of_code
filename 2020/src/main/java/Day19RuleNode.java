import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class Day19RuleNode {

    public List<Day19Rule> rules;

    public Day19RuleNode(List<Day19Rule> rules) {
        this.rules = rules;
    }

    public static Day19RuleNode makeRuleNode(String rule) {
        // is it the end node?
        if ("\"a\"".equals(rule) || "\"b\"".equals(rule)) {
            return new Day19RuleNode(singletonList(new Day19Rule(rule.substring(1,2), Day19RuleType.END)));
        }
        List<Day19Rule> rulesList = new ArrayList<>();
        String[] rulesText = rule.trim().split("\\s");
        for (String s : rulesText) {
            if ("|".equals(s)) {
                rulesList.add(new Day19Rule(null, Day19RuleType.OR));
            } else {
                rulesList.add(new Day19Rule(s, Day19RuleType.RULE));
            }
        }
        return new Day19RuleNode(rulesList);
    }
}
