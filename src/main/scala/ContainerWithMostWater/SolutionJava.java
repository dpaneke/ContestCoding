package ContainerWithMostWater;
public class SolutionJava {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int curAreaMax = area(left, right, height);
        while (left < right) {
            int newArea = area(left, right, height);
            if (newArea > curAreaMax) {
                curAreaMax = newArea;
            }
            if (height[left] < height[right]) left++;
            else right --;
        }
        return curAreaMax;
    }

    private int area(int i, int j, int[] height) {
        return Math.min(height[i], height[j]) * (j - i);
    }
}
