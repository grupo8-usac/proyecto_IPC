const inputJson = document.getElementById('inputJson')
const divtodoslosUsuarios = document.getElementById('divtodoslosUsuarios')

function leerJSON(){
const fileReader = new FileReader();

function miOnLoad(){
    const json =  JSON.parse(fileReader.result)
    crearLista(json)
    }

fileReader.readAsText(inputJson.files[0])
fileReader.onload = miOnLoad;

}

function crearLista(usuarios){
    let html = ''
    for (const usuario of usuarios){
        html += crearUsuario(usuario)
        }

        divtodoslosUsuarios.innerHTML = html;
    
    }

    function crearUsuario(usuario){
        let  html = `
        <div class="card mt-4" style="width: 18rem;">
        <br>
        <div style='text-align:center'><h4 class="card-title"> ${usuario.username}</h4></div>
        </br>
  <img src="https://image.flaticon.com/icons/png/512/147/147144.png" alt="...">
  <div class="card-body">
    <p class="card-text"></p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Usuario: ${usuario.username}</li>
    <li class="list-group-item">Contraseña: ${usuario.password}</li>
  </ul>
  <div class="card-body">
  <div style='text-align:center'><a href="file:///C:/Users/EPA/Desktop/Reportes/Reporte%20Individual%20Usuario.html" class="card-link">Vista individual de Usuario</a></div>
  </div>
</div>

          `
          return html
    }
inputJson.addEventListener('change',leerJSON)
