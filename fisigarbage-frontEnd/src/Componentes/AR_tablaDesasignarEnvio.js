import React from 'react'

class AR_tablaDesasignarEnvio extends React.Component {

    constructor (props) {
        super(props);
    }

    render () {
        return(
            <thead>
                <tr>
                    <th className="th">Nro</th>
                    <th className="th">Nombre Apellido</th>
                    <th className="th">Concepto</th>
                    <th className="th">Recibo</th>
                    <th className="th">Moneda</th>
                    <th className="th">Importe</th>
                    <th className="th">Fecha</th>
                    
                </tr>
            </thead>
        )
    }

}
export default AR_tablaDesasignarEnvio