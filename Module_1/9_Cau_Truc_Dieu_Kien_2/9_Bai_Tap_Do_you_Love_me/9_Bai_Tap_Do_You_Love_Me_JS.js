function display() {
    alert('Đúng r');
}
let no = document.getElementById('no');
let height = window.innerHeight ;
let width = window.innerWidth ;
function random() {
    no = document.getElementById('no');
    no.style.position = 'relative';

}
function move() {
    no.style.left =  Math.round(Math.random()*width)  + 'px';
    no.style.top =  Math.round(Math.random()*height) + 'px';
}
window.onload = random();