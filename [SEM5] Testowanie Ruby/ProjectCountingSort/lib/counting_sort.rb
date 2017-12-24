class CountingSort
  attr_accessor :array

  def initialize(array)
    @array = array
  end

  def find_max
    return nil if @array == nil
    max = @array[0]
    @array.each { |elem| max = elem if elem > max}
    return max
  end

  def find_min
    return nil if @array == nil
    min = @array[0]
    @array.each { |elem| min = elem if elem < min}
    return min
  end

  def counting_sort
    return nil if @array == nil
    min = find_min()
    max = find_max()
    return "invalid range" if min > max

  	n=max-min+1
	  count=Array.new(n,0)
	  len=@array.length
	  output=Array.new(len)

  	for i in 0...len
		  count[@array[i]-min]+=1
	  end

  	for i in 1...n
		  count[i]+=count[i-1]
	  end

	  for i in 0...len
		  output[count[@array[i]-min]-1]=@array[i]
		  count[@array[i]-min]-=1
	  end

	  for i in 0...len
		  @array[i]=output[i]
	  end
	  return @array
  end
end
