import java.util.Arrays;

public class offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int expect = Integer.MAX_VALUE;
        int aux = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                aux++;
            } else {
                start = i;
                break;
            }
        }
        expect = nums[start];
        while (start < nums.length) {
            while (nums[start] != expect) {
                aux--;
                expect++;
                if (aux < 0) return false;
            }
            expect++;
            start++;
        }
        return true;
    }

}
