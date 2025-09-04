public class FindtheDuplicateNumber_287 {
    public static void main(String[] args){
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        //快慢指针（龟兔赛跑 Floyd 判环算法）
        //nums【i】的值就是下个元素的索引，这样就能构造出一个链表，而如果有重复元素，部分元素就会成环，使用快慢指针（龟兔赛跑 Floyd 判环算法）来找到这个重复元素
        //初始化，兔子每次多跑一步
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];


        //S1：再环内相遇（不一定是重复点）
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Step 2: 找到入环点（即重复的数字）
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
