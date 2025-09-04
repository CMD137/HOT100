public class SortColors_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public static void sortColors(int[] nums) {
        int zero = 0;
        int two =nums.length-1;
        for (int i = 0; i <= two; i++) {
            while (nums[i]==2 && i<=two){
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                two--;
            }

            if (nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}
