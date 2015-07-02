-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-06-28 09:44:14
-- 服务器版本： 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- 表的结构 `book_list`
--

CREATE TABLE IF NOT EXISTS `book_list` (
  `ID` int(11) NOT NULL,
  `BookName` varchar(255) NOT NULL,
  `Price` float NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Author` varchar(255) NOT NULL,
  `Pic` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `book_list`
--

INSERT INTO `book_list` (`ID`, `BookName`, `Price`, `Type`, `Author`, `Pic`) VALUES
(1, 'A', 12, 'Math', 'a', 'img/1.png'),
(2, 'B', 23.2, 'Computer', 'b', 'img/2.jpg'),
(3, 'C', 42, 'Math', 'c', 'img/3.jpg'),
(4, 'D', 99, 'Art', 'd', 'img/4.jpg'),
(5, 'E', 58.2, 'Computer', 'e', 'img/5.jpg'),
(6, 'F', 67, 'Math', 'f', 'img/6.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `cars`
--

CREATE TABLE IF NOT EXISTS `cars` (
  `caritemid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `booknum` int(11) NOT NULL,
  `bookpic` varchar(255) NOT NULL,
  `bookprice` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `cars`
--

INSERT INTO `cars` (`caritemid`, `username`, `bookname`, `booknum`, `bookpic`, `bookprice`) VALUES
(4, 'yanjiasen4', 'D', 1, 'img/4.jpg', 99);

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `orderid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `bookprice` float NOT NULL,
  `booknum` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `orders`
--

INSERT INTO `orders` (`orderid`, `username`, `bookname`, `bookprice`, `booknum`, `date`) VALUES
(1, 'yanjiasen4', 'A', 12, 10, '2015-06-27 15:54:35'),
(2, 'yanjiasen4', 'B', 23.2, 4, '2015-06-27 15:54:35'),
(3, 'yanjiasen4', 'A', 12, 1, '2015-06-27 16:22:53'),
(4, 'yanjiasen4', 'B', 23.2, 1, '2015-06-27 16:46:59'),
(5, 'yanjiasen5', 'B', 23.2, 1, '2015-06-28 13:18:08'),
(6, 'yanjiasen5', 'A', 12, 1, '2015-06-28 13:18:08'),
(7, 'yanjiasen4', 'E', 58.2, 2, '2015-05-14 09:09:00'),
(8, 'yanjiasen4', 'D', 99, 1, '2015-06-02 09:00:00'),
(9, 'yanjiasen4', 'A', 12, 3, '2015-04-15 09:12:00'),
(10, 'yanjiasen4', 'B', 23.2, 4, '2015-03-18 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`userid`, `username`, `password`, `email`) VALUES
(5, 'yanjiasen4', 'asdffdsa', '123'),
(6, 'yanjiasen5', 'asdffdsa', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_list`
--
ALTER TABLE `book_list`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`caritemid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_list`
--
ALTER TABLE `book_list`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `caritemid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
