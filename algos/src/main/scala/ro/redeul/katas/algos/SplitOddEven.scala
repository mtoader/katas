package ro.redeul.katas.algos

object SplitOddEven {
  def apply(numbers: Array[Int]): Array[Int] = {
    var left = 0
    var right = numbers.length - 1

    do {
      while (left < right && numbers(left) % 2 == 0) left += 1

      while (left < right && numbers(right) % 2 == 1) right -= 1

      if (left < right) {
        val (x, y) = (numbers(left), numbers(right))
        numbers.update(left, y)
        numbers.update(right, x)
        left += 1
        right -= 1
      }
    } while (left < right)

    numbers
  }
}
