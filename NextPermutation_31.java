public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static void nextPermutation(int[] nums) {
        //1.找到第一个升序对：i，i+1
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if (i<0){
            //说明是最大排序（降序），反转后即使所求的下一个排序（最小的）
            reverse(nums,0,nums.length-1);
            return;
        }

        //2.从后往前找第一个大于nums[i]的，同时也是最小的
        int j = nums.length-1;
        while (j>i && nums[j]<=nums[i]){
            j--;
        }

        //3.调换i，j。
        swap(nums,i,j);

        //4.此时nums[i+1]到末尾是降序，反转为升序使其最小。
        reverse(nums,i+1,nums.length-1);
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
