import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class Day19Test {
    public static final String simpleTest = "day19_testInput_rules.txt";

    // going to cheat and put the inputs in two parts
    // because I'm toofa king lazy to look for an empty line and change. :P

    @Test
    public void testMakeEndNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("\"b\"");
        assertNotNull(node);
        assertTrue(node.rules.isEmpty());
        assertEquals("b", node.letter);
    }

    @Test
    public void testMakeSinglePointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1");
        assertNotNull(node);
        assertEquals(1, node.rules.size());
        List<String> rulesRules = node.rules.get(0);
        assertEquals(1, rulesRules.size());
        assertEquals("1", rulesRules.get(0));
    }

    @Test
    public void testMakeMultiplePointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1 3 2");
        assertNotNull(node);
        assertEquals(1, node.rules.size());
        List<String> rulesRules = node.rules.get(0);
        assertEquals(3, rulesRules.size());
        assertEquals("1", rulesRules.get(0));
        assertEquals("3", rulesRules.get(1));
        assertEquals("2", rulesRules.get(2));
        assertNull(node.letter);
    }

    @Test
    public void testMakeORPointerNode() {
        Day19RuleNode node = Day19RuleNode.makeRuleNode("1 | 3 2");
        assertNotNull(node);
        assertNull(node.letter);
        assertEquals(2, node.rules.size());

        List<String> rules0 = node.rules.get(0);
        assertEquals(1, rules0.size());
        assertEquals("1", rules0.get(0));

        List<String> rules1 = node.rules.get(1);
        assertEquals(2, rules1.size());
        assertEquals("3", rules1.get(0));
        assertEquals("2", rules1.get(1));
    }

    @Test
    public void testMakeMapOfRules() throws IOException, URISyntaxException {
        Map<String, Day19RuleNode> rawRulesMap = Day19.makeRawRulesMap("day19_testInput_rules.txt");
        assertNotNull(rawRulesMap);
        assertEquals(4, rawRulesMap.size());
        assertEquals(asList(asList("1", "2")), rawRulesMap.get("0").rules);

        assertTrue(rawRulesMap.get("1").rules.isEmpty());
        assertEquals("a", rawRulesMap.get("1").letter);

        assertEquals(asList(asList("1", "3"), asList("3", "1")), rawRulesMap.get("2").rules);

        assertTrue(rawRulesMap.get("3").rules.isEmpty());
        assertEquals("b", rawRulesMap.get("3").letter);
    }

    @Test
    public void testGetAnswer() throws IOException, URISyntaxException {
        Map<String, Day19RuleNode> rawRulesMap = Day19.makeRawRulesMap("day19_testInput_rules.txt");
        List<String> matchingMessages = new ArrayList<>();
        matchingMessages = Day19.getMessagesFromRules("0", matchingMessages, rawRulesMap);
        assertEquals(2, matchingMessages.size());
        assertTrue(matchingMessages.contains("aab"));
        assertTrue(matchingMessages.contains("aba"));
    }

}
