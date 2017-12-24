class Complement
  def self.of_dna(dna_strand)
    rna_strand = ""
    dna_strand.each_char do |nucleotide|
      case nucleotide
      when 'G'
        rna_strand << 'C'
      when 'C'
        rna_strand << 'G'
      when 'T'
        rna_strand << 'A'
      when 'A'
        rna_strand << 'U'
      else
        return ''
      end
    end
    rna_strand
  end
end

module BookKeeping
  VERSION = 4
end
