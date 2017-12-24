class Squares
  def initialize(n)
    @n = n
  end

  def square_of_sum
    sum = (1..@n).inject(:+)
    sum**2
  end

  def sum_of_squares
    sum = 0
    (1..@n).each do |number|
      sum += number**2
    end
    sum
  end

  def difference
    square_of_sum - sum_of_squares
  end
end

module BookKeeping
  VERSION = 4
end
