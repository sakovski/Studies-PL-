class Array
  def super_compact
    self.reject do |e|
      e.nil? || e.empty?
    end
  end
end
