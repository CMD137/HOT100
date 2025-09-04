//136. 只出现一次的数字
public class SingleNumber_136 {
    static class Solution {
        //异或运算有加法律和结合律;自身异或为0；与0异或不变
        public int singleNumber(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result=result^nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        int single = solution.singleNumber(nums);
        System.out.println("只出现一次的数字是: " + single);
    }

}
