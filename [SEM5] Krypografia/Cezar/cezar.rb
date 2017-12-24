#Kryptografia
#Zadanie 1: Szyfr Cezara i afiniczny
#Seweryn Rutkowski, 240865
#Wywołanie programu : ruby cezar.rb arg1 arg2
#gdzie:
#arg1 = {c - szyfr Cezara, a = szyfr afiniczny}
#arg2 = {e - szyfrowanie,
#        d - deszyfrowanie,
#        j - kryptoanaliza z tekstem jawnym,
#        k - kryptoanaliza wyłącznie w oparciu o kryptogram}


# 97 - correction number to small letters https://en.wikipedia.org/wiki/ASCII
# 65 - correction number to capital letters https://en.wikipedia.org/wiki/ASCII
# 26 - modulo number

class Helpers
  def self.extended_euclidean_algorithm(a, b)  #http://eduinf.waw.pl/inf/alg/001_search/0009.php   My own Ruby implementation
    u, w, x, z = 1, a, 0, b
    while w != 0 do
      if w < z
        q = u
        u = x
        x = q
        q = w
        w = z
        z = q
      end
    q = w / z
    u -= q * x
    w -= q * z
    end
    if z == 1
      if(x < 0)
        x += b
      end
      return z, x  # z - GCD(a, b), x - modulo inverse,
    else
      return z, 0
    end
  end
end

