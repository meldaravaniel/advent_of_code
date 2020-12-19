import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day19Test {
    public static final String simpleTest = "day19_testInput_rules.txt";

    // going to cheat and put the inputs in two parts
    // because I'm too fucking lazy to look for an empty line and change. :P

    @Test
    public void testMakeEndNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("\"b\"");
        assertNotNull(node);
        assertEquals(1, node.rules.size());
        assertEquals("b", node.rules.get(0).instruction);
        assertEquals(Day19RuleType.END, node.rules.get(0).ruleType);
    }

    @Test
    public void testMakeSinglePointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1");
        assertNotNull(node);
        assertEquals(1, node.rules.size());
        assertEquals("1", node.rules.get(0).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(0).ruleType);
    }

    @Test
    public void testMakeMultiplePointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1 3 2");
        assertNotNull(node);
        assertEquals(3, node.rules.size());
        assertEquals("1", node.rules.get(0).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(0).ruleType);
        assertEquals("3", node.rules.get(1).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(1).ruleType);
        assertEquals("2", node.rules.get(2).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(2).ruleType);
    }

    @Test
    public void testMakeORPointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1 | 3 2");
        assertNotNull(node);
        assertEquals(4, node.rules.size());
        assertEquals("1", node.rules.get(0).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(0).ruleType);
        assertNull(node.rules.get(1).instruction);
        assertEquals(Day19RuleType.OR, node.rules.get(1).ruleType);
        assertEquals("3", node.rules.get(2).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(2).ruleType);
        assertEquals("2", node.rules.get(3).instruction);
        assertEquals(Day19RuleType.RULE, node.rules.get(3).ruleType);
    }

    @Test
    public void testPart1_makeTheTreeFromInput() {
        assertFalse(Day19.test(simpleTest, "aaa"));
        assertTrue(Day19.test(simpleTest, "aab"));
    }
}
