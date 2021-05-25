﻿use master
go

create database QuanLyMuaBanLinhKien
go

use QuanLyMuaBanLinhKien
go

create table NhanVien(
	maNhanVien varchar(10) not null,
	hoTenNV nvarchar(50) not null,
	gioiTinhNV nvarchar(10) null,
	ngaySinhNV date null,
	soDienThoaiNV varchar(12) null,
	diaChiNV ntext not null,
	matKhau varchar(50) not null,
	quyenTruyCap varchar(10) not null

	constraint PK_MaNhanVien primary key(maNhanVien)
)
go

create table KhachHang(
	maKhachHang varchar(10) not null,
	hoTenKH nvarchar(50) not null,
	soDienThoaiKH varchar(12),
	diaChiKH ntext not null

	constraint PK_MaKhachHang primary key (maKhachHang)
)
go

create table HoaDon(
	maHoaDon varchar(10) not null,
	maNhanVien varchar(10) not null,
	maKhachHang varchar(10) not null,
	ngayLapHoaDon datetime not null

	constraint PK_MaHoaDon primary key(maHoaDon),
	
	constraint FK_HoaDon_KhachHang foreign key (maKhachHang) references KhachHang(maKhachHang)
	on update cascade on delete cascade,
	
	constraint FK_HoaDon_NhanVien foreign key (maNhanVien) references NhanVien(maNhanVien)
	on update cascade on delete cascade
)
go

create table LinhKien(
	maLinhKien varchar(10) not null,
	tenLinhKien nvarchar(150) not null,
	loaiLinhKien nvarchar(50) null,
	moTa ntext null,
	donGia money not null,
	thuongHieu ntext null,
	soLuongTon int not null,
	ngayNhap date null,
	baoHanh int null


	constraint PK_MaLinhKien primary key(maLinhKien)
)
go

create table ChiTietHoaDon (
	maHoaDon varchar(10) not null,
	maLinhKien varchar(10) not null,
	soLuong int not null,

	constraint PK_CTHD primary key (maHoaDon, maLinhKien),

	constraint FK_CTHD_HoaDon foreign key (maHoaDon) references HoaDon(maHoaDon)
	on update cascade on delete cascade,

	constraint FK_CTHD_LinhKien foreign key (maLinhKien) references LinhKien(maLinhKien)
	on update cascade on delete cascade
)
go

use QuanLyMuaBanLinhKien
go

insert NhanVien values
('18026731', N'Võ Minh Nguyên', 'Nam', '2000-05-14', '0914370067', N'Gò Vấp', '123456', 'User'),
('19521341', N'Nguyễn Chí Hiếu', 'Nam', '2001-08-30', '0366497865', N'Quận 4', 'admin', 'Admin'),
('19522701', N'Nguyễn Văn Lâm', 'Nam', '2001-01-19', '0985140102', N'Gò Vấp', '123456', 'User'),
('19524691', N'Bùi Quang Hữu', 'Nam', '2001-05-14', '0975247624', N'Gò Vấp', 'admin', 'Admin')
go

INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenKH], [SoDienThoaiKH], [DiaChiKH]) VALUES 
('19516961', N'Mã Tiểu Linh', '0356934464', N'Gò Vấp'),
('19502941', N'Trần Đức Huy', '0866520341', N'Q3'),
('19505491', N'Nguyễn Duy Hoàng An', '0382129718', N'Gò Vấp'),
('19506111', N'Võ Thị Minh Thư', '0389888497', N'Q5'),
('19508651', N'Nguyễn Văn Khang', '0354470382', N'Q1'),
('19509451', N'Đoàn Văn Phong', '0353024808', N'Thủ Đức'),
('19517291', N'Phạm Công Tính', '0967295025', N'Q9'),
('19523031', N'Bùi Hoàng Phúc', '0798662438', N'Gò Vấp'),
('19523981', N'Mai Văn Hải', '0902709090', N'Bình Thạnh'),
('19524811', N'Lê Thị Đông Anh', '0372689440', N'Gò Vấp'),
('19527261', N'Đàm Hoàng Phúc', '0828427364', N'Bình Thạnh'),
('19530359', N'Trương Đình Phước', '0798662438', N'Gò Vấp'),
('19535184', N'Đức Minh', '02839308131', N'Bình Thạnh'),
('19536522', N'Trần Thị Cúc', '0333429987', N'Tân Phú'),
('19544818', N'Lê Quý Thanh', '0398689239', N'Bình Thạnh'),
('19545260', N'Phan Văn Ninh', '0903001435', N'Tân Phú'),
('19546308', N'Nguyễn Tuấn Anh', '0798662439', N'Gò Vấp'),
('19555671', N'Nguyễn Trần Nhật Hào', '0373668360', N'Bình Thạnh'),
('19556113', N'Lê Anh Thông', '0903387746', N'Q10'),
('19569236', N'Thành Nam', '0333429986', N'Q7'),
('19569362', N'Trương Đình Pước', '0798662438', N'Gò Vấp'),
('19572341', N'Lại Đình Nhân', '0798662439', N'Thủ Đức'),
('19576379', N'Nguyễn Thành Lâm', '01900819800', N'Thủ Đức'),
('19577570', N'Huỳnh Anh Tiên', '0798662438', N'Gò Vấp'),
('19578910', N'Huỳnh Anh Tiên', '0373668366', N'Gò Vấp'),
('19591702', N'Lê Quý Thanh', '0398689239', N'Bình Thạnh'),
('19592855', N'Công Cường', '0333429987', N'Q3'),
('19593316', N'Vũ Linh Thảo', '0980377337', N'Q5'),
('19593331', N'Nguyễn Thị Xuân Mỹ', '0797368482', N'Q7')
GO

