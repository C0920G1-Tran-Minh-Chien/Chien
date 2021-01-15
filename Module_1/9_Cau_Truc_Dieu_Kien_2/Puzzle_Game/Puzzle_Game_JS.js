let imageA = document.getElementById("carA");
let imageB = document.getElementById("carB");
let imageC = document.getElementById("carC");
let imageD = document.getElementById("carD");
let imageE = document.getElementById("carE");
init(1);
init(2);
init(3);
    function init(i) {
        let randomA = Math.floor(Math.random() * 3 + 1);
        switch (i) {
            case 1:
                switch (randomA) {
                    case 1:
                        imageA.src = "../Images/Hinh1a.png"
                }
        }
    }
    function onchangeImage(num) {
        switch (num) {
            case 1:
                if (imageA.getAttribute("src") === "../Images/Hinh1a.png")
                    imageA.src = "../Images/Hinh2a.png"
                else if (imageA.getAttribute("src") === "../Images/Hinh2a.png") {
                    imageA.src = "../Images/Hinh3a.png"
                } else if (imageA.getAttribute("src") === "../Images/Hinh3a.png") {
                    imageA.src = "../Images/Hinh1a.png"
                }
                checkImage();
                break;
            case 2:
                if (imageB.getAttribute("src") === "Images/Hinh1b.png")
                    imageB.src = "Images/Hinh2b.png"
                else if (imageB.getAttribute("src") === "Images/Hinh2b.png") {
                    imageB.src = "Images/Hinh3b.png"
                } else if (imageB.getAttribute("src") === "Images/Hinh3b.png") {
                    imageB.src = "Images/Hinh1b.png"
                }
                checkImage();
                break;
            case 3:
                if (imageC.getAttribute("src") === "Images/Hinh1c.png")
                    imageC.src = "Images/Hinh2c.png"
                else if (imageC.getAttribute("src") === "Images/Hinh2c.png") {
                    imageC.src = "Images/Hinh3c.png"
                } else if (imageC.getAttribute("src") === "Images/Hinh3c.png") {
                    imageC.src = "Images/Hinh1c.png"
                }
                checkImage();
                break;
            default:
                break;
        }
    }
    function checkImage() {
        if (imageA.getAttribute("src") === "Images/Hinh1a.png" &&
            imageB.getAttribute("src") === "Images/Hinh1b.png" &&
            imageC.getAttribute("src") === "Images/Hinh1c.png"
        )
            alert('abc');
        }