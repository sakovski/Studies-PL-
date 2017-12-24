class String
  def parse_params
    return nil unless self.include? "?"
    params = self.split("?").last
    Hash[params.split("&").map {|p| p.split("=")}]
  end
end
