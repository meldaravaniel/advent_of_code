import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day19 {

    /*
    Ideas:

    * want to make the rules, obviously have to be able to parse those to do
        anything at all.
        * could hold in a graph/tree thing
        * could hold in a map thing (but how would you store the "OR" nodes?
        * could hold in a linked list...
        started with a map, but I think a tree is better. The input *does* start
        with the 0 node, so I can build the root first and go from there.

        So....okay but once I have the first one, I need to grab 8 and 11, so really
        I need them in a mapish thing first so I can grab them without iterating over
        and over.  So first loop through the lines of the file, grab all instructions
        and don't parse further, just store in a map.  Let's redo that then, shall we?

        Can use a Trie to test the messages against what the rules are...
        1) make the rules map
        2) populate a Trie will all possible messages in the rules map
        3) loop through the inputMessages and test them against the trie, counting positives.
     */

    public static void main(String[] args) throws URISyntaxException, IOException {

    }

    static Map<String, Day19RuleNode> makeRawRulesMap(String fileName) throws URISyntaxException, IOException {
        URL resource = Day1.class.getClassLoader().getResource(fileName);
        File file = Paths.get(resource.toURI()).toFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, Day19RuleNode> rawRules = new HashMap<>();
        String rawRule = bufferedReader.readLine();
        while (rawRule != null) {
            String[] splitRule = rawRule.split(":");
            rawRules.put(splitRule[0], Day19RuleNode.makeRuleNode(splitRule[1].trim()));
            rawRule = bufferedReader.readLine();
        }
        return rawRules;
    }

    public static Map<String, Day19RuleNode> makeRuleMap(List<String> rules) {
        return rules.stream().collect(Collectors.toMap(
                rule -> rule.split(":")[0],
                rule -> Day19RuleNode.makeRuleNode(rule.split(":")[1])));
    }

    public static Day19RuleNode makeRuleGraph(String startingNode, Map<String, String> rawRulesMap) {
        return null;
    }

    public static List<String> getMessagesFromRules(String nodeId, List<String> matchingMessages,
                                                    Map<String, Day19RuleNode> rawRulesMap) {
        Day19RuleNode node = rawRulesMap.get(nodeId);

//        node.
        return matchingMessages;
    }
}
