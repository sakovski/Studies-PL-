require_relative '../lib/hello_world.rb'

describe "#hello" do
  it "returns 'Hello, World!' string" do
    expect(HelloWorld.hello).to eq "Hello, World!"
  end
end
