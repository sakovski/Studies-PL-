class Array
  def mode
    freq = inject(Hash.new(0)) do |m,v|
      m[v] += 1
      m
    end
    sort do |x, y|
      freq[x] <=> freq[y]
    end.last
  end
end
