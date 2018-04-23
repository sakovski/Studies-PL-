class Book < ApplicationRecord
  validates :title, :length => { :in => 3..20 }, presence: true
  validates :genre, :length => { :in => 3..20 }, :format => { :with => /\A[a-ząćęłńóśźżA-ZĄĆĘŁŃÓŚŹŻ]+\z/, :message => " can't contain inappropriate characters" }
  validates :year, format: { with: /\A\d+(?:\.\d{0,2})?\z/ }, numericality: { greater_than_or_equal_to: 0 }
  validates :description, :length => { :in => 0..300 }
  validate :year_in_the_future?

  def self.search(book)
    if book
      where('title LIKE ? OR genre LIKE ? OR author LIKE ?', "%#{book}%", "%#{book}%", "%#{book}%")
    else
      all
    end
  end


  private

  def year_in_the_future?
    if self.year != nil and self.year > Date.today.year
      errors.add("Books", " from the future can't exist :)")
    end
  end
end
