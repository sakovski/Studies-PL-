class String
  def alliteration?
    letter = self[0]
    self.split.all? do |w|
      w[0] == letter
    end
  end
end
