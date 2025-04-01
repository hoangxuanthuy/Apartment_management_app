ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER QLCHUNGCU IDENTIFIED BY password;
GRANT CONNECT, RESOURCE, DBA TO QLCHUNGCU;
-- Giong cau lenh use + database ben sql
ALTER SESSION SET CURRENT_SCHEMA = QLCHUNGCU;

--Tao bang tai khoan
CREATE TABLE TAIKHOAN (
    USERNAME VARCHAR2(10) PRIMARY KEY,
    PASSWORD VARCHAR2(6),
    ROLE VARCHAR2(10),
    EMAIL VARCHAR2(60)
);

-- Tao bang cu dan
CREATE TABLE CUDAN (
    MACD VARCHAR2(6) PRIMARY KEY,
    HoTen VARCHAR2(50),
    NGSINH DATE,
    GIOITINH VARCHAR2(6),
    CCCD VARCHAR2(20),
    SDT VARCHAR2(20),
    Email VARCHAR2(60),
    LoaiCD VARCHAR2(20)
);
-- tao bang xe
CREATE TABLE XE 
(   
    MAXE VARCHAR2(6) PRIMARY KEY,
    BIENSOXE VARCHAR2(20),
    LOAIXE VARCHAR2(40),
    MACD VARCHAR2(6)
);
--tao bang can ho
CREATE TABLE CANHO(
    MACH VARCHAR2(6) PRIMARY KEY,
    DienTich NUMBER,
    LoaiCH VARCHAR2(60),
    SoPhongNgu INT,
    SoPhongTam INT,
    Tang INT,
    GiaThue NUMBER,
    PHIDV NUMBER,
    GIAXE NUMBER,
    SLXE NUMBER,
    MACD VARCHAR2(6),
    MANV VARCHAR2(6),
    MAHOPDONG VARCHAR2(15)
);
-- tao bang dong ho nuoc
CREATE TABLE DONGHONUOC(
    MACH VARCHAR2(6) PRIMARY KEY,
    CHISOTRUOC NUMBER,
    CHISOSAU NUMBER,
    GIANUOC NUMBER
);
-- tao bang dien ke
CREATE TABLE DIENKE(
    MACH VARCHAR2(6) PRIMARY KEY,
    CHISOTRUOC NUMBER,
    CHISOSAU NUMBER,
    GIADIEN NUMBER
);
-- Tạo bảng Hóa đơn
CREATE TABLE HOADON (
    MAHD VARCHAR2(6) PRIMARY KEY,
    NGAYHD DATE,
    TRIGIA NUMBER,
    TINHTRANG VARCHAR(50),
    MACH VARCHAR2(6) 
);
-- tao bang chi tiet hoa don
CREATE TABLE CTHD (
    MAHD VARCHAR2(6) PRIMARY KEY,
    GIATHUE NUMBER,
    PHIXE NUMBER,
    PHIDV NUMBER,
    TIENDIEN NUMBER,
    TIENNUOC NUMBER
);
--tao bang hop dong 
CREATE TABLE HOPDONG
(
    MAHOPDONG VARCHAR2(15) PRIMARY KEY,
    NGAYBD DATE,
    THOIHAN VARCHAR2(20),
    LOAIHD VARCHAR2(40),
    GIA NUMBER, 
    MACD VARCHAR2(6),
    MABQL VARCHAR2(6)
);
-- Tạo bảng Yêu cầu cư dân
CREATE TABLE YEUCAUCUDAN (
    MAYC VARCHAR2(6) PRIMARY KEY,
    LoaiYC VARCHAR2(40),
    NoiDungYC VARCHAR2(100),
    TrangThaiYC VARCHAR2(40),
    MACD VARCHAR2(6)
);
-- Tạo bảng NHANVIEN
CREATE TABLE NHANVIEN (
    MANV VARCHAR2(6) PRIMARY KEY,
    HOTEN VARCHAR2(40),
    SDT VARCHAR2(20),
    Email VARCHAR2(60),
    MABQL VARCHAR2(6)
);
CREATE TABLE BANQUANLY (
  MABQL VARCHAR2(6) PRIMARY KEY,
  TenBQL VARCHAR2(40),
  TOA NUMBER,
  Email VARCHAR2(60)

);

-- Tạo bảng Lịch sử xử lý yêu cầu
CREATE TABLE LICHSUYEUCAU (
    MABQL VARCHAR2(6),
    MAYC VARCHAR2(6),
    NoiDungXuLy VARCHAR2(100),
    ThoiGianXuLy DATE,
    CONSTRAINT LS_CC PRIMARY KEY(MAYC,MABQL)
);

-- XE 
ALTER TABLE XE
ADD CONSTRAINT FK_XE_CD FOREIGN KEY (MACD) REFERENCES CUDAN(MACD);
--CANHO
ALTER TABLE CANHO
ADD CONSTRAINT FK_CH_CD FOREIGN KEY (MACD) REFERENCES CUDAN(MACD);
ALTER TABLE CANHO
ADD CONSTRAINT FK_CH_NV FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
ALTER TABLE CANHO
ADD CONSTRAINT FK_CH_HD FOREIGN KEY (MAHOPDONG) REFERENCES HOPDONG(MAHOPDONG);
--HOPDONG
ALTER TABLE HOPDONG
ADD CONSTRAINT FK_HD_CD FOREIGN KEY (MACD) REFERENCES CUDAN(MACD);
ALTER TABLE HOPDONG
ADD CONSTRAINT FK_CH_BQL FOREIGN KEY (MABQL) REFERENCES BANQUANLY(MABQL);
--DONG HO NUOC
ALTER TABLE DONGHONUOC
ADD CONSTRAINT FK_DHN_CH FOREIGN KEY (MACH) REFERENCES CANHO(MACH);
--DIEN KE
ALTER TABLE DIENKE
ADD CONSTRAINT FK_DK_CH FOREIGN KEY (MACH) REFERENCES CANHO(MACH);
--HOADON
ALTER TABLE HOADON
ADD CONSTRAINT FK_HD_CH FOREIGN KEY (MACH) REFERENCES CANHO(MACH);
--CTHD
ALTER TABLE CTHD
ADD CONSTRAINT FK_CTHD_HD FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD);

--YEUCAUCUDAN
ALTER TABLE YEUCAUCUDAN
ADD CONSTRAINT FK_YC_CD FOREIGN KEY (MACD) REFERENCES CUDAN(MACD);

--LICHSU
ALTER TABLE LICHSUYEUCAU
ADD CONSTRAINT FK_LS_BQL FOREIGN KEY (MABQL) REFERENCES BANQUANLY(MABQL);
ALTER TABLE LICHSUYEUCAU
ADD CONSTRAINT FK_LS_YC FOREIGN KEY (MAYC) REFERENCES YEUCAUCUDAN(MAYC);
--NHANVIEN
ALTER TABLE NHANVIEN
ADD CONSTRAINT FK_NV_BQL FOREIGN KEY (MABQL) REFERENCES BANQUANLY(MABQL);

-- INSERT DỮ LIỆU
-- Chèn dữ liệu vào bảng TAIKHOAN
INSERT INTO TAIKHOAN VALUES ('CD001' , '123456' , 'CUDAN' , 'thaimanh04@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD002' , '000000' , 'CUDAN' , 'hoangxuanthuy2004@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD003' , '987654' , 'CUDAN' , 'thuythanh@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD004' , '666666' , 'CUDAN' , 'tandangng@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD005' , '024689' , 'CUDAN' , 'manhpham@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD006' , '147369' , 'CUDAN' , 'thangnguyen@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD007' , '222222' , 'CUDAN' , 'leyenvi@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD008' , '123987' , 'CUDAN' , 'hungtrantan@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD009' , '036425' , 'CUDAN' , 'ducnhontran@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD010' , '014598' , 'CUDAN' , 'phuonguyen@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD011' , '758693' , 'CUDAN' , 'thuyvipt@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD012' , '142123' , 'CUDAN' , 'duytanng@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD013' , '000001' , 'CUDAN' , 'baolong@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD014' , '036311' , 'CUDAN' , 'tienthanh@gmail.com');
INSERT INTO TAIKHOAN VALUES ('CD015' , '966969' , 'CUDAN' , 'kieutrinh@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV001' , '023456' , 'NHANVIEN' , 'tranvana@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV002' , '777777' , 'NHANVIEN' , 'nguyenthibinh@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV003' , '223344' , 'NHANVIEN' , 'levancuong@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV004' , '963852' , 'NHANVIEN' , 'phamthidung@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV005' , '192837' , 'NHANVIEN' , 'hoangvanminh@gmail.com');
INSERT INTO TAIKHOAN VALUES ('NV006' , '741852' , 'NHANVIEN' , 'trungvoduc@gmail.com');
INSERT INTO TAIKHOAN VALUES ('BQL001', '111111' , 'BANQUANLY' ,'quanly1cc@gmail.com');


