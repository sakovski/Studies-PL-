class String
  def titlecase
    self.split.map(&:capitalize).join(' ')
  end
end
