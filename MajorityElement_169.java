public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //有已知条件：数组非空、存在多数元素。有因为出现次数 大于 ⌊ n/2 ⌋ ，所以有且仅有一个多数元素。
        //遍历所有元素，不相同的抵消，剩下的就是只有所求的“多数元素”。
        //抵消操作：对于当前元素计数count，遇到相同元素，计数+1，遇到不同的元素，计数-1；当计数为0时，将当前元素作为新的候选元素。

        int count = 0;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count==0){
                current=nums[i];
            }
            if (nums[i]==current){
                count++;
            }else {
                count--;
            }
        }

        return current;
    }
}
