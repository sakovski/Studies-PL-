require_relative '../lib/quiz2_quest8'

describe "#mode" do
  it "returns most common element" do
    arr = %w|a b dog a b b|
    expect(arr.mode).to eq "b"
  end
end
