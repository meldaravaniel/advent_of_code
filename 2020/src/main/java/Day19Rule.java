import java.util.Objects;

public class Day19Rule {
    public String instruction;
    public Day19RuleType ruleType;

    public Day19Rule(String rule, Day19RuleType type) {
        this.instruction = rule;
        this.ruleType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day19Rule day19Rule = (Day19Rule) o;
        return Objects.equals(instruction, day19Rule.instruction) &&
                ruleType == day19Rule.ruleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instruction, ruleType);
    }

    public boolean isEndNode() {
        return this.instruction != null;
    }
}
