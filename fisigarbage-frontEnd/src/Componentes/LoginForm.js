import React from 'react';
import {browserHistory} from 'react-router-3';
import swal from 'sweetalert';
import CONFIG from '../Configuracion/Config';
import { FormControl, Label, Input,  Table, Row, Form, Col, Modal, ModalHeader, ModalBody, ModalFooter, FormGroup, input, label, Button, Container } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.css';
import AddEditForm from '../Configuracion/Form/AddEditForm';
import ReactDOM from 'react-dom';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import { DropdownButton } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { ButtonGroup } from 'react-bootstrap';
import { Combobox } from 'react-widgets';
import "bootstrap/dist/css/bootstrap.min.css";


//LOGIN DE CODIGO

class LoginForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      nombres : '',
      modal:false
    };

    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
    this.VistaNueva = this.VistaNueva.bind(this);
  
  }


  onSubmit=(e)=>{    
    // console.log(this.state.nombres);   
    var nombreValidado = this.ValidarNombre(this.state.nombres);
    var nombres = this.state.nombres.toUpperCase();
    if(nombreValidado){
    var separador = " "; // un espacio en blanco
    var arregloDeSubCadenas = nombres.split(separador);    
    var arreglo = [];
    for (let i = 0; i< arregloDeSubCadenas.length; i++) {
      if(arregloDeSubCadenas[i]!==''){
         arreglo.push(arregloDeSubCadenas[i])
      }
    }    
    var nombrenuevo = arreglo.join(" & ");
        fetch(CONFIG+'recaudaciones/alumno/concepto/listar_cod/' + nombrenuevo)
            .then((response) => {
            return response.json()
            })
            .then((pagos) => {
             if(pagos.length>0){
                
              swal("Consulta realizada exitosamente!" ,"", "success").then(
                 browserHistory.push('/'+this.state.nombres.toUpperCase()))                 
              }
              else{
                swal("No se encontraron pagos con el nombre ingresado", "", "info");
              }

            })
            .catch(error => {

                swal("Oops, Algo salió mal!", "","error")
                console.error(error)
            });
    }
    e.preventDefault();
    
  }
  VistaNueva=(e)=>{
    
    browserHistory.push('/vista/nueva');
    // console.log("Vista nueva");
    e.preventDefault();
    
  }

  AsignacionPresupuesto=(e)=>{

    browserHistory.push('/vista/presupuesto');
    // console.log("Vista presupuesto");
    e.preventDefault();
  }

  AsignacionRecibo=(e)=>{

    browserHistory.push('/vista/recibomasivo');
    e.preventDefault();
  }



  NuevoLogin=(e)=>{
    
    browserHistory.push('/vista/loginNyA');
    // console.log("Vista nueva");
    e.preventDefault();
    
  }
  vistaPresupuesto = (e) =>{
    browserHistory.push('/vista/presupuestoRegistro');
    e.preventDefault();
  }
  VistaNueva2=(e)=>{
    
    browserHistory.push('/vista/nueva2');
    // console.log("Vista nueva 2");
    e.preventDefault();
    
  }
  VistaTablaCreada=(e)=>{
    
    browserHistory.push('/vista/Tabla');
    // console.log("Vista nueva 2");
    e.preventDefault();
    
  }
  ValidarNombre(nombres){
    if(!nombres){
      alert("Ingrese un nombre");
      return false;
    }else{
      return true;
    }
  }

  Regresar=(e)=>{
      
    browserHistory.push('/vista/loginFormAdmi'); //se añadio la ruta
    e.preventDefault();
    
  }

  RegresarAdmin=(e)=>{
    
    browserHistory.push('/'); //se añadio la ruta
    e.preventDefault();
    
  }
  onChange(e) {
    this.setState({nombres: e.target.value});
  }

  AsignacionMasiva = () => {
    this.setState(prevState => ({
      modal: !prevState.modal
    }))
  }

  


  render() {
    const options1 = [
      'Mayo', 'Junio', 'Julio', 'Agosto'
    ]
      const options2 = [
      '01_SEMANA_30ABRIL_09MAYO', 
      '02_SEMANA_10MAYO_16MAYO', 
      '03_SEMANA_17MAYO_23MAYO',
      '04_SEMANA_24MAYO_30MAYO',
      '01_SEMANA_31MAYO_06JUNIO',
      '02_SEMANA_07JUNIO_13JUNIO',
      '03_SEMANA_14JUNIO_20JUNIO',
      '04_SEMANA_21JUNIO_27JUNIO',
      '01_SEMANA_28JUNIO_04JULIO',
      '02_SEMANA_05JULIO_11JULIO',
      '03_SEMANA_12JULIO_18JULIO',
      '04_SEMANA_19JULIO_25JULIO',
      '01_SEMANA_26JULIO_01AGOSTO',
      '02_SEMANA_02AGOSTO_08AGOSTO',
      '03_SEMANA_09AGOSTO_15AGOSTO',
      '04_SEMANA_16AGOSTO_22AGOSTO',
    ]
      const options3 = [
      '2020'
    ]
    
    const defaultOption1 = options1[0];
    const defaultOption2 = options2[0];
    const defaultOption3 = options3[0];
    return (
      <div className="">
      <h3>Módulo consulta de pagos

         <ul id="nav-mobile" className="right  hide-on-med-and-down">
              {/*<li ><a className="seleccionar" href="https://siga-fisi.herokuapp.com/dashboard" >Vista Principal<i className="material-icons right">launch</i></a></li>*/}
          </ul>
      </h3>
      <nav>
    <div className="nav-wrapper azul">
      <ul id="nav-mobile" className="right hide-on-med-and-down">
		    <li><a onClick={this.vistaPresupuesto} >  <i className="small material-icons right">attach_money</i>Registro Costo Programas</a></li>															 
        <li><a onClick={this.VistaNueva2}><i className="small material-icons right">check_box</i>Asignar Programa</a></li>
        <li><a onClick={this.AsignacionPresupuesto}><i className="small material-icons right">check_box</i>Presupuesto Masivo</a></li>
       
        <li><a onClick={this.AsignacionRecibo}><i className="small material-icons right">check_box</i>Fecha Envio-Masivo</a></li>

		    <li ><a className="seleccionar" onClick={this.RegresarAdmin} >Salir<i className="material-icons right">reply</i></a></li>																													  
      </ul>
    </div>
  </nav>


        <Modal isOpen={this.state.modal} toggle={this.AsignacionMasiva} size="lg">
            <ModalHeader toggle={this.AsignacionMasiva}>Asignacion Fecha Envio (BCP-DEGP)</ModalHeader>
                <ModalBody>
                  <table  className="table-sm">
                    <tbody>
                        <th><div className="col-sm-12"><h6 >Numeros de recibo:</h6></div> </th> 
                        <th><div className="col-sm-12"><h6 ></h6></div> </th>                                       
                        <th><div className="col-sm-12"><h6 >Precisar fecha de envio</h6></div> </th> 
                    </tbody>
                  </table>
                 
                   <Table >
                      <thead>
                            <th > 
                              <div className="row sombra3">
                                  <div className="col-md-12">
                                    <textarea class="form-control "  rows="3" placeholder="Ingrese recibos..."></textarea>
                                  </div>
                              </div>
                            </th>
                            <th>
                              <Button color="primary">Buscar</Button>{' '}
                             {/*  <button className="waves-effect btn-primary btn-large center" type="submit" onClick={this.onClick}>
                                Buscar <i className="small material-icons left">search</i>
                              </button>
                              */}
                            </th>
                            <th>
                                <Table>
                                    <thead>
                                      <tr>
                                        <th>
                                          <td className="td"><Dropdown options = {options1} onChange = {this._onSelect} value = {defaultOption1} /></td>
                                          <td className="td"><Dropdown options = {options3} onChange = {this._onSelect} value = {defaultOption3} /></td>
                                        </th>
                                      </tr>
                                    </thead>
                                </Table>
                            </th>
                       
                      </thead>
                      </Table>
                  <div className="table-responsive">
                    <table className="table table-bordered table-hover">
                        <thead className="table-info">
                          <tr>
                            <th>Check</th>
                            <th>Numero</th>
                            <th>Fecha</th>
                            <th>Cuenta bancaria</th>
                            <th>Importe</th>
                            <th>Envio</th>

                          </tr>
                        </thead>

                        <tbody>
                          <tr>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                          </tr>
                          <tr>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                          </tr>
                          <tr>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                          </tr>
                          <tr>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                          </tr>
                          <tr>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                            <td> </td>
                          </tr>
                        </tbody>
                    </table>
                  </div>
                          
                   
                         
                                        
                                   
                </ModalBody>
                    <ModalFooter>
                        <div className="col col-lg-4">
                          <button className="waves-effect btn-success btn-large center" type="submit" onClick={this.onSubmitGuardar}>
                                Asignar <i className="large material-icons left">save</i>
                          </button>
                        </div>
                    </ModalFooter>
          </Modal>

          

      <div className="vista">
      <div className="grupo">
      <h4 className="center h4"><b>Consulte</b></h4>
      <form>
          <div className="center datos">
            <div>
            <i className="material-icons">person</i>
            </div>
            <b>CODIGO:</b>
            <div className="center">
            <input type="text"  value={this.state.nombres} onChange={this.onChange} />
            </div>
            
           <button type="submit" onClick={this.onSubmit} className="waves-effect waves-light btn-small ">CONSULTAR</button>
          </div>
    
      </form>
      <br/>
      
      <u className="colorI">
      <a  onClick={this.NuevoLogin} href="" className="row center-xs centrar colorI">
      Ingresa por tus nombres</a>
      </u>
      </div>
      
      </div>
      <footer>
            <div className="row center-xs centrar color">
            Proyecto SIGAP © 2019 v.1.3
            </div>
            </footer>
      </div>
    );
  }
}

export default LoginForm;