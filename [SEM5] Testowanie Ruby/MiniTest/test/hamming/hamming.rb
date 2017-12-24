class Hamming
  def self.compute(param1, param2)
    counter = 0
    if param1.length() == param2.length()
      for iterator in 0..param1.length
        if param1[iterator] != param2[iterator]
          counter += 1
        end
      end
    else
      raise ArgumentError
    end
    return counter
  end
end

module BookKeeping
  VERSION = 3
end
