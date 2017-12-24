def vowels(string)
  string.split.select do |w|
    w.match /[aeiou]/
  end
end
