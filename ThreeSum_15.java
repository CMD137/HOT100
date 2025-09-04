import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        //先排序，使得双向指针移动有逻辑、并且可以去重
        Arrays.sort(nums);

        //固定一个first，另外两个同向移动，遇到重复的连续跳过。当first>0就找不到了。
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;

            int left = first + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    left++;
                    right--;
                    //去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    //sum<0说明要往大走，即left右移
                    left++;
                    //去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    //对称逻辑
                    right--;
                    //去重
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }

}
