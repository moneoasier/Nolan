USE [master]
GO
/****** Object:  Database [Nolan]    Script Date: 19/11/2021 12:12:57 ******/
CREATE DATABASE [Nolan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Nolan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Nolan.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Nolan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Nolan_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Nolan] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Nolan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Nolan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Nolan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Nolan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Nolan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Nolan] SET ARITHABORT OFF 
GO
ALTER DATABASE [Nolan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Nolan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Nolan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Nolan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Nolan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Nolan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Nolan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Nolan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Nolan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Nolan] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Nolan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Nolan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Nolan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Nolan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Nolan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Nolan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Nolan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Nolan] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Nolan] SET  MULTI_USER 
GO
ALTER DATABASE [Nolan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Nolan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Nolan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Nolan] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Nolan] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Nolan] SET QUERY_STORE = OFF
GO
USE [Nolan]
GO
/****** Object:  User [UNI\peralta.laura]    Script Date: 19/11/2021 12:12:57 ******/
CREATE USER [UNI\peralta.laura] FOR LOGIN [UNI\peralta.laura] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [UNI\moneo.asier]    Script Date: 19/11/2021 12:12:57 ******/
CREATE USER [UNI\moneo.asier] FOR LOGIN [UNI\moneo.asier] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [UNI\hayar.abderrafia]    Script Date: 19/11/2021 12:12:57 ******/
CREATE USER [UNI\hayar.abderrafia] FOR LOGIN [UNI\hayar.abderrafia] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [admin]    Script Date: 19/11/2021 12:12:57 ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_datareader] ADD MEMBER [admin]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [admin]
GO
/****** Object:  Table [dbo].[app_users]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_users](
	[email] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[id] [numeric](18, 0) NULL,
 CONSTRAINT [PK_app_users] PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hr_employee]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hr_employee](
	[id] [int] NOT NULL,
	[barcode] [varchar](50) NULL,
	[department_id] [int] NULL,
	[gender] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[work_email] [varchar](50) NULL,
	[create_uid] [varchar](50) NULL,
	[user_id] [varchar](50) NULL,
 CONSTRAINT [PK_hr_employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_category]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_category](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_product_category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_template]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_template](
	[id] [int] NOT NULL,
	[create_date] [varchar](50) NULL,
	[list_price] [decimal](18, 0) NULL,
	[default_code] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[categ_id] [int] NOT NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[res_partner]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[res_partner](
	[id] [int] NOT NULL,
	[city] [varchar](50) NULL,
	[create_date] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[type] [varchar](50) NULL,
	[signup_type] [varchar](50) NULL,
 CONSTRAINT [PK_res_partner] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[res_users]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[res_users](
	[id] [int] NOT NULL,
	[create_date] [varchar](50) NULL,
	[login] [varchar](50) NULL,
	[write_date] [varchar](50) NULL,
	[partner_id] [varchar](50) NULL,
 CONSTRAINT [PK_res_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sale_order]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sale_order](
	[id] [int] NOT NULL,
	[amount_tax] [int] NULL,
	[amount_total] [int] NULL,
	[date_order] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[procurement_group_id] [int] NULL,
	[state] [varchar](50) NULL,
	[partner_id] [varchar](50) NULL,
	[create_uid] [varchar](50) NULL,
	[user_id] [varchar](50) NULL,
 CONSTRAINT [PK_sale_order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sale_order_line]    Script Date: 19/11/2021 12:12:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sale_order_line](
	[id] [int] NOT NULL,
	[create_date] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[price_total] [decimal](18, 0) NULL,
	[price_unit] [decimal](18, 0) NULL,
	[state] [varchar](50) NULL,
	[order_partner_id] [varchar](50) NULL,
	[create_uid] [varchar](50) NULL,
	[order_id] [varchar](50) NULL,
 CONSTRAINT [PK_sale_order_line] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [Nolan] SET  READ_WRITE 
GO
