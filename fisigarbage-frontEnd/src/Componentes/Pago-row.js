import React, { useState } from 'react'
import CONFIG from '../Configuracion/Config'
import swal from 'sweetalert';
import Select from 'react-select';

import { FormControl, Label, Input, Table, Modal, ModalHeader, ModalBody, ModalFooter, FormGroup, Button   } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.css';




import AddEditForm from '../Configuracion/Form/AddEditForm';
import ReactDOM from 'react-dom';
import Dropdown from 'react-dropdown';

import { DropdownButton } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { ButtonGroup } from 'react-bootstrap';
import { Combobox } from 'react-widgets';

const opciones = [
  { value: 'Búsqueda por mes', label: 'Búsqueda por mes' },
  { value: 'Búsqueda por año', label: 'Búsqueda por año' },
  { value: 'Pendiente de asignación', label: 'Pendiente de asignación' },
  { value: 'Transferencia', label: 'Transferencia' },
  { value: 'CuentasPorCobrar', label: 'Deudas' }, 
  { value: 'Deudas con mas informacion', label: 'Deudas con informacion personal' }
];









class PagoRow extends React.Component {

  state={
    abierto:false,
  }
  
  constructor(props) {
    super(props)
    this.state = {
      
      
      optionsAnio:[],
      objRecaudaciones: [],
      optionsTipoSemana:[],
      semanasBD:[],
      fechaBD:[],
      semanas:[],
      fecha:[],
      arregloAlumnos : [],
      arregloEnvioOriginal : [],
      opcionidEnvio: [],
      semanaSeleccionada : 0,
      desabilitar: true,
      desabilitar2: true,
      desabilitar3: true,
      desabilitar4: true,
      desabilitar5: true,
      desabilitar6: true,
      desablilitarTipoRecaudacion:true,
      selectedOption: null,
      selectedOption2: null,
      selectedOption3: null,
      selectedOption4: null,
      selectedOption5: null,
      selectedOption6: null,
      selectedOption7: null,
      semana_actual: null,

      selectedIdTipoRecaudacion:null,
      asignarRec: false,
      idconcepto: '',
      idmoneda: '',
      array: this.props.datos,
      idEnvio:'',
      moneda: '',
      cod_alum:'',
      numero:'',
      id_envio:'',
      estado: '',
      estados:0,
      isChecked: false,
      tipo_recaudacion:[],
      modal:false,
      modal2:false,
      alumno: null,
      mes:'',
      anio:'',
      tipo_mes:[{value:"01",label:"Enero"},{value:"02",label:"Febrero"},{value:"03",label:"Marzo"},
      {value:"04",label:"Abril"},{value:"05",label:"Mayo"},{value:"06",label:"Junio"},{value:"07",label:"Julio"},{value:"08",label:"Agosto"},
      {value:"09",label:"Septiembre"},{value:"10",label:"Octubre"},{value:"11",label:"Noviembre"},{value:"12",label:"Diciembre"}],
      mes_actual:{value:"-1",label:"Seleccione un Mes"},
      anio_actual:{value:"-1",label:"Seleccione un Año"},
      semana_actual:{value:"-1", label:"Seleccione Semana"},
      tipo_anio:[{value:"01", label:"2015"}, {value:"02", label:"2016"}, {value:"03", label:"2017"}, 
      {value:"04", label:"2018"}, {value:"05", label:"2019"}, {value:"06", label:"2020"}],


      detalleRecaudaciones: {
        apeNom: '',
        concepto: '',
        recibo: '',
        moneda: '',
        importe: '',
        fecha: '',
        estado: '',
        codAlum: '',//m
        idProg: '',//m
        siglaPrograma: '',//m
        observacion: '',
        fechaEnvio:'',
        numero:'',				
    },
     


    }
    this.onSubmitGuardar = this.onSubmitGuardar.bind(this);
    this.onSubmitAsignarFecha = this.onSubmitAsignarFecha.bind(this);
    this.onSubmitAsignar = this.onSubmitAsignar.bind(this);
    this.Validar = this.Validar.bind(this);
    this.buscarmes = this.buscarmes.bind(this);
    this.buscaranio = this.buscaranio.bind(this);
    this.onChangeMes = this.onChangeMes.bind(this);
    this.onChangeAnio = this.onChangeAnio.bind(this);
   
  }

 
  onSubmitGuardar = (e) => {  //JUAN

    console.log("---ALUMNO DEPUES DEL CLICK GUARDAR ---"); //VERIFICAR CON LA CONSOLA
    console.log(this.state.alumno);
    //ANTHONY	
    //alert(this.state.alumno.codAlumno);		
    //alert(this.state.alumno.nom_programa);
   {/* console.log("---ACTUALIZA CODIGO Y PROGRAMA EN RECAUDACIONES ---");
    console.log(this.state.objRecaudaciones[0].idRec);

   

    let state_apeNom = this.state.objRecaudaciones[0].apeNom;
    let state_concepto = this.state.objRecaudaciones[0].concepto;
    let state_recibo = this.state.objRecaudaciones[0].numero;
    let state_importe = this.state.objRecaudaciones[0].importe;
    let state_fecha = this.state.objRecaudaciones[0].fecha;
    let state_moneda = this.state.objRecaudaciones[0].moneda;
    let id_alum = this.state.objRecaudaciones[0].codAlum;
    let id_prog = this.state.objRecaudaciones[0].idProg;
    let siglaPrograma = '-'; //m-----IMPORTAAAA
    
    try {
        id_alum = this.state.alumno.codAlumno;
        id_prog = this.state.alumno.idPrograma;
        siglaPrograma = this.state.alumno.siglaProg; //AHORA CAMBIAR LA REST
    } catch (error) {
        console.log(error);
    }

    let objRecibo_estado = "true";
 */}
{/* 
    if (state_moneda == '108') {

        this.setState({
            detalleRecaudaciones: {
                apeNom: state_apeNom,
                concepto: state_concepto,
                recibo: state_recibo,
                moneda: 'SOL',
                importe: 'S/ ' + state_importe,
                fecha: state_fecha,
                estado: objRecibo_estado,
                codAlumno: id_alum,//m
                programa: id_prog,//m
                siglaPrograma: siglaPrograma,
            }
        });
    } else if (state_moneda == '113') {
        this.setState({
            detalleRecaudaciones: {
                apeNom: state_apeNom,
                concepto: state_concepto,
                recibo: state_recibo,
                moneda: 'DOL',
                importe: '$ ' + state_importe,
                fecha: state_fecha,
                estado: objRecibo_estado,
                codAlumno: id_alum,//m
                programa: id_prog,//m
                siglaPrograma: siglaPrograma,
            }
        });
    } else {
        this.setState({
            detalleRecaudaciones: {
                apeNom: state_apeNom,
                concepto: state_concepto,
                recibo: state_recibo,
                moneda: ' ',
                importe: state_importe,
                fecha: state_fecha,
                estado: objRecibo_estado,
                codAlumno: id_alum,//m
                programa: id_prog,
                siglaPrograma: siglaPrograma,
            }
        });
    }
*/}

    if (this.state.alumno != null) {
        fetch(CONFIG + 'recaudaciones/actualizar/' + this.state.objRecaudaciones[0].idRec + '/' + this.state.alumno.codAlumno + '/' + this.state.alumno.idPrograma, {
            headers: {
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                'idRec': this.state.objRecaudaciones[0].idRec,
                'codAlumno': this.state.alumno.codAlumno,
                'idPrograma': this.state.alumno.idPrograma
            })
        })
            .then((response) => {
                console.log(response);
                if (response) {
                    swal("guardado exitosamente!", "", "success");
                    this.setState({
                        estado: true,
                    });
                } else {
                    swal("Oops, Algo salió mal!!", "", "error");
                }
            })
            .catch((error) => {
                swal("Oops, Algo salió mal!!", "", "error");
                console.log(error);
            })
    } else {
        swal("Seleccione una opción", " ", "info");
    }
}



    componentWillMount(){
      let id= this.props.pago.id_tipo_recaudacion;
      let tiposRecaudacion=this.props.tipo_recaudacion;
      let tiposConvertidos=[];
      tiposRecaudacion.forEach(element => {
        
          let object = {
            label:element.desc_tipo_recaudacion,
            value:element.id_tipo_recaudacion
          }
          if(id==element.id_tipo_recaudacion){
            this.setState({
              selectedIdTipoRecaudacion:object
          })}

          tiposConvertidos.push(object);
      });

      this.setState({
        tipo_recaudacion:tiposConvertidos
      })

    }



  componentDidMount() {
    // if(this.props.pago.estado=="M"){
    //   this.setState({
    //     desabilitar:false
    //   })


    // }

    this.setState({
      selectedOption: { value: this.props.pago.concepto, label: this.props.pago.concepto },
      idconcepto: this.idconcepto(this.props.pago.concepto),
      selectedOption2: { value: this.props.pago.moneda2, label: this.props.pago.moneda2 },
      selectedOption3: { value: this.props.pago.descripcion_ubi, label: this.props.pago.descripcion_ubi },
      selectedOption4: { value: this.props.pago.descripcion_tipo, label: this.props.pago.descripcion_tipo },
      selectedOption6: { value: this.props.pago.repitencia, label: this.props.pago.repitencia=='S' ? 'SI' : 'NO'},
      selectedOption7: { value:'1', label:'2'},
      //semana_actual:{value: this.props.pago.descripcion_envio, label: this.props.pago.descripcion_envio},
      
      
      
      idmoneda: this.idmoneda(this.props.pago.moneda2),
      estado: this.setEstado(this.props.pago.estado),
      isChecked: this.props.pago.validado,
    });

    if (this.props.pago.moneda2 == 'DOL') {
      this.setState({
        moneda: '$. '
      })
    }
    else {
      this.setState({
        moneda: 'S/. '
      })
    }

  }

    idconcepto(valor) {

    let id_concepto = "";
    // console.log("valor:  "+valor);
    // console.log("tamaño " +this.state.array.length)  ;

    for (let i = 0; i < this.props.datos.length; i++) {
      if (valor.trim() == this.props.datos[i].concepto.trim()) {
        id_concepto = this.props.datos[i].idConcepto;
        //  console.log("el valor" +valor +"es igual a"+this.props.datos[i].concepto);
      }

    }
    // console.log("el concepto es : "+id_concepto);
    return id_concepto;
  }

  idmoneda(valor) {
    // console.log("MONEDAS");
    let id_moneda = "";
    // console.log("tamaño " +this.props.datosmonedas.length)  ;
    // console.log("moneda 1" +this.props.datosmonedas[1].moneda)  ;
    // console.log("valor_monedas:  "+valor);

    for (let i = 0; i < this.props.datosmonedas.length; i++) {

      if (valor == this.props.datosmonedas[i].moneda) {
        id_moneda = this.props.datosmonedas[i].id_moneda;
        //  console.log("el valor la moneda" +valor +"es igual a "+this.props.datosmonedas[i].id_moneda);
      }


    }
    // console.log("la moneda es  : "+id_moneda);
    return id_moneda;

  }

  setEstado(valor) {
    if (valor == null) {
      return 'REMITIDO'
    }
    else {
      return 'DIGITADO'
    }
  }

  componentWillUpdate() {
    //console.log("idconcepto : "+this.state.idconcepto);
  }

  handleChange = (selectedOption) => {

    if (selectedOption != null) {

      this.setState({
        selectedOption: selectedOption,
        idconcepto: this.idconcepto(selectedOption.value)
      });
      // console.log(`Option selected:`, selectedOption);
      // console.log("idconcepto : "+this.idconcepto(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }
  handleChange2 = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        selectedOption2: selectedOption,
        idmoneda: this.idmoneda(selectedOption.value)
      });

      if (selectedOption.value == 'DOL') {
        this.setState({
          moneda: '$. '
        })
      }
      else {
        this.setState({
          moneda: 'S/. '
        })

      }


      // console.log(`Option selected:`, selectedOption);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }

  handleChange3 = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        selectedOption3: selectedOption,
      });
       console.log(`Option selected:`, this.state.selectedOption3.value);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }

  handleChange7 = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        semana_actual: selectedOption,
      });
       console.log(`Option selected:`, this.state.semana_actual.value);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }

  handleChange4 = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        selectedOption4: selectedOption,
      });
      // console.log(`Option selected:`, selectedOption);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }

  handleChange6 = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        selectedOption6: selectedOption,
      });
      // console.log(`Option selected:`, selectedOption);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }

  handleChangeIdTipoRecaudacion = (selectedOption) => {
    if (selectedOption != null) {
      this.setState({
        selectedIdTipoRecaudacion: selectedOption,
      });
      // console.log(`Option selected:`, selectedOption);
      // console.log("idconcepto : "+this.idmoneda(selectedOption.value));
    } else {
      swal("Seleccione una opcion", "", "info");
    }
  }


  colocar = () => {
    var checkbox = document.getElementById(this.props.pago.idRec);
    console.log(checkbox.id);
    var checkboxID = checkbox.id;
    this.props.Funciones(checkboxID);
  }

  toggleChange = () => {
    this.setState({
      isChecked: !this.state.isChecked,
    });
  }

  editarFila = () => {

    var estadoAlumno;
    estadoAlumno = this.props.pago.estado;

    var digitado = "N";
    var remitido = "N";

    for(let x = 0; x<this.props.configuraciones.length;x++){
      if(this.props.configuraciones[x].idConfiguracion == 5){
        remitido = this.props.configuraciones[x].estado;
      }
      else if(this.props.configuraciones[x].idConfiguracion == 6){
        digitado = this.props.configuraciones[x].estado;
      }
    }

    console.log("Digitado:" + digitado)
    console.log("Remitido:" + remitido)


    if (estadoAlumno == "M" && digitado == "S") {
      
      this.setState({
        desabilitar: false
      })

      this.setState({
        desabilitar2: false
      })


      var editFecha;
      var fechaEdit = this.props.pago.fecha;
      var anioFecha = fechaEdit.substring(0, 4);
      console.log("AÑO");
      console.log(anioFecha);

      var mesFecha = fechaEdit.substring(5, 7);
      console.log("MES");
      console.log(mesFecha);
      var diaFecha = fechaEdit.substring(8, 10);
      console.log("DIA");
      console.log(diaFecha);

      var fechaVolteada = diaFecha + "-" + mesFecha + "-" + anioFecha;

      editFecha = this.props.pago.idRec.toString() + this.props.pago.idAlum.toString();
      document.getElementById(editFecha).value = fechaVolteada;
      document.getElementById(editFecha).disabled = false;
      document.getElementById(editFecha).style.background = '#F2F2F2';


      var editCiclo;
      var num = 250296;
      editCiclo = this.props.pago.idRec.toString() + num.toString();
      var _ciclo_ = this.props.pago.ciclo;

      document.getElementById(editCiclo).value = _ciclo_;
      document.getElementById(editCiclo).disabled = false;
      document.getElementById(editCiclo).style.background = '#F2F2F2';
      document.getElementById(editCiclo).focus();

      var editImporte;
      num = 250296;
      editImporte = this.props.pago.idRec.toString() + num.toString() + "importe";
      var _importe_ = this.props.pago.importe;

      document.getElementById(editImporte).value = _importe_;
      document.getElementById(editImporte).disabled = false;
      document.getElementById(editImporte).style.background = '#F2F2F2';
      document.getElementById(editImporte).focus();

      this.setState({
        desabilitar3: false
      })

      this.setState({
        desabilitar4: false
      })

      this.setState({
        desabilitar5: false
      })

      this.setState({
        desabilitar6: false
      })

      this.setState({
        desablilitarTipoRecaudacion: false
      })

      var numRecibo;
      numRecibo = this.props.pago.idRec.toString() + this.props.pago.numero;
      var numReciboEdit;
      numReciboEdit = this.props.pago.numero;
      document.getElementById(numRecibo).value = numReciboEdit;
      document.getElementById(numRecibo).disabled = false;
      document.getElementById(numRecibo).style.background = '#F2F2F2';
      console.log(estadoAlumno);
    }
    else{
      //no haga ni pincho
    }
    if(estadoAlumno != "M" && remitido == "S"){
      var editCiclo;
      var num = 250296;
      editCiclo = this.props.pago.idRec.toString() + num.toString();

      document.getElementById(editCiclo).disabled = false;
      document.getElementById(editCiclo).style.background = '#F2F2F2';
      document.getElementById(editCiclo).focus();

      this.setState({
        desabilitar2: false
      })

      var editFecha;
      var fechaEdit = this.props.pago.fecha;
      var anioFecha = fechaEdit.substring(0, 4);
      console.log("AÑO");
      console.log(anioFecha);

      var mesFecha = fechaEdit.substring(5, 7);
      console.log("MES");
      console.log(mesFecha);
      var diaFecha = fechaEdit.substring(8, 10);
      console.log("DIA");
      console.log(diaFecha);

      var fechaVolteada = diaFecha + "-" + mesFecha + "-" + anioFecha;

      editFecha = this.props.pago.idRec.toString() + this.props.pago.idAlum.toString();
      document.getElementById(editFecha).value = fechaVolteada;
      document.getElementById(editFecha).disabled = false;
      document.getElementById(editFecha).style.background = '#F2F2F2';

      this.setState({
        desabilitar3: false
      })

      this.setState({
        desabilitar4: false
      })

      this.setState({
        desabilitar5: false
      })
      this.setState({
        desabilitar6: false
      })

      this.setState({
        desablilitarTipoRecaudacion: false
      })
    }
    else{
      
    }
  }


  SeleccionNumeroRecibo = () => {

    var stringss;
    var prueba;
    stringss = this.props.pago.idRec.toString() + this.props.pago.numero;
    prueba = document.getElementById(stringss).value;

    if (prueba == "") {
      prueba = this.props.pago.numero;
    } else {

      return prueba;
    }

    return prueba;

  }

  SeleccionConcepto = () => {

    var stringss;
    var prueba;
    stringss = this.props.pago.idRec.toString() + this.props.pago.concepto;
    
    //prueba = document.getElementById(stringss).value;

    if (prueba == "") {
      prueba = this.props.pago.concepto;
    } else {

      return prueba;
    }

    return prueba;

  }

  SeleccionFecha = () => {

    var stringss;
    var prueba;
    stringss = this.props.pago.idRec.toString() + this.props.pago.idAlum.toString();
    prueba = document.getElementById(stringss).value.replace(/^(\d{2})[-\/](\d{2})[-\/](\d{4})$/g, '$3-$2-$1');

    console.log(prueba)
    if (prueba == "") {
      prueba = this.props.pago.fecha.replace(/^(\d{2})[-\/](\d{2})[-\/](\d{4})$/g, '$3-$2-$1');
    } else {

      return prueba;
    }

    return prueba;

  }


  SeleccionCiclo = () => {

    var num = 250296;
    var stringss;
    var prueba;
    stringss = this.props.pago.idRec.toString() + num.toString();
    prueba = document.getElementById(stringss).value;

    if (prueba == "") {
      prueba = 0;
    } else {

      return prueba;
    }

    return prueba;

  }

  SeleccionImporte = () => {

    var num = 250296;
    var stringss;
    var importe=0;
    stringss = this.props.pago.idRec.toString() + num.toString() + "importe";
    console.log("ss",stringss);
    importe = document.getElementById(stringss).value;
    console.log("El nuevo importe es ->",importe );

    if (importe == "") {
      importe = 0;
    } else {

      return importe;
    }

    return importe;

  }

  SeleccionUbicacion = () => {

    var num = 250296;
    var stringss;
    var ubicacion = this.state.selectedOption3.value;
    //stringss = this.props.pago.idRec.toString() + num.toString() + "ubicacion";
    /*var id = this.props.numero + 1;

    try{
      stringss = 'react-select-' + (4*id) + '--value-item'; 
      var ubicacion = document.getElementById(stringss).innerHTML;
    }
    catch(error){
      stringss = 'react-select-' + (4*(id+10)) + '--value-item'; 
      var ubicacion = document.getElementById(stringss).innerHTML;
    }


    if (ubicacion == "") {
      ubicacion = 0;
    } else {

      return ubicacion;
    }
    */
    return ubicacion;

  }

  
 


  SeleccionRepitencia = () => {

    var num = 250296;
    var stringss;
    var repitencia = this.state.selectedOption6.value;
    return repitencia;

  }

  SeleccionTipoRecaudacion = () => {

    var num = 250296;
    var tipoRecaudacion = (this.state.selectedIdTipoRecaudacion===null) ? 0 : this.state.selectedIdTipoRecaudacion.value;
    return tipoRecaudacion;
  }

  SeleccionCtaBanco = () => {

    var num = 250296;
    var stringss;
    var ctabanco = this.state.selectedOption4.value;;
    /*var id = this.props.numero + 1;
    try{
      stringss = 'react-select-' + (4*id+1) + '--value-item';
      var ctabanco = document.getElementById(stringss).innerHTML;
    }
    catch(error){
      stringss = 'react-select-' + (4*(id+10)+1) + '--value-item';
      var ctabanco = document.getElementById(stringss).innerHTML;
    }


    if (ctabanco == "") {
      ctabanco = 0;
    } else {

      return ctabanco;
    }*/

    return ctabanco;

  }

    
  editarObservacion = () => {   //CHECKA JUAN

    var obs = this.props.pago.observacion_upg;
    console.log("obs: " + obs)
    //var estadoAlumno = this.props.pago.estado;
    var idRecG = "";
    idRecG = this.SeleccionIdRec();

    swal({
      title: "Desea editar la observacion?",
      text: "Observacion: " + obs,
      icon: "warning",
      buttons: true,
      //dangerMode: true,
      closeOnClickOutside: false,
      closeOnEsc: false,
    })
      .then((willDelete) => {
        if (willDelete) {
          swal({
            closeOnClickOutside: false,
            closeOnEsc: false,

            content: {
              element: "input",
              attributes: {
                value: obs
              },
            },
          })
            .then((value) => {
              if (value != '') {
                fetch(CONFIG + 'recaudaciones/alumno/concepto/obs/' + value + '/' + idRecG)
                  .then((resp) => {
                    if (!(resp == true)) {
                      swal("Editado exitoso!", "", "success").then(function () { // te descubri abel fake :v
                        window.location.reload();
                      }
                      );
                    }
                    else {
                      swal("Oops, Algo salió mal!!", "", "error").then(function () { // te descubri abel fake :v
                        window.location.reload();
                      }
                      );
                    }

                  })
                  .catch(error => {
                    swal("Oops, Algo salió mal!!", "", "error")
                    console.error(error)
                  });
              }
              else {
                swal("No se hizo ningún cambio", "", "info");
              }
            });
        } else {

        }
      });
  }

  editarActualizacion = () => {   /*CHECKA JUAN*/

    var obs = this.props.pago.observacion_upg;
    console.log("obs: " + obs)
    //var estadoAlumno = this.props.pago.estado;
    var idRecG = "";
    idRecG = this.SeleccionIdRec();

    swal({
      title: "¿Desea editar el registro?",
      text: "Actualizacion: " + obs,
      icon: "warning",
      buttons: true,
      //dangerMode: true,
      closeOnClickOutside: false,
      closeOnEsc: false,
    })
      .then((willDelete) => {
        if (willDelete) {
          swal({
            closeOnClickOutside: false,
            closeOnEsc: false,

            content: {
             
              element: "input",
              attributes: {
                value: obs
              },
            },
            
          }
          )
            .then((value) => {
              if (value != '') {
                fetch(CONFIG + 'recaudaciones/alumno/concepto/obs/' + value + '/' + idRecG)
                  .then((resp) => {
                    if (!(resp == true)) {
                      swal("Editado exitoso!", "", "success").then(function () { // te descubri abel fake :v
                        window.location.reload();
                      }
                      );
                    }
                    else {
                      swal("Oops, Algo salió mal!!", "", "error").then(function () { // te descubri abel fake :v
                        window.location.reload();
                      }
                      );
                    }

                  })
                  .catch(error => {
                    swal("Oops, Algo salió mal!!", "", "error")
                    console.error(error)
                  });
              }
              else {
                swal("No se hizo ningún cambio", "", "info");
              }
            });
        } else {

        }
      });
  }

  showObservacion = () => {
    let obs = this.props.pago.observacion;
    if(obs === '' || obs === '0' ){
      swal("Ops! ", `Aun no tiene asignado ninguna observacion`, "warning")
    }else{
      swal("Observacion", `La observacion es : " ${obs} "`, "success")
    }
  }



  SeleccionIdRec = () => {

    var stringss;
   
    stringss = this.props.pago.idRec.toString();

    if (stringss == "") {
      stringss = "null";
    } else {

      return stringss;
    }

    return stringss;

  }

  SeleccionIdConceptoG = () => {

    var stringss;

    stringss = this.props.pago.idconcepto;

    if (stringss == null) {
      stringss = null;
    } else {

      return stringss;
    }

    return stringss;

  }

  
  sonSubmitAsignar = () => {
    var estadoAlumno;
    estadoAlumno = this.props.pago.estado;           

      var numero = "";
      numero = this.SeleccionNumeroRecibo();            

      console.log("lo que se envia es ->",JSON.stringify({
      
        "id_envio": numero,
      }))

      fetch(CONFIG + "recaudaciones/asignar",
        {
          headers: {
            'Content-Type': 'application/json'
          },
          method: "POST",
          body: JSON.stringify(
            {
              "id_envio": numero,
              
            }

          )
        })
        .then((response) => {
          return response.json()
        })
        .then((resp) => {
          console.log(resp);
          if (resp == true) {
            swal("Editado exitoso!", "", "success").then(function () {
              window.location.reload();
            }
            );
          } else {
            swal("Oops, el editado no se concreto", "", "info");
          }

        })
        .catch(error => {

          swal("Oops, Algo salió mal!!", "", "error")
          console.error(error)
        });        

  }





  GuardarFecth = () => {

    var estadoAlumno;
    estadoAlumno = this.props.pago.estado;

    if (estadoAlumno == "M") {
      var cicloG = "";
      cicloG = this.SeleccionCiclo();

      var conceptoG = "";
      conceptoG = this.SeleccionConcepto();

      var numeroReciboG = "";
      numeroReciboG = this.SeleccionNumeroRecibo();

      var fechaG = "";
      fechaG = this.SeleccionFecha();

      var idRecG = "";
      idRecG = this.SeleccionIdRec();

      var idConceptoG = "";
      idConceptoG = this.SeleccionIdConceptoG();

      var importe = "";
      importe = this.SeleccionImporte();

      var repitencia = "";
      repitencia = this.SeleccionRepitencia();

      var seleccionTipoRecaudacion = "";
      seleccionTipoRecaudacion = this.SeleccionTipoRecaudacion();
      

      var ubicacion = "";
      ubicacion = this.SeleccionUbicacion();

      var ctabanco = "";
      ctabanco = this.SeleccionCtaBanco();

      var validado = null;
      console.log("Validado: " + String(this.state.isChecked));
      validado = String(this.state.isChecked);

      console.log("lo que se envia es ->",JSON.stringify({
        "idRec": idRecG,
        "ciclo": cicloG,
        "concepto": conceptoG,
        "recibo": numeroReciboG,
        "fecha": fechaG,
        "id_concepto": this.state.idconcepto,
        "id_moneda": this.state.idmoneda,
        "importe": importe,
        "repitencia":repitencia, //linea que recien se agrega
        "ubicacion": ubicacion,
        "ctabanco": ctabanco,
        "validado": validado,
        "id_tipo_recaudacion":seleccionTipoRecaudacion
      }))

      fetch(CONFIG + "recaudaciones/alumno/concepto/actualizar",
        {
          headers: {
            'Content-Type': 'application/json'
          },
          method: "POST",
          body: JSON.stringify(
            {
              "idRec": idRecG,
              "ciclo": cicloG,
              "concepto": conceptoG,
              "recibo": numeroReciboG,
              "fecha": fechaG,
              "id_concepto": this.state.idconcepto,
              "id_moneda": this.state.idmoneda,
              "importe": importe,
              "repitencia":repitencia, //linea que recien se agrega
              "ubicacion": ubicacion,
              "ctabanco": ctabanco,
              "validado": validado,
              "id_tipo_recaudacion":seleccionTipoRecaudacion
            }

          )
        })
        .then((response) => {
          return response.json()
        })
        .then((resp) => {
          console.log(resp);
          if (resp == true) {
            swal("Editado exitoso!", "", "success").then(function () {
              window.location.reload();
            }
            );
          } else {
            swal("Oops, el editado no se concreto", "", "info");
          }

        })
        .catch(error => {

          swal("Oops, Algo salió mal!!", "", "error")
          console.error(error)
        });



    } else {

      var cicloG = "";
      cicloG = this.SeleccionCiclo();

      var conceptoG = "";
      conceptoG = this.SeleccionConcepto();

      var numeroReciboG = "";
      numeroReciboG = this.SeleccionNumeroRecibo();

      var fechaG = "";
      fechaG = this.SeleccionFecha();

      var idRecG = "";
      idRecG = this.SeleccionIdRec();

      var idConceptoG = "";
      idConceptoG = this.SeleccionIdConceptoG();

      var fechaG = "";
      fechaG = this.SeleccionFecha();
      console.log("FECHA BIEN FEIK");
      console.log(fechaG);

      var importe = "";
      importe = this.SeleccionImporte();

      var repitencia = "";
      repitencia = this.SeleccionRepitencia();

      var seleccionTipoRecaudacion = "";
      seleccionTipoRecaudacion = this.SeleccionTipoRecaudacion();

      var ubicacion = "";
      ubicacion = this.SeleccionUbicacion();

      var ctabanco = "";
      ctabanco = this.SeleccionCtaBanco();

      var validado = null;
      console.log("Validado: " + String(this.state.isChecked));
      validado = String(this.state.isChecked);

      fetch(CONFIG + "recaudaciones/alumno/concepto/actualizar",
        {
          headers: {
            'Content-Type': 'application/json'
          },
          method: "POST",
          body: JSON.stringify(
            {
              "idRec": idRecG,
              "ciclo": cicloG,
              "concepto": conceptoG,
              "recibo": numeroReciboG,
              "fecha": fechaG,
              "id_concepto": this.state.idconcepto,
              "id_moneda": this.state.idmoneda,
              "importe": importe,
              "repitencia":repitencia, //linea que recien se agrega
              "ubicacion": ubicacion,
              "ctabanco": ctabanco,
              "validado": validado,
              "id_tipo_recaudacion":seleccionTipoRecaudacion
            }

          )
        })
        .then((response) => {
          return response.json()
        })
        .then((resp) => {
          console.log(resp);
          if (resp == true) {
            swal("Editado exitoso!", "", "success").then(function () {
              window.location.reload();
            }
            );
          } else {
            swal("Oops, el editado no se concreto", "", "info");
          }

        })
        .catch(error => {

          swal("Oops, Algo salió mal!!", "", "error")
          console.error(error)
        });



      /*
          console.log("No tiene permiso para guargar")
          swal("No es posible realizar cambios", "", "info");*/



    }



  }

  /** state={
    abierto: false,
  }*/

  abrirModal=()=>{
    this.setState({abierto: !this.state.abierto});
  }

  toggle = () => {
    this.setState(prevState => ({
      modal: !prevState.modal
    }))
  }

  desasignar = () => {
    this.setState(prevState => ({
      modal2: !prevState.modal2
    }))
  }

  Validar(mes, año) {
    if (mes == '' && año == '' ) {
        swal("Llene uno de los campos para realizar la búsqueda", "", "info");
        return false;
    } else {
        return true;
    }
}

