import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Day19Test {
    public static final String simpleTest = "day19_testInput_rules.txt";

    // going to cheat and put the inputs in two parts because I'm too fucking lazy to look for an empty line and change. :P

    @Test
    public void testMakeNodes() {
        Day19RuleNode node = Day19.makeNode("\"b\"");
        assertNotNull(node);
        assertEquals(1, node.rules.size());
        assertEquals("b", node.rules.get(0).instruction);
        assertEquals(Day19RuleType.END, node.rules.get(0).ruleType);
    }

    @Test
    public void testPart1_makeTheTreeFromInput() {
        assertFalse(Day19.test(simpleTest, "aaa"));
        assertTrue(Day19.test(simpleTest, "aab"));
    }
}
