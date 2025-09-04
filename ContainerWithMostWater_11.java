public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int result = 0;
        while (!(left==right)){
            int tHeight=Math.min(height[left],height[right]);
            int size = tHeight*(right-left);
            if (size>result){
                result=size;
            }
            if (height[left]==tHeight){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }
}
