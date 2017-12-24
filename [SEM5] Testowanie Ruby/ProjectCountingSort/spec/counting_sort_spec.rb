require_relative '../lib/counting_sort.rb'

describe "#counting_sort" do
  it "given array is [9,8,7,6,5,4,3,2,1,0] array: expected = [0,1,2,3,4,5,6,7,8,9]" do
    given_array = [9,8,7,6,5,4,3,2,1,0]
    exp_array = [0,1,2,3,4,5,6,7,8,9]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [0,1,2,3,4,5,6,7,8,9] array: expected = [0,1,2,3,4,5,6,7,8,9]" do
    given_array = [0,1,2,3,4,5,6,7,8,9]
    exp_array = [0,1,2,3,4,5,6,7,8,9]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [0,0,0,0,0] array: expected = [0,0,0,0,0]" do
    given_array = [0,0,0,0,0]
    exp_array = [0,0,0,0,0]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [1] array: expected = [1]" do
    given_array = [1]
    exp_array = [1]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1] array: expected = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]" do
    given_array = [9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1]
    exp_array = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9] array: expected = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]" do
    given_array = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]
    exp_array = [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "given array is [99,2,3,5,4,2,1312,5444,5555,5555,1] array: expected = [1,2,2,3,4,5,99,1312,5444,5555,5555]" do
    given_array = [99,2,3,5,4,2,1312,5444,5555,5555,1]
    exp_array = [1,2,2,3,4,5,99,1312,5444,5555,5555]
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end

  it "returns nil if array is nil" do
    given_array = nil
    exp_array = nil
    expect(CountingSort.new(given_array).counting_sort).to eq exp_array
  end
end
