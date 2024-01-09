-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2022 at 11:51 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dslibrary`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(255) NOT NULL,
  `isbn` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` double(255,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `isbn`, `name`, `author`, `price`) VALUES
(2, 123, 'testbook', 'testnameasdasd asdasd', 12.00),
(4, 321, 'libri asd', 'drini', 42.00),
(7, 0, 'testime', 'testime', 123.00),
(9, 7777, 'paul kalkbrenner', 'kalk', 567.00);

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE `user_account` (
  `id` int(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES
(1, 'test', 'test', 'test', 'test'),
(2, 'drini', 'drini', 'drini', 'drini'),
(3, 'lumi', 'lumi', 'lumi', '1000:4a48e42686050835765736b8f45693e0:066e5621dd29191c81812f8ce1ffeb7d9b8bbdd0ba98b615f416ca626784b227934fbd2f9a251bdd63e10a0101d5a5d55a9ff25259a765970f20f73b2441b356'),
(4, 'asd', 'asd', 'asd', '1000:ee487755a7269b5e4fef6d4e69e4aa4f:800fab348cb190dd29aea56ad7e3435e71d29a4088c29535943d4dd57d6ee294c752ad85f18503cb1c4556380a629b36b75df617ee0d7bf027cb5c05c70164ee'),
(5, 'verona', 'verona', 'verona', '1000:77bb5412a6eaaeca16edf4802285099b:d855a4efc3d1b8f76bb08a3a0b0b497873bc52d0df549dbb54204877db96b6b01d4427749ca744a5258bda8087e1771e317f14d90523fd1a83cade6afe68dac8');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user_account`
--
ALTER TABLE `user_account`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
