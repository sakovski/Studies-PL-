require_relative '../lib/quiz2_quest9'

describe "#first_duplicate" do
  it "returns first duplicate in an array" do
    arr = %w|b c d c a a a|
    expect(arr.first_duplicate).to eq "c"
  end
end
