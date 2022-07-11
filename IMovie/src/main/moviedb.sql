DROP DATABASE IF EXISTS movieDB;
CREATE DATABASE movieDB;

USE movieDB;

CREATE TABLE IF NOT EXISTS `user` (
  userId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  isAdmin BOOL NOT NULL,
  email VARCHAR(30) NOT NULL,
  userPassword VARCHAR(30) NOT NULL,
  PRIMARY KEY(userId)
);

CREATE TABLE IF NOT EXISTS `movie` (
  movieId INT NOT NULL AUTO_INCREMENT,
  movieName VARCHAR(60) NOT NULL,
  price DOUBLE NOT NULL,
  genre VARCHAR(30) NOT NULL,
  releaseDate DATE NOT NULL,
  producedBy VARCHAR(60) NOT NULL,
  pictureURL TEXT NOT NULL,
  trailerURL TEXT NOT NULL,
  movieDescription TEXT NOT NULL,
  PRIMARY KEY(movieId)
);

CREATE TABLE IF NOT EXISTS `purchasedMovie` (
  movieId INT NOT NULL,
  PRIMARY KEY(movieId)
);

CREATE TABLE IF NOT EXISTS userMovies (
	userId INT NOT NULL,
    movieId INT NOT NULL,
    PRIMARY KEY(userId, movieId)
);

ALTER TABLE `purchasedMovie`
  ADD CONSTRAINT fk_movieId1
    FOREIGN KEY (movieId)
    REFERENCES `Movie`(movieId);

ALTER TABLE `userMovies`
	ADD CONSTRAINT fk_userId
    FOREIGN KEY (userId)
    REFERENCES `user`(userId);
    
ALTER TABLE `userMovies`
	ADD CONSTRAINT fk_movieId
    FOREIGN KEY (movieId)
    REFERENCES `Movie`(movieId);
    
/* SELECT * FROM movie;
SELECT * FROM purchasedMovie;
SELECT * FROM movie INNER JOIN purchasedMovie ON movie.movieId = purchasedMovie.movieId;

SELECT * FROM movie WHERE 
MATCH(movieName, genre, producedBy, movieDescription)
AGAINST ('james'); */