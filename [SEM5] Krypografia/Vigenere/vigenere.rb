#Kryptografia
#Zadanie 5: Szyfr Vigenere'a
#Seweryn Rutkowski, 240865
#Wywołanie programu : ruby vigenere.rb arg1
#gdzie:
#arg1 = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -d = deszyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}



class Vigenere

  @@english_frequencies = { "a" => 82, "b" => 15, "c" => 28, "d" => 43, "e" => 127, "f" => 22, "g" => 20, "h" => 61, "i" => 70, "j" => 2, "k" => 8, "l" => 40, "m" => 24, "n" => 67, "o" => 75, "p" => 29, "q" => 1, "r" => 60, "s" => 63, "t" => 91, "u" => 28, "v" => 10, "w" => 23, "x" => 1, "y" => 20, "z"=> 1 }

  def self.prepare
    if File.file?("plain.txt") and File.file?("orig.txt")
      orig_text = File.read("orig.txt")
      puts "~~~~~~~~ORYGINIALNY TEKST~~~~~~~~"
      puts orig_text
      plain_text = orig_text.gsub!(/[ ,."<>{}!?:;'-0123456789!@#$^&*()_=+\n\r]/, "").downcase!
      puts "~~~~~~~~PRZETWORZONY TEKST~~~~~~~~"
      puts plain_text
      File.open("plain.txt", "w") {|file| file.puts(plain_text)}
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.encrypt
    if File.file?("crypto.txt") and File.file?("key.txt") and File.file?("plain.txt")
      plain_text = File.read("plain.txt")
      key = File.read("key.txt")
      puts "~~~~~~~~SZYFROWANY TEXT~~~~~~~~"
      puts plain_text
      puts "~~~~~~~~KLUCZ~~~~~~~~"
      puts key
      crypto_text = ""
      i = 0
      plain_text.each_char do |char|
        if(char.ord >= 97 and char.ord <= 122)
          pos_c = char.ord - 'a'.ord
          pos_k = key[i].ord - 'a'.ord
          crypto_text << ((pos_c + pos_k) % 26 + 'a'.ord).chr
          i = (i + 1) % (key.length-1)
        end
      end
      puts "~~~~~~~~ZASZYFROWANY TEXT~~~~~~~~"
      puts crypto_text
      File.open("crypto.txt", "w") {|file| file.puts(crypto_text)}
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.decrypt
    if File.file?("crypto.txt") and File.file?("key.txt") and File.file?("decrypt.txt")
      crypto_text = File.read("crypto.txt")
      key = File.read("key.txt")
      puts "~~~~~~~~ZASZYFROWANY TEXT~~~~~~~~"
      puts crypto_text
      puts "~~~~~~~~KLUCZ~~~~~~~~"
      puts key
      decrypt_text = ""
      i = 0
      crypto_text.each_char do |char|
        if(char.ord >= 97 and char.ord <= 122)
          pos_c = char.ord - 'a'.ord
          pos_k = key[i].ord - 'a'.ord
          decrypt_text << ((pos_c - pos_k) % 26 + 'a'.ord).chr
          i = (i + 1) % (key.length-1)
        end
      end
      puts "~~~~~~~~ODSZYFROWANY TEXT~~~~~~~~"
      puts decrypt_text
      File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.cryptoanalisys
    if File.file?("crypto.txt") and File.file?("key-crypto.txt") and File.file?("decrypt.txt")
      crypto_text = File.read("crypto.txt")
      #etap 1
      puts "Znajduje dlugosc klucza..."
      found_key = ""
      key_length = find_key_length(crypto_text)
      puts "~~~~~~~~DLUGOSC KLUCZA~~~~~~~~"
      puts key_length

      #etap 2
      puts "Odszyfrowuje..."
      iter = 0
      while iter < key_length do
        j = iter
        freqs = Array.new(26, 0) #0 = 'a', 1 = 'b' itd.
        sum = 0
        while j < crypto_text.length - 1 do
          freqs[crypto_text[j].ord - 97] = freqs[crypto_text[j].ord - 97] + 1
          sum = sum + 1
          j = j + key_length
        end

        #dziele czestotliosci na promile
        freq_div = 0
        while freq_div < freqs.length do
          if freqs[freq_div] != 0
            freqs[freq_div] = freqs[freq_div] / sum.to_f
          end
          freq_div = freq_div + 1
        end

        #porownuje z english frequencies i licze skalar
        #english_freq zawsze staly, przesuwamy freqs
        i = 0
        shift = 0
        final_freqs = Array.new(26, 0) #finalowe freqsy z ktorych wybierzemy najwiekszy i to bedzie nasza litera asci - 97
        #dla shift = 0
        current_shift_total = 0
        while i < freqs.length do
          current_shift_total = current_shift_total + freqs[i] * @@english_frequencies[(i+97).chr]
          i = i + 1
        end
        final_freqs[0] = current_shift_total
        shift = shift + 1
        #dla shift > 0 z kazda iteracja przesuwamy o 1 w lewo, czyli freqs[0] = freqs[freqs.length-1]

        while shift < freqs.length do
          #przesuniecie freqs
          current_shift_total = 0
          first = freqs[0]
          i = 0
          while i < freqs.length - 1 do
            freqs[i] = freqs[i+1]
            i = i + 1
          end
          freqs[freqs.length - 1] = first
          j = 0
          while j < freqs.length do
            current_shift_total = current_shift_total + freqs[j] * @@english_frequencies[(j+97).chr]
            j = j + 1
          end
          final_freqs[shift] = current_shift_total
          shift = shift + 1
        end

        #wybieramy najwieksza z final_freqs i jej index to nasz char
        max = 0.to_f
        final_char = 0
        i = 0
        while i < final_freqs.length do
          if(final_freqs[i] > max)
            max = final_freqs[i]
            final_char = i
          end
          i = i + 1
        end
        found_letter = (final_char + 97).chr
        found_key << found_letter
        iter = iter + 1
      end
      puts "~~~~~~~~ZNALEZIONY KLUCZ~~~~~~~~"
      puts found_key
      File.open("key-crypto.txt", "w") {|file| file.puts(found_key)}
    else
      puts "Brak odpowiednich plików!"
    end
  end
end

def find_key_length(crypto_text)
  coinsidences_array = Array.new(crypto_text.length - 1)
  coinsidences = 0;
  shift = 1
  i = 0
  j = 0
  length = 0
  while i < crypto_text.length - 1 do
    while j < crypto_text.length - 1 do
      if j+shift > crypto_text.length
        break
      end
      if crypto_text[j] == crypto_text[j+shift]
        coinsidences = coinsidences + 1
      end
      j = j + 1
    end
    coinsidences_array[i] = coinsidences
    coinsidences = 0
    j = 0
    i = i + 1
    shift = shift + 1
  end

  #tutaj porownanie coinsidences_array
  lines = 1
  coinsidences_array.each do |number|
    if(number > 60)
      length = lines
      break
    end
    lines = lines + 1
  end
  return length
end

class Executor
  def self.execute()
    args = ARGV
    return "Proszę wywołac program z argumentem (ruby vigenere.rb arg1). Dostępne możliwości dla argumentu = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -d = deszyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}" unless args.length == 1
    case(args[0])
    when "-p"
      puts "Przygotowanie tekstu do przykładu działania"
      puts "-------------------------------------------"
      Vigenere.prepare
    when "-e"
      puts "Szyfrowanie"
      puts "-------------------------------------------"
      Vigenere.encrypt
    when "-d"
      puts "Deszyfrowanie"
      puts "-------------------------------------------"
      Vigenere.decrypt
    when "-k"
      puts "Kryptoanaliza wyłącznie w oparciu o kryptogram"
      puts "-------------------------------------------"
      Vigenere.cryptoanalisys
    else
      puts "Podano zły argument. Dostępne możliwości dla argumentu = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}"
    end
    return ""
  end
end

begin
  puts Executor.execute()
end