onChangeMes = (e) => {
  e.preventDefault();
  this.setState({
      mes: e.target.value
  });
}

onChangeAnio = (e) => {
  e.preventDefault();
  this.setState({
      anio: e.target.value
  });
}



  buscarmes = (mes) => {
   fetch(CONFIG + 'recaudaciones_envios/buscarm/' + mes)
      .then((response) => {
          return response.json();
      })
      .then((fecha) => {
          console.log("---Alumnos---");
          console.log(fecha);
          var Array = [];
          if (fecha.length > 0) {
              for (var i = 0; i < fecha.length; i++) {
                  var e = {
                      desc_semana: fecha[i].desc_semana,
                      nanio: fecha[i].nanio,
                      nmes: fecha[i].nmes,
                      idEnvio: fecha[i].idEnvio,
                      nsemana: fecha[i].nsemana
                  }
                  Array.push(e);
              }

              this.setState({
                  mostrarResultadoFecha: true,
              });
              swal("Consulta realizada exitosamente!", "", "success");
          } else {
              swal("No hay registro de esa fecha", " ", "info");
          }
          this.setState({
              opcFecha: Array,
              objFechas: fecha,
              asignarRec: false,
          });
      })
      .catch((error) => {
          swal("Algo salío mal", "", "error");
          console.log(error);
      });
}

