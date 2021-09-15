CREATE DATABASE bookstore;
USE bookstore;

CREATE TABLE PUBLISHER (
PUBLISHER_CODE VARCHAR(4) NOT NULL,
PUBLISHER_NAME VARCHAR(100) NOT NULL,
PRIMARY KEY (PUBLISHER_CODE)
);
CREATE TABLE BOOK (
ISBN VARCHAR(50) NOT NULL,
BOOK_NAME VARCHAR(100) NOT NULL,
PUBLISHER_CODE VARCHAR(4),
PRIMARY KEY (ISBN),
FOREIGN KEY (PUBLISHER_CODE) REFERENCES PUBLISHER (PUBLISHER_CODE)
);
CREATE TABLE CHAPTER (
BOOK_ISBN VARCHAR(50) NOT NULL,
CHAPTER_NUM INT NOT NULL,
TITLE VARCHAR(100) NOT NULL,
PRIMARY KEY (BOOK_ISBN, CHAPTER_NUM),
FOREIGN KEY (BOOK_ISBN) REFERENCES BOOK (ISBN)
);

SELECT * FROM publisher;
SELECT * FROM book;
SELECT * FROM chapter;

DROP TABLE chapter;
DROP TABLE book;
DROP TABLE bookstore.publisher;