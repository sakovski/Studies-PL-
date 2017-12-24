class Array
  def merge_overlapping_ranges
    self.sort_by(&:begin).inject([]) do |memo, range|
      if !memo.empty? && ranges_overlap?(memo.last, range)
        memo[0...-1] + [merge_ranges(memo.last, range)]
      else
        memo + [range]
      end
    end
  end

  private

  def ranges_overlap?(a, b)
    a.include?(b.begin) || b.include?(a.begin)
  end

  def merge_ranges(a, b)
    [a.begin, b.begin].min..[a.end, b.end].max
  end
end
