def average_word_length(string)
  words = string.split(" ")
  return if words.empty?
  words.inject(0) {|m, w| m += w.length}.to_f / words.length
end
