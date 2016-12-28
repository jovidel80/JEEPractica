/**
 * Created by capitanjovi on 26/12/16.
 */
function validacion() {
    if (document.forms[0].isbn.value == "") {
        alert("Debe ingresar al menos el ISBN");   
    } else {
        document.forms[0].submit();
    }
}
