package ContainerWithMostWater

object Solution {
  def maxArea(height: Array[Int]): Int = {
    var left: Int = 0
    var right: Int = height.length - 1
    var curAreaMax: Int = area(left, right, height)
    while (left < right) {
      val newArea: Int = area(left, right, height)
      if (newArea > curAreaMax) {
        curAreaMax = newArea
      }
      if (height(left) < height(right)) {
        left += 1
      } else {
        right -= 1
      }
    }
    curAreaMax
  }
  def area(i: Int, j: Int, height: Array[Int]): Int =
    scala.math.min(height(i), height(j)) * (j - i)
}
