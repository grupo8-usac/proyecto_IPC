const inputJson = document.getElementById('inputJson')
const divtodoslosclientes = document.getElementById('todoslosclientes')

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

<div class="card mb-3" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
    
      <img src="https://image.freepik.com/vector-gratis/perfil-empresario-dibujos-animados_18591-58479.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
    <div class="card-body">
    <ul class="list-group list-group-flush">
    <div style='text-align:center'><h2 class="card-title">${sessionStorage.idac}</h2></div>
    <li class="list-group-item">Dirección: ${sessionStorage.addressac}</li>
    <li class="list-group-item">Telefono:  ${sessionStorage.phoneac}</li>
    <li class="list-group-item">Nit:  ${sessionStorage.nitac}</li>
  </ul>
      </div>
    </div>
  </div>
</div>

          `
          return html
    }
inputJson.addEventListener('change',leerJSON)
