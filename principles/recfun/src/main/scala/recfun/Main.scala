package recfun

import scala.annotation.tailrec
import scala.collection.mutable.MutableList


object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ((c == r) && (r == 1)) {
        return 1
      }
      pascal(c-1, r-1) + pascal(c-1, r)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def subBalance(chars: List[Char], state: Int): Boolean = (chars, state) match {
        case (c, 0) if c.isEmpty => true
        case (c, _) if c.isEmpty => false
        case ('(' :: c, s) => subBalance(c, s + 1)
        case (')' :: c, s) => if (s > 0) subBalance(c, s - 1) else false
        case (c, s) => subBalance(c.tail, s)
      }

      subBalance(chars, 0)
    }
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeTotal(money: Int, coins: List[Int], total: Int): Int = {
        if (total == money) {
            return 1
        }
        else if (total > money) {
          return 0
        }

        var ways = 0

        coins.foreach((i: Int) => ways += countChangeTotal(money, coins, total + i))

        ways
      }

      countChangeTotal(money, coins, 0)
    }
  }
