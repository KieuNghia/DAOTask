-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 11 2015 г., 18:55
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
