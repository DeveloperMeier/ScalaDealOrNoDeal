object Main {
  def main(args: Array[String]): Unit = {
    val cases: List[Game.Case] = Game.init
    println("Cases In Main")
    prettyPrint[Game.Case](cases, 5)
    println(s" Case Value in case 1: #${Game.pickCase(1, cases).map(_.caseNumber).getOrElse("")}  ==> $$${Game.pickCase(1, cases).map(_.caseValue).getOrElse(0)}")
  }

  // This doesn't work right... Not sure why. Debug output in #1 below
  // TODO: should also return a matrix divided at m for example:
  /**List[List[Game.Case]] where List(1)=List(Case 1, Case, 2, Case 3, Case 4, Case 5) when m = 5 */
  def prettyPrint[T](l: List[T], m: Int, acc: List[T] = List.empty): Unit = {
    if (l.length == 0)  return ()
    if (acc.size <= m) {
      if (acc.size == m) {
          acc.map(Game.caseDisplay[T](_)).map(println)
          if (l.size <= m) l.map(Game.caseDisplay[T](_)).map(println)
          prettyPrint(l.drop(1), m, List.empty)
      } else {
        prettyPrint(l.drop(1), m, acc ++ List(l.take(1)))
      }
    }
  }
}


