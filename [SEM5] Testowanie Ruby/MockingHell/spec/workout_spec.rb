require_relative '../lib/workout.rb'

RSpec.describe 'Workout' do
  context '#new' do
    let(:id) { 1 }
    let(:date) { Date.parse('2018-01-05') }
    let(:distance) { 5 }
    let(:duration) { '00:18:30' }
    let(:pace) { '03:42' }
    subject(:workout) { Workout.new id, date, distance, duration }

    it 'creates a new workout' do
      expect { workout }.not_to raise_error
    end

    it 'returns Workout type' do
      allow(workout).to receive(:kind_of?).and_return(Workout)
      expect(workout).to be_a_kind_of(Workout)
    end

    it 'returns correct id' do
      expect(workout.id).to eq(id)
    end

    it 'returns correct date' do
      expect(workout.date.to_s).to eq(date.to_s)
      expect(workout.date).to be_a(Date)
    end

    it 'returns correct distance' do
      expect(workout.distance).to eq(distance)
    end

    it 'returns correct duration' do
      expect(workout.duration).to eq(duration)
    end

    it 'returns correct calculated pace' do
      expect(workout.pace).to eq(pace)
    end
  end

  context '#to_s' do
    subject(:workout) { Workout.new 1, Date.parse('2018-01-05'), 5, '00:18:30' }

    it 'returns correct output' do
      expect(workout.to_s).to be_a(String).and include('2018-01-05 - 5 km - 00:18:30 - 03:42 min/km')
    end
  end
end
