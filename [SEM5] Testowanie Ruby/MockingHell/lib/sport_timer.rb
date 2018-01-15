class SportTimer
  attr_accessor :people, :accounts, :workouts, :progresses

  @@people = []
  @@accounts = []
  @@workouts = []
  @@progresses = []

  def add_person(firstname, lastname, country)
    size = @@people.size
    id = 0
    id += 1 while id < size && !@@people[id].nil?
    person = Person.new(id, firstname, lastname, country)
    @@people.insert(id, person)
    puts "Added new person to database:
    id - #{@@people[id].id},
    firstname - #{@@people[id].firstname},
    lastname - #{@@people[id].lastname},
    country - #{@@people[id].country}."
  end

  def show_person(id)
    raise PersonNotFoundError if @@people.at(id).nil?
    puts "Person on id = #{@@people[id].id}: #{@@people[id]}"
  end

  def edit_person(id, firstname, lastname, country)
    raise PersonNotFoundError if @@people.at(id).nil?
    insert_data_edit_person(id, firstname, lastname, country)
    puts "Updated person on id = #{@@people[id].id}."
  end

  def insert_data_edit_person(id, firstname, lastname, country)
    @@people[id].firstname = firstname if firstname != ''
    @@people[id].lastname = lastname if lastname != ''
    @@people[id].country = country if country != ''
  end

  def remove_person(id)
    raise PersonNotFoundError if @@people.at(id).nil?
    @@people[id] = nil
    puts "Removed person on id = #{id}."
  end

  def add_account(login, password, person)
    size = @@accounts.size
    id = 0
    id += 1 while id < size && !@@accounts[id].nil?
    account = Account.new(id, login, password, person)
    @@accounts.insert(id, account)
    puts "Added new account:
    login - #{login},
    password - #{password}."
  end

  def show_account(id)
    raise AccountNotFoundError if @@accounts.at(id).nil?
    puts "Account on id = #{id}: #{@@accounts[id]}"
  end

  def edit_login_password(id, login, password)
    @@accounts[id].login = login if login != ''
    @@accounts[id].password = password if password != ''
  end

  def edit_account(id, login, password)
    raise AccountNotFoundError if @@accounts.at(id).nil?
    @@accounts[id].person = @@people[id]
    edit_login_password(id, login, password)
    puts "Updated account on id = #{id}."
  end

  def remove_account(id)
    raise AccountNotFoundError if @@accounts.at(id).nil?
    @@accounts[id] = nil
    remove_person(id)
    puts "Removed account on id = #{id}."
  end

  def add_workout(date, distance, duration)
    size = @@workouts.size
    id = 0
    id += 1 while id < size && !@@workouts[id].nil?
    workout = Workout.new(id, date, distance, duration)
    @@workouts.insert(id, workout)
    puts "Added new workout:
    id - #{id} ,
    date - #{date},
    distance - #{distance},
    duration - #{duration}."
  end

  def insert_data_edit_workout(id, date, distance, duration)
    @@workouts[id].date = date unless date.nil?
    @@workouts[id].distance = distance if distance != ''
    @@workouts[id].duration = duration if duration != ''
  end

  def edit_workout(id, date, distance, duration)
    raise WorkoutNotFoundError if @@workouts.at(id).nil?
    insert_data_edit_workout(id, date, distance, duration)
    puts "Updated workout on id = #{id}."
  end

  def show_workout(id)
    raise WorkoutNotFoundError if @@workouts.at(id).nil?
    puts "Workout on id = #{id}: #{@@workouts[id]}"
  end

  def remove_workout(id)
    raise WorkoutNotFoundError if @@workouts.at(id).nil?
    @@workouts[id] = nil
    puts "Removed workout on id = #{id}."
  end

  def add_progress(account_id, workout_id)
    max = @@progresses.size
    id = 0
    id += 1 while id < max && !@@progresses[id].nil?
    if !@@accounts[account_id].nil? && !@@workouts[workout_id].nil?
      progress = Progress.new(id, @@accounts[account_id], @@workouts[workout_id])
      @@progresses.insert(id, progress)
      puts "Added new progress item on id => #{@@progresses[id].id}."
    else
      puts "Account on id => #{account_id} does not exist." if @@accounts[account_id].nil?
      puts "Workout on id => #{workout_id} does not exist." if @@workouts[workout_id].nil?
      puts 'Adding a new entry failed.'
    end
  end

  def show_progress(id)
    if !@@progresses.at(id).nil?
      puts "Progress on id => #{@@progresses[id].id}: #{@@progresses[id]}"
    else
      puts "Progress on id => #{id} does not exist."
    end
  end

  def show_all_progresses
    puts 'Progresses:'
    i = 0
    while i < @@progresses.size
      puts "Progress on id => #{@@progresses[i].id}: #{@@progresses[i]}" unless @@progresses.at(i).nil?
      i += 1
    end
  end
end

class PersonNotFoundError < StandardError
  def initialize(msg = 'Person not found in database')
    super
  end
end

class AccountNotFoundError < StandardError
  def initialize(msg = 'Account not found in database')
    super
  end
end

class WorkoutNotFoundError < StandardError
  def initialize(msg = 'Workout not found in database')
    super
  end
end