class Cezar
  def self.is_key_valid?(key, m)
    return true if (0..m-1).include?(key)
    return false
  end

  def self.encrypt()
    puts "szyfrowanie"
    if File.file?("plain.txt") and File.file?("key.txt") and File.file?("crypto.txt")
      plain_text = File.read("plain.txt")
      key_text = File.read("key.txt").split
      key = key_text[1].to_i
      if(is_key_valid?(key,26))
        crypt_text = ""
        plain_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            crypt_text << ((((letter.ord - 97 + key) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            crypt_text << ((((letter.ord - 65 + key) % 26)) + 65).chr
          else
            crypt_text << letter
          end
        end
        puts plain_text
        puts crypt_text
        File.open("crypto.txt", "w") {|file| file.puts(crypt_text)}
      else
        puts "Błędny klucz - musi należeć do zakresu [0,25]"
      end
    else
      puts("Brak odpowiednich plików!")
    end

  end

  def self.decrypt()
    puts "deszyfrowanie"
    if File.file?("crypto.txt") and File.file?("key.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      key_text = File.read("key.txt").split
      key = key_text[1].to_i
      decrypt_text = ""
      crypt_text.each_char do |letter|
        if ('a'..'z').include?(letter)
          decrypt_text << ((((letter.ord - 97 + 26 - key) % 26)) + 97).chr
        elsif ('A'..'Z').include?(letter)
          decrypt_text << ((((letter.ord - 65 + 26 - key) % 26)) + 65).chr
        else
          decrypt_text << letter
        end
      end
      puts crypt_text
      puts decrypt_text
      File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
    else
      puts("Brak odpowiednich plików!")
    end
  end

  def self.crack_with_plain_text()
    puts "kryptoanaliza z tekstem jawnym"
    if File.file?("crypto.txt") and File.file?("extra.txt") and File.file?("key-new.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      extra_text = File.read("extra.txt")
      key = crypt_text[0].ord - extra_text[0].ord
      key = 26 + key if key < 0
      puts crypt_text
      puts extra_text
      puts key
      if key >= 1 and key <=25
        decrypt_text = ""
        crypt_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            decrypt_text << ((((letter.ord - 97 + 26 - key) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            decrypt_text << ((((letter.ord - 65 + 26 - key) % 26)) + 65).chr
          else
            decrypt_text << letter
          end
        end
        puts decrypt_text
        File.open("key-new.txt", "w") {|file| file.puts(key)}
        File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
      else
        puts "Nie znaleziono klucza"
      end
    else
      puts("Brak odpowiednich plików!")
    end
  end

  def self.crack_with_cryptogram()
    puts "kryptoanaliza w oparciu o kryptogram"
    if File.file?("crypto.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      puts crypt_text
      decrypt_file = File.open("decrypt.txt", "a")
      decrypt_file.truncate(0)
      (1..25).each do |key|
        decrypt_text = ""
        crypt_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            decrypt_text << ((((letter.ord - 97 + 26 - key) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            decrypt_text << ((((letter.ord - 65 + 26 - key) % 26)) + 65).chr
          else
            decrypt_text << letter
          end
        end
        puts decrypt_text
        decrypt_file.puts(decrypt_text)
      end
      decrypt_file.close
    else
      puts ("Brak odpowiednich plików!")
    end
  end
end

class Afiniczny
  def self.is_key_valid?(key_a, key_b, m)
    euklides = Helpers.extended_euclidean_algorithm(key_a, m)
    gcd = euklides[0]
    return true if gcd == 1 and (0..m-1).include?(key_b)
    return false
  end

  def self.encrypt()
    puts "szyfrowanie"
    if File.file?("plain.txt") and File.file?("key.txt") and File.file?("crypto.txt")
      plain_text = File.read("plain.txt")
      key_text = File.read("key.txt").split
      key_a = key_text[0].to_i
      key_b = key_text[1].to_i
      if is_key_valid?(key_a, key_b, 26)
        crypt_text = ""
        plain_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            crypt_text << ((((key_a * (letter.ord - 97) + key_b) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            crypt_text << ((((key_a * (letter.ord - 65) + key_b) % 26)) + 65).chr
          else
            crypt_text << letter
          end
        end
        puts plain_text
        puts crypt_text
        File.open("crypto.txt", "w") {|file| file.puts(crypt_text)}
      else
        puts ("Błędny klucz - NWD(a,26) musi być równe 1 i b musi należeć do zakresu [0,25]!")
      end
    else
      puts("Brak odpowiednich plików!")
    end
  end

  def self.decrypt()
    puts "deszyfrowanie"
    if File.file?("crypto.txt") and File.file?("key.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      key_text = File.read("key.txt").split
      euklides = Helpers.extended_euclidean_algorithm(key_text[0].to_i, 26)
      if euklides[1] != 0
        inv_key_a = euklides[1]
        key_b = key_text[1].to_i
        decrypt_text = ""
        crypt_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            decrypt_text << ((((inv_key_a * ((letter.ord - 97) - key_b)) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            decrypt_text << ((((inv_key_a * ((letter.ord - 65) - key_b)) % 26)) + 65).chr
          else
            decrypt_text << letter
          end
        end
        puts crypt_text
        puts decrypt_text
        File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
      else
        ("Błędny klucz - NWD(a,26) musi być równe 1 i b musi należeć do zakresu [0,25]!")
      end
    else
      puts("Brak odpowiednich plików!")
    end
  end

  def self.crack_with_plain_text()
    puts "kryptoanaliza z tekstem jawnym"
    if File.file?("crypto.txt") and File.file?("extra.txt") and File.file?("key-new.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      extra_text = File.read("extra.txt")
      if extra_text.length >= 2
        crypt_nums = [] #letter numbers (0..25)
        extra_nums = [] #---||---
        i=0
        extra_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            extra_nums << extra_text[i].ord - 97
            crypt_nums << crypt_text[i].ord - 97
          else
            extra_nums << extra_text[i].ord - 65
            crypt_nums << crypt_text[i].ord - 65
          end
          i += 1
        end
        x_sub = extra_nums[0] - extra_nums[1]
        y_sub = crypt_nums[0] - crypt_nums[1]
        if x_sub < 0
          x_sub *= -1
          y_sub *= -1
        end
        if y_sub < 0
          y_sub += 26
        end
        euklides = Helpers.extended_euclidean_algorithm(x_sub,26)
        a = (y_sub * euklides[1]) % 26
        key_b = (crypt_nums[0] - a*extra_nums[0]) % 26
        euklides = Helpers.extended_euclidean_algorithm(a,26)
        inv_key_a = euklides[1]
        puts a
        puts key_b
        decrypt_text = ""
        crypt_text.each_char do |letter|
          if ('a'..'z').include?(letter)
            decrypt_text << ((((inv_key_a * ((letter.ord - 97) - key_b)) % 26)) + 97).chr
          elsif ('A'..'Z').include?(letter)
            decrypt_text << ((((inv_key_a * ((letter.ord - 65) - key_b)) % 26)) + 65).chr
          else
            decrypt_text << letter
          end
        end
        key = ""
        key << a.to_s << " " << key_b.to_s
        File.open("key-new.txt", "w") {|file| file.puts(key)}
        File.open("decrypt.txt", "w") {|file| file.puts(decrypt_text)}
        puts crypt_text
        puts decrypt_text
      else
        puts "Za krótki tekst jawny (potrzebne przynajmniej 2 litery)"
      end
    else
      puts("Brak odpowiednich plików!")
    end
  end

  def self.crack_with_cryptogram()
    puts "kryptoanaliza w oparciu o kryptogram"
    if File.file?("crypto.txt") and File.file?("decrypt.txt")
      crypt_text = File.read("crypto.txt")
      count = 0
      puts crypt_text
      decrypt_file = File.open("decrypt.txt", "a")
      decrypt_file.truncate(0)
      (1..25).each do |inv_key_a|
        euklides = Helpers.extended_euclidean_algorithm(inv_key_a, 26)
        if euklides[1] != 0
          (0..25).each do |key_b|
            decrypt_text = ""
            crypt_text.each_char do |letter|
              if ('a'..'z').include?(letter)
                decrypt_text << ((((inv_key_a * ((letter.ord - 97) - key_b)) % 26)) + 97).chr
              elsif ('A'..'Z').include?(letter)
                decrypt_text << ((((inv_key_a * ((letter.ord - 65) - key_b)) % 26)) + 65).chr
              else
                decrypt_text << letter
              end
            end
            puts decrypt_text
            decrypt_file.puts(decrypt_text)
          end
        end
      end
      decrypt_file.close
    else
      puts("Brak odpowiednich plików!")
    end
  end
end

class Executor
  def self.execute()
    args = ARGV
    return "Proszę wywołac program z dwoma argumentami (ruby cezar.rb arg1 arg2)" unless args.length == 2
    case(args[0])
    when 'c'
      puts "szyfr Cezara"
      case(args[1])
      when 'e'
        Cezar.encrypt()
      when 'd'
        Cezar.decrypt()
      when 'j'
        Cezar.crack_with_plain_text()
      when 'k'
        Cezar.crack_with_cryptogram()
      else
        puts "Podano zły argument 2. Dostępne możliwości dla arg2 = {e - szyfrowanie, d - deszyfrowanie, j - kryptoanaliza z tekstem jawnym, k - kryptoanaliza wyłącznie w oparciu o kryptogram}"
      end
    when 'a'
      puts "Szyfr afiniczny"
      case(args[1])
      when 'e'
        Afiniczny.encrypt()
      when 'd'
        Afiniczny.decrypt()
      when 'j'
        Afiniczny.crack_with_plain_text()
      when 'k'
        Afiniczny.crack_with_cryptogram()
      else
        puts "Podano zły argument 2. Dostępne możliwości dla arg2 = {e - szyfrowanie, d - deszyfrowanie, j - kryptoanaliza z tekstem jawnym, k - kryptoanaliza wyłącznie w oparciu o kryptogram}"
      end
    else
      puts "Podano zły argument 1. Dostępne możliwości dla arg1 = {c - szyfr Cezara, a = szyfr afiniczny}"
    end
    return ""
  end
end

begin
  puts Executor.execute()
end
