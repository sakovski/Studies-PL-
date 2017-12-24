require_relative '../lib/gigasecond.rb'

describe "#from" do
  it "returns Time.utc(2043, 1, 1, 1, 46, 40) for Time.utc(2011, 4, 25, 0, 0, 0)" do
    expect(Gigasecond.from(Time.utc(2011, 4, 25, 0, 0, 0))).to eq Time.utc(2043, 1, 1, 1, 46, 40)
  end

  it "returns Time.utc(2009, 2, 19, 1, 46, 40) for Time.utc(1977, 6, 13, 0, 0, 0)" do
    expect(Gigasecond.from(Time.utc(1977, 6, 13, 0, 0, 0))).to eq Time.utc(2009, 2, 19, 1, 46, 40)
  end

  it "returns Time.utc(1991, 3, 27, 1, 46, 40) for Time.utc(1959, 7, 19, 0, 0, 0)" do
    expect(Gigasecond.from(Time.utc(1959, 7, 19, 0, 0, 0))).to eq Time.utc(1991, 3, 27, 1, 46, 40)
  end

  it "returns Time.utc(2046, 10, 2, 23, 46, 40) for Time.utc(2015, 1, 24, 22, 0, 0)" do
    expect(Gigasecond.from(Time.utc(2015, 1, 24, 22, 0, 0))).to eq Time.utc(2046, 10, 2, 23, 46, 40)
  end

  it "returns Time.utc(2046, 10, 3, 1, 46, 39) for Time.utc(2015, 1, 24, 23, 59, 59)" do
    expect(Gigasecond.from(Time.utc(2015, 1, 24, 23, 59, 59))).to eq Time.utc(2046, 10, 3, 1, 46, 39)
  end
end
