class Sieve
  def initialize(number)
    @number = number
    primes
  end

  def primes
    return [] if @number <= 1
    return [2] if @number == 2
    num_array = (2..@number).to_a
    num_array.each do |num|
      (num..@number).step(num*num).each do |step|
        num_array.delete(step)
      end
    end
    num_array
  end
end

module BookKeeping
  VERSION = 1
end
