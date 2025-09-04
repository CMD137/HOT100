public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        //时间复杂度为 O (n)，空间复杂度为 O (1)。
        int ans=0;
        int left = 0;
        int right = height.length-1;
        int preMax = 0;
        int sufMax = 0;

        while (left<=right){
            //更新前缀最大值和后缀最大值
            preMax = Math.max(height[left],preMax);
            sufMax = Math.max(height[right],sufMax);

            //当前位置接水高度取决于左右边界中较小的值
            if (preMax<sufMax){
                //如果当前前缀最大值小于后缀最大值，那么前缀最大值就是要求的“较小的值”，因为后缀最大值不能更小了。
                ans+=preMax-height[left];
                left++;
            }else {
                //同理对称，此处包含相等的逻辑，相等时谁减底座都一样。
                ans+=sufMax-height[right];
                right--;
            }
        }

        return ans;
    }
}
