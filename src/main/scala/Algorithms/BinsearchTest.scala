package Algorithms

object BinsearchTest extends App {
  val binsearcher0: BinSearch = new BinSearch(Array.emptyIntArray)
  val binsearcher1: BinSearch = new BinSearch(Array(2))
  val binsearcher2: BinSearch = new BinSearch(Array(2, 3))
  val binsearcher3: BinSearch = new BinSearch(Array(2, 3, 3))
  val binsearcher4: BinSearch = new BinSearch(Array(2, 2, 3, 3, 3, 4, 5, 12, 13, 14))

  val bsearchers: Array[BinSearch] = Array(
    binsearcher0, binsearcher1, binsearcher2, binsearcher3, binsearcher4
  )
  val i: Int = 4
  val x: Int = 3
  println(
    bsearchers(i).BinSearchLeft(x),
    bsearchers(i).BinSearchRight(x),
    bsearchers(i).contains(x)
  )
}
