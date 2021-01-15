
function display () {
    var month = parseInt(document.getElementById('month').value);
    var result;
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12: {
            result = 'Thang ' + month + ' co 31 ngay';
            break;
        }
        case 4:
        case 6:
        case 9:
        case 11: {
            result = 'Tháng ' + month + ' có 30 ngày';
            break;
        }
        case 2: {
            result = 'Tháng ' + month + ' có 28 hoặc 29 ngày';
            break;
        }
        default: {
            result = 'Error';
        }
    }
    document.getElementById('show').innerHTML = result;
}