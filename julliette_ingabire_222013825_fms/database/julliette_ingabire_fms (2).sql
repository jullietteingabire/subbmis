-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:14 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `julliette_ingabire_fms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `fname` varchar(437) DEFAULT NULL,
  `lname` varchar(439) DEFAULT NULL,
  `idnumber` varchar(273) DEFAULT NULL,
  `phone` varchar(186) DEFAULT NULL,
  `gender` varchar(365) DEFAULT NULL,
  `martialstatus` varchar(623) DEFAULT NULL,
  `DoB` varchar(312) DEFAULT NULL,
  `email` varchar(111) DEFAULT NULL,
  `password` varchar(222) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `fname`, `lname`, `idnumber`, `phone`, `gender`, `martialstatus`, `DoB`, `email`, `password`) VALUES
(1, 'keza', 'Bibi', '199079876566', '07862426', 'Male', 'single', '20/12/2000', 'keza@gmail.com', 'kezaQgmail.com'),
(2, 'nini', 'nini', '199067878', '0786272', 'Female', 'maried', '20/02/2000', 'nini@gmail.com', 'nini');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `Customer_id` int(10) NOT NULL,
  `Customername` varchar(75) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Address` varchar(150) DEFAULT NULL,
  `Gender` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`Customer_id`, `Customername`, `Email`, `Address`, `Gender`) VALUES
(1, 'Sarah', 'sarah@gmail.com', 'Kigali', 'Female'),
(3, 'Mutoni', 'mutoini@gmail.com', 'Kigali', 'Female'),
(4, 'Vianney', 'vianney@gmail.com', 'Nyagatare', 'Male'),
(5, 'John', 'john@gmail.com', 'Kigali', 'Female'),
(13, 'sahar', 'sahar@gmail.co', 'Kigali', 'Female'),
(14, 'John', 'john@gmail.com', 'Kigali', 'Male'),
(15, 'Sahar', 'sahar@gmail.com', 'Kigali', 'Female'),
(19, 'Mutoni', 'mutoni@gmail.com', 'Kamonyi', 'Female'),
(22, 'era', 'era@gmail.com', 'nyanza', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `flower`
--

CREATE TABLE `flower` (
  `Flower_id` int(10) NOT NULL,
  `Flower_type` varchar(20) DEFAULT NULL,
  `Unit_price` int(10) DEFAULT NULL,
  `Quantity` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flower`
--

INSERT INTO `flower` (`Flower_id`, `Flower_type`, `Unit_price`, `Quantity`) VALUES
(1, 'Rose', 10, '11'),
(2, 'Granium', 10, '30'),
(4, 'granium', 34, '25kgs'),
(5, 'rose', 4356, '778 kgs'),
(8, 'venders', 233, '324kgs'),
(10, 'sunflower', 67567, '6767kgs');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `Manager_id` int(10) NOT NULL,
  `Manager_name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `Telephone` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`Manager_id`, `Manager_name`, `username`, `Telephone`, `Email`, `Customer_id`) VALUES
(1, 'Toni', 'nina', '0780495290', 'Tomas@gmail.com', 1),
(2, 'Muhirwa', 'hirwa', '0780495290', 'muhirwa@gmail.com', 3),
(3, 'Erineste', 'neste', '078049456', 'erineste@gmail.com', 5),
(4, 'Yvonne', 'vonne', '078675298', 'yvonne@gmail.com', 4),
(8, 'gfg', 'fggh', '5456', 'fdfg', NULL),
(12, 'titi', 'tini', '073857676', 'titi@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` int(11) NOT NULL,
  `Amaunt` float DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL,
  `PaymentMethod` varchar(77) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_id`, `Amaunt`, `PaymentDate`, `PaymentMethod`, `Customer_id`) VALUES
(1, 5670, '2023-10-02', 'bank', 1),
(3, 9057, '2023-10-03', 'cash', 3),
(4, 6497, '2023-11-12', 'bank', 4),
(5, 2000, '2023-06-02', 'cash', 5);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `Stock_id` int(10) NOT NULL,
  `ProductName` varchar(20) DEFAULT NULL,
  `UnitPrice` int(222) DEFAULT NULL,
  `DateReceived` date DEFAULT NULL,
  `QuantityAvailable` varchar(20) DEFAULT NULL,
  `Flower_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`Stock_id`, `ProductName`, `UnitPrice`, `DateReceived`, `QuantityAvailable`, `Flower_id`) VALUES
(4, 'Rose', 35894, '2023-10-02', '453', 1),
(5, 'Lavender', 9736, '2023-08-11', '623', 2),
(6, 'granium', 5467, '2020-12-05', '565', 4),
(8, 'Iris', 5465, '2024-02-05', '45667', NULL),
(9, 'sunflower', 5665, '2024-04-06', '5456', NULL),
(10, 'Lily', 7845, '2024-05-09', '1190', NULL),
(11, 'triplis', 6567, '2024-11-30', '4554', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_id` int(10) NOT NULL,
  `SupplierName` varchar(40) DEFAULT NULL,
  `Telephone` varchar(31) DEFAULT NULL,
  `Email` varchar(456) DEFAULT NULL,
  `Manager_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_id`, `SupplierName`, `Telephone`, `Email`, `Manager_id`) VALUES
(1, 'Manzi', '0783620003', 'mnzi@gmail.com', 1),
(2, 'NONO', '0784432203', 'nono@gmail.com', 2),
(3, 'Mimi', '0788880995', 'mimi@gmail.com', 3),
(4, 'Mource', '0727568903', 'ourice@gmail.com', 4),
(6, 'Julie', '0783564782', 'julie@gmail.com', NULL),
(7, 'mimi', '073667798', 'mimi@gmail.com', NULL),
(10, 'nepo', '07354667', 'nepo@gmail.com', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `flower`
--
ALTER TABLE `flower`
  ADD PRIMARY KEY (`Flower_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`Manager_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`Stock_id`),
  ADD KEY `Flower_id` (`Flower_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier_id`),
  ADD KEY `Manager_id` (`Manager_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `Customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `flower`
--
ALTER TABLE `flower`
  MODIFY `Flower_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `Manager_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `Stock_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `Supplier_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customers` (`Customer_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customers` (`Customer_id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`Flower_id`) REFERENCES `flower` (`Flower_id`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`Manager_id`) REFERENCES `manager` (`Manager_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
