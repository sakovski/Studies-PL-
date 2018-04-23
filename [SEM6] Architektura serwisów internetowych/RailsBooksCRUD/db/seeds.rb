# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
Book.destroy_all
Book.create(title: 'Harry Potter', author: 'J K Rowling', genre: 'Fantasy', year: '2013', description: '')
Book.create(title: 'Lalka', author: 'Bolesław Prus', genre: 'Horror', year: '2017', description: 'Iza Łęcka')
Book.create(title: 'Dziady 1', author: 'Adam Mickiewicz', genre: 'Thriller', year: '1998', description: 'No words, pure story')
Book.create(title: 'Dziady 2', author: 'Adam Mickiewicz', genre: 'War', year: '1234', description: 'One Word, No Story')
Book.create(title: 'Dziady 3', author: 'Adam Mickiewicz', genre: 'Horror', year: '1885', description: 'Pure Words, No SKill')
Book.create(title: 'Oaza Spokoju', author: 'Marcin Krzywy', genre: 'Kids', year: '1995', description: 'Krzywo')
