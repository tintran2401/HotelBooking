USE [master]
GO
/****** Object:  Database [HotelBooking]    Script Date: 5/9/2020 9:08:48 ******/
CREATE DATABASE [HotelBooking]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HotelBooking', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HotelBooking.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HotelBooking_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\HotelBooking_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [HotelBooking] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HotelBooking].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HotelBooking] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HotelBooking] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HotelBooking] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HotelBooking] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HotelBooking] SET ARITHABORT OFF 
GO
ALTER DATABASE [HotelBooking] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [HotelBooking] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HotelBooking] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HotelBooking] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HotelBooking] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HotelBooking] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HotelBooking] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HotelBooking] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HotelBooking] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HotelBooking] SET  ENABLE_BROKER 
GO
ALTER DATABASE [HotelBooking] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HotelBooking] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HotelBooking] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HotelBooking] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HotelBooking] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HotelBooking] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HotelBooking] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HotelBooking] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HotelBooking] SET  MULTI_USER 
GO
ALTER DATABASE [HotelBooking] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HotelBooking] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HotelBooking] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HotelBooking] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [HotelBooking] SET DELAYED_DURABILITY = DISABLED 
GO
USE [HotelBooking]
GO
/****** Object:  Table [dbo].[tbl_Account]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Account](
	[Email] [nvarchar](50) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Phone] [int] NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[RoleId] [int] NOT NULL,
	[StatusId] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Account] PRIMARY KEY CLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Booking]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Booking](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[DateCreated] [datetime] NULL,
	[UserEmail] [nvarchar](50) NULL,
	[StatusId] [int] NULL,
	[DiscountPercent] [int] NULL,
 CONSTRAINT [PK_tbl_Booking] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_BookingDetails]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_BookingDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoomId] [int] NULL,
	[BookingId] [int] NULL,
	[CheckInDate] [datetime] NULL,
	[CheckOutDate] [datetime] NULL,
	[Amount] [int] NULL,
	[UnitPrice] [int] NULL,
 CONSTRAINT [PK_tbl_BookingDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Discount]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Discount](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Code] [varchar](50) NULL,
	[DiscountPercent] [int] NULL,
	[ExpiredDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_Hotel]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Hotel](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Location] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbl_hotel] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Role]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Role](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_Role] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Room]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Room](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[HotelId] [int] NOT NULL,
	[TypeId] [int] NOT NULL,
	[Amount] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Room] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_RoomType]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_RoomType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Status]    Script Date: 5/9/2020 9:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Status](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_Status] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tbl_Account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_tbl_Role] FOREIGN KEY([RoleId])
REFERENCES [dbo].[tbl_Role] ([Id])
GO
ALTER TABLE [dbo].[tbl_Account] CHECK CONSTRAINT [FK_tbl_Account_tbl_Role]
GO
ALTER TABLE [dbo].[tbl_Account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Account_tbl_Status] FOREIGN KEY([StatusId])
REFERENCES [dbo].[tbl_Status] ([Id])
GO
ALTER TABLE [dbo].[tbl_Account] CHECK CONSTRAINT [FK_tbl_Account_tbl_Status]
GO
ALTER TABLE [dbo].[tbl_Booking]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Booking_tbl_Account] FOREIGN KEY([UserEmail])
REFERENCES [dbo].[tbl_Account] ([Email])
GO
ALTER TABLE [dbo].[tbl_Booking] CHECK CONSTRAINT [FK_tbl_Booking_tbl_Account]
GO
ALTER TABLE [dbo].[tbl_Booking]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Booking_tbl_Status] FOREIGN KEY([StatusId])
REFERENCES [dbo].[tbl_Status] ([Id])
GO
ALTER TABLE [dbo].[tbl_Booking] CHECK CONSTRAINT [FK_tbl_Booking_tbl_Status]
GO
ALTER TABLE [dbo].[tbl_BookingDetails]  WITH CHECK ADD  CONSTRAINT [FK_tbl_BookingDetails_tbl_Booking] FOREIGN KEY([BookingId])
REFERENCES [dbo].[tbl_Booking] ([Id])
GO
ALTER TABLE [dbo].[tbl_BookingDetails] CHECK CONSTRAINT [FK_tbl_BookingDetails_tbl_Booking]
GO
ALTER TABLE [dbo].[tbl_BookingDetails]  WITH CHECK ADD  CONSTRAINT [FK_tbl_BookingDetails_tbl_Room] FOREIGN KEY([RoomId])
REFERENCES [dbo].[tbl_Room] ([Id])
GO
ALTER TABLE [dbo].[tbl_BookingDetails] CHECK CONSTRAINT [FK_tbl_BookingDetails_tbl_Room]
GO
ALTER TABLE [dbo].[tbl_Room]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Room_tbl_Hotel] FOREIGN KEY([HotelId])
REFERENCES [dbo].[tbl_Hotel] ([Id])
GO
ALTER TABLE [dbo].[tbl_Room] CHECK CONSTRAINT [FK_tbl_Room_tbl_Hotel]
GO
ALTER TABLE [dbo].[tbl_Room]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Room_tbl_RoomType] FOREIGN KEY([TypeId])
REFERENCES [dbo].[tbl_RoomType] ([Id])
GO
ALTER TABLE [dbo].[tbl_Room] CHECK CONSTRAINT [FK_tbl_Room_tbl_RoomType]
GO
USE [master]
GO
ALTER DATABASE [HotelBooking] SET  READ_WRITE 
GO
