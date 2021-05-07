import scala.io.StdIn.readInt

// https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles/problem

object Solution {

  def drawTriangles(n: Int) {
    def drawTriRec(i: Int, height: Int): List[String] = {
      if (i < 1) (0 until height).toList.map(r => "_" * (height-r-1) + "1" * (r*2 + 1) + "_" * (height-r-1) )
      else
        drawTriRec(i-1, height / 2)
          .map("_" * (height / 2) + _ + "_" * (height / 2)) ++
          drawTriRec(i-1, height / 2).map(s => s + "_" + s)
    }

    for (row <- drawTriRec(n, 32)) println(row)
  }

  def main(args: Array[String]) {
    drawTriangles(readInt())
  }
}
