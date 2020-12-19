import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day19Test {
    public static final String simpleTest = "day19_testInput_rules.txt";

    // going to cheat and put the inputs in two parts because I'm too fucking lazy to look for an empty line and change. :P

    @Test
    public void testPart1_makeTheTreeFromInput() {
        assertFalse(Day19.test(simpleTest, "aaa"));
        assertTrue(Day19.test(simpleTest, "aab"));
    }
}
