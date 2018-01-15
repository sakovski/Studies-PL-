require_relative '../lib/progress.rb'

RSpec.describe 'Progress' do
  context '#new' do
    let(:id) { 1 }
    let(:account) { double('Account', id: 1, login: 'jbrzdakal', password: 'pass123', person: double('Person', id: 1, firstname: 'Jozef', lastname: 'Brzdakal', country: 'Poland')) }
    let(:workout) { double('Workout', id: 1, date: Date.parse('2018-01-05'), distance: 5, duration: '00:18:30') }
    subject(:progress) { Progress.new id, account, workout }

    it 'creates a new progress object' do
      expect { progress }.not_to raise_error
    end

    it 'returns Progress type' do
      allow(progress).to receive(:kind_of?).and_return(Progress)
      expect(progress).to be_a_kind_of(Progress)
    end

    it 'returns correct id' do
      expect(progress.id).to eq(id)
    end

    it 'returns correct account' do
      expect(progress.account).to eq(account)
      allow(progress.account).to receive(:kind_of?).and_return(Account)
      expect(progress.account).to be_a_kind_of(Account)
    end

    it 'returns correct workout' do
      expect(progress.workout).to eq(workout)
      allow(progress.workout).to receive(:kind_of?).and_return(Workout)
      expect(progress.workout).to be_a_kind_of(Workout)
    end
  end

  context '#to_s' do
    let(:id) { 1 }
    let(:account) { double('Account', id: 1, login: 'jbrzdakal', password: 'pass123', person: double('Person', id: 1, firstname: 'Jozef', lastname: 'Brzdakal', country: 'Poland')) }
    let(:workout) { double('Workout', id: 1, date: Date.parse('2018-01-05'), distance: 5, duration: '00:18:30') }
    subject(:progress) { Progress.new id, account, workout }

    it 'returns correct output' do
      expect(progress.to_s).to be_a(String).and include(account.login, workout.to_s)
    end
  end
end
