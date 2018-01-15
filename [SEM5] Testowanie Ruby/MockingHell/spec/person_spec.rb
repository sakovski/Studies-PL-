require_relative '../lib/person.rb'

RSpec.describe 'Person' do
  context '#new' do
    let(:id) { 1 }
    let(:firstname) { 'Jozef' }
    let(:lastname) { 'Brzdakal' }
    let(:country) { 'Poland' }
    subject(:person) { Person.new id, firstname, lastname, country }

    it 'creates a new person' do
      expect { person }.not_to raise_error
    end

    it 'returns Person type' do
      allow(person).to receive(:kind_of?).and_return(Person)
      expect(person).to be_a_kind_of(Person)
    end

    it 'returns correct id' do
      expect(person.id).to eq(id)
    end

    it 'returns correct firstname' do
      expect(person.firstname).to eq(firstname)
    end

    it 'returns correct lastname' do
      expect(person.lastname).to eq(lastname)
    end

    it 'returns correct country' do
      expect(person.country).to eq(country)
    end
  end

  context '#to_s' do
    subject(:person) { Person.new 1, 'Jozef', 'Brzdakal', 'Poland' }

    it 'returns correct output' do
      expect(person.to_s).to be_a(String).and include('Jozef Brzdakal Poland')
    end
  end
end
