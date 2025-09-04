public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        int zeroP = 0;
        int p = 0;

        for (; p < nums.length; p++) {
            if (nums[p]!=0){
                int temp = nums[p];
                nums[p] = nums[zeroP];
                nums[zeroP] = temp;
                zeroP++;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
