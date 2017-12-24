require_relative '../lib/quiz2_quest13'

describe "#merge_overlapping_ranges" do
  it "consolidates overlapping ranges" do
    ranges = [(1..2), (3..6), (5..8)]
    expected = [(1..2), (3..8)]
    expect(ranges.merge_overlapping_ranges).to eq expected
  end
end