INSERT [dbo].[LinhKien] (maLinhKien, tenLinhKien, moTa, donGia, loaiLinhKien, thuongHieu, soLuongTon, ngayNhap, baoHanh) 
VALUES ('LK000001', N'Ổ cứng HDD Seagate Backup Plus', N'Tên sản phẩm: ổ cứng HDD Seagate 1TB Backup Plus 3.0, 2.5'' (Đỏ)
- Dung lượng: 1TB
- Kích thước: 2.5"
- Kết nối: USB 3.0', 1640000, N'HDD', N'SEAGATE', 30, CAST(N'2020-06-10' AS Date), 36),
('LK000002', N'Ổ cứng HDD Seagate Expansion Desktop 3TB 3.5" 3.0', N'Tên sản phẩm: ổ cứng HDD Seagate Expansion Desktop 3TB 3.5" 3.0 (STEB3000300)
- Dung lượng: 3TB
- Kích thước: 3.5"
- Kết nối: USB 3.0', 2890000, N'HDD', N'SEAGATE', 22, CAST(N'2020-01-01' AS Date), 36),
('LK000003', N'Tản nhiệt CPU AIO Cooler Master Masterliquid ', N'Tên sản phẩm: Tản nhiệt CPU AIO CM Masterliquid ML240P Mirage
- Tên sản phẩm: MASTERLIQUID ML240P MIRAGE
- Dạng tản nhiệt: Tản nước
- Chất liệu: Nhôm', 3840000, N'Tản nhiệt', N'Cooler Master', 20, CAST(N'2020-04-15' AS Date), 60),
('LK000004', N'Đế tản nhiệt Laptop DEEPCOOL Windpal Mini', N'Tên sản phẩm: Tản nhiệt/ Fan laptop Deep cool Windpal Mini
- Cổng kết nối: USB
- Phù hợp laptop 15.6" trở xuống
- Tốc độ quạt: 1000 ± 10% rpm
- Kích thước: 140x140x15 mm
- Trọng lượng: 575g
- Màu sắc: Đen', 209000, N'Tản Nhiệt', N'DEEPCOOL', 33, CAST(N'2020-03-12' AS Date), 12),
('LK000005', N'RAM desktop ADATA AD4U240038G17-R (1x8GB) DDR4 2400MHz', N'Tên sản phẩm: Bộ nhớ DDR4 Adata 8GB (2400) AD4U240038G17-R
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz', 1490000, N'RAM', N'ADATA', 20, CAST(N'2020-02-14' AS Date), 36),
('LK000006', N'Case máy tính AeroCool Night Hawk - Mid Tower', N'Tên sản phẩm: Thùng máy/ Case Aerocool Night Hawk
- Hỗ trợ mainboard: Mini-ITX, Micro-ATX, ATX, Extended-ATX
- Khay mở rộng tối đa: 2 x 3.5", 4 x 2.5"
- USB: , 2 x USB 3.0', 990000, N'Case', N'AeroCool', 15, CAST(N'2020-01-01' AS Date), 12),
('LK000007', N'RAM server Kingston KSM24ES8/8ME (1x8GB) DDR4', N'Tên sản phẩm: Bộ nhớ/ Ram Kingston 8GB ECC DDR4 2400 (KSM24ES8/8ME)
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz
- Cas: 17', 1490000, N'RAM', N'KINGSTON', 20, CAST(N'2020-02-12' AS Date), 36),
('LK000008', N'RAM laptop Crucial (1x8GB) DDR4 2400MHz', N'Tên sản phẩm: Bộ nhớ laptop DDR4 Crucial 8GB (2400) - CT8G4SFS824A
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz
- Cas: 17', 980000, N'RAM', N'CRUCIAL', 17, CAST(N'2020-04-25' AS Date), 36),
('LK000009', N'Bàn phím cơ Asus ROG Strix Scope (Red switch)', N'Tên sản phẩm: Bàn phím cơ Asus ROG Strix Scope (Red switch)
- Bàn phím cơ
- Kết nối: USB
- Switch: Cherry MX', 3590000, N'Bàn phím', N'ASUS', 10, CAST(N'2020-03-06' AS Date), 12),
('LK000010', N'Bàn phím cơ AKKO 3084 World Tour - Blue Switch', N'Tên sản phẩm: Bàn phím cơ AKKO 3084 World Tour - Tokyo Blue Switch (84 keys)
- Bàn phím cơ
- Kết nối: USB Type-C
- Switch: Akko Blue
- phụ kiện đi kèm: Key puller, Cover chống bụi, cáp USB-C, Keycap tặng kèm', 1299000, N'Bàn phím', N'AKKO', 22, CAST(N'2020-04-12' AS Date), 12),
('LK000011', N'Bàn phím Akko 3108S RGB PRO Blue Switch', N'Tên sản phẩm: Bàn phím Akko 3108S RGB PRO Blue Switch (108 keys) (Đen)
- Bàn phím cơ
- Kết nối: USB Type-C
- Switch: Cherry MX Blue
- phụ kiện đi kèm: Key puller, Cover chống bụi, cáp USB-C', 2399000, N'Bàn phím', N'AKKO', 14, CAST(N'2020-04-12' AS Date), 12),
('LK000012', N'Bàn phím Dareu EK880 Blue Switch', N'Tên sản phẩm: Bàn phím cơ Dareu EK880 Blue Switch
- Kiểu: Bàn phím cơ 
- Kiểu kết nối: Có dây
- Switch: Blue D switch
- Đèn nền: RGB
- Kích thước: Tenkeyless
- Màu sắc: Đen', 749000, N'Bàn phím', N'DAREU', 28, CAST(N'2020-05-20' AS Date), 24),
('LK000013', N'Màn Hình cong Samsung 27" LC27F397FHEXXV', N'Tên sản phẩm: Màn hình LCD Samsung 27'''' LC27F397FHEXXV
- Kích thước: 27"
- Độ phân giải: 1920 x 1080 ( 16:9 )
- Công nghệ tấm nền: VA
- Góc nhìn: 178 (H) / 178 (V)
- Tần số quét: 60Hz
- Thời gian phản hồi: 4 ms', 4490000, N'Màn hình', N'SAMSUNG', 11, CAST(N'2020-06-01' AS Date), 24),
('LK000014', N'Màn hình cong ACER 24" ED242QR', N'Tên sản phẩm: Màn hình cong ACER 24" ED242QR
- Kích thước: 23.6" (1920 x 1080), Tỷ lệ 16:9
- Tấm nền VA, Góc nhìn: 178 (H) / 178 (V)
- Tần số quét: 75Hz , Thời gian phản hồi 4 ms
- HIển thị màu sắc: 16.7 triệu màu
- Cổng hình ảnh: , 1 x HDMI, 1 x VGA/D-sub', 3690000, N'Màn hình', N'ACER', 10, CAST(N'2020-01-20' AS Date), 36),
('LK000015', N'Màn hình LCD Asus 24" VL249HE (1920 x 1080/IPS/75Hz/5 ms', N'Tên sản phẩm: Màn hình LCD Asus 24" VL249HE
- Kích thước: 23.8" (1920 x 1080), Tỷ lệ 16:9
- Tấm nền IPS, Góc nhìn: 178 (H) / 178 (V)
- Tần số quét: 75Hz , Thời gian phản hồi 5 ms
- Cổng hình ảnh: , 1 x HDMI, 1 x VGA/D-sub', 3850000, N'Màn hình', N'ASUS', 17, CAST(N'2020-02-15' AS Date), 36),
('LK000016', N'Màn hình LCD LENOVO 18.5" D19-10 (61E0KAR6WW) (1366 x 768/TN/60Hz/5 ms', N'Tên sản phẩm: Màn hình LCD LENOVO 18.5" D19-10 (61E0KAR6WW)
- Kích thước: 18.5" (1366 x 768), Tỷ lệ 16:9
- Tấm nền TN, Góc nhìn: 90 (H) / 65 (V)
- Tần số quét: 60Hz , Thời gian phản hồi 5 ms
- HIển thị màu sắc: 16.7 triệu màu
- Cổng hình ảnh: , 1 x HDMI, 1 x VGA/D-sub', 1590000, N'Màn hình', N'Lenovo', 19, CAST(N'2019-11-01' AS Date), 36),
('LK000017', N'Chuột máy tính Dareu EM908', N'Tên sản phẩm: Chuột máy tính Dareu EM908
- Kiểu kết nối: Có dây
- Cảm biến: BRAVO ATG4090
- Độ phân giải: 6000 DPI
- Màu sắc: Đen', 349000, N'Chuột', N'DAREU', 14, CAST(N'2020-01-01' AS Date), 24),
('LK000018', N'Chuột máy tính có dây E-dra EM602 (Đen)', N'Tên sản phẩm: Chuột máy tính có dây E-dra EM602 (Đen)
- Chuột chơi game E-dra EM602 
- Chuẩn kết nối USB, độ phân giải 1200DPI 
- Chất liệu nhựa phủ lớp chống nước 
- Switch: Hunao cho độ bền lên đến 10 triệu lần nhấn 
- Tương thích hệ điều hành: Windows 98 / 2000 / ME / NT / XP / win 7', 149000, N'Chuột', N'E-Dra', 22, CAST(N'2020-02-12' AS Date), 24),
('LK000019', N'Chuột gaming EMS610 (Đen)', N'Tên sản phẩm: Chuột máy tính E-Dra EMS610 (Đen)
- Thương hiệu: E-Dra - Mã sản phẩm: EMS610 - Kích thước:125 x 66 x 39 mm', 259000, N'Chuột', N'E-Dra', 30, CAST(N'2019-12-31' AS Date), 12),
('LK000020', N'Chuột máy tính Akko LW325 (Hồng)', N'Tên sản phẩm: Chuột máy tính Akko LW325 (Hồng)
- Thiết kế công thái học cho người thuận tay phải 
- Mắt đọc PWM3325, kết nối USB 
- Vỏ nhựa ABS, Switch Omron (50 triệu lần nhấn) 
- Đèn LED RGB có thể điều chỉnh được thông qua phần mềm driver riêng', 599000, N'Chuột', N'AKKO', 14, CAST(N'2020-06-02' AS Date), 12),
('LK000021', N'Mainboard ASUS EX-B365M-V5', N'Tên sản phẩm: Bo mạch chính/ Mainboard Asus EX-B365M-V5
- Chuẩn mainboard: Micro-ATX
- Socket: LGA 1151-v2 , Chipset: B365
- Hỗ trợ RAM: DDR4 , tối đa 32GB
- Cổng cắm lưu trữ: 1 x M.2 SATA/NVMe; 4 x SATA 3 6Gb/s; Hỗ trợ Intel Optane
- Cổng xuất hình: 1 x HDMI; 1 x VGA/D-sub', 1750000, N'Mainboard ', N'ASUS', 19, CAST(N'2020-01-01' AS Date), 36),
('LK000022', N'USB 256GB SANDISK Ultra Flair', N'Tên sản phẩm: ổ cứng di động/ USB Sandisk Ultra Flair 256GB SDCZ73-256G-G46
- SanDisk Ultra Flair USB 3.0 Flash Drive 
- Tốc lên đến 150MB/s 
- Password Protech giúp bảo mật an toàn dữ liệu 
- Hỗ trợ Window 7 trở lên, Mac OS 10.9 trở lên', 940000, N'USB', N'SANDISK', 30, CAST(N'2020-02-28' AS Date), 60),
('LK000023', N'Cáp Nối Nguồn Cooler Master Sleeved Extension', N'Tên sản phẩm: Cáp Nối Nguồn Cooler Master Sleeved Extension CMA-SEST16XXBK1-GL (Đen)
- Model: CMA-SEST16XXBK1-GL 
- CONNECTORS: 1x 24 Pin, 1x 8(4+4) Pin, 2x PCI-e 6 Pin, 2x PCI-e 8 Pin 
- CABLE CLIP NUMBERS: 4x 24 Pin, 12x 8 Pin, 8x 6 Pin
- Màu sắc: Đen', 670000, N'Cáp', N'Cooler Master', 32, CAST(N'2019-11-11' AS Date), 12),
('LK000024', N'Ổ cứng SSD Western Digital WD Green 240GB M.2 2280 SATA 3', N'Tên sản phẩm: Ổ cứng SSD WD Green 240GB M2-2280 (WDS240G2G0B)
- Dung lượng: 240GB
- Kích thước: M.2 2280
- Kết nối: M.2 SATA
- Tốc độ đọc / ghi (tối đa): 545MB/s', 930000, N'SSD', N'WD', 23, CAST(N'2020-05-01' AS Date), 36),
('LK000025', N'Ổ cứng SSD Western Digital WD Green 520GB M.2 2280 SATA 3', N'Tên sản phẩm: Ổ cứng SSD WD Green 520GB M2-2280 (WDS240G2G0B),
- Dung lượng: 520GB
- Kích thước: M.2 2280
- Kết nối: M.2 SATA
- Tốc độ đọc / ghi (tối đa): 545MB/s', 930000, N'SSD', N'WD', 27, CAST(N'2020-05-01' AS Date), 36),
('LK000026', N'Ổ cứng SSD Western Digital Blue 500GB M.2 2280 SATA 3', N'Tên sản phẩm: Ổ cứng SSD WD Blue 500GB M2-2280 (WDS500G2B0B)
- Dung lượng: 500GB
- Kích thước: M.2 2280
- Kết nối: M.2 SATA
- Tốc độ đọc / ghi (tối đa): 560MB/s / 530MB/s', 1790000, N'SSD', N'WD', 30, CAST(N'2020-05-15' AS Date), 36),
('LK000027', N'Ổ cứng HDD Seagate BARRACUDA 2TB 3.5" Sata', N'Tên sản phẩm: Ổ cứng HDD Seagate BARRACUDA 2TB 3.5" Sata (ST2000DM005)
- Dung lượng: 2TB
- Kích thước: 3.5"
- Kết nối: SATA 3
- Tốc độ vòng quay: 5400RPM
- Cache: 256MB', 1590000, N'HDD', N'SEAGATE', 29, CAST(N'2020-05-15' AS Date), 36),
('LK000028', N'Ổ cứng SSD Seagate BARRACUDA 120 250GB 2.5" Sata', N'Tên sản phẩm: Ổ cứng SSD Seagate BARRACUDA 120 250GB 2.5" Sata (ZA250CM1A003)
- Dung lượng: 250GB
- Kích thước: 2.5"
- Kết nối: SATA
- NAND: 3D-NAND
- Tốc độ đọc/ghi (tối đa): 560MB/s | 540M', 1490000, N'SSD', N'SEAGATE', 30, CAST(N'2020-05-15' AS Date), 60),
('LK000029', N'Đế tản nhiệt Laptop Cooler Master C3', N'Tên sản phẩm: Tản nhiệt/ Fan laptop CM C3
- Cổng kết nối: USB
- Phù hợp cho laptop 15.6" trở xuống
- Tốc độ quạt: 700 ± 10 % RPM
- Kích thước: 322 x 290 x 50 mm
- Trọng lượng: 0,55 kg
- Màu sắc: Đen', 230000, N'Tản nhiệt', N'Cooler Master', 22, CAST(N'2020-03-15' AS Date), 6),
('LK000030', N'Tản khí Cooler Master XDream i117', N'Tên sản phẩm: Quạt CPU Cooler Master X Dream i117
- Kích thước 112.2 x 112.2 x 60.4 mm - Tốc độ 1,800 ± 10 % RPM - Độ ồn 19 dBA - Lưu lượng gió 36.5 CFM ±10% - Tương thích Intel 1156 / 1155 / 1151 / 1150 / 775', 220000, N'Tản nhiệt', N'Cooler Master', 26, CAST(N'2020-03-15' AS Date), 12),
('LK000031', N'RAM laptop Crucial (1x8GB) DDR4 2400MHz', N'Tên sản phẩm: Bộ nhớ laptop DDR4 Crucial 8GB (2400) - CT8G4SFS824A
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz
- Cas: 17', 980000, N'RAM', N'CRUCIAL', 17, CAST(N'2020-04-25' AS Date), 36),
('LK000032', N'Quạt 120E', N'Tên sản phẩm: Quạt case đèn 12" (120E)
- Fan 12cm - Led xanh lam', 60000, N'Tản nhiệt', N'ADATA', 40, CAST(N'2020-02-14' AS Date), 8),
('LK000033', N'Quạt Sama Halo Dual Ring Regular RGB', N'Tên sản phẩm: Quạt case Sama Halo Dual Ring Regular RGB 12cm Fan 7 Colors/RGB
- Thương hiệu: Halo - Kích thước quạt: 12cm - Loại đèn quạt: 7 màu/RGB', 185000, N'Tản nhiệt', N'SAMA', 32, CAST(N'2020-02-14' AS Date), 12),
('LK000034', N'Quạt 8cm', N'Tên sản phẩm: Quạt case 8cm
Quạt CPU Số lượng: 1 quạt Công suất: 10V', 14000, N'Tản nhiệt', N'Khác', 29, CAST(N'2020-02-14' AS Date), 0),
('LK000035', N'CPU INTEL Core i5-10400', N'Tên sản phẩm: Bộ vi xử lý/ CPU Intel Comet Lake Core i5-10400 (6 Cores 12 Threads up to 4.30 GHz 10th Gen LGA 1200)
- Socket: LGA 1200 , Intel Core thế hệ thứ 10
- Tốc độ xử lý: 2.90 GHz - 4.30 GHz ( 6 nhân, 12 luồng)
- Bộ nhớ đệm: 12MB
- Đồ họa tích hợp: Intel UHD Graphics 630', 4890000, N'CPU', N'INTEL', 30, CAST(N'2020-02-14' AS Date), 12),
('LK000036', N'Màn hình LCD Asus 24" VL249HE (1920 x 1080/IPS/75Hz/5 ms', N'Tên sản phẩm: Màn hình LCD Asus 24" VL249HE
- Kích thước: 23.8" (1920 x 1080), Tỷ lệ 16:9
- Tấm nền IPS, Góc nhìn: 178 (H) / 178 (V)
- Tần số quét: 75Hz , Thời gian phản hồi 5 ms
- Cổng hình ảnh: , 1 x HDMI, 1 x VGA/D-sub', 3850000, N'Màn hình', N'ASUS', 17, CAST(N'2020-05-04' AS Date), 36),
('LK000037', N'Bàn phím cơ AKKO 3084 World Tour - Blue Switch', N'Tên sản phẩm: Bàn phím cơ AKKO 3084 World Tour - Tokyo Blue Switch (84 keys)
- Bàn phím cơ
- Kết nối: USB Type-C
- Switch: Akko Blue
- phụ kiện đi kèm: Key puller, Cover chống bụi, cáp USB-C, Keycap tặng kèm', 1299000, N'Bàn phím', N'AKKO', 22, CAST(N'2020-04-12' AS Date), 12),
('LK000038', N'Chuột máy tính có dây E-dra EM602 (Đen)', N'Tên sản phẩm: Chuột máy tính có dây E-dra EM602 (Đen)
- Chuột chơi game E-dra EM602 
- Chuẩn kết nối USB, độ phân giải 1200DPI 
- Chất liệu nhựa phủ lớp chống nước 
- Switch: Hunao cho độ bền lên đến 10 triệu lần nhấn 
- Tương thích hệ điều hành: Windows 98 / 2000 / ME / NT / XP / win 7', 149000, N'Chuột', N'E-Dra', 22, CAST(N'2020-02-12' AS Date), 24),
('LK000039', N'RAM server Kingston KSM24ES8/8ME (1x8GB) DDR4', N'Tên sản phẩm: Bộ nhớ/ Ram Kingston 8GB ECC DDR4 2400 (KSM24ES8/8ME)
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz
- Cas: 17', 1490000, N'RAM', N'KINGSTON', 20, CAST(N'2020-02-12' AS Date), 36),
('LK000040', N'Bàn phím Dareu EK880 Blue Switch', N'Tên sản phẩm: Bàn phím cơ Dareu EK880 Blue Switch
- Kiểu: Bàn phím cơ 
- Kiểu kết nối: Có dây
- Switch: Blue D switch
- Đèn nền: RGB
- Kích thước: Tenkeyless
- Màu sắc: Đen', 749000, N'Bàn phím', N'DAREU', 28, CAST(N'2020-05-20' AS Date), 24),
('LK000041', N'Ổ cứng HDD Seagate BARRACUDA 2TB 3.5" Sata', N'Tên sản phẩm: Ổ cứng HDD Seagate BARRACUDA 2TB 3.5" Sata (ST2000DM005)
- Dung lượng: 2TB
- Kích thước: 3.5"
- Kết nối: SATA 3
- Tốc độ vòng quay: 5400RPM
- Cache: 256MB', 1590000, N'HDD', N'SEAGATE', 29, CAST(N'2020-05-15' AS Date), 36),
('LK000042', N'CPU Intel Core I5-8600K (3.6GHz)', N'Tên sản phẩm: Bộ vi xử lý/ CPU Intel Core i5-8600K (9M Cache, up to 4.3GHz)
- Socket: LGA 1151-v2 , Intel Core thế hệ thứ 8
- Tốc độ xử lý: 3.6 GHz ( 6 nhân, 6 luồng)
- Bộ nhớ đệm: 9MB
- Đồ họa tích hợp: Intel UHD Graphics 630', 5990000, N'CPU', N'INTEL', 17, CAST(N'2020-04-25' AS Date), 36),
('LK000043', N'CPU AMD Ryzen 3 3100', N'Tên sản phẩm: Bộ vi xử lý/ CPU AMD Ryzen 3 3100 (4 Cores 8 Thread up to 3.9 GHz AM4)
Socket: AM4, AMD Ryzen thế hệ thứ 3
Tốc độ: 3.6 GHz Up to 3.9 GHz (4nhân, 8 luồng)
Bộ nhớ đệm: 16MB', 2620000, N'CPU', N'AMD', 20, CAST(N'2020-04-25' AS Date), 36),
('LK000044', N'RAM desktop KINGMAX (1x8GB) DDR4 2666MHz', N'Tên sản phẩm: Bộ nhớ/ Ram DDR4 Kingmax 8GB (2666)
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2666MHz', 890000, N'RAM', N'KINGMAX', 23, CAST(N'2020-04-25' AS Date), 36),
('LK000045', N'RAM desktop ADATA AD4U240038G17-R', N'Tên sản phẩm: Bộ nhớ DDR4 Adata 8GB (2400) AD4U240038G17-R
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz', 1490000, N'RAM', N'ADATA', 23, CAST(N'2020-04-25' AS Date), 36),
('LK000046', N'RAM desktop G.SKILL Trident Z RGB F4-3000C16S-8GTZR', N'Tên sản phẩm: Bộ nhớ/ Ram DDR4 G.Skill Trident Z RGB 8GB (3000) F4-3000C16S-8GTZR (Đen)
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 3000MHz
- Cas: 16', 1290000, N'RAM', N'G.SKILL', 23, CAST(N'2020-04-25' AS Date), 36),
('LK000047', N'RAM desktop G.SKILL F4-2666C19S-8GNT', N'Tên sản phẩm: Bộ nhớ DDR4 G.Skill 8GB (2666) F4-2666C19S-8GNT
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2666MHz
- Cas: 19', 850000, N'RAM', N'G.SKILL', 23, CAST(N'2020-04-25' AS Date), 36),
('LK000048', N'Card màn hình GIGABYTE GeForce GT 1030 2GB GDDR5 OC', N'Tên sản phẩm: Card màn hình Gigabyte 2GB N1030OC-2GI
- Chip đồ họa: NVIDIA GeForce GT 1030
- Bộ nhớ: 2GB GDDR5 ( 64-bit )
- GPU clock Boost: 1544 MHz/ Base: 1290 MHz in OC Mode Boost: 1518 MHz/ Base: 1265 MHz in Gaming Mode
- Nguồn phụ: Không nguồn phụ', 2350000, N'Card đồ họa', N'GIGABYTE', 36, CAST(N'2020-01-01' AS Date), 36),
('LK000049', N'Card màn hình GIGABYTE GeForce GTX 1050 2GB GDDR5', N'Tên sản phẩm: Card màn hình Gigabyte 2GB N1050D5-2GD
- Chip đồ họa: NVIDIA GeForce GTX 1050
- Bộ nhớ: 2GB GDDR5 ( 128-bit )
- GPU clock Boost: 1493 MHz/ Base: 1379 MHz in OC Mode Boost: 1455 MHz/ Base: 1354 MHz in Gaming Mode
- Nguồn phụ: Không nguồn phụ', 3790000, N'Card đồ họa', N'GIGABYTE', 30, CAST(N'2020-01-01' AS Date), 36),
('LK000050', N'Card màn hình GIGABYTE GeForce GTX 1070 8GB GDDR5 G1 Gaming', N'Tên sản phẩm: Card màn hình Gigabyte 8GB N1070G1 Gaming
- Chip đồ họa: NVIDIA GeForce GTX 1070
- Bộ nhớ: 8GB GDDR5 ( 256-bit )
- GPU clock Boost: 1822 MHz/ Base: 1620 MHz in OC Mode Boost: 1784 MHz/ Base: 1594 MHz in Gaming Mode
- Nguồn phụ: 1 x 8-pin', 12490000, N'Card đồ họa', N'GIGABYTE', 8, CAST(N'2020-01-01' AS Date), 36),
('LK000052', N'Cáp chuyển đổi HDMI to DVI Unitek YC 220A', N'Tên sản phẩm: Cáp HDMI->DVI 24+1 Unitek YC 220A
- Thương hiệu: Unitek - Chiều dài dây: 5m - Cáp HDMI -> DVI 24+1', 150000, N'Cáp', N'UNITEK', 40, CAST(N'2020-01-01' AS Date), 12),
('LK000053', N'Cáp Nối Nguồn Cooler Master Sleeved Extension CMA-SEST16RDBK1-GL', N'Tên sản phẩm: Cáp Nối Nguồn Cooler Master Sleeved Extension CMA-SEST16RDBK1-GL (Đỏ Đen)
- Model: CMA-SEST16XXBK1-GL  
- CONNECTORS: 1x 24 Pin, 1x 8(4+4) Pin, 2x PCI-e 6 Pin, 2x PCI-e 8 Pin  
- CABLE CLIP NUMBERS: 4x 24 Pin, 12x 8 Pin, 8x 6 Pin  
- Màu sắc: Đỏ', 670000, N'Cáp', N'Cooler Master', 35, CAST(N'2020-01-01' AS Date), 12),
('LK000054', N'Cáp Nối Nguồn Cooler Master Sleeved Extension CMA-SEST16XXBK1-GL', N'Tên sản phẩm: Cáp Nối Nguồn Cooler Master Sleeved Extension CMA-SEST16RDBK1-GL (Đen)
- Model: CMA-SEST16XXBK1-GL  
- CONNECTORS: 1x 24 Pin, 1x 8(4+4) Pin, 2x PCI-e 6 Pin, 2x PCI-e 8 Pin  
- CABLE CLIP NUMBERS: 4x 24 Pin, 12x 8 Pin, 8x 6 Pin  
- Màu sắc: Đỏ', 670000, N'Cáp', N'Cooler Master', 35, CAST(N'2020-01-01' AS Date), 12),
('LK000055', N'Mainboard MSI MAG B365M MORTAR', N'Tên sản phẩm: Bo mạch chính/ Mainboard MSI MAG B365M Mortar
- Chuẩn mainboard: Micro-ATX
- Socket: LGA 1151-v2 , Chipset: B365
- Hỗ trợ RAM: DDR4 , tối đa 64GB
- Cổng cắm lưu trữ: 1 x M.2 SATA/NVMe; 6 x SATA 3 6Gb/s; Hỗ trợ Intel Optane
- Cổng xuất hình: 1 x HDMI', 670000, N'Mainboard ', N'MSI', 35, CAST(N'2020-02-16' AS Date), 12),
('LK000056', N'Mainboard GIGABYTE GA-A320M-S2H', N'Tên sản phẩm: Bo mạch chính/ Mainboard Gigabyte A320M-S2H
- Chuẩn mainboard: Micro-ATX
- Socket: AM4 , Chipset: A320
- Hỗ trợ RAM: DDR4 , tối đa 32GB
- Cổng cắm lưu trữ: 1 x M.2 SATA/NVMe; 4 x SATA 3 6Gb/s
- Cổng xuất hình: 1 x DVI-D; 1 x HDMI; 1 x VGA/D-sub', 1290000, N'Mainboard ', N'GIGABYTE', 22, CAST(N'2020-02-16' AS Date), 12),
('LK000057', N'Mainboard GIGABYTE GA-H81M-DS2', N'Tên sản phẩm: Bo mạch chính/ Mainboard Gigabyte H81M-DS2
- Chuẩn mainboard: Micro-ATX
- Socket: LGA 1150 , Chipset: H81
- Hỗ trợ RAM: DDR3 , tối đa 16GB
- Cổng cắm lưu trữ: 2 x SATA 2 3Gb/s; 2 x SATA 3 6Gb/s
- Cổng xuất hình: 1 x VGA/D-sub', 1520000, N'Mainboard ', N'GIGABYTE', 22, CAST(N'2020-02-16' AS Date), 12),
('LK000058', N'Mainboard ASUS PRIME H310M-D R2.0', N'ên sản phẩm: Bo mạch chính/ Mainboard Asus Prime H310M-D R2.0
- Chuẩn mainboard: Micro-ATX
- Socket: LGA 1151-v2 , Chipset: H310
- Hỗ trợ RAM: DDR4 , tối đa 32GB
- Cổng cắm lưu trữ: 1 x M.2 SATA/NVMe; 4 x SATA 3 6Gb/s
- Cổng xuất hình: 1 x HDMI; 1 x VGA/D-sub', 1690000, N'Mainboard ', N'ASUS', 26, CAST(N'2020-02-16' AS Date), 12),
('LK000059', N'Mainboard Intel Server Board S1200SPSR', N'Tên sản phẩm: Bo mạch chính/ Mainboard Intel S1200 SPSR
- Chuẩn mainboard: Micro-ATX
- Socket: LGA 1151 , Chipset: C232
- Hỗ trợ RAM: DDR4 , tối đa 64GB
- Cổng cắm lưu trữ: 6 x SATA 3 6Gb/s
- Cổng xuất hình: 1 x VGA/D-sub', 3990000, N'Mainboard ', N'Intel', 26, CAST(N'2020-02-16' AS Date), 36),
('LK000060', N'Mainboard ASRock B450M Pro4-F', N'Tên sản phẩm: Bo mạch chính/ Mainboard Asrock B450M Pro4-F
- Chuẩn mainboard: Micro-ATX
- Socket: AM4 , Chipset: B450
- Hỗ trợ RAM: DDR4 , tối đa 64GB
- Cổng cắm lưu trữ: 1 x M.2 NVMe; 1 x M.2 SATA; 4 x SATA 3 6Gb/s
- Cổng xuất hình: 1 x DVI-D; 1 x HDMI; 1 x VGA/D-sub', 1580000, N'Mainboard ', N'ASRock', 26, CAST(N'2020-02-16' AS Date), 36),
('LK000061', N'RAM desktop ADATA AD4U240038G17-R (1x8GB) DDR4 2400MHz', N'Tên sản phẩm: Bộ nhớ DDR4 Adata 8GB (2400) AD4U240038G17-R
- Dung lượng: 1 x 8GB
- Thế hệ: DDR4
- Bus: 2400MHz', 1490000, N'RAM', N'ADATA', 20, CAST(N'2020-02-14' AS Date), 36),
('LK000062', N'Ổ cứng HDD Western Digital Blue 1TB 3.5" SATA 3', N'Tên sản phẩm: Ổ cứng HDD WD Blue 1TB SATA3 7200rpm (WD10EZEX)
- Dung lượng: 1TB
- Kích thước: 3.5"
- Kết nối: SATA 3
- Tốc độ vòng quay: 7200RPM', 990000, N'HDD', N'WD', 20, CAST(N'2020-02-14' AS Date), 36)
GO 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaNhanVien], [MaKhachHang], [ngayLapHoaDon]) VALUES
(N'17011274', N'18026731', N'19536522', '2020-07-11 11:45:59'),
(N'17018273', N'18026731', N'19544818', '2020-07-12 11:45:59'),
(N'17024861', N'18026731', N'19555671', '2020-07-12 11:45:59'),
(N'17026299', N'18026731', N'19577570', '2020-07-09 11:45:59'),
(N'17032236', N'18026731', N'19593316', '2020-07-12 11:45:59'),--nguyen

(N'17037456', N'19522701', N'19569236', '2020-07-09 11:45:59'),
(N'17037890', N'19522701', N'19555671', '2020-07-12 11:45:59'),
(N'17040852', N'19522701', N'19556113', '2020-07-11 11:45:59'),
(N'17044854', N'19522701', N'19555671', '2020-07-12 11:45:59'),--lam

(N'17050903', N'19521341', N'19592855', '2020-07-12 11:45:59'),
(N'17052185', N'19521341', N'19546308', '2020-07-09 11:45:59'),
(N'17053095', N'19521341', N'19516961', '2020-07-02 11:45:59'),--hieu

(N'17054971', N'19522701', N'19545260', '2020-07-12 11:45:59'),
(N'17062608', N'19522701', N'19523031', '2020-07-08 11:45:59'),
(N'17066629', N'19522701', N'19556113', '2020-07-11 11:45:59'),
(N'17069479', N'19522701', N'19535184', '2020-07-12 11:45:59'),
(N'17072351', N'19522701', N'19523981', '2020-07-11 11:45:59'), --lam

(N'17072986', N'18026731', N'19536522', '2020-07-08 11:45:59'),
(N'17073330', N'18026731', N'19535184', '2020-07-12 11:45:59'),
(N'17077605', N'18026731', N'19555671', '2020-07-07 11:45:59'),
(N'17078525', N'18026731', N'19546308', '2020-07-10 11:45:59'),
(N'17083096', N'18026731', N'19516961', '2020-07-12 11:45:59'),--nguyen

(N'17087296', N'19524691', N'19556113', '2020-07-11 11:45:59'),
(N'17088452', N'19524691', N'19576379', '2020-07-10 11:45:59'),
(N'17092854', N'19524691', N'19523981', '2020-07-11 11:45:59'),
(N'17093335', N'19524691', N'19523031', '2020-07-08 11:45:59')--huu
GO

INSERT [dbo].[ChiTietHoaDon] VALUES 
('17011274', 'LK000034', 1),
('17011274', 'LK000035', 1),
('17018273', 'LK000014', 1),
('17018273', 'LK000015', 1),
('17024861', 'LK000009', 1),
('17024861', 'LK000021', 1),
('17024861', 'LK000034', 1),
('17032236', 'LK000001', 1),
('17032236', 'LK000023', 1),
('17032236', 'LK000027', 1),
('17037456', 'LK000023', 1),
('17037456', 'LK000032', 1),
('17037890', 'LK000015', 1),
('17040852', 'LK000008', 1),
('17040852', 'LK000015', 1),
('17044854', 'LK000019', 1),
('17050903', 'LK000009', 1),
('17050903', 'LK000023', 1),
('17052185', 'LK000002', 1),
('17053095', 'LK000001', 1),
('17053095', 'LK000004', 1),
('17054971', 'LK000022', 1),
('17054971', 'LK000032', 1),
('17062608', 'LK000013', 1),
('17062608', 'LK000015', 1),
('17066629', 'LK000007', 1),
('17069479', 'LK000015', 1),
('17072351', 'LK000008', 1),
('17072986', 'LK000032', 2),
('17073330', 'LK000019', 1),
('17073330', 'LK000020', 1),
('17077605', 'LK000001', 1),
('17078525', 'LK000007', 1),
('17078525', 'LK000008', 1),
('17078525', 'LK000012', 1),
('17078525', 'LK000020', 1),
('17083096', 'LK000001', 1),
('17083096', 'LK000004', 1),
('17087296', 'LK000007', 1),
('17087296', 'LK000010', 1),
('17087296', 'LK000014', 2),
('17092854', 'LK000061', 1),
('17093335', 'LK000004', 1),
('17093335', 'LK000010', 1)
Go


--select ngayLapHoaDon from HoaDon
--order by ngayLapHoaDon