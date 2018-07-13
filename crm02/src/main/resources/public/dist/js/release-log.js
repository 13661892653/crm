function extbkboxnar(){
    var narrowmen = document.getElementById("extbkboxnar");
    var narrowbox = document.getElementById("extbkboxb");
    if (narrowbox.style.display == "block"){
        narrowbox.style.display = "none";
        narrowmen.className = "extbkboxnarove";
    }
    else{
        narrowbox.style.display = "block";
        narrowmen.className = "extbkboxnar";
    }
}

function extbkboxove(str){
    document.getElementById("extbkbox").style.display = "none";
}