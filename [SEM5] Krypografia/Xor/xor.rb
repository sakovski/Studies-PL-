#Kryptografia
#Zadanie 2: Błędne powtórzenie klucza jednorazowego
#Seweryn Rutkowski, 240865
#Wywołanie programu : ruby xor.rb arg1
#gdzie:
#arg1 = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}


class Xor

  @@ascii_placeholder = 32
  @@ascii_space = 32
  @@ascii_new_line = 10
  @@ascii_carriage_return = 13

  def self.prepare
    if File.file?("plain.txt") and File.file?("orig.txt")
      orig_text = File.read("orig.txt")
      puts "~~~~~~~~ORYGINIALNY TEKST~~~~~~~~"
      puts orig_text
      plain_text = ""
      line_limiter = 0
      orig_text.each_char do |char|
        line_limiter += 1
        plain_text << char unless char.ord == @@ascii_new_line or char.ord == @@ascii_carriage_return #@@ascii_new_line for windows, @@ascii_carriage_return for linux
        if line_limiter == 32
          plain_text << "\n"
          line_limiter = 0
        end
      end
      plain_text.gsub!(/[,.!?:;'-0123456789]/, " ").downcase!
      puts "~~~~~~~~PRZETWORZONY TEKST~~~~~~~~"
      puts plain_text
      File.open("plain.txt", "w") {|file| file.puts(plain_text)}
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.encrypt
    if File.file?("plain.txt") and File.file?("crypto.txt") and File.file?("key.txt")
      key = File.read("key.txt")
      plain_text = File.read("plain.txt")
      crypt_text = ""
      limit = key.length - 1
      i = 0
      ascii = 0
      plain_text.each_line do |line|
        line.each_char do |letter|
          i = 0 if i >= limit
          if ((97..122).include?(letter.ord) or letter.ord == @@ascii_space) #letters
            ascii = (letter.ord ^ key[i].ord) + @@ascii_placeholder
            ascii = 126 if ascii == 0
            crypt_text << (ascii).chr
          end
          i += 1
        end
        crypt_text << "\n"
        i = 0
      end
      File.open("crypto.txt", "w") {|file| file.puts(crypt_text)}
      puts "~~~~~~~~KRYPTOGRAM~~~~~~~~"
      puts crypt_text
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.cryptoanalisys
    if File.file?("crypto.txt") and File.file?("decrypt.txt")
      crypto_text = File.read("crypto.txt")
      lines_count = 0
      crypto_text.each_line do |line|
        lines_count += 1
      end

      array_bytes = Hash.new
      array_decrypt = Hash.new
      i = 0
      j = 0
      crypto_text.each_char do |letter| #filling array_bytes
        if letter.ord == @@ascii_new_line or letter.ord == @@ascii_carriage_return
          i += 1
          j = 0
        else
          array_bytes[[i, j]] = letter.ord - @@ascii_placeholder
          j += 1
        end
      end

      #Cryptoanalisys
      key = ""
      (0..31).each do |column|
        found = false
        (0..lines_count).each do |line|
          break if (line+2 == lines_count)
          xor = array_bytes[[line, column]] ^ array_bytes[[line+1, column]]
          if xor >= 64 && xor <= 95 #010. .... space ^ letter1,  key = space or letter1
            tempxor = array_bytes[[line+1, column]] ^ array_bytes[[line+2, column]]
            if tempxor >= 64 && tempxor <= 95
              if (array_bytes[[line, column]] ^ array_bytes[[line+2, column]] == 0) #space-letter-space or letter1-space-letter1
                next
              else
                array_decrypt[[line+1, column]] = @@ascii_space
                key[column] = (@@ascii_space ^ array_bytes[[line+1, column]]).chr
              end
              break
            elsif tempxor != 0 #space-letter1-letter2
              array_decrypt[[line, column]] = @@ascii_space
              key[column] = (@@ascii_space ^ array_bytes[[line, column]]).chr
              break
            else
              array_decrypt[[line+1, column]] = @@ascii_space #letter1-space-letter2
              key[column] = (@@ascii_space ^ array_bytes[[line+1, column]]).chr
              break
            end
            found = true
          end
          key[column] = '*' unless found
        end
      end

      #Decryption
      decrypt_text = ""
      i = 0
      crypto_text.each_line do |line|
        line.each_char do |letter|
          decrypt_text << ((letter.ord ^ key[i].ord) + @@ascii_placeholder).chr unless letter.ord == @@ascii_new_line or letter.ord == @@ascii_carriage_return
          i += 1
        end
        decrypt_text << "\n"
        i = 0
      end
      puts "~~~~~~~~ODSZYFROWANY TEXT~~~~~~~~"
      puts decrypt_text
      puts "~~~~~~~~KLUCZ ZNALEZIONY~~~~~~~~"
      puts key
      File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
    else
      puts "Brak odpowiednich plików!"
    end
  end
end

class Executor
  def self.execute()
    args = ARGV
    return "Proszę wywołac program z argumentem (ruby xor.rb arg1). Dostępne możliwości dla argumentu = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}" unless args.length == 1
    case(args[0])
    when "-p"
      puts "Przygotowanie tekstu do przykładu działania"
      puts "-------------------------------------------"
      Xor.prepare
    when "-e"
      puts "Szyfrowanie"
      puts "-------------------------------------------"
      Xor.encrypt
    when "-k"
      puts "Kryptoanaliza wyłącznie w oparciu o kryptogram"
      puts "-------------------------------------------"
      Xor.cryptoanalisys
    else
      puts "Podano zły argument. Dostępne możliwości dla argumentu = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}"
    end
    return ""
  end
end

begin
  puts Executor.execute()
end
