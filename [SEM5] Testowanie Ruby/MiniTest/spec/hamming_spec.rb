require_relative '../lib/hamming.rb'

describe "#compute" do
  it 'returns 0 for two empty strands' do
      first = ''
      second = ''
      expect(Hamming.compute(first, second)).to eq 0
    end
    it 'returns 0 for identical strands (A,A)' do
      first = 'A'
      second = 'A'
      expect(Hamming.compute(first, second)).to eq 0
    end
    it 'returns 0 for long identical strands (GGACTGA,GGACTGA)' do
      first = 'GGACTGA'
      second = 'GGACTGA'
      expect(Hamming.compute(first, second)).to eq 0
    end
    it 'returns 1 for complete distance in single nucleotide strands (A,G)' do
      first = 'A'
      second = 'G'
      expect(Hamming.compute(first, second)).to eq 1
    end
    it 'returns 2 for complete distance in small strands (AG,CT)' do
      first = 'AG'
      second = 'CT'
      expect(Hamming.compute(first, second)).to eq 2
    end
    it 'returns 1 for (AT,CT)' do
      first = 'AT'
      second = 'CT'
      expect(Hamming.compute(first, second)).to eq 1
    end
    it 'returns 1 for (GGACG,GGTCG)' do
      first = 'GGACG'
      second = 'GGTCG'
      expect(Hamming.compute(first, second)).to eq 1
    end
    it 'returns 2 for (ACCAGGG,ACTATGG)' do
      first = 'ACCAGGG'
      second = 'ACTATGG'
      expect(Hamming.compute(first, second)).to eq 2
    end
    it 'returns 1 for non unique character in first strand (AGA,AGG)' do
      first = 'AGA'
      second = 'AGG'
      expect(Hamming.compute(first, second)).to eq 1
    end
    it 'returns 1 for non unique character in second strand (AGG,AGA)' do
      first = 'AGG'
      second = 'AGA'
      expect(Hamming.compute(first, second)).to eq 1
    end
    it 'returns 2 for same nucleotides in different positions (TAG,GAT)' do
      first = 'TAG'
      second = 'GAT'
      expect(Hamming.compute(first, second)).to eq 2
    end
    it 'returns 4 for (GATACA, GCATAA))' do
      first = 'GATACA'
      second = 'GCATAA'
      expect(Hamming.compute(first, second)).to eq 4
    end
    it 'returns 9 for large distance in off by one strand (GGACGGATTCTG,AGGACGGATTCT)' do
      first = 'GGACGGATTCTG'
      second = 'AGGACGGATTCT'
      expect(Hamming.compute(first, second)).to eq 9
    end
    it 'returns error for disallow first strand longer (AATG,AAA)' do
      first = 'AATG'
      second = 'AAA'
      expect { Hamming.compute(first, second) }.to raise_error(ArgumentError)
    end
    it 'returns error for disallow second strand longer (ATA,AGTG)' do
      first = 'ATA'
      second = 'AGTG'
      expect{ Hamming.compute(first, second) }.to raise_error(ArgumentError)
    end
end
