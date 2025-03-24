import java.util.Arrays;
// LC : 169. Majority Element
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int item = 0, count = 0;

        for (int num : nums) {
            // if (count == 0)
            //     item = num;
            // count += (num == item) ? 1 : -1;

            // The above commented code can be written as below

            if (count++ == 0)
                item = num;

            else if (num == item)
                count++;

            else
                count--;
        }
        return item;
    }

    public static void main(String[] args) {
        int[] numbers = {2,2,1,1,1,2,2};
        System.out.println("Find majority element from " + Arrays.toString(numbers));
        System.out.println("Majority Element : " + majorityElement(numbers));
    }
}