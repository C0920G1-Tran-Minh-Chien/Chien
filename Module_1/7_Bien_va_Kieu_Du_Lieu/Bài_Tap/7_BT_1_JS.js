// Bài 1: Tính điểm trung bình
let l = prompt('Nhập điểm vật lý: ');
l = parseInt(l);
let h = prompt('Nhập điểm hóa học: ');
h = parseInt(h);
let s = prompt('Nhập điểm sinh học: ');
s = parseInt(s);
let DTB = (l+h+s)/3;
alert('Điểm trung bình là: '+DTB);


//Bài 2: Chuyển gí trị nhiệt độ.
let C = prompt('Nhập giá trị độ C: ');
C = parseInt(C);
let F = 9*C/5 + 32 ;
alert('Độ C = '+ F );

//Bài 3; Tính diện tích hình tròn
let r = prompt('nhập bán kính: ');
r = parseInt(r);
const pi = 3.14;
let dt = (r**2)*3.14;
alert('Diện tích hình tròn: '+dt);

//Bài 4: Chu vi hình tròn
let d = prompt('Nhập đường kính: ');
d = parseInt(d);
let cv = d*pi;
alert('Chu vi hình tròn: '+cv);