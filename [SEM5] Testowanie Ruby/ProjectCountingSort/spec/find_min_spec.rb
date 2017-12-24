require_relative '../lib/counting_sort.rb'

describe "#find_min" do
  it "finds min in [9,9,9,9] array: expected = 9" do
    given_array = [9,9,9,9]
    exp = 9
    expect(CountingSort.new(given_array).find_min).to eq exp
  end

  it "finds min in [0,0,0,0] array: expected = 0" do
    given_array = [0,0,0,0]
    exp = 0
    expect(CountingSort.new(given_array).find_min).to eq exp
  end

  it "finds min in [1,2,3,4,5,6,7,8,9] array: expected = 1" do
    given_array = [1,2,3,4,5,6,7,8,9]
    exp = 1
    expect(CountingSort.new(given_array).find_min).to eq exp
  end

  it "finds min in [9,8,7,6,5,4,3,2,1] array: expected = 1" do
    given_array = [9,8,7,6,5,4,3,2,1]
    exp = 1
    expect(CountingSort.new(given_array).find_min).to eq exp
  end

  it "finds min in [11,11,999,921,955,555,555] array: expected = 11" do
    given_array = [11,11,999,921,955,555,555]
    exp = 11
    expect(CountingSort.new(given_array).find_min).to eq exp
  end

  it "returns nil if array is nil" do
    given_array = nil
    exp_array = nil
    expect(CountingSort.new(given_array).find_min).to eq exp_array
  end
end
