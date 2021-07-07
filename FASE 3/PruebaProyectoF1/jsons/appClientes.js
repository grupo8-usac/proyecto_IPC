const inputJson = document.getElementById('inputJson')
localStorage.setItem('jsonCont',document.getElementById('inputJson'))

const divtodoslosclientes = document.getElementById('todoslosclientes')
localStorage.setItem('clientesCont',document.getElementById('todoslosclientes'))

function leerJSON(){
const fileReader = new FileReader();


function miOnLoad(){
    const json =  JSON.parse(fileReader.result)
    crearLista(json)
    }

fileReader.readAsText(inputJson.files[0])
fileReader.onload = miOnLoad;

}

function crearLista(clientes){
    let html = ''
    for (const cliente of clientes){
        html += crearCliente(cliente)

        }

        divtodoslosclientes.innerHTML = html;
    
    }

    function crearCliente(cliente){
        let  html = `
        <div class="card mt-4" style="width: 18rem;">
        <h5 class="card-title">  ID# ${cliente.id}</h5>
  <img src="https://image.freepik.com/vector-gratis/ilustracion-icono-calificacion-cliente_138676-400.jpg" alt="...">
  <div class="card-body">
  <div style='text-align:center'><h5 class="card-title">${cliente.name}</h5></div>
    <p class="card-text"></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Dirección: ${cliente.address}</li>
    <li class="list-group-item">Telefono: ${cliente.phone}</li>
    <li class="list-group-item">Nit: ${cliente.nit}</li>
  </ul>
  <div class="card-body">
  
  <button value=${divtodoslosclientes} onclick="verCliente(this)" type="button" class="btn btn-outline-danger">Ver cliente</button>
  </div>
</div>
          `
          return html
    }
inputJson.addEventListener('change',leerJSON)

sessionStorage.setItem("idac",cliente.id)
sessionStorage.setItem("nameac",cliente.name)
sessionStorage.setItem("addressac",cliente.address)
sessionStorage.setItem("phoneac",cliente.phone)
sessionStorage.setItem("nitac",cliente.nit)

function verCliente(boton){
  var id = document.getElementById("idac")
  var name = document.getElementById("nameac")
  var address = document.getElementById("addressac")
  var phone = document.getElementById("phoneac")
  var nit = document.getElementById("nitac")

  var cont = name + "," + address +","+phone+ ","+nit

  window.open("Reporte Individual Cliente.html", "Reporte Individual Cliente")
  
}


 