require_relative '../lib/quiz1_quest1'

RSpec.describe "#word_count" do
  it "returns number of words in a string" do
    string = "laughter, it's free"
    expect(word_count(string)).to eq 3
  end

  it "returns - for empty string" do
    expect(word_count("")).to eq 0
  end
end
