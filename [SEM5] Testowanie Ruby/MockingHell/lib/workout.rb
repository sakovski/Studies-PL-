require 'date'
require 'time'

class Workout
  attr_accessor :id, :date, :distance, :duration, :pace

  def initialize(id, date, distance, duration)
    @id = id
    @date = date
    @distance = distance
    @duration = duration
    @pace = calc_pace
  end

  def dur2sec
    time = Time.parse(@duration)
    time.hour * 3600 + time.min * 60 + time.sec
  end

  def calc_pace
    temp = dur2sec / @distance
    Time.at(temp).utc.strftime('%M:%S')
  end

  def to_s
    "#{date} - #{distance} km - #{duration} - #{pace} min/km"
  end
end
