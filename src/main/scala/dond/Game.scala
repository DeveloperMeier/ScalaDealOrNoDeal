import dond.GameSpec

import scala.util.Random

object Game extends GameSpec {

  override def init: List[Case] = {
    genCase()._1
  }

  override def pickCase(n: Int, cases: List[Case]): Option[Case] = cases.find(x => x.caseNumber == n)

  override def caseDisplay[T](c: T): String = {
    c match {
      case c1: List[Game.Case] =>  s"|  ${c1.map(_.caseNumber).head}   |\t"
      case _ => ""
    }
  }

  private def flattenCasePossibilities = for {
    (e, i) <- possibleValues.zipWithIndex
  } yield Case(i, e)

  private def genCase(assigned: List[Case] = List.empty, remaining: List[Case] = flattenCasePossibilities): (List[Case], List[Case]) = remaining.length match {
    case 1 => {
      val scrambledFinal = (
        // Just to scramble them up based on whatever random order they ended up in assigned
        for {(e, i) <- (assigned ++ List(remaining.last)).zipWithIndex} yield Case(i, e.caseValue),
        List.empty
      )
      println(s"Successfully Allocated and Scrambled Cases")
      scrambledFinal
    }
    case _ => {
      // Basically the only non-pure part...is there a pure way to randomize I wonder...?
      val r = Random.nextInt(remaining.size)
      val c = List(remaining(r))
      val newAssigned = assigned ++ c
      val newRemaining = remaining.filterNot((d: Case) => d.caseNumber == remaining(r).caseNumber)
      genCase(newAssigned, newRemaining)
    }
  }
}