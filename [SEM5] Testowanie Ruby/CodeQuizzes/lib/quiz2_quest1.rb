class Array
  def has_string?
    self.any? {|e| e.instance_of?(String)}
  end
end
