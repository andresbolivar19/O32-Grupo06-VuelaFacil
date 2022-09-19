const instancia = axios.create(
    {
        baseURL: "http://localhost:8080/api",
        Headers: {
            "Content-Type": "application/json"
        }
    }
);

async function listaragencias() {

    const respuesta = await instancia.get('/agencias');
    let i = 0;
    respuesta.data.forEach(function (agencias) {
        console.log(agencias);
        var table = document.getElementById("tablaprueba");
        var row = table.insertRow(i);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        i++;
        cell1.innerHTML = agencias.nombreAgencia;
        cell2.innerHTML = agencias.direccionAgencia;
        cell3.innerHTML = "<a href='/editaragencia.html?id=" + agencias.idAgencia + "' class='btn btn-info btn-circle'><i class='fas fa-info-circle'></i></a><a onclick='borraragencia(" + agencias.idAgencia + ")' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a>"
    });
}

async function buscaragencias() {

    let nombreAgencia = document.getElementById("nombreAgencia");
    let direccionAgencia = document.getElementById("direccionAgencia");

    const queryString = window.location.search;
    console.log(queryString);
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    console.log(id);

    const respuesta = await instancia.get(`/agencias/${id}`);
    nombreAgencia.value = respuesta.data.nombreAgencia;
    direccionAgencia.value = respuesta.data.direccionAgencia;
}


async function guardaragencia() {
    let nombreagencia = document.getElementById("nombreagencia");
    let direccionagencia = document.getElementById("direccionagencia");
    let resultado = document.getElementById("resultado");

    try {
        const respuesta = await instancia.post("/agencias", {
            nombreAgencia:nombreagencia.value,
            direccionAgencia:direccionagencia.value
        });

        if (respuesta.status == 201) {
            nombreagencia.value = "";
            direccionagencia.value = "";
            resultado.innerHTML = "La agencias se guardo con exito";
        } else {
            resultado.innerHTML = "La agencias NO SE GUARDO";
        }
    } catch (err) {
        console.log(err.response.data.error);
        resultado.innerHTML = err.response.data.error;
    }
}

async function editaragencia() {
    let nombreagencia= document.getElementById("nombreagencia");
    let direccionagencia = document.getElementById("direccionagencia");

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');

    try {
        const respuesta = await instancia.put(`/agencias/${id}`,{
            nombreAgencia:nombreagencia.value,
            direccionAgencia:direccionagencia.value
        });

        if (respuesta.status == 200) {

            resultado.innerHTML="El agencias se actualizo con exito";
            window.location.reload(true);
        }else{
            resultado.innerHTML = "El agencias NO SE actualizo";
        }
        }catch (err) {
            console.log(err.response.data.error);
            resultado.innerHTML=err.response.data.error;
        }
}

async function borraragencia(id) {
    const respuesta = await instancia.delete(`/agencias/${id}`);
    window.location.reload(true);
}