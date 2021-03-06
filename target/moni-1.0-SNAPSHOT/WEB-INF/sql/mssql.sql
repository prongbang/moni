USE [spring]
GO
/****** Object:  Table [dbo].[book]    Script Date: 1/11/2016 11:57:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[price] [decimal](18, 0) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_roles]    Script Date: 1/11/2016 11:57:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_roles](
	[user_role_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[role] [varchar](50) NOT NULL,
 CONSTRAINT [PK_user_roles] PRIMARY KEY CLUSTERED 
(
	[user_role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 1/11/2016 11:57:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](512) NOT NULL,
	[enabled] [tinyint] NOT NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[book] ([id], [name], [price]) VALUES (1, N'Book 1', CAST(1000 AS Decimal(18, 0)))
INSERT [dbo].[book] ([id], [name], [price]) VALUES (2, N'Book 2', CAST(2000 AS Decimal(18, 0)))
INSERT [dbo].[book] ([id], [name], [price]) VALUES (3, N'dddd', CAST(2222 AS Decimal(18, 0)))
INSERT [dbo].[book] ([id], [name], [price]) VALUES (4, N'Book 5', CAST(44444 AS Decimal(18, 0)))
INSERT [dbo].[book] ([id], [name], [price]) VALUES (5, N'ssss', CAST(1111 AS Decimal(18, 0)))
INSERT [dbo].[book] ([id], [name], [price]) VALUES (6, N'xxx', CAST(222 AS Decimal(18, 0)))
SET IDENTITY_INSERT [dbo].[user_roles] ON 

INSERT [dbo].[user_roles] ([user_role_id], [username], [role]) VALUES (1, N'prongbang', N'ROLE_USER')
INSERT [dbo].[user_roles] ([user_role_id], [username], [role]) VALUES (2, N'prongbang', N'ROLE_ADMIN')
SET IDENTITY_INSERT [dbo].[user_roles] OFF
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'prongbang', N'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', 1)
