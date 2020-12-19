import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Given a list of numbers, find the two that sum to 2020, then find what they multiply to.
 */
public class Day1Test {

    public static final List<Integer> INPUT = Arrays.asList(1721, 979, 366, 299, 675, 1456);

    @Test
    public void testTheThings_part1() {
        Day1Answer answer = Day1.calculateAnswer(INPUT);
        assertNotNull(answer);
        assertEquals(answer.addend1, 1721);
        assertEquals(answer.addend2, 299);
        assertEquals(514579, answer.addend1 * answer.addend2);
    }

    @Test
    public void testFindThree() {
        Day1Answer answer = Day1.calculateTripartiteAnswer(INPUT);
        assertNotNull(answer);
        assertEquals(241861950, answer.addend1 * answer.addend2 * answer.addend3);
    }
}
