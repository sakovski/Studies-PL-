class Array
  def mean
    self.inject(&:+).to_f / self.length
  end
end
