require_relative 'workout'
require_relative 'sport_timer'
require_relative 'progress'
require_relative 'account'
require_relative 'person'

class Program
  @@person = []
  @@account = []
  @@workout = []

  def initialize
    @program = SportTimer.new
    start
    logo
    menu_action
  end

  def menu_action
    loop do
      menu
      input = gets.chomp
      case input
      when '1'
        users_submenu
        case gets.chomp
        when '1'
          show_user_action
        when '2'
          edit_user_action
        when '3'
          remove_user_action
        else
          command_not_found
        end
      when '2'
        activity_submenu
        case gets.chomp
        when '1'
          show_workout_action
        when '2'
          edit_workout_action
        when '3'
          remove_workout_action
        else
          command_not_found
        end
      when '3'
        authors
      when '4'
        exit
      else
        command_not_found
      end
      puts ' '
      puts ' '

      next_step
      break if input.chomp == '6'
    end
  end

  def remove_workout_action
    puts 'Wprowadz ID treningu do usuniecia:'
    id = gets.chomp
    @program.remove_account(id.to_i)
    next_step
    gets.chomp
  end

  def edit_workout_action
    puts 'Wprowadz ID treningu do edycji:'
    id = gets.chomp
    puts 'Podaj date:'
    date = gets.chomp
    puts 'Podaj dystans:'
    distance = gets.chomp
    puts 'Podaj dystans:'
    duration = gets.chomp
    puts 'Podaj czas trwania:'
    @program.edit_workout(id, date, distance, duration)
    next_step
    gets.chomp
  end

  def show_workout_action
    puts 'Wprowadz ID treningu:'
    id = gets.chomp
    @program.show_workout(id.to_i)
    next_step
    gets.chomp
  end

  def remove_user_action
    puts 'Wprowadz ID uzytkownika do usuniecia:'
    id = gets.chomp
    @program.remove_account(id.to_i)
    next_step
    gets.chomp
  end

  def edit_user_action
    puts 'Wprowadz ID uzytkownika do edycji:'
    id = gets.chomp
    puts 'Podaj login:'
    login = gets.chomp
    puts 'Podaj haslo:'
    password = gets.chomp
    @program.edit_account(id, login, password)
    next_step
    gets.chomp
  end

  def show_user_action
    puts 'Wprowadz ID uzytkownika:'
    id = gets.chomp
    @program.show_account(id.to_i)
    next_step
    gets.chomp
  end

  def command_not_found
    puts 'Nie rozpoznano komendy'
  end

  def users_submenu
    puts '    1 -> Pokaz szczegoly'
    puts '    2 -> Edytuj uzytkownika'
    puts '    3 -> Usun osobe'
  end

  def activity_submenu
    puts '    1 -> Pokaz szczegoly'
    puts '    2 -> Edytuj trening'
    puts '    3 -> Usun trening'
  end

  def next_step
    puts 'Co chcesz teraz zrobic?'
  end

  def logo
    puts '------------------------------------------------'
    puts '|                                              |'
    puts '|                Sport Timer                   |'
    puts '|                                              |'
    puts '| -------------------------------------------- |'
    puts '|                      /// 6|                  |'
    puts '|                     //  _|                   |'
    puts "|                     /,-'                     |"
    puts "|               _.-/'/   \   ,/;,               |"
    puts "|             ,-' /'  \_   \ / _/                |"
    puts "|             `\ /     _/\  ` /                  |"
    puts "|               |     /,  `\_/                  |"
    puts "|               |     \'                        |"
    puts "|   /\_        /`      /\                        |"
    puts "| /' /_``--.__/\  `,. /  \                       |"
    puts "||_/`  `-._     `\/  `\   `.                     |"
    puts "|      `-.__/'     `    \   |                   |"
    puts "|                        `\  \                   |"
    puts "|                          `\ \                  |"
    puts "|                            \_\__               |"
    puts "|                             \___)             |"
    puts '------------------------------------------------'
    puts ' '
  end

  def menu
    puts '---   Menu   ---'
    puts '1 -> Uzytkownicy'
    puts '2 -> Aktywnosc'
    puts '3 -> Autorzy'
    puts '4 -> Koniec'
  end

  def authors
    puts 'Autorzy:'
    puts 'Jakub Ronkiewicz'
    puts 'Seweryn Rutkowski'
    puts 'Dominik Rynko'
    puts 'Mikolaj Bronk'
  end

  def create_person
    @@person[0] = @program.add_person('Andrzej', 'Rudy', 'Poland')
    @@person[1] = @program.add_person('Marek', 'Nowak', 'Poland')
  end

  def create_account
    @@account[0] = @program.add_account('a.rudy', 'haslo123', @@person[0])
    @@account[1] = @program.add_account('m.nowak', 'password', @@person[1])
  end

  def create_workout
    @@workout[0] = @program.add_workout('2018-01-03 00:00:00', 10, '1:30:20')
    @@workout[1] = @program.add_workout('2018-01-05 00:00:00', 15, '00:15:54')
    @@workout[2] = @program.add_workout('2017-12-25 00:00:00', 3, '00:20:10')
    @@workout[3] = @program.add_workout('2017-12-27 00:00:00', 4, '00:34:05')
  end

  def create_progress
    Progress.new(0, @@account[0], @@workout[0])
    Progress.new(1, @@account[0], @@workout[1])

    Progress.new(1, @@account[1], @@workout[2])
    Progress.new(1, @@account[1], @@workout[3])
  end

  def start
    create_person
    create_account
    create_workout
    create_progress
  end
end
