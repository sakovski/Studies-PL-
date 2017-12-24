def start_with_c?(str)
  str.split.all? do |word|
    word.start_with? "c"
  end
end
