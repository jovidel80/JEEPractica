/**
 * Created by capitanjovi on 26/12/16.
 */
function validacion() {
    var isbn = document.getElementById("isbn");
    var titulo = document.getElementById("titulo");
    var categoria = document.getElementById("categoria");
    
    var miFormulario = document.getElementById("miformulario");
    
    if (isbn.value == "") {
        alert("Debe ingresar el ISBN");
        return false;
    } else if (titulo.value == "") {
        alert("Debe ingresar el Título");
        return false;
    } else if (categoria.value == "") {
        alert("Debe ingresar la Categoría");
        return false;
    } else {
        miFormulario.submit();
    }
        
}
