use moviedb;

insert into movie(
  movieName,
  price,
  genre,
  releaseDate,
  producedBy,
  pictureURL,
  trailerURL,
  movieDescription ) 
values ('Black Panther', 65.50, 'Action, Adventure, Sci-Fi', '2018-01-29', 'Kevin Feige', 
'https://m.media-amazon.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_.jpg', 
'https://www.imdb.com/video/vi2320939289?',
'T''Challa, after the death of his father, the King of Wakanda, returns home to the isolated, technologically advanced African nation to succeed to the throne and take his rightful place as king.'),

('Godzilla vs. Kong', 50.00, 'Action, Thriller, Sci-Fi', '2021-03-31', 'Adam Wingard Warner Bros.', 
'https://m.media-amazon.com/images/M/MV5BZmYzMzU4NjctNDI0Mi00MGExLWI3ZDQtYzQzYThmYzc2ZmNjXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi576962841?playlistId=tt5034838&ref_=tt_ov_vi',
'The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.'),

('Thunder Force', 40.00, 'Action, Adventure, Comedy', '2021-04-09', 'Melissa McCarthy, Ben Falcone, Marc Platt', 
'https://m.media-amazon.com/images/M/MV5BMWZkM2I2NjEtNWM0Mi00MTgwLWJlYTAtYmNkZWYzNmQ1ZTBiXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi1639956505?playlistId=tt10121392&ref_=tt_ov_vi',
'In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.'),

('Mortal Kombat', 55.00, 'Action, Adventure, Fantasy', '2021-04-23', 'James Wan, Todd Garner, Lawrence Kasanoff', 
'https://m.media-amazon.com/images/M/MV5BY2ZlNWIxODMtN2YwZi00ZjNmLWIyN2UtZTFkYmZkNDQyNTAyXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi3209216281?playlistId=tt0293429&ref_=tt_ov_vi',
'MMA fighter Cole Young seeks out Earth''s greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.'),

('Coming 2 America', 60.00, 'Comedy', '2021-03-04', 'Eddie Murphy, Kevin Misher', 
'https://m.media-amazon.com/images/M/MV5BZTMyY2Q2MDctMDFlMS00MWEzLTk1NmEtNDcxNzg1ZGJlNGU5XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX182_CR0,0,182,268_AL_.jpg', 
'https://www.imdb.com/title/tt6802400/videoplayer/vi1935261977?ref_=tt_pv_vi_aiv_1',
'The African monarch Akeem learns he has a long-lost son in the United States and must return to America to meet this unexpected heir and build a relationship with his son.'),

('Bad Trip', 50.00, 'Comedy', '2021-03-26', ' Kitao Sakurai', 
'https://m.media-amazon.com/images/M/MV5BNDgzMTgxOTktNmM2Ny00Nzk5LTgxNjAtNzJlNjBjNjMyOWZkXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi464240153?playlistId=tt9684220&ref_=tt_ov_vi',
'This mix of a scripted buddy comedy road movie and a real hidden camera prank show follows the outrageous misadventures of two buds stuck in a rut who embark on a cross-country road trip to NYC. The storyline sets up shocking real pranks.'),

('Aquaman', 40.00, 'Action, Adventure, Fantasy', '2021-11-21', 'James Wan', 
'https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi3588536857?playlistId=tt1477834&ref_=tt_ov_vi',
'Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land.'),

('Joker', 65.00, 'Crime, Drama, Thriller', '2019-10-04', 'Todd Phillips', 
'https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg', 
'https://www.imdb.com/video/imdb/vi1723318041?playlistId=tt7286456&ref_=tt_ov_vi',
'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.');
 
 select * from movie;
 