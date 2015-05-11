-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 11 2015 г., 19:06
-- Версия сервера: 5.6.24
-- Версия PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `moviesdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `crew`
--

CREATE TABLE IF NOT EXISTS `crew` (
  `id` int(5) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `dateOfBirth` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `crew`
--

INSERT INTO `crew` (`id`, `firstName`, `lastName`, `dateOfBirth`) VALUES
(1, 'Kevin', 'Spacey', '1959-07-26'),
(2, 'Brad', 'Pitt', '1963-01-18'),
(3, 'Morgan', 'Freeman', '1937-07-01'),
(4, 'Angelina ', 'Jolie', '1975-07-04');

-- --------------------------------------------------------

--
-- Структура таблицы `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `year` year(4) NOT NULL,
  `country` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `movie`
--

INSERT INTO `movie` (`id`, `name`, `year`, `country`) VALUES
(1, 'Seven', 1995, 'USA'),
(2, 'Life of David Gale', 2002, 'USA'),
(3, 'House of Cardsd', 2013, 'USA'),
(4, 'American Beauty', 1999, 'USA'),
(5, 'Unbroken', 2014, 'USA'),
(6, 'Lara Croft', 2003, 'USA');

-- --------------------------------------------------------

--
-- Структура таблицы `moviecast`
--

CREATE TABLE IF NOT EXISTS `moviecast` (
  `id_movie` int(11) NOT NULL,
  `id_crew` int(11) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `moviecast`
--

INSERT INTO `moviecast` (`id_movie`, `id_crew`, `role`) VALUES
(1, 1, 'actor'),
(5, 4, 'director'),
(1, 2, 'actor'),
(3, 1, 'actor'),
(4, 1, 'actor'),
(1, 2, ''),
(1, 2, 'actor'),
(1, 3, 'actor'),
(6, 4, 'actor');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `crew`
--
ALTER TABLE `crew`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `crew`
--
ALTER TABLE `crew`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
