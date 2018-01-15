#Kryptografia
#Zadanie 6: System ElGamala
#Seweryn Rutkowski, 240865
#Wywołanie programu : ruby elgamal.rb arg1
#gdzie:
#arg1 = {
# =>     -k = generuje parę kluczy zapisanych w plikach private.txt oraz public.txt,
# =>     -e = szyfrowanie,
# =>     -d = deszyfrowanie,
# =>     -s = produkuje podpis,
# =>     -v = weryfikacja
#}

class Elgamal
  def self.generate
    if File.file?("elgamal.txt") and File.file?("private.txt") and File.file?("public.txt")
      file_elgamal = File.open("elgamal.txt", "r")
      file_private = File.open("private.txt", "w")
      file_public = File.open("public.txt", "w")
      p = file_elgamal.readline.to_i
	    g = file_elgamal.readline.to_i
      k = rand(p)
      beta = Helpers.mod_pow(g, k, p)
      file_public.puts p, g, beta
	    file_private.puts p, g, k
      file_elgamal.close
	    file_private.close
	    file_public.close
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.encrypt
    if File.file?("plain.txt") and File.file?("public.txt") and File.file?("crypto.txt")
      file_plain = File.open("plain.txt", "r")
      file_public = File.open("public.txt", "r")
      file_crypto = File.open("crypto.txt", "w")
      p = file_public.readline.to_i
      g = file_public.readline.to_i
      beta = file_public.readline.to_i
      #przygotowanie wiadomosci
      message = file_plain.readlines("").join
      message.chomp!
      temp = ""
      message.each_byte {|lett| temp += lett.to_s(16)}
      message = temp.to_i(16)
      if message > p
        puts "ERROR: Warunek m<p nie jest spełniony!"
        exit
      end
      #szyfrowanie
      random = rand(p)
      gk = Helpers.mod_pow(g, random, p)
      mbk = Helpers.mod_pow(beta, random, p) * message
      file_crypto.puts gk, mbk
      file_plain.close
      file_public.close
      file_crypto.close
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.decrypt
    if File.file?("crypto.txt") and File.file?("private.txt") and File.file?("public.txt") and File.file?("decrypt.txt")
      file_crypto = File.open("crypto.txt", "r")
      file_public = File.open("public.txt", "r")
      file_private = File.open("private.txt", "r")
      file_decrypt = File.open("decrypt.txt", "w")
      p = file_private.readline.to_i
      g = file_private.readline.to_i
      k = file_private.readline.to_i
      beta = file_public.readline.to_i
      beta = file_public.readline.to_i
      beta = file_public.readline.to_i
      gk = file_crypto.readline.to_i
      mbk = file_crypto.readline.to_i
      #deszyfr
      betax = Helpers.mod_pow(gk, k, p)
	    gamma = Helpers.backEl(betax, p)
	    result = (mbk * gamma) % p
	    coded = result.to_s(16)
	    for i in 0..(coded.size / 2 -1)
		    temp = coded[i*2, 2].to_i(16).chr
		    file_decrypt.print temp
	    end
      file_crypto.close
      file_public.close
      file_private.close
      file_decrypt.close
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.sign
    if File.file?("message.txt") and File.file?("private.txt") and File.file?("signature.txt")
      file_message = File.open("message.txt", "r")
      file_private = File.open("private.txt", "r")
      file_signature = File.open("signature.txt", "w")
      p = file_private.readline.to_i
      g = file_private.readline.to_i
      a = file_private.readline.to_i
      #biore message
      message = file_message.readlines("").join
      message.chomp!
      temp = ""
      message.each_byte {|lett| temp += lett.to_s(16)}
      message = temp.to_i(16)
      if message > p
        puts "ERROR: Warunek m<p nie jest spełniony!"
        exit
      end
      k = rand(p-1)
    	k = rand(p-1) while Helpers.gcd(k,p-1) != 1
    	r = Helpers.mod_pow(g,k,p)
    	z = (message % (p-1)) - (a*r % (p-1))
    	z += p-1 while z < 0
    	x = z*Helpers.backEl(k, p-1) % (p-1)
    	file_signature.puts r,x
      file_message.close
      file_private.close
    	file_signature.close
    else
      puts "Brak odpowiednich plików!"
    end
  end

  def self.verify
    if File.file?("public.txt") and File.file?("message.txt") and File.file?("signature.txt") and File.file?("verify.txt")
      file_public = File.open("public.txt", "r")
      file_message = File.open("message.txt", "r")
      file_signature = File.open("signature.txt", "r")
      file_verify = File.open("verify.txt", "w")
      p = file_public.readline.to_i
      g = file_public.readline.to_i
      beta = file_public.readline.to_i
      message = file_message.readlines("").join
      message.chomp!
      temp = ""
      message.each_byte {|lett| temp += lett.to_s(16)}
      message = temp.to_i(16)
      if message > p
        puts "ERROR: Warunek m<p nie jest spełniony!"
        exit
      end
    	r = file_signature.readline.to_i
      x = file_signature.readline.to_i
    	a = Helpers.mod_pow(g,message,p)
    	b = Helpers.mod_pow(r,x,p)*Helpers.mod_pow(beta,r,p) % p
    	if  a == b
        verify_mess = "Podpis pod wiadomoscia zapisana w pliku message.txt jest poprawny"
    		puts verify_mess
        file_verify.puts verify_mess
    	else
    		verify_mess = "Podpis jest niepoprawny!"
        puts verify_mess
        file_verify.puts verify_mess
    	end
      file_public.close
      file_message.close
      file_signature.close
      file_verify.close
    else
      puts "Brak odpowiednich plików!"
    end
  end
