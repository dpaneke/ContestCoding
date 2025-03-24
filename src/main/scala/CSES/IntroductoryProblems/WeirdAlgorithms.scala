package CSES.IntroductoryProblems

import java.io.PrintWriter
import java.util.Scanner

object WeirdAlgorithms extends App {
  val in: Scanner = new Scanner(System.in)
  val out: PrintWriter = new PrintWriter(System.out)
  var n: Long = in.nextLong()
  while (n != 1) {
    out.print(n)
    out.print(' ')
    if (n % 2 == 0) {
      n /= 2
    } else {
      n = n * 3 + 1
    }
  }
  out.print(1)
  out.flush()
}
