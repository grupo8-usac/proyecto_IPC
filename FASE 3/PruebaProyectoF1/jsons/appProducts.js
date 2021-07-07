const inputJson = document.getElementById('inputJson')
const divtodoslosProductos = document.getElementById('divtodoslosProductos')

function leerJSON(){
const fileReader = new FileReader();

function miOnLoad(){
    const json =  JSON.parse(fileReader.result)
    crearLista(json)
    }

fileReader.readAsText(inputJson.files[0])
fileReader.onload = miOnLoad;

}

function crearLista(productos){
    let html = ''
    for (const producto of productos){
        html += crearProducto(producto)
        }

        divtodoslosProductos.innerHTML = html;
    
    }

    function crearProducto(producto){
        let  html = `
        <div class="card mt-4" style="width: 18rem;">
        <div style='text-align:center'><h5 class="card-title" >${producto.name}</h5> </div>
  <img src="https://png.pngtree.com/png-vector/20190618/ourlarge/pngtree-baghandbagshoppingbuy-abstract-circle-background-flat-colo-png-image_1487746.jpg" alt="...">
  <div class="card-body">
    <p class="card-text">Descripción: ${producto.description}</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Costo: ${producto.cost}</li>
    <li class="list-group-item">Precio: ${producto.price}</li>
    <li class="list-group-item">Ingredientes: 3 </li>

  </ul>
  <div class="card-body">
  <div style='text-align:center'><a href="file:///C:/Users/EPA/Desktop/Reportes/Reporte%20Individual%20Productos.html" class="card-link">Vista individual de Productos</a></div>

  </div>
</div>

          `
          return html
    }
inputJson.addEventListener('change',leerJSON)