end

class Helpers
  def self.mod_pow(x,n,m=0)
    r = 1
  	b = x
  	while n != 0
  		if(n%2 == 1)
  			n -= 1
  			r = (r*b) % m if m != 0
  			r = (r*b) if m == 0
  		else
  			n = n / 2
  			b = b*b % m if m != 0
  			b = b*b if m == 0
  		end
  	end
  	return r
	end

  def self.backEl(a,n)
	  p0, p1, a0, n0 = 0, 1, a, n
	  q = n0 / a0
	  r = n0 % a0
	  while (r > 0)
		  t = p0 - q*p1
		  if ( t >- 0)
			  t = t % n
		  else
			  t = n - ((-t) % n)
		  end
		  p0, p1 = p1,t
		  n0, a0 = a0, r
		  q = n0 / a0
		  r = n0 % a0
	  end
	  return p1
  end

  def self.gcd(a,b)
    while b != 0
  		c = a % b
  		a = b
  		b = c
  	end
  	return a
  end
end

class Executor
  def self.execute()
    args = ARGV
    return "Proszę wywołac program z argumentem (ruby elgamal.rb arg1). Dostępne możliwości dla argumentu = {
     -k = generuje parę kluczy zapisanych w plikach private.txt oraz public.txt,
     -e = szyfrowanie,
     -d = deszyfrowanie,
     -s = produkuje podpis,
     -v = weryfikacja}" unless args.length == 1
    case(args[0])
    when "-k"
      puts "Generowanie pary kluczy do public.txt i private.txt"
      Elgamal.generate
    when "-e"
      puts "Szyfrowanie"
      Elgamal.encrypt
    when "-d"
      puts "Deszyfrowanie"
      Elgamal.decrypt
    when "-s"
      puts "Produkuje podpis"
      Elgamal.sign
    when "-v"
      puts "Weryfikacja"
      Elgamal.verify
    else
      puts "Podano zły argument. Dostępne możliwości dla argumentu = {-p = przygotowanie tekstu do przykładu działania, -e = szyfrowanie, -k = kryptoanaliza wyłącznie w oparciu o kryptogram}"
    end
    return ""
  end
end

begin
  puts Executor.execute()
end
