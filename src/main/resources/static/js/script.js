/**
 * Created by Nobody on 5/11/2017.
 */

$("#versO").hide();
$("#DD").hide();
$("#TT").hide();
function change(obj) {
    if(obj.id=="virement")
        obj.checked?$("#versO").show(1000):$("#versO").hide(1000);
    else
    obj.checked?$("#versO").hide(1000):$("#versO").show(1000);
}

function change1(obj) {
    if(obj.id=="Courant"){
        $("#DD").show(1000);
        $("#TT").hide(800);
    }
    else
    {
        $("#DD").hide(800);
        $("#TT").show(1000);
    }

}
