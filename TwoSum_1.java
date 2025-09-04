import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1.两数之和
class Solution {
    //1.暴力for循环
    public int[] twoSum1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i]+nums[j]==target)
                        return new int[]{i,j};
                }
            }
            return null;
    }


    //2.哈希表
    /*
    为什么使用哈希表？
    ：要判断这个元素是否出现过/在这个集合
    遍历到n，则需要判断target-n是否出现过
    为什么用map
    使用map：key：元素；value：下标
     */
    public int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int k = target- nums[i];
            if (map.containsKey(k))
                return new int[]{i, (int) map.get(k)};
            else
                map.put(nums[i],i);
        }
        return null;
    }
}

public class TwoSum_1 {
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,4};
        int target=6;
        Solution solution=new Solution();

        //1
        System.out.println("@1:\n"+ Arrays.toString(solution.twoSum1(arr,target)));
        //2
        System.out.println("@1:\n"+ Arrays.toString(solution.twoSum2(arr,target)));

    }
}
