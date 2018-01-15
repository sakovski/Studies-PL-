require_relative '../lib/sport_timer.rb'
require_relative '../lib/person.rb'
require_relative '../lib/account.rb'
require_relative '../lib/workout.rb'
require_relative '../lib/progress.rb'

RSpec.describe 'SportTimer' do
  subject(:sport_timer) { SportTimer.new }

  context '#add_person' do
    it {
      firstname = 'Jan'
      lastname = 'Bak'
      country = 'Poland'
      expect { sport_timer.add_person(firstname, lastname, country) }.not_to raise_error
    }
    it {
      firstname = 'Albert'
      lastname = 'Smith'
      country = 'USA'
      expect { sport_timer.add_person(firstname, lastname, country) }.not_to raise_error
    }
  end

  context '#insert_data_edit_person' do
    it {
      id = 0
      firstname = 'Math'
      lastname = 'Janniston'
      country = 'France'
      expect { sport_timer.insert_data_edit_person(id, firstname, lastname, country) }.not_to raise_error
    }

    it {
      id = 1
      firstname = 'Charles'
      lastname = 'Bright'
      country = 'England'
      expect { sport_timer.insert_data_edit_person(id, firstname, lastname, country) }.not_to raise_error
    }
  end

  context '#edit_person' do
    it {
      id = 0
      country = 'Germany'
      expect { sport_timer.edit_person(id, '', '', country) }.not_to raise_error
    }
    it {
      id = 0
      firstname = 'Math'
      lastname = 'Janniston'
      expect { sport_timer.edit_person(id, firstname, lastname, '') }.not_to raise_error
    }
    it {
      id = 1
      firstname = 'Math'
      lastname = 'Janniston'
      country = 'France'
      expect { sport_timer.edit_person(id, firstname, lastname, country) }.not_to raise_error
    }
    it {
      id = 0
      expect { sport_timer.edit_person(id, '', '', '') }.not_to raise_error
    }
    it {
      id = 5
      expect { sport_timer.edit_person(id, '', '', '') }.to raise_error(PersonNotFoundError)
    }
  end

  context '#show_person' do
    it { expect { sport_timer.show_person(0) }.not_to raise_error }
    it { expect { sport_timer.show_person(1) }.not_to raise_error }
    it { expect { sport_timer.show_person(5) }.to raise_error(PersonNotFoundError) }
  end

  context '#remove_person' do
    it { expect { sport_timer.remove_person(0) }.not_to raise_error }
    it { expect { sport_timer.remove_person(1) }.not_to raise_error }
    it { expect { sport_timer.remove_person(5) }.to raise_error(PersonNotFoundError) }
  end

  context '#add_account' do
    it {
      login = 'mjanniston'
      password = 'pass'
      firstname = 'Math'
      lastname = 'Janniston'
      country = 'France'
      person = double('Person', id: 0, firstname: firstname, lastname: lastname, country: country)
      expect { sport_timer.add_account(login, password, person) }.not_to raise_error
    }
    it {
      login = 'mjanniston'
      password = 'pass123'
      firstname = 'Harold'
      lastname = 'Bohme'
      country = 'Germany'
      person = double('Person', id: 1, firstname: firstname, lastname: lastname, country: country)
      expect { sport_timer.add_account(login, password, person) }.not_to raise_error
    }
    it {
      login = 'szuk'
      password = 'pass2234'
      firstname = 'Sebastian'
      lastname = 'Gamrot'
      country = 'USA'
      person = double('Person', id: 2, firstname: firstname, lastname: lastname, country: country)
      expect { sport_timer.add_account(login, password, person) }.not_to raise_error
    }
  end

  context '#show_account' do
    it { expect { sport_timer.show_account(0) }.not_to raise_error }
    it { expect { sport_timer.show_account(1) }.not_to raise_error }
    it { expect { sport_timer.show_account(2) }.not_to raise_error }
    it { expect { sport_timer.show_account(5) }.to raise_error(AccountNotFoundError) }
  end

  context '#edit_account' do
    it {
      id = 0
      login = 'Mark22'
      expect { sport_timer.edit_account(id, login, '') }.not_to raise_error
    }
    it {
      id = 1
      password = 'passsss'
      expect { sport_timer.edit_account(id, '', password) }.not_to raise_error
    }
    it {
      id = 1
      login = 'markopolo123'
      password = 'pass12'
      expect { sport_timer.edit_account(id, login, password) }.not_to raise_error
    }
    it {
      id = 0
      expect { sport_timer.edit_account(id, '', '') }.not_to raise_error
    }
    it {
      id = 5
      expect { sport_timer.edit_account(id, '', '',) }.to raise_error(AccountNotFoundError)
    }
  end

  context '#remove_account' do
    it { expect { sport_timer.remove_account(0) }.to raise_error(PersonNotFoundError) }
    it { expect { sport_timer.remove_account(1) }.to raise_error(PersonNotFoundError) }
    it { expect { sport_timer.remove_account(2) }.to raise_error(PersonNotFoundError) }
    it { expect { sport_timer.remove_account(5) }.to raise_error(AccountNotFoundError) }
  end

  context '#add_workout' do
    it {
      date = Date.parse('2018-01-05')
      distance = 4
      duration = '00:18:30'
      expect { sport_timer.add_workout(date, distance, duration) }.not_to raise_error
    }
    it {
      date = Date.parse('2018-01-06')
      distance = 5
      duration = '00:25:30'
      expect { sport_timer.add_workout(date, distance, duration) }.not_to raise_error
    }
  end

  context '#edit_workout' do
    it {
      id = 0
      date = Date.parse('2018-01-06')
      distance = 6
      duration = '00:25:30'
      expect { sport_timer.edit_workout(id, date, distance, duration) }.not_to raise_error
    }
    it {
      id = 1
      date = Date.parse('2018-01-06')
      expect { sport_timer.edit_workout(id, date, '', '') }.not_to raise_error
    }
    it {
      id = 0
      expect { sport_timer.edit_workout(id, '', '', '') }.not_to raise_error
    }
    it {
      id = 5
      expect { sport_timer.edit_workout(id, '', '', '') }.to raise_error(WorkoutNotFoundError)
    }
  end

  context '#show_workout' do
    it { expect { sport_timer.show_workout(0) }.not_to raise_error }
    it { expect { sport_timer.show_workout(1) }.not_to raise_error }
    it { expect { sport_timer.show_workout(5) }.to raise_error(WorkoutNotFoundError) }
  end

  context '#remove_workout' do
    it { expect { sport_timer.remove_workout(0) }.not_to raise_error }
    it { expect { sport_timer.remove_workout(1) }.not_to raise_error }
    it { expect { sport_timer.remove_workout(5) }.to raise_error(WorkoutNotFoundError) }
  end

  context '#add_progress' do
    let(:a1) do
      person1 = double('Person', firstname: 'Math', lastname: 'Janniston', country: 'France')
      double('Account', login: 'mjanniston', password: 'pass', person: person1)
    end

    let(:a2) do
      person2 = double('Person', firstname: 'Sebastian', lastname: 'Gamrot', country: 'USA')
      double('Account', login: 'szuk', password: 'pass2234', person: person2)
    end

    let(:w1) { double('Workout', date: Date.parse('2017-10-15'), distance: 10, duration: '00:39:17') }
    let(:w2) { double('Workout', date: Date.parse('2017-10-20'), distance: 5, duration: '00:19:33') }

    it {
      p = double('Progress', account: 0, workout: 0)
      expect { sport_timer.add_progress(p.account, p.workout) }.not_to raise_error
    }

    it {
      sport_timer.add_account(a1.login, a1.password, a1.person)
      sport_timer.add_account(a2.login, a2.password, a2.person)
      sport_timer.add_workout(w1.date, w1.distance, w1.duration)
      sport_timer.add_workout(w2.date, w2.distance, w2.duration)
      p1 = double('Progress', account: 0, workout: 0)
      p2 = double('Progress', account: 1, workout: 1)
      expect { sport_timer.add_progress(p1.account, p1.workout) }.not_to raise_error
      expect { sport_timer.add_progress(p2.account, p2.workout) }.not_to raise_error
    }
  end

  context '#show_progress' do
    it { expect { sport_timer.show_progress(0) }.not_to raise_error }
    it { expect { sport_timer.show_progress(1) }.not_to raise_error }
    it { expect { sport_timer.show_progress(2) }.not_to raise_error }
  end

  context '#show_all_progresses' do
    it { expect { sport_timer.show_all_progresses }.not_to raise_error }
  end
end
