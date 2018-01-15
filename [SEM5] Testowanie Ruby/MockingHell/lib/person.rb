class Person
  attr_accessor :id, :firstname, :lastname, :country

  def initialize(id, firstname, lastname, country)
    @id = id
    @firstname = firstname
    @lastname = lastname
    @country = country
  end

  def to_s
    "#{firstname} #{lastname} #{country}"
  end
end
