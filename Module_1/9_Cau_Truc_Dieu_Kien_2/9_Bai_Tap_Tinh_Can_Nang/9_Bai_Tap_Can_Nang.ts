let weigth = prompt('Nhập cân nặng :');
weigth = parseInt(weigth);
let height = prompt('Nhập chiều cao :');
height = parseInt(height);
var bmi = weigth / (height*height) ;
if (bmi < 18.5){
    alert('Suy dinh dưỡng');
} else if (bmi < 25){
    alert('BÌnh thường');
} else if (bmi < 30) {
    alert('Cơ bắp ');
} else {
    alert('Mập ');
}

