let img = null;
img = document.getElementById('imgSeol');
function init() {
    img = document.getElementById('imgSeol');
    img.style.position = 'relative';
    img.style.left = '0px';
}
function moveRight() {
    img.style.left = parseInt(img.style.left) + 100 +'px';
}
function moveLeft(){
    img.style.left = parseInt(img.style.left) - 100 +'px';
}

window.onload = init();