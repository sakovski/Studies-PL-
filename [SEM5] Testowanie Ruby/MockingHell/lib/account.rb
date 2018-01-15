class Account
  attr_accessor :id, :login, :password, :person

  def initialize(id, login, password, person)
    @id = id
    @login = login
    @password = password
    @person = person
  end

  def to_s
    "#{login} ; #{password} ; #{person}"
  end
end
