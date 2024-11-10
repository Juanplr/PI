const URL_WS = 'http://localhost:8084/API/api/';

async function obtenerInformacionPagos() {
    const listaPagos = document.getElementById('lista-pagos');
    listaPagos.innerHTML = '<p>Cargando informacion de pagos...</p>';


    try {
        const respuesta = await fetch(URL_WS + 'pagos/obtenerPagos', {
            method: 'GET',
        })
        if (respuesta.ok) {
            const pagos = await respuesta.json();
            console.log(pagos);
            mostrarInformacion(listaPagos, pagos)
        } else {
            throw new Error(`Error en la petición ${respuesta.status}`)
        }
    } catch (error) {
        console.error(error);
        listaPagos.innerHTML = '<p>Hubo un error al consultar la información</p>';
    }
}
async function obtenerClientePorCorreo(correo) {
    try {
        const idClienteResponse = await fetch(URL_WS + `cliente/obtenerClientesPorCorreo/${correo}`, {
            method: 'GET',
        });

        if (idClienteResponse.ok) {
            const idClienteData = await idClienteResponse.json();
            console.log(idClienteData);
            return idClienteData.clientes[0].idCliente;
        } else {
            throw new Error(`Error en la petición ${idClienteResponse.status}`);
        }
    } catch (error) {
        console.error(error);
        const listaPagos = document.getElementById('lista-pagos');
        listaPagos.innerHTML = '<p>Hubo un error al consultar la información</p>';
        return null;
    }
}

async function obtenerPagosCliente() {
    const listaPagos = document.getElementById('lista-pagos');
    const correo = document.getElementById('correo-cliente');
    listaPagos.innerHTML = '<p>Cargando información de pagos...</p>';

    try {
        const id = await obtenerClientePorCorreo(correo.value);

        if (id && id > 0) {
            console.log(id);
            try {
                const respuesta = await fetch(URL_WS + `pagos/obtenerPagos-cliente/${id}`, {
                    method: 'GET',
                });
                if (respuesta.ok) {
                    const pagos = await respuesta.json();
                    console.log(pagos);
                    mostrarInformacion(listaPagos, pagos);
                } else {
                    throw new Error(`Error en la petición ${respuesta.status}`);
                }
            } catch (error) {
                console.error(error);
                listaPagos.innerHTML = '<p>Hubo un error al consultar la información</p>';
            }
        } else {
            listaPagos.innerHTML = '<p>Hubo un error, el correo no fue encontrado</p>';
        }
    } catch (error) {
        console.error(error);
        listaPagos.innerHTML = '<p>Hubo un error al consultar la información</p>';
    }
}



function mostrarInformacion(listaPagos, pagos) {
    listaPagos.innerHTML = '';
    pagos.forEach(pago => {
        const pagoElemento = document.createElement('div'); // Cambiado a 'div' sin <>
        pagoElemento.className = 'lista-elemento';
        pagoElemento.innerHTML = `
            <strong>Cliente: </strong> ${pago.cliente} <br>
            <strong>Descuento: </strong> ${pago.descuento} <br>
            <strong>Fecha de pago: </strong> ${pago.fechaPago} <br>
            <strong>Tipo de pago: </strong> ${pago.tipoPago} <br>
        `;
        listaPagos.appendChild(pagoElemento);
    });
}