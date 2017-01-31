-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2017 at 03:13 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_batch`
--

CREATE TABLE `tbl_batch` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `course_id` int(11) NOT NULL,
  `facilitator_id` int(11) NOT NULL,
  `timing_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_batch`
--

INSERT INTO `tbl_batch` (`id`, `title`, `status`, `course_id`, `facilitator_id`, `timing_id`) VALUES
(1, 'BJV_2017_1', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_course`
--

CREATE TABLE `tbl_course` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_course`
--

INSERT INTO `tbl_course` (`id`, `title`, `description`) VALUES
(1, 'Basic Java', 'basics of OOP with Java'),
(2, 'Advanced Java', 'Advanced java and frameworks');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_discount`
--

CREATE TABLE `tbl_discount` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `percentage` float NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_discount`
--

INSERT INTO `tbl_discount` (`id`, `title`, `percentage`, `status`) VALUES
(1, 'Martyr''s Day', 10, 1),
(2, 'Ex student', 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_enrollment`
--

CREATE TABLE `tbl_enrollment` (
  `id` int(11) NOT NULL,
  `enrollment_date` date NOT NULL,
  `batch_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `discount_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_enrollment`
--

INSERT INTO `tbl_enrollment` (`id`, `enrollment_date`, `batch_id`, `student_id`, `discount_id`) VALUES
(1, '2017-01-30', 1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_facilitator`
--

CREATE TABLE `tbl_facilitator` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact_number` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_facilitator`
--

INSERT INTO `tbl_facilitator` (`id`, `first_name`, `last_name`, `email`, `contact_number`, `status`) VALUES
(1, 'Dixant', 'Bahadur', 'dixant@gmail.com', '9841232435', 1),
(2, 'Ranjan', 'Shrestha', 'ranjan@gmail.com', '9841231234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact_number` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`id`, `first_name`, `last_name`, `email`, `contact_number`) VALUES
(1, 'Sailesh', 'Kasaju', 'leosailesh@gmail.com', '9801203423'),
(2, 'Sagar', 'Magar', 'sagarmagar@gmail.com', '9843700252');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_timing`
--

CREATE TABLE `tbl_timing` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_timing`
--

INSERT INTO `tbl_timing` (`id`, `title`, `start_time`, `end_time`) VALUES
(1, 'Morning', '07:00:00', '09:00:00'),
(2, 'Evening', '16:00:00', '19:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_batch`
--
ALTER TABLE `tbl_batch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_course`
--
ALTER TABLE `tbl_course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_discount`
--
ALTER TABLE `tbl_discount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_enrollment`
--
ALTER TABLE `tbl_enrollment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_facilitator`
--
ALTER TABLE `tbl_facilitator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_timing`
--
ALTER TABLE `tbl_timing`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_batch`
--
ALTER TABLE `tbl_batch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_course`
--
ALTER TABLE `tbl_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_discount`
--
ALTER TABLE `tbl_discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_enrollment`
--
ALTER TABLE `tbl_enrollment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_facilitator`
--
ALTER TABLE `tbl_facilitator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_timing`
--
ALTER TABLE `tbl_timing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
