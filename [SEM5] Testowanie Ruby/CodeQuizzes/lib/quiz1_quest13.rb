class Float
  def to_money
    sprintf("%.2f", self).prepend('$')
  end
end
