class String
  def delete_last(n)
    n.times {chop!}
    self
  end
end
