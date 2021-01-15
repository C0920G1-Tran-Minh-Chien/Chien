drop database if exists case_study;
create database case_study;
use case_study;

create table loai_khach(
	id_loai_khach int primary key auto_increment,
    ten_loai_khach varchar(50)
);

create table khach_hang(
	id_khach_hang int primary key auto_increment,
    id_loai_khach int,
    ten_khach_hang varchar(50),
    ngay_sinh date,
    cmnd varchar(20),
    sdt varchar(50),
    email varchar(50),
    dia_chi varchar(50),
    foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue(
	id_kieu_thue int primary key auto_increment,
    ten_kieu_thue varchar(50),
    gia int
);

create table loai_dich_vu(
	id_loai_dich_vu int primary key auto_increment,
    ten_loai_dich_vu varchar(50)
);

create table dich_vu(
	id_dich_vu int primary key auto_increment,
    ten_dich_vu varchar(50),
    dien_tich varchar(50),
    so_tang int,
    so_nguoi_toi_da varchar(50),
    chi_phi_thue varchar(50),
    trang_thai varchar(50),
    id_kieu_thue int,
    id_loai_dich_vu int,
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table vi_tri(
	id_vi_tri int primary key auto_increment,
    ten_vi_tri varchar(50)
);

create table trinh_do(
	id_trinh_do int primary key auto_increment,
    trinh_do varchar(50)
);

create table bo_phan(
	id_bo_phan int primary key auto_increment,
    ten_bo_phan varchar(50)
);

create table nhan_vien(
	id_nhan_vien int primary key auto_increment,
    ten_nhan_vien varchar(50),
    ngay_sinh date,
    cmnd varchar(50),
    luong varchar(50),
    sdt varchar(50),
    email varchar(50),
    dia_chi varchar(50),
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    foreign key (id_vi_tri) references vi_tri(id_vi_tri),
    foreign key (id_trinh_do) references trinh_do(id_trinh_do),
    foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key auto_increment,
    ten_dich_vu_di_kem varchar(50),
    gia int,
    don_vi varchar(50),
    trang_thai varchar(50)
);


create table hop_dong(
	id_hop_dong int primary key auto_increment,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien) on update cascade on delete cascade,
    foreign key (id_khach_hang) references khach_hang(id_khach_hang) on update cascade on delete cascade,
    foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key auto_increment,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int,
    foreign key (id_hop_dong) references hop_dong(id_hop_dong) on update cascade on delete cascade,
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
    
);


insert into loai_khach(id_loai_khach,ten_loai_khach) values (id_loai_khach, 'vip');
insert into loai_khach(id_loai_khach,ten_loai_khach) values (id_loai_khach, 'vip_pro');
insert into loai_khach(id_loai_khach,ten_loai_khach) values (id_loai_khach, 'dang_cap');
insert into loai_khach(id_loai_khach,ten_loai_khach) values (id_loai_khach, 'v_vip');

insert into khach_hang()
values (id_khach_hang, 1, 'Han Minh Chien', '1995-01-10', '123321', '0987654321', 'chien@gmail.com', 'Quang Binh'),
(id_khach_hang, 1, 'Tuong The Anh', '1993-01-10', '123321', '0982354321', 'the@gmail.com', 'Quang Tri'),
(id_khach_hang, 3, 'Koc Anh', '2000-01-10', '123321', '043554321', 'anh@gmail.com', 'Da Nang'),
(id_khach_hang, 1, 'Le Nguyen Dinh Phuc', '1992-01-10', '123321', '0982344321', 'phuc@gmail.com', 'Hue');

insert into kieu_thue() values (id_kieu_thue, 'Dai han', 1000);
insert into kieu_thue() values (id_kieu_thue, 'Ngan han', 500);
insert into kieu_thue() values (id_kieu_thue, 'Khong thoi han', 0);
insert into kieu_thue() values (id_kieu_thue, '1 Ngay', 100);

insert into loai_dich_vu() values (id_loai_dich_vu, 'Villa 1');
insert into loai_dich_vu() values (id_loai_dich_vu, 'House 1');
insert into loai_dich_vu() values (id_loai_dich_vu, 'Room 1');

insert into dich_vu() values (id_dich_vu, 'Villa', '200m2', 3, '10 nguoi', '1 trieu', 'Sach se',1,1);
insert into dich_vu() values (id_dich_vu, 'House', '100m2', 2, '5 nguoi', '5 tram', 'Sach se', 2,2);
insert into dich_vu() values (id_dich_vu, 'Room', '50m2', 1, '2 nguoi', '1 tram', 'Sach se',3,3);

insert into vi_tri() values (id_vi_tri, 'Le tan');
insert into vi_tri() values (id_vi_tri, 'Phuc vu');
insert into vi_tri() values (id_vi_tri, 'Bao ve');

insert into trinh_do() values (id_trinh_do, 'Dai hoc');
insert into trinh_do() values (id_trinh_do, 'Cao dang');
insert into trinh_do() values (id_trinh_do, 'thpt');

insert into bo_phan() values (id_bo_phan, 'marketing');
insert into bo_phan() values (id_bo_phan, 'an ninh');
insert into bo_phan() values (id_bo_phan, 'sale');

insert into nhan_vien() 
values (id_nhan_vien, 'Tran Van A', '1995-01-10' ,'123456789', '10 trieu', '09128445', 'A@abc.com', 'Quang Nam',1,1,1),
 (id_nhan_vien, 'Tran Van B', '1998-01-11','123456789', '1 trieu', '09128445', 'A@abc.com', 'Quang Ngai',1,2,3),
 (id_nhan_vien, 'Tran Van C', '2002-11-10' ,'123456789', '5 trieu', '09128445', 'A@abc.com', 'Da Nang',2,2,3 ),
 (id_nhan_vien, 'Han Van C', '2000-11-12' ,'123456789', '5 trieu', '09128445', 'A@abc.com', 'Da Nang',1,3,2 ),
 (id_nhan_vien, 'Mran Van C', '1995-01-10' ,'123456789', '5 trieu', '09128445', 'A@abc.com', 'Da Nang',2,3,3 );


insert into dich_vu_di_kem() values (id_dich_vu_di_kem, 'massage', 1000, 'USD', 'ngon'),
(id_dich_vu_di_kem, 'karakole', 100, 'USD', 'oke'),
(id_dich_vu_di_kem, 'nhau', 500, 'USD', 'vip'),
(id_dich_vu_di_kem, 'buffet', 300, 'USD', 'tot')
;



insert into hop_dong() 
values (id_hop_dong, '1995-05-05', '2000-05-05', 200, 1000, 1,1,1),
(id_hop_dong, '2018-02-05', '2018-05-05', 500, 2000, 1,2,2),
(id_hop_dong, '2019-05-05', '2021-05-15', 700, 1500,2,2,1),
(id_hop_dong, '1995-05-05', '2019-10-05', 200, 1000, 1,1,3),
(id_hop_dong, '2018-02-05', '2019-02-05', 500, 2000, 1,2,2),
(id_hop_dong, '2019-05-05', '2021-05-15', 700, 1500,2,4,1);

insert into hop_dong_chi_tiet() values (id_hop_dong_chi_tiet,1,2, 10),
(id_hop_dong_chi_tiet,2,2, 20),
(id_hop_dong_chi_tiet,4,3, 30),
(id_hop_dong_chi_tiet,3,1, 50),
(id_hop_dong_chi_tiet,5,4, 30),
(id_hop_dong_chi_tiet,6,1, 50);


-- task2-- 
select * from nhan_vien
 where (ten_nhan_vien like 'H%' or ten_nhan_vien like 'T%' ) 
 and length(ten_nhan_vien) < 15; 

-- task 3 
select * from nhan_vien 
where year(curdate()) - year(ngay_sinh) > 18 
and year(curdate()) - year(ngay_sinh) < 50 
and dia_chi in ('Da Nang', 'Quang Nam'); 

-- task 4 
select khach_hang.id_khach_hang,
khach_hang.ten_khach_hang,hop_dong.id_hop_dong, khach_hang.id_loai_khach, count(khach_hang.id_khach_hang) as so_lan
from khach_hang 
join hop_dong
on hop_dong.id_khach_hang = khach_hang.id_khach_hang
group by khach_hang.id_khach_hang
order by so_lan asc;

-- task 5
select khach_hang.id_khach_hang, khach_hang.ten_khach_hang,
hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu_di_kem.gia,hop_dong_chi_tiet.so_luong,
dich_vu.chi_phi_thue, (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) as tongtien 
from khach_hang
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu 
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong 
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem;

-- task 6
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu,hop_dong.ngay_lam_hop_dong ,hop_dong.ngay_ket_thuc from hop_dong
join dich_vu
on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join loai_dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
where not ((year(hop_dong.ngay_ket_thuc) = 2019 
and month(hop_dong.ngay_ket_thuc) < 4)  or (year(hop_dong.ngay_ket_thuc) < 2019));

-- task 7
 select dich_vu.id_dich_vu, dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,
 dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong 
 from dich_vu 
 join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
 join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
 where year(hop_dong.ngay_lam_hop_dong) = 2018 and dich_vu.id_dich_vu 
 not in (select dich_vu.id_dich_vu from dich_vu
 where year(hop_dong.ngay_lam_hop_dong) = 2019 );
 
 -- task 8
	-- cach 1.
    select distinct khach_hang.ten_khach_hang from khach_hang;
    -- cach 2.
    select khach_hang.ten_khach_hang 
    from khach_hang group by ten_khach_hang;
    -- cach 3.
    SELECT khach_hang.ten_khach_hang 
	from khach_hang
	UNION
	SELECT khach_hang.ten_khach_hang 
	from khach_hang;
    
    -- task 9.
    SELECT month(hop_dong.ngay_lam_hop_dong) as 'thang' ,
    count(month(hop_dong.ngay_lam_hop_dong)) as 'soHopDong' 
	FROM hop_dong
	WHERE year(hop_dong.ngay_lam_hop_dong)=2019
	GROUP BY ngay_lam_Hop_Dong
	ORDER BY hop_dong.ngay_lam_hop_dong;
    
    -- task 10.
    SELECT hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
    hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as 'so_luong_dv_di_kem'
	FROM hop_dong
	INNER JOIN hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
	GROUP BY hop_dong.id_hop_dong;
    
    -- task 11.
    SELECT dich_vu_di_kem.id_dich_vu_di_kem,
	 dich_vu_di_kem.ten_dich_vu_di_kem,
	 dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, 
	 dich_vu_di_kem.trang_thai,
	 loai_khach.ten_loai_khach, 
	 khach_hang.dia_chi, 
	 khach_hang.ten_khach_hang
	FROM dich_vu_di_kem
	INNER JOIN hop_dong_chi_tiet  on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
	INNER JOIN hop_dong  on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	INNER JOIN khach_hang  on hop_dong.id_khach_hang = khach_hang.id_khach_hang
	INNER JOIN loai_khach  on khach_hang.id_loai_khach = loai_khach.id_loai_khach
	WHERE loai_khach.ten_loai_khach = 'Vip' 
	AND (khach_hang.dia_chi = 'Da Nang' or khach_hang.dia_chi = 'Quang Binh');
    
    
    -- task 12.
	SELECT hop_dong.id_hop_dong,
	 nhan_vien.ten_nhan_vien,
	 khach_hang.ten_khach_hang,
	 khach_hang.sdt,
	 dich_vu.ten_dich_vu,
	 count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as 'SoLuongDichVuDikem ',
	 hop_dong.tien_dat_coc
	FROM hop_dong 
	INNER JOIN nhan_vien  on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
	INNER JOIN khach_hang  on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	INNER JOIN dich_vu  on dich_vu.id_dich_vu = hop_dong.id_dich_vu
	INNER JOIN hop_dong_chi_tiet  on hop_dong_chi_tiet.id_hop_dong= hop_dong.id_hop_dong
	WHERE (month(hop_dong.ngay_lam_hop_dong)>9 and year(hop_dong.ngay_lam_hop_dong)=2019)
	and hop_dong.id_hop_dong NOT IN (month(hop_dong.ngay_lam_hop_dong) < 7 AND year(hop_dong.ngay_lam_hop_dong) = 2019);
    
-- task 13
    select dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as count
    from hop_dong_chi_tiet 
    join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    group by hop_dong_chi_tiet.id_dich_vu_di_kem 
    having count = 
    (select count(hop_dong_chi_tiet.id_dich_vu_di_kem) as count 
    from hop_dong_chi_tiet
    join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    group by hop_dong_chi_tiet.id_dich_vu_di_kem  
    order by count desc
    limit 1);
    
    -- task 14
  select dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan
    from khach_hang 
    join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
    join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem 
    group by id_dich_vu_di_kem having so_lan = 1
    ;  
    
    -- task 15
    select nhan_vien.id_nhan_vien, nhan_vien.ten_nhan_vien, 
    trinh_do.trinh_do, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi, count(hop_dong.id_nhan_vien) as so_hop_dong
    from nhan_vien
    join trinh_do on nhan_vien.id_trinh_do = trinh_do.id_trinh_do
    join bo_phan on nhan_vien.id_bo_phan = bo_phan.id_bo_phan
    join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
    where year(hop_dong.ngay_lam_hop_dong) > 2017 and year(hop_dong.ngay_lam_hop_dong) < 2020
    group by id_nhan_vien having so_hop_dong < 4;
    
    -- task 16
    SET SQL_SAFE_UPDATES = 0;
    delete
	 FROM nhan_vien 
	 WHERE nhan_vien.id_nhan_vien 
	  not IN (
	 SELECT hop_dong.id_nhan_vien 
	 FROM hop_dong 
	 WHERE year(hop_dong.ngay_lam_hop_dong) BETWEEN 2017 and 2019 and hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
	 );
    
    -- task 17 
	UPDATE khach_hang
	set khach_hang.id_loai_khach = 2
	WHERE khach_hang.id_loai_khach = 1 and  khach_hang.id_khach_hang IN (
	 SELECT hop_dong.id_khach_hang FROM hop_dong WHERE hop_dong.tong_tien>= 1500 and year(hop_dong.ngay_lam_hop_dong) = 2019
	 );
     
     -- task 18	
      DELETE 
	  FROM khach_hang
	  WHERE khach_hang.id_khach_hang in (
	  SELECT hop_dong.id_khach_hang 
	  FROM hop_dong 
	  WHERE year(hop_dong.ngay_lam_hop_dong) < 2016
	  );
 
 -- task 19
	update dich_vu_di_kem 
	set dich_vu_di_kem.gia = dich_vu_di_kem.gia *2
	WHERE  dich_vu_di_kem.id_dich_vu_di_kem in ( 
	SELECT hop_dong_chi_tiet.id_dich_vu_di_kem 
	FROM hop_dong_chi_tiet  
	JOIN hop_dong  ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
	WHERE year(hop_dong.ngay_lam_hop_dong)=2019
	GROUP BY hop_dong_chi_tiet.id_dich_vu_di_kem
	HAVING count(hop_dong_chi_tiet.id_dich_vu_di_kem) >=3
	);
    
    -- task 20
    CREATE VIEW khach_hang_view as 
	SELECT khach_hang.id_khach_hang, khach_hang.ten_khach_hang,khach_hang.email, khach_hang.sdt, khach_hang.ngay_sinh, khach_hang.dia_chi
	FROM khach_hang;
	SELECT * FROM khach_hang_view;
    
	CREATE VIEW nhanvien_view as
	SELECT nhan_vien.id_nhan_vien,nhan_vien.ten_nhan_vien,nhan_vien.email,nhan_vien.sdt,nhan_vien.ngay_sinh,nhan_vien.dia_chi
	FROM nhan_vien;
	SELECT * FROM nhanvien_view;
    
    SELECT *,"nhan vien"  as loai from nhanvien_view union 
    select *, "khach hang" as loai   from khach_hang_view;
    -- task 21
    drop view if exists nhanvien;
	 CREATE VIEW nhanvien as
	 SELECT nhan_vien.id_nhan_vien,nhan_vien.ten_nhan_vien,vi_tri.ten_vi_tri,trinh_do.trinh_do,bo_phan.ten_bo_phan, nhan_vien.email,
     nhan_vien.sdt,nhan_vien.ngay_sinh,nhan_vien.dia_chi
	 FROM nhan_vien 
	  JOIN vi_tri  on vi_tri.id_vi_tri = nhan_vien.id_vi_tri
	  JOIN trinh_do  on trinh_do.id_trinh_do=nhan_vien.id_trinh_do
	  JOIN bo_phan  on bo_phan.id_bo_phan=nhan_vien.id_bo_phan
	  JOIN hop_dong  on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
	 WHERE nhan_vien.dia_chi = 'Quang Nam' and date(hop_dong.ngay_lam_hop_dong)='2019-12-12';
     
     select * from nhanvien;
     
     -- task 22
     UPDATE nhanvien
	 SET dia_chi='Ha Noi Chieu'
	 WHERE dia_chi='Quang Nam';	
     select * from nhanvien;

     -- task 23
      DELIMITER //
		CREATE PROCEDURE Sp_1(id int)
		BEGIN
		DELETE FROM khach_hang
		WHERE id_khach_hang = id;
		select * from khach_hang;
		END; //
		DELIMITER ;   
		call SP_1(8);
        
        -- task 24
        drop procedure if exists sp_2;
		DELIMITER //
		CREATE PROCEDURE SP_2(
        id_hop_dong int ,
        ngay_lam_hop_dong DATE,
		ngay_ket_thuc DATE,
        tien_dat_coc INT,
		tong_tien INT,
		id_nhan_vien INT ,
		id_khach_hang INT,
		id_dich_vu INT
		)
		BEGIN
		insert into hop_dong(id_hop_dong, ngay_lam_hop_dong,ngay_ket_thuc, tien_dat_coc, tong_tien, id_nhan_vien, id_khach_hang,id_dich_vu)
		values (id_hop_dong, ngay_lam_hop_dong,ngay_ket_thuc, tien_dat_coc, tong_tien, id_nhan_vien, id_khach_hang,id_dich_vu )
		 ;
		 SELECT * 
		FROM hop_dong;
		END; //
		DELIMITER ; 
		call SP_2(8, '2019-03-15', '2019-04-19', 100, 5000,1,2,3);