/**
 * Created by capitanjovi on 26/12/16.
 */
function validacion() {
    var isbn = document.getElementById("isbn");
    var miFormulario = document.getElementById("miformulario");
    if (isbn.value == "") {
        alert("Debe ingresar al menos el ISBN");
        return false;
    } else {
        miFormulario.submit();
    }
}
