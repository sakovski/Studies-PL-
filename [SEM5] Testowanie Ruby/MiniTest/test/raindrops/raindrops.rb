class Raindrops
  require 'prime'

  def self.convert(number)
    output = ""
    factors = number.prime_division.map(&:first)
    factors.each do |factor|
      output += "Pling" if factor == 3
      output += "Plang" if factor == 5
      output += "Plong" if factor == 7
    end
    if(output == "")
      return number.to_s
    else
      return output
    end
  end
end

module BookKeeping
  VERSION = 3
end
