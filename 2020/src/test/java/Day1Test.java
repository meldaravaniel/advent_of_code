import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Given a list of numbers, find the two that sum to 2020, then find what they multiply to.
 */
public class Day1Test {

    @Test
    public void testTheThings() {
        Day1Answer answer = Day1.calculateAnswer(Arrays.asList(1721, 979, 366, 299, 675, 1456));
        assertNotNull(answer);
        assertEquals(answer.addend1, 1721);
        assertEquals(answer.addend2, 299);
        assertEquals(514579, answer.addend1 * answer.addend2);
    }
}
