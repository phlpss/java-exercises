import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var maxCandies = Arrays.stream(candies).max().getAsInt();
        var result = new ArrayList<Boolean>(candies.length);
        for (var candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }
}
