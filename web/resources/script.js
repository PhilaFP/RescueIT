var it = 0;
var clicked = 0;
function myFun1(){
    it++;
    switch(it) {
        case 1:
            document.getElementById("AlertInfo").innerText = "Nacisnij jeszcze 2 razy";
            document.getElementById("buttonAlert").style.backgroundImage = "url('/resources/help2.png')";
            break;
        case 2:
            document.getElementById("AlertInfo").innerText = "Nacisnij jeszcze 1 raz";
            document.getElementById("buttonAlert").style.backgroundImage = "url('/resources/help3.png')";
            break;
        case 3:
            document.getElementById("buttonAlert").style.opacity = "0.4";
            document.getElementById("buttonAlert").style.backgroundImage = "url('/resources/help4.png')";
            document.getElementById("AlertInfo").innerText = "Twoje zgłoszenie \n zostało wysłane.\nCzekaj na pomoc!";

            var aWhile = 1500; // 3 seconds

            var doSomethingAfterAWhile = function() {
                document.getElementById("sectionMainContent").style.display="none";
                document.getElementById("sectionMainContent2").style.display="block";
            }
            setTimeout( doSomethingAfterAWhile, aWhile );

            break;
        default:
            document.getElementById("AlertInfo").innerText = "Wysłałeś już zgłoszenie! \nPomoc jest w drodze";
            break;

    }

    if(it < 3){

    }
    else if(it == 3) {

    }
    else if(it > 3){

    }
}
function myFun2() {
    if(document.getElementById("characterAccidentOther").checked == true) {
        document.getElementById("inputCharacterAccidentOther").disabled = false;
    }
    else{
        document.getElementById("inputCharacterAccidentOther").disabled = true;
    }
}
function myFun3() {

    if(clicked == 0){
       document.getElementById("navMain").style.left = 0;
        clicked++;
    }
    else{
        document.getElementById("navMain").style.left = '-60%';
        clicked=0;
    }

}