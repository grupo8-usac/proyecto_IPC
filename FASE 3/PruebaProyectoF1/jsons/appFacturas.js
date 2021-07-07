const inputJson = document.getElementById('inputJson')
const divtodaslasFacturas = document.getElementById('divtodaslasFacturas')

function leerJSON(){
const fileReader = new FileReader();

function miOnLoad(){
    const json =  JSON.parse(fileReader.result)
    crearLista(json)
    }

fileReader.readAsText(inputJson.files[0])
fileReader.onload = miOnLoad;

}

function crearLista(facturas){
    let html = ''
    for (const factura of facturas){
        html += crearFactura(factura)
        }

        divtodaslasFacturas.innerHTML = html;
    
    }

    function crearFactura(factura){
        let  html = `
        <div class="card mt-4" style="width: 18rem;">
        <h5 class="card-title" >ID# ${factura.id}</h5>
  <img src="https://png.pngtree.com/png-vector/20190725/ourlarge/pngtree-invoice-icon-design-vector-png-image_1586820.jpg" alt="...">
  <div class="card-body">
    <p class="card-text"></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Cliente: ${factura.client}</li>
    <li class="list-group-item">Fecha:${factura.date}</li>
    <li class="list-group-item">Telefono:${factura.phone}</li>
    <li class="list-group-item">Productos:${factura.products}</li>

  </ul>
  <div class="card-body">
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>

          `
          return html
    }
inputJson.addEventListener('change',leerJSON)
