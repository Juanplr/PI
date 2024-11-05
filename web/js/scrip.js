const URL_WS = 'http://localhost:8084/API/api/pagos/obtenerPagos';

async function obtenerInformacionPagos() {
    const listaPagos = document.getElementById('lista-pagos');
    listaPagos.innerHTML = '<p>Caragndo informacion de pagos...</p>';


    try {
        const respuesta = await fetch(URL_WS, {
            method: 'GET',
        })
        if (respuesta.ok) {
            const pagos = await respuesta.json();
            console.log(pagos);
        } else {
            throw new Error(`Error en la petición ${respuesta.status}`)
        }
    } catch (error) {
        console.error(error);
        listaPagos.innerHTML = '<p>Hubo un error al concultar la información</p>';
    }
}