package MyLoop

object Main extends App with Loop{
  def reversedString(s: String): String = {
    var reversed = ""
    loop(s.length - 1, _ >= 0, _ - 1) { i =>
      reversed += s(i)
    }
    reversed
  }

  println(reversedString("qazwsxedc"))
}

trait Loop {
  def loop(init: Int, constr: Int => Boolean, next: Int => Int)
          (block: Int => Any): Unit = {
    var i = init
    while (constr(i)){
      block(i)
      i = next(i)
    }
  }
}