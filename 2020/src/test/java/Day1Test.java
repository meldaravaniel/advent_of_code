import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Given a list of numbers, find the two that sum to 2020, then find what they multiply to.
 */
public class Day1Test {

    @Test
    public void testTheThings() {
        Day1Answer answer = Day1.calculateAnswer(1721, 979, 366, 299, 675, 1456);
        assertNotNull(answer.sumPair);
        assertEquals(2, answer.sumPair.length);
        assertEquals(answer.sumPair[0], 1721);
        assertEquals(answer.sumPair[1], 299);
        assertEquals(514579, answer.sumPairProduct);
    }
}
