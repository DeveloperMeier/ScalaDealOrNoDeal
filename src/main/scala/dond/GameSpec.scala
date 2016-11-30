package dond

abstract class GameSpec {
  case class Case(caseNumber: Int, caseValue: Int)
  val possibleValues: List[Int] = List(1, 10, 100, 200, 250,
    500, 1000, 1500, 2500, 5000, 10000, 30000, 50000, 100000,
    150000, 300000, 450000, 900000, 1000000, 10000000
  ) // 20 Values hard coded for now
  def init: List[Case]
}
