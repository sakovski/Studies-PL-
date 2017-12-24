class String
  def strip_whitespace
    self.gsub(/[ ]/, "")
  end
end
