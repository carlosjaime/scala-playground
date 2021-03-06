import org.specs2.time.Time

/**
 * Created by IntelliJ IDEA.
 * User: pmishra
 * Date: 24/8/11
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
  /*
  Each new term in the Fibonacci sequence is generated by adding the previous two terms.
  By starting with 1 and 2, the first 10 terms will be:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
By considering the terms in the Fibonacci sequence whose values do not exceed four million,
find the sum of the even-valued terms.
   */
class Problem2 {

  def Solve(input:Int): Int = {
      return 2 + GetFibonacciSequence(1,2,input)
  }
  def SolveFromInternet(input:Int): Int = {
    lazy val fs: Stream[Int] = 0 #:: 1 #:: fs.zip(fs.tail).map(p => p._1 + p._2)
    fs.takeWhile(_ < input).filter(_ % 2 == 0).foldLeft(0)(_ + _)
    //Another way of doing the same
    // lazy val fib: Stream[Int] = {
    //def loop(h: Int, n: Int): Stream[Int] = h #:: loop(n, h + n)
    //loop(1, 1)
}
  }
  def GetFibonacciSequence(num1:Int, num2:Int, maxNumber:Int): Int = {
    var result =  num1 + num2
    if(result > maxNumber) 0
    else if (result % 2 == 0) result + GetFibonacciSequence(num2, result, maxNumber)
    else GetFibonacciSequence(num2, result, maxNumber)
  }
}