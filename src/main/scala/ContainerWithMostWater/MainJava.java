package ContainerWithMostWater;

import java.util.Scanner;
public class MainJava {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        SolutionJava solution = new SolutionJava();
        System.out.println(solution.maxArea(height));
    }
}
