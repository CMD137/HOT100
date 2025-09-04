import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive128 {
    public static void main(String[] args) {
        int[] nums1={100,4,200,1,3,2};
        int[] nums2={0,3,7,2,5,8,4,6,0,1};
        int[] nums3={1,0,1,2};

        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));
    }

    public static int  longestConsecutive(int[] nums){
        // 将数组转换为集合以删除重复元素
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;

        for (int num : numSet) {
            // 只有当num是序列的起始元素时才开始计数
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // 向右扩展计数
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }

                ans = Math.max(ans, currentLen);
            }
        }

        return ans;
    }
}
