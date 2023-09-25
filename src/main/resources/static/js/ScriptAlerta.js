var deleteButtons = document.getElementsByClassName('delete-button');
const launcAlert=document.getElementById("alerta");
const closeButton=document.getElementById("zerrar");


// Recorrer los elementos y agregar el evento de clic a cada uno
for (var i = 0; i < deleteButtons.length; i++) {
  deleteButtons[i].addEventListener('click', function(e) {
    e.preventDefault(); // Prevenir el comportamiento predeterminado del enlace
    var id = this.getAttribute('data-id'); // Obtener la ID almacenada en data-id

    // Mostrar una alerta con la ID correspondiente
    launcAlert.classList.add("noSee")
    console.log(id);
    var lil=document.getElementById("input-id");
    lil.value = id;
  });
}
closeButton.addEventListener('click', function(){
    launcAlert.classList.remove("noSee");
})

var editButtons = document.querySelectorAll('.edit-buttons.update-button');
// Iterar sobre cada botón obtenido
editButtons.forEach(function(button) {
  button.addEventListener('click', function(event) {
      // Prevenir el comportamiento predeterminado del evento (en este caso, la acción de navegación de los enlaces)
    event.preventDefault();
     // Obtener el atributo "data-id" del botón, que contiene el ID del empleado correspondiente
    var empleadoId = this.getAttribute('data-id');
    // Construir el ID del modal único concatenando el ID del empleado con la cadena "modal-editar"
    var modalId = "modal-editar" + empleadoId;
    console.log(modalId)
     // Mostrar el modal seleccionándolo por su ID y agregando la clase CSS "aparecer"
    var modalc = document.getElementById(modalId);
    modalc.classList.add("ver") 
      // Obtener el botón de cierre dentro del modal
      var closeButton = modalc.querySelector('.botoncito');
       // Agregar evento de clic al botón de cierre para llamar a la función cerrarModal
      closeButton.addEventListener('click', function() {
        cerrarModal(modalId, modalc)// Pasar el ID del modal y el elemento modal como parámetros
    });
    });
});
// Función para cerrar el modal
function cerrarModal(modalId, modalc) {
  modalc.classList.remove('ver')// Quitar la clase "aparecer" para ocultar el modal
}