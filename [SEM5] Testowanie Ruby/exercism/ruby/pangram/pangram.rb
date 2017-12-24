class Pangram
  def self.pangram?(phase)
    ('a'..'z').all? {|letter| phase.downcase.include?(letter)}
  end
end

module BookKeeping
  VERSION = 5
end
