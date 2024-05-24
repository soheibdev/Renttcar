-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 mai 2024 à 17:15
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `losrent`
--

-- --------------------------------------------------------

--
-- Structure de la table `carregistation`
--

CREATE TABLE `carregistation` (
  `Registrationnum` varchar(20) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Model` varchar(255) NOT NULL,
  `Statut` text NOT NULL,
  `Price` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `carregistation`
--

INSERT INTO `carregistation` (`Registrationnum`, `Brand`, `Model`, `Statut`, `Price`) VALUES
('C0001', 'AUDI', 'A07', 'Available', '7000000'),
('C0002', 'AUDI', 'Q3', 'Available', '5000'),
('C0003', 'MERCESES', 'A54', 'Available', '600'),
('C0004', 'AUDI', 'RSQ8', 'Available', '9999'),
('C0005', 'BMW', 'M7', 'Available', '900'),
('C0001', 'AUDI', 'A07', 'Available', '7000000'),
('C0006', '', '', 'Booked', ''),
('C0007', 'ggg', 'dd', 'Booked', '66'),
('C0008', 'rrr', 'w', 'Booked', '6'),
('C0008', 'fgd', 'sdfgd', 'Available', '5555'),
('C0009', 'rrr', 'svf', 'Booked', '44'),
('C0010', 'rrrr', 'ddd', 'Booked', '555'),
('C0011', '', '', 'Booked', ''),
('C0012', 't', 'r', 'Available', '4'),
('C0013', 'tt', 'dfd', 'Available', '55');

-- --------------------------------------------------------

--
-- Structure de la table `customer2`
--

CREATE TABLE `customer2` (
  `cust_id` varchar(255) NOT NULL,
  `name` text NOT NULL,
  `address` varchar(255) NOT NULL,
  `mobile` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `renttable`
--

CREATE TABLE `renttable` (
  `Rentid` int(255) NOT NULL,
  `Registration` varchar(255) NOT NULL,
  `Customername` text NOT NULL,
  `Rentdate` date NOT NULL,
  `Returndate` date NOT NULL,
  `Fees` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `renttable`
--

INSERT INTO `renttable` (`Rentid`, `Registration`, `Customername`, `Rentdate`, `Returndate`, `Fees`) VALUES
(111, '222', 'mohamed', '2024-04-06', '2024-04-06', 888),
(3333, 'eett', 'mohamed', '2024-04-07', '2024-04-03', 9999),
(22222, 'FGDFGDFG', 'YOUNES', '2024-04-10', '2024-04-01', 5555),
(3333, 'SDTDT', 'mohamed', '2024-04-04', '2024-04-11', 66),
(555, 'fafsfs', 'mohamed', '2024-05-10', '2024-05-01', 555);

-- --------------------------------------------------------

--
-- Structure de la table `return`
--

CREATE TABLE `return` (
  `Returnid` int(255) NOT NULL,
  `Registration` varchar(255) NOT NULL,
  `Returndate` date NOT NULL,
  `delay` varchar(255) NOT NULL,
  `fine` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `return`
--

INSERT INTO `return` (`Returnid`, `Registration`, `Returndate`, `delay`, `fine`) VALUES
(4444, 'vcbcv', '2024-04-06', '4', 'Mechanical problem'),
(444, 'fgfdg', '2024-04-06', '5t', 'Mechanical problem'),
(4444, 'fgdfg', '2024-04-13', '4', 'Mechanical problem');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
