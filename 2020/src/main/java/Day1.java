import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource = Day1.class.getClassLoader().getResource("day1_input.txt");
        File file = Paths.get(resource.toURI()).toFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Integer> numbers = new ArrayList<>();
        boolean end = false;
        while (!end)
        try{
            Integer number = Integer.parseInt(bufferedReader.readLine());
            numbers.add(number);
        } catch (NumberFormatException e) {
            end = true;
        }

        Day1Answer day1Answer = calculateAnswer(numbers);
        System.out.println("First number is " + day1Answer.addend1 +
                "; second is " + day1Answer.addend2 + ".  Product is "
                + day1Answer.addend1 * day1Answer.addend2 + ".");

        Day1Answer day1Answer2 = calculateTripartiteAnswer(numbers);
        System.out.println("First number is " + day1Answer2.addend1 +
                "; second is " + day1Answer2.addend2 +
                "; third is " + day1Answer2.addend3 +
                ".  Product is "
                + day1Answer2.addend1 * day1Answer2.addend2 * day1Answer2.addend3 + ". " +
                "Let's double check: " + (day1Answer2.addend1 + day1Answer2.addend2 + day1Answer2.addend3));
    }

    /**
     * You could go brute force, but where's the fun in that?
     *
     * We know we have to add up to 2020, so let's instead just
     * figure out what the mate of each number is, then see if
     * that mate exists in the list.  Stop when we find it, since
     * we were told there's only one.
     *
     * Complexity: N
     *
     * Technically speaking it's N-1, since the worst
     * case scenario is that your numbers are right next to each other,
     * at the end of the list.  But that boils down to N.
     *
     * @param input
     * @return
     */
    public static Day1Answer calculateAnswer(List<Integer> input) {
        for (Integer number : input) {
            int mate = 2020 - number;
            if (input.contains(mate)) {
                return new Day1Answer(number, mate);
            }
        }
        return null;
    }

    /**
     * Find the three numbers that add to 2020.  Using similar method
     * as above, but a nested loop now.
     *
     * Complexity: N^2 ish.
     *
     * I tweaked it a bit because you don't have to start searching at
     * the 0th index every time through, knowing there's only one answer.
     *
     * @param input
     * @return
     */
    public static Day1Answer calculateTripartiteAnswer(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int currentNumber = input.get(i);
            // This is what we need to add to with our next two numbers.
            int remainder = 2020 - currentNumber;
            // don't need to start at the beginning of the list every time, so this gets a little more efficient as you search...
            for (int k = i + 1; k < input.size(); k++) {
                int otherNumber = input.get(k);
                int mate = remainder - otherNumber;
                if (input.subList(k+1, input.size()).contains(mate)) {
                    return new Day1Answer(currentNumber, otherNumber, mate);
                }
            }
        }
        return null;
    }
}