-- Chèn dữ liệu vào bảng CUDAN
INSERT INTO CUDAN VALUES('CD001' , 'Nguyen Van Thai Manh',TO_DATE('2004-01-01', 'YYYY-MM-DD'), 'Nam', '072212301142', '0987654321', 'thaimanh04@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD002' , 'Hoang Xuan Thuy', TO_DATE('2000-05-05', 'YYYY-MM-DD'), 'Nam', '073269854253', '0343456789', 'hoangxuanthuy2004@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD003' , 'Nguyen Thi Thanh Thuy', TO_DATE('2001-12-10', 'YYYY-MM-DD'), 'Nu', '053214178963', '0919090909', 'thuythanh@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD004' , 'Nguyen Dang Tan', TO_DATE('1999-08-20', 'YYYY-MM-DD'), 'Nam', '052214627895', '0873456789', 'tandangng@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD005' , 'Pham Duc Manh', TO_DATE('2002-03-15', 'YYYY-MM-DD'), 'Nam', '052204001560', '0987654321', 'manhpham@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD006' , 'Nguyen Van Thang', TO_DATE('2004-03-11', 'YYYY-MM-DD'), 'Nam', '052245692525', '0914747263', 'thangnguyen@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD007' , 'Le Yen Vi', TO_DATE('2003-04-17', 'YYYY-MM-DD'), 'Nu', '05369787525', '0987256365', 'leyenvi@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD008' , 'Tran Tan Hung', TO_DATE('2002-06-14', 'YYYY-MM-DD'), 'Nam', '052204141239', '0987414239', 'hungtrantan@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD009' , 'Tran Duc Nhon', TO_DATE('2001-06-01', 'YYYY-MM-DD'), 'Nam', '052204001887', '0364398874', 'ducnhontran@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD010', 'Nguyen Thi Phuong Uyen', TO_DATE('2000-09-10', 'YYYY-MM-DD'), 'Nu', '053614472534', '0347256144', 'phuonguyen@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD011', 'Pham Thanh Thuy Vi', TO_DATE('2003-01-04', 'YYYY-MM-DD'), 'Nu', '052312542478', '0911245236', 'thuyvipt@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD012', 'Nguyen Duy Tan', TO_DATE('1999-12-03', 'YYYY-MM-DD'), 'Nam', '057423651990', '0987207590', 'duytanng@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD013', 'Hoang Bao Long', TO_DATE('2004-01-29', 'YYYY-MM-DD'), 'Nam', '052204651699', '0364569364', 'baolong@gmail.com', 'Mua');
INSERT INTO CUDAN VALUES('CD014', 'To Tien Thanh', TO_DATE('2002-02-27', 'YYYY-MM-DD'), 'Nam', '052204001969', '0876364602', 'tienthanh@gmail.com', 'Thue');
INSERT INTO CUDAN VALUES('CD015', 'Nguyen Thi Kieu Trinh', TO_DATE('2001-05-18', 'YYYY-MM-DD'), 'Nu', '053301201758', '0914240468', 'kieutrinh@gmail.com', 'Thue');

---- Chèn dữ liệu vào bảng XE
INSERT INTO XE VALUES ('XE001' , '30X-12345', 'Xe hoi', 'CD001');
INSERT INTO XE VALUES ('XE002' , '77D-61639', 'Xe may', 'CD001');
INSERT INTO XE VALUES ('XE003' , '78D-65457', 'Xe may', 'CD001');
INSERT INTO XE VALUES ('XE004' , '29T-98765', 'Xe may', 'CD002');
INSERT INTO XE VALUES ('XE005' , '51B-65432', 'Xe may', 'CD003');
INSERT INTO XE VALUES ('XE006' , '51B-14178', 'Xe dap', 'CD003');
INSERT INTO XE VALUES ('XE007' , '51B-67845', 'Xe dap', 'CD003');
INSERT INTO XE VALUES ('XE008' , '43H-24689', 'Xe may', 'CD004');
INSERT INTO XE VALUES ('XE009' , '89Z-13579', 'Xe hoi', 'CD005');
INSERT INTO XE VALUES ('XE010', '89Z-34523', 'Xe may', 'CD005');
INSERT INTO XE VALUES ('XE011', '77Z-34523', 'Xe may', 'CD006');
INSERT INTO XE VALUES ('XE012', '89D-63256', 'Xe dap', 'CD006');
INSERT INTO XE VALUES ('XE013', '52L-77779', 'Xe may', 'CD007');
INSERT INTO XE VALUES ('XE014', '89Z-66253', 'Xe dap', 'CD008');
INSERT INTO XE VALUES ('XE015', '43H-44444', 'Xe hoi', 'CD009');
INSERT INTO XE VALUES ('XE016', '45Z-12345', 'Xe may', 'CD009');
INSERT INTO XE VALUES ('XE017', '77D-67894', 'Xe dap', 'CD010');
INSERT INTO XE VALUES ('XE018', '89D-25356', 'Xe may', 'CD011');
INSERT INTO XE VALUES ('XE019', '78D-24514', 'Xe may', 'CD011');
INSERT INTO XE VALUES ('XE020', '52H-45365', 'Xe hoi', 'CD012');
INSERT INTO XE VALUES ('XE021', '52B-54321', 'Xe hoi', 'CD013');
INSERT INTO XE VALUES ('XE022', '59T-65324', 'Xe may', 'CD013');
INSERT INTO XE VALUES ('XE023', '59B-52420', 'Xe may', 'CD015');
INSERT INTO XE VALUES ('XE024', '59H-62301', 'Xe dap', 'CD015');

-- Chèn dữ liệu vào bảng BANQUANLY
INSERT INTO BANQUANLY VALUES ('BQL001', 'Ban quan ly 1', 1 , 'quanly1cc@gmail.com');


