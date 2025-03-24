import java.util.Arrays;
// LC : 283. Move Zeroes
public class MovesZeros {
    public static void moveZeroes(int[] nums) {
        int temp;
        for (int lastNonZero = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                temp = nums[cur];
                nums[cur] = nums[lastNonZero];
                nums[lastNonZero++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        System.out.println("Before moving zeros" + Arrays.toString(numbers));
        moveZeroes(numbers);
        System.out.println("After moving zeros" + Arrays.toString(numbers));
    }
}