buscaranio = (anio) => {
  fetch(CONFIG + 'recaudaciones_envios/buscara/' + anio)
     .then((response) => {
         return response.json();
     })
     .then((fecha) => {
         console.log("---Alumnos---");
         console.log(fecha);
         var Array = [];
         if (fecha.length > 0) {
             for (var i = 0; i < fecha.length; i++) {
                 var e = {
                     desc_semana: fecha[i].desc_semana,
                     nanio: fecha[i].nanio,
                     nmes: fecha[i].nmes,
                     idEnvio: fecha[i].idEnvio,
                     nsemana: fecha[i].nsemana
                 }
                 Array.push(e);
             }

             this.setState({
                 mostrarResultadoFecha: true,
             });
             swal("Consulta realizada exitosamente!", "", "success");
         } else {
             swal("No hay registro de esa fecha", " ", "info");
         }
         this.setState({
             opcFecha: Array,
             objFechas: fecha,
             asignarRec: false,
         });
     })
     .catch((error) => {
         swal("Algo salío mal", "", "error");
         console.log(error);
     });
}

        onSubmitAsignarFecha = (e) => {
            if (this.Validar(this.state.mes, this.state.anio)) {
                if (this.state.mes != '' && this.state.anio == '' ) {
                    this.buscarmes(this.state.mes, e);

                } else if (this.state.mes == '' && this.state.anio != '' ) {
                    this.buscaranio(this.state.anio, e);

                } else {
                    swal("Lo sentimos, sólo puede llenar un campo para la búsqueda", "", "info");
                }
            }
            e.preventDefault();
          }




          

          onSubmitAsignar = (e) => {  //JUAN
            console.log("---ACTUALIZA CODIGO Y PROGRAMA EN RECAUDACIONES ---");
           // console.log(this.state.objRecaudaciones[0].codAlum);
    
            console.log("---ALUMNO DEPUES DEL CLICK GUARDAR ---"); //VERIFICAR CON LA CONSOLA
            console.log(this.state.alumno);
            //ANTHONY	
            //alert(this.state.alumno.codAlumno);		 
            //alert(this.state.alumno.nom_programa);
    
           
            
            let id_envio = this.state.objRecaudaciones[0].id_envio;
            
            try {
                
                id_envio = this.state.alumno.id_envio; //AHORA CAMBIAR LA REST
            } catch (error) {
                console.log(error);
            }
    
            if (this.state.alumno != null) {
                fetch(CONFIG + 'recaudaciones/actualizar/' +  this.state.objRecaudaciones[0].codAlumno+ '/'+this.state.objRecaudaciones[0].numero + '/' + this.state.alumno.id_envio, {
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    method: "POST",
                    body: JSON.stringify({
                        'codAlumno': this.state.objRecaudaciones[0].codAlumno,
                        'numero': this.state.objRecaudaciones[0].numero,
                        'id_envio': this.state.alumno.id_envio
                    })
                })
                    .then((response) => {
                        console.log(response);
                        if (response) {
                            swal("guardado exitosamente!", "", "success");
                            this.setState({
                                estado: true,
                            });
                        } else {
                            swal("Oops, Algo salió mal!!", "", "error");
                        }
                    })
                    .catch((error) => {
                        swal("Oops, Algo salió mal!!", "", "error");
                        console.log(error);
                    })
            } else {
                swal("Seleccione una opción", " ", "info");
            }
        }

          componentWillMount(){

            fetch(CONFIG+'recaudaciones_envios/listar')
            .then((response)=>{
              return response.json();
            })
            .then((recaudacion_envio)=>{
              
              this.setState({
                semanasBD : recaudacion_envio
              })
            })
          }

          
          handleChangeSelectRangoSemana=(estados)=>{
            this.setState({
              semana_actual:{value: estados.value,label: estados.label},
              vacio:false
            });
          }

          handleChangeSelectTipoAnio = (estados) => {
            //if(estado!== null){
              this.setState({
                anio_actual:{value: estados.value,label: estados.label}
              });
              setTimeout(() => {
                
              }, 100);
      
          }

          handleChangeSelectTipoMes = (estados) =>{
            this.setState({
              //mes_actual:{value:"-1",label:"Seleccione un Mes"},
              mes_actual:{value:estados.value,label:estados.label}
            });
      
            let arreglo = [];
            switch(estados.value){
      
      
              case "01" : Object.keys(this.state.semanasBD).map(key=>(
                  // console.log(this.state.programas[key].label.split(" "[0])),
                  (this.state.semanasBD[key].nmes==1) ? (
                    arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                    )
                    : null,
      
                    this.setState({
                      semanas : arreglo
                    })
              ))          
              ;break;
      
              case "02" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==2) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,
    
                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;
      
              case "03" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==3) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,
    
                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

              case "04" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==4) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

              case "05" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==5) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

              case "06" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==6) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

              case "07" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==7) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

                case "08" : Object.keys(this.state.semanasBD).map(key=>(
                  // console.log(this.state.programas[key].label.split(" "[0])),
                  (this.state.semanasBD[key].nmes==8) ? (
                    arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                    )
                    : null,

                    this.setState({
                      semanas : arreglo
                    })
              ))          
              ;break;

                case "09" : Object.keys(this.state.semanasBD).map(key=>(
                  // console.log(this.state.programas[key].label.split(" "[0])),
                  (this.state.semanasBD[key].nmes==9) ? (
                    arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                    )
                    : null,

                    this.setState({
                      semanas : arreglo
                    })
              ))          
              ;break;

              case "10" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==10) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

              case "11" : Object.keys(this.state.semanasBD).map(key=>(
                // console.log(this.state.programas[key].label.split(" "[0])),
                (this.state.semanasBD[key].nmes==11) ? (
                  arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                  )
                  : null,

                  this.setState({
                    semanas : arreglo
                  })
            ))          
            ;break;

            case "12" : Object.keys(this.state.semanasBD).map(key=>(
              // console.log(this.state.programas[key].label.split(" "[0])),
              (this.state.semanasBD[key].nmes==12) ? (
                arreglo.push({value:this.state.semanasBD[key].nsemana,label:this.state.semanasBD[key].desc_semana})
                )
                : null,

                this.setState({
                  semanas : arreglo
                })
          ))          
          ;break;

            }      

          }

          obtenerIDEnvio=()=>{
            fetch(CONFIG+'recaudaciones_envios/'+this.state.semana_actual.value)
              .then((response)=>{
                return response.json();
              })
              .then((envio)=>{
                this.setState({
                  opcionidEnvio : [{value : envio.idEnvio,  label : envio.desc_semana}],/**/ 
                  semanaSeleccionada : envio.idEnvio,
                  
                })
                
              })
              .catch(error=>{
                console.log(error)
              })
              
          }

          AsignarRecibo=(estados)=>{
            var numeroRecibo = "";
            numeroRecibo = this.SeleccionNumeroRecibo();

            let arreglo_rec_envio = [];

            Object.keys(this.state.semanasBD).map(key=>(
              // console.log(this.state.programas[key].label.split(" "[0])),
              (this.state.semanasBD[key].desc_semana==this.state.semana_actual.label) ? (
                fetch(CONFIG+'recaudaciones/alumno/concepto/actualizarIdEnvio/'+this.state.semanasBD[key].idEnvio+'/'+numeroRecibo,
                {
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  method: "PATCH",
                }
              )
              .then((defuncion) => {
                  swal("Recibo Asignado Correctamente","","")  
              })
              .catch(error => {
                // si hay algún error lo mostramos en consola
                swal("Oops, Algo salió mal!!", "", "error")
                console.error(error)
              })
                )
                : null,
  
                this.setState({
                  semanas : arreglo_rec_envio
                })
          ))  
              }
          

          desasignarRecibo=()=>{
            var numeroRecibo = "";
            numeroRecibo = this.SeleccionNumeroRecibo();

           
              // console.log(this.state.programas[key].label.split(" "[0])),
              
                fetch(CONFIG+'recaudaciones/alumno/concepto/actualizarIdEnvio/'+0+'/'+numeroRecibo,
                {
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  method: "PATCH",
                }
              )
              .then((defuncion) => {
                  swal("Recibo Desasignado Correctamente","","")  
              })
              .catch(error => {
                // si hay algún error lo mostramos en consola
                swal("Oops, Algo salió mal!!", "", "error")
                console.error(error)
              })
                
            }
  
                
               
              


          
        
            

            obtenerDatosRecaudacionEnvio(){
              var numeroRecibo = "";
              var mes="";
              numeroRecibo = this.SeleccionNumeroRecibo();

              fetch(CONFIG+'recaudaciones_envios/fechaenvio/'+numeroRecibo)
              .then((response)=>{
                return response.json();
              })
              .then((recaudacion_envio)=>{
                
                this.setState({
                  fechaBD : recaudacion_envio
                })
              })

      
              

            }


            MostrarRecibo=()=>{
            
  
              let arreglo_rec_envio = [];
  
              Object.keys(this.state.fechaBD).map(key=>(
                (this.state.fechaBD[key].length>0) ? (
                arreglo_rec_envio.push({value:this.state.fechaBD[key].nmes})
                
                )
                : null,
                this.setState({
                  fecha : arreglo_rec_envio
                })
               
            ))  
                }

           
         

          

 

  render() {

    

    //const closeBtn = <button className="close" onClick={this.toggle}>&times;</button>

    //const label = this.props.buttonLabel

    //let button = ''
    //let title = ''
   // title = 'Actualizar datos'
   
    {/*  button =  <td  className="td" id={"edit" + (this.props.numero + 2)}>  
        <button
          onClick={this.toggle}       //JUAN ACTUALIZAR
          className="waves-effect waves-light btn-small">
          <i className="large material-icons center">edit</i>
        </button>
      </td>
       */}
    

    

   

    
 
 
 
   return (
      <tr>
        <td className="td">
          <form action="#">
            <label className="row center-xs color_white">
              <input
                onClick={this.colocar}
                className="checkbox1"
                id={this.props.pago.idRec}
                type="checkbox" />
              <span> </span>
            </label>
          </form>
        </td>

        <td className="td">
          {this.props.numero + 1}
        </td>

        <td className="td">
          <form action="#" >
            <label className="center-xs color_white">
              <input
                id={this.props.pago.idRec.toString() + "250296"}
                placeholder={this.props.pago.ciclo}
                disabled="true"
                type="text" 
                style ={{width: '15px'}}/>
              <span> </span>
            </label>
          </form>
        </td>

        <td  className="xd">
          {/* <form action="#">
          <label className="row center-xs color_white">
            <input
              placeholder={this.props.pago.concepto}
              id={this.props.pago.idRec.toString()+this.props.pago.concepto}
              disabled = "true"
              type="text" />
              <span> </span>
          </label>
          
        </form> */}

          <Select

            id="conceptos"
            className="conceptos"
            value={this.state.selectedOption}
            onChange={this.handleChange}
            options={this.props.conceptos}
            disabled={this.state.desabilitar}
          //autofocus

          />

        </td>


        <td className="td">
          <form action="#">
            <label className="center-xs color_white">
              <input
                name={this.props.pago.idRec.toString() + this.props.pago.numero}
                placeholder={this.props.pago.numero}
                id={this.props.pago.idRec.toString() + this.props.pago.numero}
                disabled="true"
                type="text" />
              <span> </span>
            </label>
          </form>
        </td>

        <td className="td">
          <form action="#">
            <label className=" center-xs color_white"> 
              <input
                name={this.props.pago.idRec.toString() + this.props.pago.idAlum.toString()}
                placeholder={this.props.pago.fecha.replace(/^(\d{4})-(\d{2})-(\d{2})$/g, '$3-$2-$1')}
                id={this.props.pago.idRec.toString() + this.props.pago.idAlum.toString()}
                disabled="true"
                type="text" />
              <span> </span>
            </label>
          </form>
        </td>

        <td className="td">
          {/* {this.props.pago.moneda} */}
          
          <Select
            inputId = {this.props.pago.idRec.toString() + "250296" + "moneda"}
            value={this.state.selectedOption2}
            onChange={this.handleChange2}
            options={this.props.monedas}
            disabled={this.state.desabilitar2}
          />
        </td>

        <td className="td">
          <table>
            <td>
              {this.state.moneda}
            </td>
            <td>
              <form action="#">
                <label className="center-xs color_white">
                  <input
                    id={this.props.pago.idRec.toString() + "250296" + "importe"}
                    defaultValue={this.props.pago.importe}
                    disabled="true"
                    type="number" />
                  
                </label>
              </form>
            </td>
          </table>
        </td>

      

        <td className="td"/*TIPO_RECAUDACION*/ id={"tipo_recaudacion" + (this.props.numero + 1)} style={{display: 'none'}}>
          <Select
                inputId = {this.props.pago.idRec.toString() + "250296" + "tipo_recaudacion"}
                className="conceptos"
                value={this.state.selectedIdTipoRecaudacion}
                onChange={this.handleChangeIdTipoRecaudacion}
                options= {this.state.tipo_recaudacion}
                disabled={this.state.desablilitarTipoRecaudacion} style ={{width: '100px'}}
                
              />
        </td>


        <td className="td"/*CTA BANCO*/ id={"banco" + (this.props.numero + 1)} style={{display: 'none'}}>
            <h6 align="left">
            <Select
                inputId = {this.props.pago.idRec.toString() + "250296" + "ctabanco"}
                value={this.state.selectedOption4}
                onChange={this.handleChange4}
                options= {this.props.cuentas}
                disabled={this.state.desabilitar4} style ={{width: '180px'}}
              />
              </h6>
        </td>

        <td className="td"/*UBICACION*/ id={"ubicacion" + (this.props.numero + 1)} style={{display: 'none'}}>
          <h6 align="left">
          <Select
            inputId = {this.props.pago.idRec.toString() + "250296" + "ubicacion"}
            value={this.state.selectedOption3}
            onChange={this.handleChange3}
            options= {this.props.ubicaciones}
            disabled={this.state.desabilitar3} style ={{width: '145px'}}
          />
          </h6>
        </td>

   {/*Validado*/}
        <td className="td">
          <form action="#">
            <label className="row center-xs color_white">
              <input
                onClick={this.toggleChange}
                className="checkbox2"
                checked = {this.state.isChecked}
                id={this.props.pago.idRec + "validar"}
                type="checkbox"
                disabled={this.state.desabilitar5} />
              <span> </span>
            </label>
          </form>
        </td>

        


  
       <td  className="td" id={"actualizar" + (this.props.numero + 1)} style={{display: 'none'}}>          
          <button          
            onClick={this.abrirModal}       //JUAN  ACTUALIZAR
            className="waves-effect waves-light btn-small"
            data-target="#modal-transparent"
            >
            <i className="large material-icons center ">add</i>
          </button>
         
          <button
            onClick={this.desasignar}       //JUAN  ACTUALIZAR
            className="waves-effect waves-light btn-small  red darken-1">
            <i className="large material-icons center">clear</i>
          </button>
          
        </td>

        <Modal isOpen={this.state.modal2}  size="lg">
                        <ModalHeader toggle={this.desasignar}>Desasignar fecha de Envio</ModalHeader>
                        <ModalBody>
                            <FormGroup>
                                <thead>
                                    <tr>
                                        <th className="th">Mes</th>
                                        <th className="th">Semana</th>
                                        <th className="th">Año</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    
                                       <td> <Input disabled="true"  defaultValue={this.state.fecha}></Input> </td>
                                       <td> <Input disabled="true"  defaultValue={this.state.fecha.desc_semana}></Input> </td>
                                       <td> <Input disabled="true"  defaultValue={this.state.fecha.nanio}></Input>   </td>
                                      
                                    </tr>
                                </tbody>
                            </FormGroup>                                   
                                   
                        </ModalBody>
                        <ModalFooter>
                                   <Button color="primary" onClick={this.desasignarRecibo}>  Desasignar</Button>
                                   <Button color="secondary" onClick={this.desasignar}>  Cerrar</Button>
                        
                        </ModalFooter>
          </Modal>

         

        <Modal isOpen={this.state.abierto}  size="lg"  >
                        <ModalHeader >Asignar fecha de Envio</ModalHeader>
                        <ModalBody>
                            <FormGroup>
                            <thead>
                                    <tr>
                                        <th className="th">Filtro por Mes y Año</th>
                                        
                                    </tr>
                                </thead>
                                <div className="row">

                                      <div className="row col-xs-12">
                                        <label className="col-xs-2">Mes</label>
                                        <Select className="col-xs-4" 
                                            placeholder="Seleccione un Mes"
                                            name="selectipo"
                                            id="selectipo"
                                            value={this.state.mes_actual}
                                            onChange={this.handleChangeSelectTipoMes}
                                            options={this.state.tipo_mes}
                                        />

                                        <label className="col-xs-1">Año</label>
                                        <Select className="col-xs-4" 
                                            placeholder="Seleccione un Año"
                                            name="selecprograma"
                                            id="selecprograma"
                                            value={this.state.anio_actual}
                                            onChange={this.handleChangeSelectTipoAnio}
                                            options={this.state.tipo_anio}
                                        />
                                      </div>
                                      </div> 
                                      </FormGroup>
                                            
                                   <thead>
                                    <tr>
                                        <th className="th">Rango de Semana</th>
                                        
                                    </tr>
                                </thead>
                                <div className="row">
                                  <div className="row col-sm-12 center">
                                     <label className="col-lg-2">Semana</label>
                                        <Select className="col-lg-6 " 
                                          placeholder="Seleccione Semana"
                                          name="selectipo"
                                          id="selectipo"
                                          value={this.state.semana_actual}
                                          onChange={this.handleChange7}
                                          options={this.state.semanas}   
                                          />    

                                                                         
                                  </div>    
                                </div>   
                                   
                        </ModalBody>

                        <ModalFooter>
                                   <Button color="primary" onClick={this.AsignarRecibo} options={this.state.semanas}>  Asignar</Button>
                                   <Button color="secondary" onClick={this.abrirModal}>  Cerrar</Button>
                       
                        </ModalFooter>
                        
          </Modal>
          
        
       {/* 

        <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}>
             <ModalHeader toggle={this.toggle}>
               Asignar fecha de Envio
            </ModalHeader>
              <ModalBody>
                  
                      <Row className="justify-content-md-center">
                      <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                      <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                      <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                     
                        
                      </Row>
            </ModalBody>
            <ModalFooter>
              <Button variant="secondary" onClick={this.toggle}>
                Cerrar
               </Button>
              <Button variant="primary" onClick={this.toggle}>
                Guardar Cambios
              </Button>
            </ModalFooter>
      </Modal>
       */} 
        
       {/*  
         <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}   >
          <ModalHeader toggle={this.toggle} close={closeBtn}>{title}</ModalHeader>
            <ModalBody>
              <DropdownButton id="  dropdown-basic-button" title="Dropdown button">
                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
              </DropdownButton>

              
              
             <AddEditForm
               addItemToState={this.props.addItemToState}
                updateState={this.props.updateState}
                toggle={this.toggle}
                item={this.props.item} />
            </ModalBody>
        </Modal>
     */}
        

       {/*  <Modal isOpen={this.state.abierto} style={modalStyles}>
          <ModalHeader>
            Asignar fecha de Envio     
          </ModalHeader>
          <ModalBody>
          <Form>
                <Form.Row>
                  <Col>
                    <Form.Control placeholder="First name" />
                  </Col>
                  <Col>
                    <Form.Control placeholder="Last name" />
                  </Col>
                </Form.Row>
              </Form>
               

              <div className="margen3"> 
                 <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                 <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                 <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
                 <Dropdown options = {options} onChange = {this._onSelect} value = {defaultOption} placeholder = "Seleccionar una opción" />
              </div>   
                    
          </ModalBody>
          <ModalFooter>
            <Button >Asignar</Button>
            <Button onClick={this.abrirModal}>cerrar</Button>
          </ModalFooter>
        </Modal>

*/}     



   

        <td className="td" id={"search" + (this.props.numero + 1)}>
          <button
            onClick={this.editarObservacion}       /*checa JUAN*/
            className="waves-effect waves-light btn-small">
            <i className="large material-icons center">search</i>
          </button>
        </td>

        <td className="td" id={"show" + (this.props.numero + 1)}>
          <button
            onClick={this.showObservacion}
            className="waves-effect waves-light btn-small">
            <i className="large material-icons center">search</i>
          </button>
        </td>


        <td className="td" id={"edit" + (this.props.numero + 1)}>
          <button
            onClick={this.editarFila}
            className="waves-effect waves-light btn-small">
            <i className="large material-icons center">edit</i>
          </button>
        </td>

        <td className="td" id={"save" + (this.props.numero + 1)}>
          <button
            onClick={this.GuardarFecth}
            className="waves-effect waves-light btn-small">
            <i className="large material-icons center">save</i>
          </button>
        </td>

        <td className="td">
          {this.state.estado}
        </td>
      </tr>
    )
  }
}

export default PagoRow;
