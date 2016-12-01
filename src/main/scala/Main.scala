object Main {
  def main(args: Array[String]): Unit = {
    val cases: List[Game.Case] = Game.init
    println("Cases In Main")
    // Hackish Pretty Print
    val c: (List[Game.Case], List[Game.Case]) = cases.splitAt(cases.size / 2)
    //c._1.zip(c._2).map(println)
    prettyPrint[Game.Case](cases, 5, List.empty)

  }

  // This doesn't work right... Not sure why. Debug output in #1 below
  def prettyPrint[T](l: List[T], m: Int, acc: List[T]): Unit = {
    val sepString = " | "
    //println(s"l.size ==> ${l.size}, acc.size ==> ${acc.size}")
    if (l.size <= m) println(s"l -- ${l.mkString(sepString)}")
    if (acc.size == m) println(s"s -- ${acc.mkString(sepString)} ")
    prettyPrint(l filterNot(_ == l.last), m, (acc ++ List(l.last)))
  }

  /**
    * #1 First hackish pretty print
    *
      Successfully Allocated and Scrambled Cases
      Cases In Main
      (Case(0,30000),Case(10,250))
      (Case(1,50000),Case(11,300000))
      (Case(2,200),Case(12,1500))
      (Case(3,1000000),Case(13,900000))
      (Case(4,450000),Case(14,10000000))
      (Case(5,2500),Case(15,150000))
      (Case(6,500),Case(16,10))
      (Case(7,100000),Case(17,100))
      (Case(8,5000),Case(18,1000))
      (Case(9,1),Case(19,10000))
    */

  /** #2 Pretty Print Debug output
    * Successfully Allocated and Scrambled Cases
      Cases In Main
      s -- Case(19,450000) | Case(18,200) | Case(17,1) | Case(16,100000) | Case(15,5000)
      l -- Case(0,10) | Case(1,1000000) | Case(2,1500) | Case(3,50000) | Case(4,500)
      l -- Case(0,10) | Case(1,1000000) | Case(2,1500) | Case(3,50000)
      l -- Case(0,10) | Case(1,1000000) | Case(2,1500)
      l -- Case(0,10) | Case(1,1000000)
      l -- Case(0,10)
      l --
    */
}


