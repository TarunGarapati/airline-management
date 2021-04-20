/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    var dots=document.getElementsByClassName("dot");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);
}

function crctpic(k){
	var j;
	var x = document.getElementsByClassName("mySlides");
	 for (j = 0; j < x.length; j++) {
       x[j].style.display = "none";  
    }
	if(k>x.length){k=0}
		x[k-1].style.display = "block";
}

