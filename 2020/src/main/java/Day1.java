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

    public static Day1Answer calculateTripartiteAnswer(List<Integer> input) {
        return null;
    }
}
