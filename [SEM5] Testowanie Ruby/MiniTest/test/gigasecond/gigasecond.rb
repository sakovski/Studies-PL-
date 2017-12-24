class Gigasecond
  def self.from(birth_date)
    duration = 1000000000
    birth_date + duration
  end
end

module BookKeeping
  VERSION = 6
end
