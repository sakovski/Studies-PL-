json.extract! book, :id, :title, :author, :genre, :year, :description, :created_at, :updated_at
json.url book_url(book, format: :json)
