class Array
  def first_duplicate
    find {|e| count(e) > 1}
  end
end
