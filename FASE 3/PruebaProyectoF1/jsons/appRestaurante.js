const inputJson = document.getElementById('inputJson')


const divrestauranteinfo = document.getElementById('restauranteinfo')


function leerJSON(){
const fileReader = new FileReader();


function miOnLoad(){
    const json =  JSON.parse(fileReader.result)
    crearLista(json)
    }

fileReader.readAsText(inputJson.files[0])
fileReader.onload = miOnLoad;

}

function crearLista(restaurantes){
    let html = ''
    for (const restaurante of restaurantes){
        html += crearRes(restaurante)

        }

        divrestauranteinfo.innerHTML = html;
    
    }

    function crearRes(restaurante){
        let  html = `
        <div class="card mt-3" style="width: 18rem;">
  <img src="https://cdnb.artstation.com/p/assets/images/images/011/676/781/original/pixel-jeff-cafe.gif?1530807813" alt="...">
  <div class="card-body">
  <div style='text-align:center'><h5 class="card-title">${restaurante.name}</h5></div>
    <p class="card-text"></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Dirección: ${restaurante.address}</li>
    <li class="list-group-item">Telefono: ${restaurante.phone}</li>
    <li class="list-group-item">Load: ${restaurante.load}</li>
  </ul>
  <div class="card-body">
  </div>
</div>
          `
          return html
    }
inputJson.addEventListener('change',leerJSON)



 