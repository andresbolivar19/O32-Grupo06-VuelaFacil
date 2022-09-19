const instancia = axios.create(
    {
        baseURL: "http://localhost:8080/api",
        Headers: {
            "Content-Type": "application/json"
        }
    }
);

async function listaragencias() {

    const respuesta = await instancia.get("/agencias");

    let i = 0;
    respuesta.data.forEach(function (agencias) {
        console.log(agencias);
        var table = document.getElementById("tablaprueba");
        var row = table.insertRow(i);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        i++;
        cell1.innerHTML = agencias.nombreAgencias;
        cell2.innerHTML = agencias.direccionAgencia;
        cell5.innerHTML = '<a class="button" href="/editaragencias.html?id=' + agencias.idAgencias + '">Editar</a>  | <a class="button" href="/editaragencias.html?id=' + agencias.idAgencias + '">Borrar</a> ';
    });

}

async function buscaragencias() {

    let nombreagencias = document.getElementById("nombreagencias");
    let direccionagencia = document.getElementById("direccionagencia");

    const queryString = window.location.search;
    console.log(queryString);
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');
    console.log(id);

    const respuesta = await instancia.get(`/agencias/${id}`);
    nombreagencias.value = respuesta.data.nombreAgencias;
    direccionagencia.value = respuesta.data.direccionagencia;
}


async function guardaragencias() {
    let nombreagencias = document.getElementById("nombreagencias");
    let direccionagencia = document.getElementById("direccionagencia");
    try {
        const respuesta = await instancia.post("/agencias", {
            nombreAgencias: nombreagencias.value,
            direccionagencia: direccionagencia.value
        });

        if (respuesta.status == 201) {
            nombreagencias.value = "";
            direccionagencia.value = "";
            preciocompra.value = "";
            precioventa.value = "";
            resultado.innerHTML = "La agencias se guardo con exito";
        } else {
            resultado.innerHTML = "La agencias NO SE GUARDO";
        }
    } catch (err) {
        console.log(err.response.data.error);
        resultado.innerHTML = err.response.data.error;
    }
}

async function editaragencias() {
    let nombreagencias = document.getElementById("nombreagencias");
    let direccionagencia = document.getElementById("direccionagencia");

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');

    try {
        const respuesta = await instancia.put(`/agencias/${id}`, {
            nombreAgencias: nombreagencias.value,
            direccionagencia: direccionagencia.value
        });

        if (respuesta.status == 200) {

            resultado.innerHTML = "El agencias se actualizo con exito";
            window.location.reload(true);
        } else {
            resultado.innerHTML = "El agencias NO SE actualizo";
        }
    } catch (err) {
        console.log(err.response.data.error);
        resultado.innerHTML = err.response.data.error;
    }
}
