-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2023 at 10:31 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `megagiga`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `kode_barang` varchar(255) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `harga_beli` bigint(20) NOT NULL,
  `harga_jual` bigint(20) NOT NULL,
  `satuan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`kode_barang`, `kategori`, `nama_barang`, `harga_beli`, `harga_jual`, `satuan`) VALUES
('57626602-0036-496c-885e-ec63fc48dec7', 'Laptop', 'Macbook M2 Pro 14 Inch 2022', 31000000, 32000000, 1),
('d5ecc5d1-4b9d-4fd7-bdf5-85e3cb8865bb', 'Laptop', 'Macbook M2 Air 2022', 16500000, 18000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penjualan`
--

CREATE TABLE `tbl_penjualan` (
  `no_faktur` bigint(20) NOT NULL,
  `tgl_faktur` datetime NOT NULL,
  `jumlah` int(11) NOT NULL,
  `nama_konsumen` varchar(100) NOT NULL,
  `harga_satuan` bigint(20) NOT NULL,
  `harga_total` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_penjualan`
--

INSERT INTO `tbl_penjualan` (`no_faktur`, `tgl_faktur`, `jumlah`, `nama_konsumen`, `harga_satuan`, `harga_total`) VALUES
(1, '2023-05-10 00:00:00', 3, 'Wahyu Budi Utomo', 81999999, 81999999),
(2, '2023-05-11 00:00:00', 2, 'John Doe', 50000000, 50000000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penjualan_barang`
--

CREATE TABLE `tbl_penjualan_barang` (
  `no_faktur` bigint(20) NOT NULL,
  `kode_barang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_penjualan_barang`
--

INSERT INTO `tbl_penjualan_barang` (`no_faktur`, `kode_barang`) VALUES
(1, '57626602-0036-496c-885e-ec63fc48dec7'),
(1, 'd5ecc5d1-4b9d-4fd7-bdf5-85e3cb8865bb'),
(2, '57626602-0036-496c-885e-ec63fc48dec7'),
(2, 'd5ecc5d1-4b9d-4fd7-bdf5-85e3cb8865bb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `tbl_penjualan_barang`
--
ALTER TABLE `tbl_penjualan_barang`
  ADD PRIMARY KEY (`no_faktur`,`kode_barang`),
  ADD KEY `FK6gxbkuvxsm60gr0wfaj1mooox` (`kode_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  MODIFY `no_faktur` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_penjualan_barang`
--
ALTER TABLE `tbl_penjualan_barang`
  ADD CONSTRAINT `FK6gxbkuvxsm60gr0wfaj1mooox` FOREIGN KEY (`kode_barang`) REFERENCES `tbl_barang` (`kode_barang`),
  ADD CONSTRAINT `FKg99ebaivnfyrg4b4hsvsdbtit` FOREIGN KEY (`no_faktur`) REFERENCES `tbl_penjualan` (`no_faktur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