-- Chèn dữ liệu vào bảng HOPDONG
INSERT INTO HOPDONG VALUES ('HOPDONG001' , TO_DATE('2022-10-01', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 11000000  , 'CD001' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG002' , TO_DATE('2022-07-01', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 12000000  , 'CD002' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG003' , TO_DATE('2022-08-01', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 7000000   , 'CD003' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG004' , TO_DATE('2022-05-01', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 2500000000, 'CD004' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG005' , TO_DATE('2022-05-01', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 3000000000, 'CD005' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG006' , TO_DATE('2022-09-02', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 2800000000, 'CD006' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG007' , TO_DATE('2022-06-30', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 6500000   , 'CD007' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG008' , TO_DATE('2022-07-01', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 10000000  , 'CD008' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG009' , TO_DATE('2022-01-21', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 8000000   , 'CD009' , 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG010' , TO_DATE('2022-04-01', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 3500000000, 'CD010', 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG011' , TO_DATE('2022-08-08', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 8500000   , 'CD011', 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG012' , TO_DATE('2022-10-20', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 4000000000, 'CD012', 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG013' , TO_DATE('2022-11-21', 'YYYY-MM-DD'),'Vinh vien', 'Hop dong mua nha' , 2500000000, 'CD013', 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG014' , TO_DATE('2022-03-10', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 8500000   , 'CD014', 'BQL001');
INSERT INTO HOPDONG VALUES ('HOPDONG015' , TO_DATE('2022-04-30', 'YYYY-MM-DD'),'12 thang' , 'Hop dong thue nha', 12000000  , 'CD015', 'BQL001');




-- Chèn dữ liệu vào bảng NHANVIEN
INSERT INTO NHANVIEN  VALUES ('NV001',  'Tran Van An', '0963545614', 'tranvana@gmail.com',  'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV002',  'Nguyen Thi Binh', '0909141457', 'nguyenthibinh@gmail.com',  'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV003',  'Le Van Cuong', '0876325603', 'levancuong@gmail.com',  'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV004',  'Pham Thi Dung', '0987424235', 'phamthidung@gmail.com','BQL001');
INSERT INTO NHANVIEN  VALUES ('NV005',  'Hoang Van Minh', '0911236565', 'hoangvanminh@gmail.com', 'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV006',  'Vo Duc Trung', '0987207560', 'trungvoduc@gmail.com', 'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV007',  'Nguyen Thi Tha', '0987207560', 'trungvoduc@gmail.com', 'BQL001');
INSERT INTO NHANVIEN  VALUES ('NV008',  'Bui Dung Thu', '0987207560', 'trungvoduc@gmail.com', 'BQL001');




-- Chèn dữ liệu vào bảng CANHO
INSERT INTO CANHO VALUES ('CH001' , 80 , 'Studio', 0, 1, 6, 11000000, 100000, 150000, 3, 'CD001', 'NV001', 'HOPDONG001');
INSERT INTO CANHO VALUES ('CH002' , 100, 'Studio', 0, 2, 6, 12000000, 100000,150000, 1, 'CD002', 'NV001', 'HOPDONG002');
INSERT INTO CANHO VALUES ('CH003' , 60 , 'Thuong', 1, 1, 5, 7000000, 100000,150000, 3, 'CD003', 'NV002', 'HOPDONG003');
INSERT INTO CANHO VALUES ('CH004' , 70 , 'Thuong', 1, 2, 3, 0, 100000,150000, 1, 'CD004', 'NV002', 'HOPDONG004');
INSERT INTO CANHO VALUES ('CH005' , 60 , 'Thuong', 2, 1, 4, 0, 100000,150000, 2, 'CD005', 'NV002', 'HOPDONG005');
INSERT INTO CANHO VALUES ('CH006' , 50 , 'Thuong', 1, 1, 1, 0, 100000,150000, 2, 'CD006', 'NV003', 'HOPDONG006');
INSERT INTO CANHO VALUES ('CH007' , 50 , 'Thuong', 1, 1, 2, 6500000, 100000,150000, 1, 'CD007', 'NV003', 'HOPDONG007');
INSERT INTO CANHO VALUES ('CH008' , 70 , 'Studio', 0, 1, 6, 10000000, 100000,150000, 1, 'CD008', 'NV003', 'HOPDONG008');
INSERT INTO CANHO VALUES ('CH009' , 70 , 'Thuong', 2, 1, 4, 8000000, 100000,150000, 2, 'CD009', 'NV004', 'HOPDONG009');
INSERT INTO CANHO VALUES ('CH010', 90 , 'Studio', 0, 2, 7, 0, 100000,150000, 1, 'CD010', 'NV004', 'HOPDONG010');
INSERT INTO CANHO VALUES ('CH011', 80 , 'Thuong', 2, 2, 3, 85000000, 100000,150000, 2, 'CD011', 'NV004', 'HOPDONG011');
INSERT INTO CANHO VALUES ('CH012', 80 , 'Studio', 0, 2, 7, 0, 100000,150000, 1, 'CD012', 'NV005', 'HOPDONG012');
INSERT INTO CANHO VALUES ('CH013', 70 , 'Thuong', 2, 1, 2, 0, 100000,150000, 2, 'CD013', 'NV005', 'HOPDONG013');
INSERT INTO CANHO VALUES ('CH014', 80 , 'Thuong', 2, 2, 1, 8500000, 100000,150000, 0, 'CD014', 'NV006', 'HOPDONG014');
INSERT INTO CANHO VALUES ('CH015', 100, 'Studio', 1, 2, 6, 12000000, 100000,150000, 2, 'CD015', 'NV006', 'HOPDONG015');
INSERT INTO CANHO VALUES ('CH016', 100, 'Studio', 1, 2, 6, 9000000, 100000,150000, 0, null, null, null);
INSERT INTO CANHO VALUES ('CH017', 130, 'Thuong', 2, 2, 6, 11000000, 100000,150000, 0 , null, null,null);
INSERT INTO CANHO VALUES ('CH018', 120, 'Studio', 1, 2, 6, 10000000, 100000,150000, 0, null, null, null);
INSERT INTO CANHO VALUES ('CH019', 90, 'Thuong', 1, 2, 6, 8000000, 100000,150000, 0, null, null, null);
INSERT INTO CANHO VALUES ('CH020', 100, 'Thuong', 2, 1, 5, 10000000, 100000,150000, 0 , null, null,null);


SELECT * FROM CANHO;

-- Chèn dữ liệu vào bảng DONGHONUOC
INSERT INTO DONGHONUOC VALUES ('CH001' , 100, 110, 15000);
INSERT INTO DONGHONUOC VALUES ('CH002' , 80 , 85 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH003' , 70 , 77 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH004' , 120, 127, 15000);
INSERT INTO DONGHONUOC VALUES ('CH005' , 150, 155, 15000);
INSERT INTO DONGHONUOC VALUES ('CH006' , 0  , 6  , 15000);
INSERT INTO DONGHONUOC VALUES ('CH007' , 12 , 20 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH008' , 110, 120, 15000);
INSERT INTO DONGHONUOC VALUES ('CH009' , 100, 105, 15000);
INSERT INTO DONGHONUOC VALUES ('CH010', 75 , 82 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH011', 80 , 88 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH012', 85 , 92 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH013', 70 , 81 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH014', 25 , 32 , 15000);
INSERT INTO DONGHONUOC VALUES ('CH015', 110, 119, 15000);

-- Chèn dữ liệu vào bảng DIENKE
INSERT INTO DIENKE VALUES ('CH001' , 300, 400, 3500);
INSERT INTO DIENKE VALUES ('CH002' , 400, 520, 3500);
INSERT INTO DIENKE VALUES ('CH003' , 250, 380, 3500);
INSERT INTO DIENKE VALUES ('CH004' , 200, 290, 3500);
INSERT INTO DIENKE VALUES ('CH005' , 150, 230, 3500);
INSERT INTO DIENKE VALUES ('CH006' , 70 , 150, 3500);
INSERT INTO DIENKE VALUES ('CH007' , 140, 200, 3500);
INSERT INTO DIENKE VALUES ('CH008' , 110, 190, 3500);
INSERT INTO DIENKE VALUES ('CH009' , 80 , 160, 3500);
INSERT INTO DIENKE VALUES ('CH010', 90 , 190, 3500);
INSERT INTO DIENKE VALUES ('CH011', 200, 280, 3500);
INSERT INTO DIENKE VALUES ('CH012', 180, 270, 3500);
INSERT INTO DIENKE VALUES ('CH013', 160, 230, 3500);
INSERT INTO DIENKE VALUES ('CH014', 120, 200, 3500);
INSERT INTO DIENKE VALUES ('CH015', 130, 220, 3500);


-- Chèn dữ liệu vào bảng HOADON
INSERT INTO HOADON VALUES ('HD001' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 12050000,'Chua thanh toan', 'CH001');
INSERT INTO HOADON VALUES ('HD002' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 12745000,'Da thanh toan'  , 'CH002');
INSERT INTO HOADON VALUES ('HD003' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 8110000 ,'Chua thanh toan', 'CH003');
INSERT INTO HOADON VALUES ('HD004' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 670000  ,'Da thanh toan'  , 'CH004');
INSERT INTO HOADON VALUES ('HD005' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 755000  , 'Chua thanh toan','CH005');
INSERT INTO HOADON VALUES ('HD006' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 770000  ,'Da thanh toan', 'CH006');
INSERT INTO HOADON VALUES ('HD007' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 7080000 ,'Da thanh toan', 'CH007');
INSERT INTO HOADON VALUES ('HD008' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 10680000,'Chua thanh toan', 'CH008');
INSERT INTO HOADON VALUES ('HD009' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 8755000 ,'Da thanh toan', 'CH009');
INSERT INTO HOADON VALUES ('HD010' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 705000  ,'Chua thanh toan', 'CH010');
INSERT INTO HOADON VALUES ('HD011' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 9265000 ,'Da thanh toan', 'CH011');
INSERT INTO HOADON VALUES ('HD012' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 670000  , 'Da thanh toan','CH012');
INSERT INTO HOADON VALUES ('HD013' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 810000  ,'Chua thanh toan', 'CH013');
INSERT INTO HOADON VALUES ('HD014' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 8985000 , 'Da thanh toan','CH014');
INSERT INTO HOADON VALUES ('HD015' , TO_DATE('2023-08-01', 'YYYY-MM-DD'), 12850000,'Da thanh toan', 'CH015');



-- Chèn dữ liệu vào bảng CTHD
INSERT INTO CTHD VALUES ('HD001' , 11000000, 450000, 100000, 350000, 150000);
INSERT INTO CTHD VALUES ('HD002' , 12000000, 150000, 100000, 420000, 75000);
INSERT INTO CTHD VALUES ('HD003' , 7000000, 450000, 100000, 455000, 105000);
INSERT INTO CTHD VALUES ('HD004' , 0, 150000, 100000, 315000, 105000);
INSERT INTO CTHD VALUES ('HD005' , 0, 300000, 100000, 280000, 75000);
INSERT INTO CTHD VALUES ('HD006' , 0, 300000, 100000, 280000, 90000);
INSERT INTO CTHD VALUES ('HD007' , 6500000, 150000, 100000, 210000, 120000);
INSERT INTO CTHD VALUES ('HD008' , 10000000, 150000, 100000, 280000, 150000);
INSERT INTO CTHD VALUES ('HD009' , 8000000, 300000, 100000, 280000, 75000);
INSERT INTO CTHD VALUES ('HD010', 0, 150000, 100000, 350000, 105000);
INSERT INTO CTHD VALUES ('HD011', 8500000, 300000, 100000, 245000, 120000);
INSERT INTO CTHD VALUES ('HD012', 0, 150000, 100000, 315000, 105000);
INSERT INTO CTHD VALUES ('HD013', 0, 300000, 100000, 245000, 165000);
INSERT INTO CTHD VALUES ('HD014', 8500000, 0, 100000, 280000, 105000);
INSERT INTO CTHD VALUES ('HD015', 12000000, 300000, 100000, 315000, 135000);



-- Chèn dữ liệu vào bảng YEUCAUCUDAN
INSERT INTO YEUCAUCUDAN VALUES ('YC001', 'Yeu cau sua chua', 'Loi nuoc trong nha', 'Chua xu ly', 'CD001');
INSERT INTO YEUCAUCUDAN VALUES ('YC002', 'Yeu cau ve sinh' , 'Don dep khu vuc chung cu', 'Chua xu ly', 'CD003');
INSERT INTO YEUCAUCUDAN VALUES ('YC003', 'Yeu cau bao tri' , 'Sua chua may phat dien', 'Chua xu ly', 'CD004');
INSERT INTO YEUCAUCUDAN VALUES ('YC004', 'Yeu cau ho tro'  , 'Can ho thieu thiet bi', 'Chua xu ly', 'CD006');
INSERT INTO YEUCAUCUDAN VALUES ('YC005', 'Yeu cau gop y', 'Phuong an bao ve chung cu', 'Chua xu ly', 'CD007');
INSERT INTO YEUCAUCUDAN VALUES ('YC006', 'Yeu cau sua chua', 'Hut nuoc bi tac', 'Chua xu ly', 'CD008');
INSERT INTO YEUCAUCUDAN VALUES ('YC007', 'Yeu cau ve sinh', 'Don dep thang may', 'Chua xu ly', 'CD010');
INSERT INTO YEUCAUCUDAN VALUES ('YC008', 'Yeu cau bao tri', 'Sua chua he thong dien', 'Chua xu ly', 'CD011');
INSERT INTO YEUCAUCUDAN VALUES ('YC009', 'Yeu cau ho tro', 'Can ho thieu bao hoa hong', 'Chua xu ly', 'CD012');


--Check LoaiCD
ALTER TABLE CUDAN
ADD CONSTRAINT chk_loaicudan
CHECK (LoaiCD IN ('Thue', 'Mua'));

--Check HoaDon
ALTER TABLE HOADON
ADD CONSTRAINT chk_tinhtranghd
CHECK (TINHTRANG IN ('Chua thanh toan', 'Da thanh toan'));

--Check GioiTinh
ALTER TABLE CUDAN
ADD CONSTRAINT chk_gioitinh
CHECK (GIOITINH IN ('Nam', 'Nu'));


--THEM hoac cap nhap chi so truoc phai be hon hoac bang chi so sau( dong ho nuoc)
CREATE OR REPLACE TRIGGER check_chiso_dongho
BEFORE INSERT OR UPDATE
ON DONGHONUOC
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu CHISOTRUOC lớn hơn CHISOSAU
    IF :new.CHISOTRUOC > :new.CHISOSAU THEN
        RAISE_APPLICATION_ERROR(-20003, 'CHISOTRUOC phải nhỏ hơn hoặc bằng CHISOSAU');
    END IF;
END;

--THEM hoac cap nhap chi so truoc phai be hon hoac bang chi so sau( dien ke)
CREATE OR REPLACE TRIGGER check_chiso_dienke
BEFORE INSERT OR UPDATE
ON DIENKE
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu CHISOTRUOC lớn hơn CHISOSAU
    IF :new.CHISOTRUOC > :new.CHISOSAU THEN
        RAISE_APPLICATION_ERROR(-20003, 'CHISOTRUOC phải nhỏ hơn hoặc bằng CHISOSAU');
    END IF;
END;

-- Trigger tính giá trị TRIGIA trước khi chèn hoặc cập nhật bảng HOADON:
CREATE OR REPLACE TRIGGER trg_tinh_gia_tri_trigia
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
DECLARE
    v_giathue NUMBER;
    v_phixe NUMBER;
    v_phidv NUMBER;
    v_slxe NUMBER;
    v_tiendien NUMBER;
    v_tiennuoc NUMBER;
    v_chisodien_truoc NUMBER;
    v_chisodien_sau NUMBER;
    v_giadien NUMBER;
    v_chisonuoc_truoc NUMBER;
    v_chisonuoc_sau NUMBER;
    v_gianuoc NUMBER;
BEGIN
    -- Get values from CANHO table
    SELECT GiaThue, GiaXe, PhiDV, SLXE
    INTO v_giathue, v_phixe, v_phidv, v_slxe
    FROM CANHO
    WHERE MACH = :NEW.MACH;

    -- Calculate PHIXE
    v_phixe := v_phixe * v_slxe;

    -- Get values from DIENKE table
    SELECT CHISOTRUOC, CHISOSAU, GIADIEN
    INTO v_chisodien_truoc, v_chisodien_sau, v_giadien
    FROM DIENKE
    WHERE MACH = :NEW.MACH;

    -- Calculate TIENDIEN
    v_tiendien := (v_chisodien_sau - v_chisodien_truoc) * v_giadien;

    -- Get values from DONGHONUOC table
    SELECT CHISOTRUOC, CHISOSAU, GIANUOC
    INTO v_chisonuoc_truoc, v_chisonuoc_sau, v_gianuoc
    FROM DONGHONUOC
    WHERE MACH = :NEW.MACH;

    -- Calculate TIENNUOC
    v_tiennuoc := (v_chisonuoc_sau - v_chisonuoc_truoc) * v_gianuoc;

    -- Calculate total TRIGIA
    :NEW.TRIGIA := v_giathue + v_phixe + v_phidv + v_tiendien + v_tiennuoc;
END;

--Trigger đặt giá trị mặc định cho DONGHONUOC và DIENKE khi chèn mới CANHO:
CREATE OR REPLACE TRIGGER trg_mac_dinh_dongho_dienke
AFTER INSERT ON CANHO
FOR EACH ROW
BEGIN
    INSERT INTO DONGHONUOC (MACH, CHISOTRUOC, CHISOSAU, GIANUOC)
    VALUES (:NEW.MACH, 0, 0, 15000);

    INSERT INTO DIENKE (MACH, CHISOTRUOC, CHISOSAU, GIADIEN)
    VALUES (:NEW.MACH, 0, 0, 3500);
END;

--Trigger kiểm tra cư dân phải trên 18 tuổi:
CREATE OR REPLACE TRIGGER trg_check_age_cudan
BEFORE INSERT OR UPDATE ON CUDAN
FOR EACH ROW
DECLARE
    v_age INTEGER;
BEGIN
    IF :NEW.NGSINH IS NOT NULL THEN
        SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, :NEW.NGSINH) / 12)
        INTO v_age
        FROM DUAL;

        IF v_age < 18 THEN
            RAISE_APPLICATION_ERROR(-20007, 'Cư dân phải trên 18 tuổi.');
        END IF;
    END IF;
END;

--Trigger 1 cư dân không được sở hữu quá 4 chiếc xe nằm trong căn hộ
CREATE OR REPLACE TRIGGER trg_check_car_limit
FOR INSERT OR UPDATE OR DELETE ON XE
COMPOUND TRIGGER
  -- Biến toàn cục để lưu trữ mã cư dân bị ảnh hưởng
  TYPE t_macd_tab IS TABLE OF VARCHAR2(6);
  g_macd_tab t_macd_tab := t_macd_tab();

  BEFORE EACH ROW IS
  BEGIN
    -- Thêm mã cư dân vào bảng tạm khi thực hiện INSERT hoặc UPDATE
    IF INSERTING OR UPDATING THEN
      g_macd_tab.EXTEND;
      g_macd_tab(g_macd_tab.COUNT) := :NEW.MACD;
    END IF;

    -- Thêm mã cư dân vào bảng tạm khi thực hiện DELETE
    IF DELETING THEN
      g_macd_tab.EXTEND;
      g_macd_tab(g_macd_tab.COUNT) := :OLD.MACD;
    END IF;
  END BEFORE EACH ROW;

  AFTER STATEMENT IS
  BEGIN
    -- Kiểm tra số lượng xe của mỗi cư dân bị ảnh hưởng
    FOR i IN 1 .. g_macd_tab.COUNT LOOP
      DECLARE
        v_car_count NUMBER;
      BEGIN
        SELECT COUNT(*) INTO v_car_count
        FROM XE
        WHERE MACD = g_macd_tab(i);

        -- Giới hạn số lượng xe cho mỗi cư dân, ví dụ là 2 xe
        IF v_car_count > 4 THEN
          RAISE_APPLICATION_ERROR(-20001, 'Cư dân ' || g_macd_tab(i) || ' có quá nhiều xe.');
        END IF;
      END;
    END LOOP;
  END AFTER STATEMENT;
END trg_check_car_limit;


--trigger ngày bắt đầu hoá đơn phải luôn luôn lớn hơn ngày bắt đầu hợp đồng
CREATE OR REPLACE TRIGGER trg_check_ngayhd
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
DECLARE
    v_ngaybd DATE;
BEGIN
    -- Lấy ngày bắt đầu hợp đồng từ bảng HOPDONG tương ứng với căn hộ
    SELECT NGAYBD
    INTO v_ngaybd
    FROM HOPDONG
    WHERE MAHOPDONG = (SELECT MAHOPDONG FROM CANHO WHERE MACH = :NEW.MACH);

    -- Kiểm tra nếu NGAYHD không lớn hơn NGAYBD
    IF :NEW.NGAYHD <= v_ngaybd THEN
        RAISE_APPLICATION_ERROR(-20010, 'Ngày bắt đầu hóa đơn phải lớn hơn ngày bắt đầu hợp đồng.');
    END IF;
END;

-- trigger Phixe ở cthd phải bằng ( giá xe* slxe ) ở bảng căn hộ
CREATE OR REPLACE TRIGGER trg_check_and_update_phixe
BEFORE INSERT OR UPDATE ON CTHD
FOR EACH ROW
DECLARE
    v_giaxe NUMBER;
    v_slxe NUMBER;
BEGIN
    -- Lấy GIAXE và SLXE từ bảng CANHO dựa trên MACH từ bảng HOADON
    SELECT CANHO.GIAXE, CANHO.SLXE
    INTO v_giaxe, v_slxe
    FROM CANHO
    JOIN HOADON ON CANHO.MACH = HOADON.MACH
    WHERE HOADON.MAHD = :NEW.MAHD;

    -- Cập nhật giá trị PHIXE trong bảng CTHD
    :NEW.PHIXE := v_giaxe * v_slxe;

    -- Kiểm tra nếu giá trị PHIXE không hợp lệ
    IF :NEW.PHIXE IS NULL THEN
        RAISE_APPLICATION_ERROR(-20011, 'Giá trị PHIXE không thể là NULL.');
    END IF;
END;

-- trigger tiền điện ở bảng cthd bằng (chisosau-chisotruoc)*giadien ở bảng điện kế
CREATE OR REPLACE TRIGGER trg_check_and_update_tiendien
BEFORE INSERT OR UPDATE ON CTHD
FOR EACH ROW
DECLARE
    v_chisotruoc NUMBER;
    v_chisosau NUMBER;
    v_giadien NUMBER;
BEGIN
    -- Lấy CHISOTRUOC, CHISOSAU và GIADIEN từ bảng DIENKE dựa trên MACH từ bảng HOADON
    SELECT DIENKE.CHISOTRUOC, DIENKE.CHISOSAU, DIENKE.GIADIEN
    INTO v_chisotruoc, v_chisosau, v_giadien
    FROM DIENKE
    JOIN HOADON ON DIENKE.MACH = HOADON.MACH
    WHERE HOADON.MAHD = :NEW.MAHD;

    -- Tính toán giá trị TIENDIEN
    :NEW.TIENDIEN := (v_chisosau - v_chisotruoc) * v_giadien;

    -- Kiểm tra nếu giá trị TIENDIEN không hợp lệ
    IF :NEW.TIENDIEN IS NULL THEN
        RAISE_APPLICATION_ERROR(-20012, 'Giá trị TIENDIEN không thể là NULL.');
    END IF;
END;

--trigger tiền nước ở bảng cthd bằng (chisosau-chisotruoc)*gianuoc ở bảng đồng hồ nước
CREATE OR REPLACE TRIGGER trg_check_and_update_tiennuoc
BEFORE INSERT OR UPDATE ON CTHD
FOR EACH ROW
DECLARE
    v_chisotruoc NUMBER;
    v_chisosau NUMBER;
    v_gianuoc NUMBER;
BEGIN
    -- Lấy CHISOTRUOC, CHISOSAU và GIANUOC từ bảng DONGHONUOC dựa trên MACH từ bảng HOADON
    SELECT DONGHONUOC.CHISOTRUOC, DONGHONUOC.CHISOSAU, DONGHONUOC.GIANUOC
    INTO v_chisotruoc, v_chisosau, v_gianuoc
    FROM DONGHONUOC
    JOIN HOADON ON DONGHONUOC.MACH = HOADON.MACH
    WHERE HOADON.MAHD = :NEW.MAHD;

    -- Tính toán giá trị TIENNUOC
    :NEW.TIENNUOC := (v_chisosau - v_chisotruoc) * v_gianuoc;

    -- Kiểm tra nếu giá trị TIENNUOC không hợp lệ
    IF :NEW.TIENNUOC IS NULL THEN
        RAISE_APPLICATION_ERROR(-20013, 'Giá trị TIENNUOC không thể là NULL.');
    END IF;
END;

-- moi can ho co 1 hoa don trong 1 thang
CREATE OR REPLACE TRIGGER hd_for_month
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    -- Đếm số hóa đơn cho căn hộ trong tháng hiện tại, loại trừ hóa đơn đang được cập nhật (nếu có)
    SELECT COUNT(*)
    INTO v_count
    FROM HOADON
    WHERE MACH = :NEW.MACH
      AND TO_CHAR(NGAYHD, 'YYYY-MM') = TO_CHAR(:NEW.NGAYHD, 'YYYY-MM')
      AND (MAHD != :NEW.MAHD OR :NEW.MAHD IS NULL);
    
    -- Nếu đã tồn tại hóa đơn trong tháng, báo lỗi
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Mỗi căn hộ chỉ được có duy nhất 1 hóa đơn mỗi tháng.');
    END IF;
END;

--PROCEDURE 
-----------------------------------------
--CANHO
-----------------------------------------
    --SUA CANHO 
CREATE OR REPLACE PROCEDURE UPDATE_CANHO(
    p_MACH IN VARCHAR2,
    p_DienTich IN NUMBER,
    p_LoaiCH IN VARCHAR2,
    p_SoPhongNgu IN INT,
    p_SoPhongTam IN INT,
    p_Tang IN INT,
    p_GiaThue IN NUMBER,
    p_PHIDV IN NUMBER,
    p_GIAXE IN NUMBER,
    p_SLXE IN NUMBER,
    p_MACD IN VARCHAR2,
    p_MANV IN VARCHAR2,
    p_MAHOPDONG IN VARCHAR2
)
IS
BEGIN
  --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
 -- SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    UPDATE CANHO 
    SET DienTich = p_DienTich,
        LoaiCH = p_LoaiCH,
        SoPhongNgu = p_SoPhongNgu,
        SoPhongTam = p_SoPhongTam,
        Tang = p_Tang,
        GiaThue = p_GiaThue,
        PHIDV = p_PHIDV,
        GIAXE = p_GIAXE,
        SLXE = p_SLXE,
        MACD = p_MACD,
        MANV = p_MANV,
        MAHOPDONG = p_MAHOPDONG
    WHERE MACH = p_MACH; 
    DBMS_SESSION.SLEEP(5);
    COMMIT; 
END UPDATE_CANHO;
-----------------------------------------
--UPDATE CANHO
CREATE OR REPLACE PROCEDURE UPDATE1_CANHO(
    p_MACH IN VARCHAR2,
    p_DienTich IN NUMBER,
    p_LoaiCH IN VARCHAR2,
    p_SoPhongNgu IN INT,
    p_SoPhongTam IN INT,
    p_Tang IN INT,
    p_GiaThue IN NUMBER,
    p_PHIDV IN NUMBER,
    p_GIAXE IN NUMBER,
    p_SLXE IN NUMBER
)
IS
BEGIN

    UPDATE CANHO 
    SET DienTich = p_DienTich,
        LoaiCH = p_LoaiCH,
        SoPhongNgu = p_SoPhongNgu,
        SoPhongTam = p_SoPhongTam,
        Tang = p_Tang,
        GiaThue = p_GiaThue,
        PHIDV = p_PHIDV,
        GIAXE = p_GIAXE,
        SLXE = p_SLXE,
        MACD=NULL,
        MANV=NULL,
        MAHOPDONG=NULL    
    WHERE MACH = p_MACH;
    COMMIT; 
END UPDATE1_CANHO;
-----------------------------------------
--CUDAN
  --THEM CUDAN
CREATE OR REPLACE PROCEDURE INSERT_CUDAN(
    p_MACD IN VARCHAR2,
    p_HoTen IN VARCHAR2,
    p_NGSINH IN DATE,
    p_GIOITINH IN VARCHAR2,
    p_CCCD IN VARCHAR2,
    p_SDT IN VARCHAR2,
    p_Email IN VARCHAR2,
    p_LoaiCD IN VARCHAR2
)
IS
BEGIN
  --  SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
  --  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    INSERT INTO CUDAN (MACD, HoTen, NGSINH, GIOITINH, CCCD, SDT, Email, LoaiCD)
    VALUES (p_MACD, p_HoTen, p_NGSINH, p_GIOITINH, p_CCCD, p_SDT, p_Email, p_LoaiCD);
    COMMIT; 
END INSERT_CUDAN;
-----------------------------------------
--Sua CUDAN
CREATE OR REPLACE PROCEDURE UPDATE_CUDAN(
    
    p_MACD IN VARCHAR2,
    p_HoTen IN VARCHAR2,
    p_NGSINH IN DATE,
    p_GIOITINH IN VARCHAR2,
    p_CCCD IN VARCHAR2,
    p_SDT IN VARCHAR2,
    p_Email IN VARCHAR2,
    p_LoaiCD IN VARCHAR2
)
IS
BEGIN
--SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE CUDAN 
    SET HoTen = p_HoTen,
        NGSINH = p_NGSINH,
        GIOITINH = p_GIOITINH,
        CCCD = p_CCCD,
        SDT = p_SDT,
        Email = p_Email,
        LoaiCD = p_LoaiCD
    WHERE MACD = p_MACD; 
    COMMIT;
END UPDATE_CUDAN;
-----------------------------------------
   
--HOPDONG
  --THEM HOPDONG
CREATE OR REPLACE PROCEDURE INSERT_HOPDONG(
    p_MAHOPDONG IN VARCHAR2,
    p_NGAYBD IN DATE,
    p_THOIHAN IN VARCHAR2,
    p_LOAIHD IN VARCHAR2,
    p_GIA IN NUMBER,
    p_MACD IN VARCHAR2,
    p_MABQL IN VARCHAR2
)
IS
BEGIN
    INSERT INTO HOPDONG (MAHOPDONG, NGAYBD, THOIHAN, LOAIHD, GIA, MACD, MABQL)
    VALUES (p_MAHOPDONG, p_NGAYBD, p_THOIHAN, p_LOAIHD, p_GIA, p_MACD, p_MABQL);  
    COMMIT; -- Commit the transaction
END INSERT_HOPDONG;

-----------------------------------------
  --SUA HOPDONG
 CREATE OR REPLACE PROCEDURE UPDATE_HOPDONG(
    p_MAHOPDONG IN VARCHAR2,
    p_NGAYBD IN DATE,
    p_THOIHAN IN VARCHAR2,
    p_LOAIHD IN VARCHAR2,
    p_GIA IN NUMBER,
    p_MACD IN VARCHAR2,
    p_MABQL IN VARCHAR2
)
IS
BEGIN
    UPDATE HOPDONG 
    SET NGAYBD = p_NGAYBD,
        THOIHAN = p_THOIHAN,
        LOAIHD = p_LOAIHD,
        GIA = p_GIA,
        MACD = p_MACD,
        MABQL = p_MABQL
    WHERE MAHOPDONG = p_MAHOPDONG;   
 --   COMMIT; -- Commit the transaction
END UPDATE_HOPDONG;
-----------------------------------------
--XE
  --THEM XE
CREATE OR REPLACE PROCEDURE INSERT_XE(
    p_MAXE IN VARCHAR2,
    p_BIENSOXE IN VARCHAR2,
    p_LOAIXE IN VARCHAR2,
    p_MACD IN VARCHAR2
)
IS
BEGIN
    INSERT INTO XE (MAXE, BIENSOXE, LOAIXE, MACD)
    VALUES (p_MAXE, p_BIENSOXE, p_LOAIXE, p_MACD);   
    COMMIT; -- Commit the transaction
END INSERT_XE;
-----------------------------------------
  --SUA xe
CREATE OR REPLACE PROCEDURE UPDATE_XE(
    p_MAXE IN VARCHAR2,
    p_BIENSOXE IN VARCHAR2,
    p_LOAIXE IN VARCHAR2,
    p_MACD IN VARCHAR2
)
IS
BEGIN
    UPDATE XE 
    SET BIENSOXE = p_BIENSOXE,
        LOAIXE = p_LOAIXE,
        MACD = p_MACD
    WHERE MAXE = p_MAXE;  
    COMMIT; -- Commit the transaction
END UPDATE_XE;
-----------------------------------------

--NHANVIEN
  --Them nhanvien
CREATE OR REPLACE PROCEDURE INSERT_NHANVIEN(
    p_MANV IN VARCHAR2,
    p_HOTEN IN VARCHAR2,
    p_SDT IN VARCHAR2,
    p_Email IN VARCHAR2,
    p_MABQL IN VARCHAR2
)
IS
BEGIN
    INSERT INTO NHANVIEN (MANV, HOTEN, SDT, Email, MABQL)
    VALUES (p_MANV, p_HOTEN, p_SDT, p_Email, p_MABQL);    
    COMMIT; -- Commit the transaction
END INSERT_NHANVIEN;
-----------------------------------------
  --Sua nhanvien
  CREATE OR REPLACE PROCEDURE UPDATE_NHANVIEN(
    p_MANV IN VARCHAR2,
    p_HOTEN IN VARCHAR2,
    p_SDT IN VARCHAR2,
    p_EMAIL IN VARCHAR2,
    p_MABQL IN VARCHAR2
)
IS
BEGIN
    UPDATE NHANVIEN 
    SET HOTEN = p_HOTEN,
        SDT = p_SDT,
        EMAIL = p_EMAIL,
        MABQL = p_MABQL
    WHERE MANV = p_MANV;  
    COMMIT; -- Commit the transaction
END UPDATE_NHANVIEN;
-----------------------------------------
--TAIKHOAN
  --Them taikhoan
CREATE OR REPLACE PROCEDURE INSERT_TAIKHOAN(
    p_USERNAME IN VARCHAR2,
    p_PASSWORD IN VARCHAR2,
    p_ROLE IN VARCHAR2,
    p_EMAIL IN VARCHAR2
)
IS
BEGIN
    INSERT INTO TAIKHOAN (USERNAME, PASSWORD, ROLE, EMAIL)
    VALUES (p_USERNAME, p_PASSWORD, p_ROLE, p_EMAIL);   
    COMMIT; -- Commit the transaction
END INSERT_TAIKHOAN;
-----------------------------------------
  --sua taikhoan
CREATE OR REPLACE PROCEDURE UPDATE_TAIKHOAN(
    p_USERNAME IN VARCHAR2,
    p_PASSWORD IN VARCHAR2,
    p_ROLE IN VARCHAR2,
    p_EMAIL IN VARCHAR2
)
IS
BEGIN
    UPDATE TAIKHOAN 
    SET PASSWORD = p_PASSWORD,
        ROLE = p_ROLE,
        EMAIL = p_EMAIL
    WHERE USERNAME = p_USERNAME;   
    COMMIT; -- Commit the transaction
END UPDATE_TAIKHOAN;
-----------------------------------------
--CTHD
CREATE OR REPLACE PROCEDURE INSERT_CTHD(
    p_MAHD IN VARCHAR2,
    p_GIATHUE IN NUMBER,
    p_PHIXE IN NUMBER,
    p_PHIDV IN NUMBER,
    p_TIENDIEN IN NUMBER,
    p_TIENNUOC IN NUMBER
)
IS
BEGIN
    INSERT INTO CTHD (MAHD, GIATHUE, PHIXE, PHIDV, TIENDIEN, TIENNUOC)
    VALUES (p_MAHD, p_GIATHUE, p_PHIXE, p_PHIDV, p_TIENDIEN, p_TIENNUOC);   
    COMMIT; -- Commit the transaction
END INSERT_CTHD;
-----------------------------------------
--HOADON
CREATE OR REPLACE PROCEDURE INSERT_HOADON(
    p_MAHD IN VARCHAR2,
    p_NGAYHD IN DATE,
    p_TRIGIA IN NUMBER,
    p_TINHTRANG IN VARCHAR2,
    p_MACH IN VARCHAR2
)
IS
BEGIN
--SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    INSERT INTO HOADON (MAHD, NGAYHD, TRIGIA,TINHTRANG, MACH)
    VALUES (p_MAHD, p_NGAYHD, p_TRIGIA,P_TINHTRANG, p_MACH);
    COMMIT; -- Commit the transaction
END INSERT_HOADON;

-----------------------------------------

CREATE OR REPLACE PROCEDURE UPDATE_TINHTRANG_HOADON(
    p_MAHD IN VARCHAR2,
    p_TINHTRANG IN VARCHAR2
) AS
BEGIN
    --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE HOADON
    SET TINHTRANG = p_TINHTRANG
    WHERE MAHD = p_MAHD;
END;
-----------------------------------------
--insert yccd
CREATE OR REPLACE PROCEDURE INSERT_YEUCAUCUDAN(
    p_MAYC IN VARCHAR2,
    p_LoaiYC IN VARCHAR2,
    p_NoiDungYC IN VARCHAR2,
    p_TrangThaiYC IN VARCHAR2,
    p_MACD IN VARCHAR2
)
IS
BEGIN
    INSERT INTO YEUCAUCUDAN (MAYC, LoaiYC, NoiDungYC, TrangThaiYC, MACD)
    VALUES (p_MAYC, p_LoaiYC, p_NoiDungYC, p_TrangThaiYC, p_MACD);  
    COMMIT; -- Commit the transaction
END INSERT_YEUCAUCUDAN;
-----------------------------------------
CREATE OR REPLACE PROCEDURE UPDATE_YEUCAUCUDAN(
            p_MAYC IN VARCHAR2,
            p_LOAIYC IN VARCHAR2,  
            p_NoiDungYC IN VARCHAR2,
            p_TrangThaiYC IN VARCHAR2,
            p_MACD IN VARCHAR2
        )
        IS
        BEGIN
            UPDATE YEUCAUCUDAN
            SET MAYC = P_MAYC,
                LoaiYC = P_LOAIYC,
                NoiDungYC = P_NOIDUNGYC,
                TrangThaiYC = P_TRANGTHAIYC,
                MACD = p_MACD
                
           WHERE MAYC=P_MAYC;
            
            COMMIT; -- Commit the transaction
END UPDATE_YEUCAUCUDAN;
        

-----------------------------------------
CREATE OR REPLACE PROCEDURE UPDATE_DIENKE(
    p_MACH IN VARCHAR2,
    p_CHISOTRUOC IN NUMBER,
    p_CHISOSAU IN NUMBER,
    p_GIADIEN IN NUMBER
)
IS
BEGIN
    UPDATE DIENKE 
    SET CHISOTRUOC = p_CHISOTRUOC,
        CHISOSAU = p_CHISOSAU,
        GIADIEN = p_GIADIEN
    WHERE MACH = p_MACH;
    
    COMMIT; -- Commit the transaction
END UPDATE_DIENKE;

-----------------------------------------
CREATE OR REPLACE PROCEDURE UPDATE_DONGHONUOC(
    p_MACH IN VARCHAR2,
    p_CHISOTRUOC IN NUMBER,
    p_CHISOSAU IN NUMBER,
    p_GIANUOC IN NUMBER
)
IS
BEGIN
    UPDATE DONGHONUOC 
    SET CHISOTRUOC = p_CHISOTRUOC,
        CHISOSAU = p_CHISOSAU,
        GIANUOC = p_GIANUOC
    WHERE MACH = p_MACH;
    
    COMMIT; -- Commit the transaction
END UPDATE_DONGHONUOC;



CREATE OR REPLACE PROCEDURE tao_hoa_don (
    p_mach IN CANHO.MACH%TYPE,
    p_mahd IN HOADON.MAHD%TYPE
) IS
    v_giathue NUMBER;
    v_phixe_unit NUMBER;
    v_phidv NUMBER;
    v_slxe NUMBER;
    v_phixe NUMBER;
    v_tiendien NUMBER;
    v_tiennuoc NUMBER;
    v_chisodien_truoc NUMBER;
    v_chisodien_sau NUMBER;
    v_giadien NUMBER;
    v_chisonuoc_truoc NUMBER;
    v_chisonuoc_sau NUMBER;
    v_gianuoc NUMBER;
    v_trigia NUMBER;
BEGIN
    -- Get values from CANHO table
    SELECT GiaThue, GiaXe, PhiDV, SLXE
    INTO v_giathue, v_phixe_unit, v_phidv, v_slxe
    FROM CANHO
    WHERE MACH = p_mach;

    -- Calculate PHIXE
    v_phixe := v_phixe_unit * v_slxe;

    -- Get values from DIENKE table
    SELECT CHISOTRUOC, CHISOSAU, GIADIEN
    INTO v_chisodien_truoc, v_chisodien_sau, v_giadien
    FROM DIENKE
    WHERE MACH = p_mach;

    -- Calculate TIENDIEN
    v_tiendien := (v_chisodien_sau - v_chisodien_truoc) * v_giadien;

    -- Get values from DONGHONUOC table
    SELECT CHISOTRUOC, CHISOSAU, GIANUOC
    INTO v_chisonuoc_truoc, v_chisonuoc_sau, v_gianuoc
    FROM DONGHONUOC
    WHERE MACH = p_mach;

    -- Calculate TIENNUOC
    v_tiennuoc := (v_chisonuoc_sau - v_chisonuoc_truoc) * v_gianuoc;

    -- Calculate total TRIGIA
    v_trigia := v_giathue + v_phixe + v_phidv + v_tiendien + v_tiennuoc;

    -- Insert new record into HOADON table
    INSERT INTO HOADON (MAHD, NGAYHD, TRIGIA, TINHTRANG, MACH)
    VALUES (p_mahd, SYSDATE, v_trigia, 'Chua thanh toan', p_mach);

    -- Insert new record into CTHD table
    INSERT INTO CTHD (MAHD, GIATHUE, PHIXE, PHIDV, TIENDIEN, TIENNUOC)
    VALUES (p_mahd, v_giathue, v_phixe, v_phidv, v_tiendien, v_tiennuoc);
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--XOAcudan
CREATE OR REPLACE PROCEDURE XoaCuDan(
    p_MACD IN CUDAN.MACD%TYPE
)
IS
BEGIN
    -- SET  TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    -- Xoa cthd
     DELETE FROM CTHD WHERE MAHD IN (SELECT MAHD FROM HOADON WHERE MACH IN (SELECT MACH FROM CANHO WHERE MACD = p_MACD));
    -- Xóa các hóa đơn thuộc sở hữu của cư dân
    DELETE FROM HOADON WHERE MACH IN (SELECT MACH FROM CANHO WHERE MACD = p_MACD);
    -- Xóa thông tin về cư dân từ các bảng có liên kết với bảng CUDAN
  
    UPDATE CANHO SET MACD = NULL, MANV = NULL, MAHOPDONG = NULL WHERE MACD = p_MACD;

    -- Xóa thông tin về cư dân từ các bảng có liên kết với bảng CUDAN
    DELETE FROM XE WHERE MACD = p_MACD;
    DELETE FROM HOPDONG WHERE MACD = p_MACD;
    DELETE FROM LICHSUYEUCAU WHERE MAYC IN( SELECT MAYC FROM YEUCAUCUDAN WHERE MACD = p_MACD);
    DELETE FROM YEUCAUCUDAN WHERE MACD = p_MACD;
    DELETE FROM TAIKHOAN WHERE USERNAME = p_MACD;
    
    -- Xóa thông tin cư dân
    DELETE FROM CUDAN WHERE MACD = p_MACD;
 DECLARE
        v_start_time TIMESTAMP := SYSTIMESTAMP;
    BEGIN
        LOOP
            EXIT WHEN SYSTIMESTAMP >= v_start_time + INTERVAL '5' SECOND;
        END LOOP;
    END;
    -- In ra thông báo xóa thành công
    DBMS_OUTPUT.PUT_LINE('Cư dân với MACD ' || p_MACD || ' đã được xóa thành công.');
    
    -- Commit thay đổi
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- In ra thông báo nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
        -- Rollback nếu có lỗi xảy ra để không lưu các thay đổi
        ROLLBACK;
END XoaCuDan;


CREATE OR REPLACE PROCEDURE XoaCanHo(
    p_MACH IN CANHO.MACH%TYPE
)
IS
    v_SLXE CANHO.SLXE%TYPE;
BEGIN
    -- Xóa các chi tiết hóa đơn thuộc hóa đơn có mã căn hộ này
    DELETE FROM CTHD WHERE MAHD IN (SELECT MAHD FROM HOADON WHERE MACH = p_MACH);
    -- Xóa các hóa đơn thuộc sở hữu của cư dân
    DELETE FROM HOADON WHERE MACH = p_MACH;
    SELECT SLXE
    INTO v_SLXE
    FROM CANHO
    WHERE MACH = p_MACH;
    -- Xóa các xe thuộc cư dân này
    DELETE FROM XE WHERE MACD IN (SELECT MACD FROM CANHO WHERE MACH = p_MACH)AND ROWNUM <= v_SLXE;
    -- Xóa các yêu cầu của cư dân từ bảng LICHSUYEUCAU và YEUCAUCUDAN
    DELETE FROM LICHSUYEUCAU WHERE MAYC IN (SELECT MAYC FROM YEUCAUCUDAN WHERE MACD IN (SELECT MACD FROM CANHO WHERE MACH = p_MACH));
    DELETE FROM YEUCAUCUDAN WHERE MACD IN (SELECT MACD FROM CANHO WHERE MACH = p_MACH); 
    -- Cập nhật các trường liên quan trong bảng CANHO
    UPDATE CANHO SET MACD = NULL, MANV = NULL, MAHOPDONG = NULL, SLXE = 0  WHERE  MACH = p_MACH; 
   DECLARE
        v_start_time TIMESTAMP := SYSTIMESTAMP;
    BEGIN
        LOOP
            EXIT WHEN SYSTIMESTAMP >= v_start_time + INTERVAL '5' SECOND;
        END LOOP;
    END;
    -- In ra thông báo xóa thành công
    DBMS_OUTPUT.PUT_LINE('Căn hộ có mã căn hộ ' || p_MACH || ' đã được xóa thành công.');
    -- Commit thay đổi
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- In ra thông báo nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
        -- Rollback nếu có lỗi xảy ra để không lưu các thay đổi
        ROLLBACK;
END XoaCanHo;

-- Tạo người dùng USER1 với mật khẩu Password1


CREATE OR REPLACE PROCEDURE XEMCTHD(
    p_MAHD IN CTHD.MAHD%TYPE,
    p_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    OPEN p_cursor FOR
    SELECT MAHD, GIATHUE, PHIXE, PHIDV, TIENDIEN, TIENNUOC 
    FROM CTHD 
    WHERE MAHD = p_MAHD;
    
    -- Giả lập một khoảng thời gian trễ
    DECLARE
        v_start_time TIMESTAMP := SYSTIMESTAMP;
    BEGIN
        LOOP
            EXIT WHEN SYSTIMESTAMP >= v_start_time + INTERVAL '8' SECOND;
        END LOOP;
    END;
    
    COMMIT; -- Commit the transaction
END XEMCTHD;

--CANHO
CREATE OR REPLACE PROCEDURE XEMCTCH(
    p_MACH IN CANHO.MACH%TYPE,
    p_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    OPEN p_cursor FOR
    SELECT *
    FROM CANHO
    WHERE MACH = p_MACH;
END XEMCTCH;

CREATE USER TK1 IDENTIFIED BY Password1;

-- Gán quyền CONNECT và RESOURCE cho USER1
GRANT CONNECT, RESOURCE, DBA TO TK1;

-- Tạo người dùng USER2 với mật khẩu Password2
CREATE USER TK2 IDENTIFIED BY Password2;

-- Gán quyền CONNECT và RESOURCE cho USER2
GRANT CONNECT, RESOURCE,DBA TO TK2;

GRANT EXECUTE ON QLCHUNGCU.XOACANHO TO TK1;
GRANT EXECUTE ON QLCHUNGCU.XEMCTCH TO TK1;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_CANHO TO TK2;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_CANHO TO TK1;
GRANT EXECUTE ON QLCHUNGCU.INSERT_CUDAN TO TK2;
GRANT EXECUTE ON QLCHUNGCU.INSERT_CUDAN TO TK1;
GRANT EXECUTE ON QLCHUNGCU.XOACUDAN TO TK2;
GRANT EXECUTE ON QLCHUNGCU.XOACUDAN TO TK1;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_CUDAN TO TK2;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_CUDAN TO TK1;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_HOPDONG TO TK2;
GRANT EXECUTE ON QLCHUNGCU.UPDATE_HOPDONG TO TK1;