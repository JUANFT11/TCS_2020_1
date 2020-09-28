import React from 'react'
import '@trendmicro/react-sidenav/dist/react-sidenav.css';
import {browserHistory} from 'react-router-3';
import NumeroRecibo from './NumeroRecibo'
import CONFIG from '../Configuracion/Config'
import Alumno from './Alumno'
import AlumnoCodigo from './AlumnoCodigo'
import Select from 'react-select';
import swal from 'sweetalert';

class AsignarReciboMasivo extends React.Component{

    constructor(props){
        super(props);

        this.state={
            estado:0,
            estados:0,
            costosP: {},
            idPrograma:'',
            //valores para los select
            optionsTipoPrograma:[],
            optionsSemestrePrimer:[],
            optionsSemestreSegundo:[],
            selectedOption: null,
            programas:[],
            recaudaciones:[], //conjunto de recibos sin verificar
            programasBD:[],
            select_programas:[],
            filtroNumeros: [],
            semanasBD:[],
            semanas:[],
            programa_actual:{value:"-1",label:"Seleccione un programa"},
            tipo_programa:[{value:"03",label:"Maestria"},{value:"05",label:"Doctorado"},{value:"06",label:"Diplomatura"}],
            anio_actual:{value:"-1",label:"Seleccione un Año"},
            mes_actual:{value:"-1",label:"Seleccione un Año"},
            semana_actual:{value:"-1",label:"Seleccione semana"},
            tipo_anio:[{value:"2020", label:"2020"},{value:"2019", label: "2019"}],
            tipo_mes:[{value:"01", label:"Enero"},{value:"02", label: "Febrero"},{value:"03", label: "Marzo"},{value:"04", label: "Abril"},{value:"05", label: "Mayo"},{value:"06", label: "Junio"},{value:"07", label: "Julio"},{value:"08", label: "Agosto"},{value:"09", label: "Setiembre"},{value:"10", label: "Octubre"},{value:"11", label: "Noviembre"},{value:"12", label: "Diciembre"}],
            tipo_actual:{value:"-1",label:"Seleccione un tipo"},
            TipopresupuestoInput:{value:"-1",label:"Seleccione un presupuesto"},
            semestreInput1:{value:"-1",label:"Seleccione periodo Inicial"},
            semestreInput2:{value:"-1",label:"Seleccione periodo Final"},
            periodos:[],
            presupuestos:[],
            semestres:[],
            vacio:true,
            
            arregloAlumnos : [],
            programaSeleccionado : 0,
           
            numRecibos:'',
            cambiar: true,
            arregloProgramaOriginal : [],
            detallePresupuesto : { upg: 0,epg:0,derecho:0,total:0,valor1:0,valor2:0}
        }

        this.Regresar=this.Regresar.bind(this);
        this.FiltrarNumeros = this.FiltrarNumeros.bind(this);
       
       // this.handleChangeSelectPrograma=this.bind(this);
        this.alumno = '';
    }

    componentWillMount(){

             

      fetch(CONFIG+'alumno/alumnoprograma/programa/programas')
      .then((response)=>{
        return response.json();
      })
      .then((programa)=>{
        
        this.setState({
          programasBD : programa
        })
      })

      let arreglo=[];

      fetch(CONFIG+'alumno/alumnoprograma/programa/semestres')
      .then((response)=>{
        return response.json();
      })
      .then((semestres)=>{
        this.setState({
          semestres 
        })

        Object.keys(semestres).map(key=>(
          arreglo.push({value:key,label:semestres[key].semestre})
        ))

        this.setState({
          optionsSemestrePrimer : arreglo, 
          optionsSemestreSegundo :arreglo
        })
      })
   
    }

    FiltrarNumeros = (listaNumeros) => {
      for (let i = 0; i < listaNumeros.length; i++) {
        var reci = listaNumeros[i]

      fetch(CONFIG + 'recaudaciones/rec/' + reci)

        .then((response)=>{
          return response.json();
        })
          .then((recaudacion)=>{
        
            this.setState({
            recaudaciones : recaudacion
            })
        
          })
      .catch((error) => {
        swal("ALgo salio mal!", "", "warning")

        });
      }
  
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
        
        mes_actual:{value:estados.value,label:estados.label}
      });

      let arreglo = [];
      switch(estados.value){


        case "01" : Object.keys(this.state.semanasBD).map(key=>(
            
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
    handleChangeSelectRangoSemana=(estados)=>{
      this.setState({
        semana_actual:{value: estados.value,label: estados.label},
        vacio:false
      });
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


    handleChangeSelectTipo = (estado) =>{
      this.setState({
        tipo_actual:{value:estado.value,label:estado.label}
      });

      let arreglo = [];
      switch(estado.value){


        case "03" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="MAESTRIA") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo
              })
        ))          
        ;break;

        case "05" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="DOCTORADO") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo
              })
        ))          
        ;break;

        case "06" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="DIPLOMATURA:") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo
              })
        ))          
        ;break;
      }
    }


    handleChangeSelectPrograma = (estado) => {
      //if(estado!== null){
        this.setState({
          programa_actual:{value: estado.value,label: estado.label}
        });
        setTimeout(() => {
          this.obtenerPresupuesto();
        }, 100);

    }

    Regresar=(e)=>{
        browserHistory.push('/');
        e.preventDefault();
    }

    


    //////////------------

    mostrarAlumnosP=()=>{
       
        document.getElementById('reciboMasivo').style.display = 'block';
        
    }

    mostrarPresupuesto=()=>{    
        document.getElementById('presupuesto').style.display='block';
        document.getElementById('alumnosP').style.display = 'none';  
        document.getElementById('alumnosP2').style.display = 'none';
    }

    obtenerPresupuesto=()=>{
      fetch(CONFIG+'alumno/alumnoprograma/programa/'+this.state.programa_actual.value)
        .then((response)=>{
          return response.json();
        })
        .then((programa)=>{
          this.setState({
            optionsTipoPrograma : [{value : programa.idPrograma,label:programa.idPrograma+" - "+programa.nomPrograma}],/**/ 
            programaSeleccionado : programa.idPrograma
          })
        })
        .catch(error=>{
          console.log(error)
        })
    }

    handleChangeSelectTipoPrograma=(estado)=>{
      this.setState({
        TipopresupuestoInput:{value: estado.value,label: estado.label},
        vacio:false
      });
    }

    handleChangeSelectSemestre1=(estado)=>{
      let arreglo=[]
      Object.keys(this.state.semestres).map(key=>(
        (Number(key)>Number(estado.value)) ?
        (arreglo.push({value:key,label:this.state.semestres[key].semestre})) :
        null
      ))

      this.setState({
        semestreInput1 : {value: estado.value,label: estado.label},
        optionsSemestreSegundo : arreglo
      })
    }

    handleChangeSelectSemestre2=(estado)=>{
      let arreglo=[]
      Object.keys(this.state.semestres).map(key=>(
        (Number(key)<Number(estado.value)) ?
        (arreglo.push({value:key,label:this.state.semestres[key].semestre})) :
        null
      ))

      this.setState({
        semestreInput2 : {value: estado.value,label: estado.label},
        optionsSemestrePrimer : arreglo
      })
    }

    seleccionar=()=>{
      fetch(CONFIG+'alumno/alumnoprograma/programa/alumnosemestres/'+this.state.semestreInput1.label+"/"+this.state.semestreInput2.label+"/"+this.state.programaSeleccionado)
      .then((response)=>{
        return response.json();
      })
      .then((resultado)=>{
        this.setState({
          alumnosM : resultado
        })

        console.log(this.state.arregloAlumnos)
      
      })

      switch(this.state.programaSeleccionado){
        case 1 : this.setState({
                    detallePresupuesto : { upg: 0, epg:0, derecho:5808, total:5808, valor1:24, valor2:242}
                  });
                  break;
        case 2 : this.setState({
                    detallePresupuesto : { upg: 0, epg:0, derecho:5808, total:5808, valor1:24, valor2:242}
                  });
                  break;
        case 3 : this.setState({
                    detallePresupuesto : { upg: 0, epg:0, derecho:5808, total:5808, valor1:24, valor2:242}
                  });
                  break;
        case 4 : this.setState({
                    detallePresupuesto : { upg: 1816, epg:208, derecho:16488, total:16488, valor1:72, valor2:229}
                  });
                  break;
        case 5 : this.setState({
                    detallePresupuesto : { upg: 1816, epg:208, derecho:16488, total:16488, valor1:72, valor2:229}
                  });
                  break;
        case 6 : this.setState({
                    detallePresupuesto : { upg: 1816, epg:208, derecho:16488, total:16488, valor1:72, valor2:229}
                  });
                  break;
        case 7 : this.setState({
                    detallePresupuesto : { upg: 1816, epg:208, derecho:16488, total:18512, valor1:212, valor2:229}
                  });
                  break;
        case 8 : this.setState({
                    detallePresupuesto : { upg: 3000, epg:312, derecho:29472, total:32784, valor1:96, valor2:307}
                  });
                  break;        
      }

      var lista= document.getElementsByClassName('checkbox1');
      var remover = document.getElementsByClassName('remover');
      var aumentar = document.getElementsByClassName('aumentar');

      for(var i=0;i<lista.length;i++)
        lista[i].checked=false;

      for(var i=0;i<remover.length;i++)
        remover[i].classList.remove("dis-none");
      
      for(var i=0;i<aumentar.length;i++)
        aumentar[i].classList.add("dis-none");

       

    }
//importante--Diana
    AgregarAlumno=(arreglo,e)=>{
      console.log(this.state.alumnosM[4])
      this.state.arregloAlumnos.splice(e,1,arreglo);

      console.log(document.getElementById("filaLista-"+e).checked)
      if(document.getElementById("filaLista-"+e).checked)
        this.state.arregloAlumnos.splice(e,1,arreglo);
      else
        this.state.arregloAlumnos.splice(e,1,{})

        console.log(this.state.arregloAlumnos);
    }

//importante--Diana
    removerAlumno=(e)=>{
      this.state.arregloAlumnos.splice(e,1,{})
        //console.log(this.state.alumnosM);
        document.getElementById('boton_remove' + e.toString()).classList.add("dis-none");
        document.getElementById('boton_add' + e.toString()).classList.remove("dis-none");
        
        document.getElementById('fila-' + e.toString()).classList.add("sombreado-rojo");
        document.getElementById('fila2-' + e.toString()).classList.add("sombreado-rojo");
        document.getElementById('fila3-' + e.toString()).classList.add("sombreado-rojo");
        //document.getElementById('fila4-' + e.toString()).classList.add("sombreado-rojo");
        document.getElementById('fila5-' + e.toString()).classList.add("sombreado-rojo");

        console.log(this.state.arregloAlumnos);
      }

    AsignarPres=()=>{
      console.log(this.state.arregloAlumnos);
      var arreglo = [...this.state.arregloAlumnos]
      this.setState({
        arregloProgramaOriginal : arreglo
      })
      Object.keys(this.state.arregloAlumnos).map(key=>(
        // console.log(this.state.arregloAlumnos[key].codigo)
          (this.state.arregloAlumnos[key].codigo) ? (
            fetch(CONFIG+'recaudaciones/alumno/concepto/actualizarIdProgramaPrespuesto/'+this.state.programaSeleccionado+'/'+this.state.arregloAlumnos[key].codigo,
            {
              headers: {
                'Content-Type': 'application/json'
              },
              method: "PATCH",
            }
          )
          .then((defuncion) => {
              swal("Presupuesto Asignado Correctamente","","")  
          })
          .catch(error => {
            // si hay algún error lo mostramos en consola
            swal("Oops, Algo salió mal!!", "", "error")
            console.error(error)
          })
          ) : 
          null
      ))
      
      this.setState({
        arregloAlumnos : []
      })
      
      setTimeout(() => {
        this.seleccionar();        
      }, 3500);
      }

      seleccionar1=()=>{
        //console.log("gg agg");
        var checks=document.getElementsByClassName("checkbox1");

        if(this.state.cambiar){
          for (let i=0;i<checks.length;i++) {
            let a
            a=this.state.alumnosM[i];
            console.log(a)
            checks[i].checked=true;
            this.state.arregloAlumnos.splice(i,1,this.state.alumnosM[i]);
          }

        }else{
          for (let i=0;i<checks.length;i++) {
            let a
            a=this.state.alumnosM[i];
            console.log(a)
            checks[i].checked=false;
            this.state.arregloAlumnos.splice(i,1,{});
          }
        }
        let cambiar1= this.state.cambiar;
            this.setState({
              cambiar:!cambiar1
            })
      console.log(this.state.arregloAlumnos)
      }


    DesasignarPres=()=>{
      Object.keys(this.state.arregloAlumnos).map(key=>(
        // console.log(this.state.arregloAlumnos[key].codigo)
          (this.state.arregloAlumnos[key].codigo) ? (
            fetch(CONFIG+'recaudaciones/alumno/concepto/actualizarIdProgramaPrespuesto/'+0+'/'+this.state.arregloAlumnos[key].codigo,
            {
              headers: {
                'Content-Type': 'application/json'
              },
              method: "PATCH",
            }
          )
          .then((defuncion) => {
              swal("Presupuesto Desasignado Correctamente","","")  
          })
          .catch(error => {
            // si hay algún error lo mostramos en consola
            swal("Oops, Algo salió mal!!", "", "error")
            console.error(error)
          })
          ) : 
          null
      ))
      this.setState({
        arregloAlumnos : []
      })
      setTimeout(() => {
        this.seleccionar();        
      }, 1000);
    }

    recorrerAlumnos=()=>{
      var indice=1;
      return(
      (this.state.alumnosM.length>0) ?
                      Object.keys(this.state.alumnosM).map(key=>(
                      <div className="alcentro " key={key}>
                        <div className="col-xs-12 row" >
                          <div className="cuadro-borde col-xs-1  " id={"fila-"+key}><div className="margenes-padding">{indice++}</div></div>
                          <div className="cuadro-borde col-xs-2  " id={"fila2-"+key}><div className="margenes-padding">{this.state.alumnosM[key].codigo}</div></div>
                          <div className="cuadro-borde col-xs-4  " id={"fila3-"+key}><div className="margenes-padding">{this.state.alumnosM[key].nombre}</div></div>
                          <div className="cuadro-borde col-xs-3  " id={"fila5-"+key}><div className="margenes-padding">{this.state.alumnosM[key].presupuesto}</div></div>
                          <div className="cuadro-borde col-xs-2 ">

                          <form action="#">
                            <label className="row center-xs color_white">
                              <input className="checkbox1" onClick={e=>this.AgregarAlumno(this.state.alumnosM[key],key)} id={"filaLista-"+key} type="checkbox"></input>
                              <span></span>
    
                            </label>
                          </form>
                           { /*
                              <button onClick={e=>this.removerAlumno(key)} id={"botonremove"+key} className="remover waves-effect waves-light btn-small btn-danger start mt-1 mb-1">Remover
                              <i className="large material-icons left">remove_circle</i>
                              </button>
                              <button onClick={e=>this.AgregarAlumno(this.state.alumnosM[key],key)} id={"boton_add"+key} className="aumentar waves-effect waves-light btn-small btn-success start mt-1 mb-1 dis-none">Incluir
                              <i className="large material-icons left">add_circle</i>
                           </button>*/}
                              
                          </div> 
                        </div>
                      </div>  
                    )) : (
                    <div className="alcentro ">  
                      <div className="col-xs-12 row">
                          <div className="cuadro-borde col-xs-12">Sin datos de alumnos</div>
                      </div>
                    </div>    
                    ))                
    }

    recorrerRecaudaciones=()=>{
      var indice=1;
      return(
      (this.state.recaudaciones.length>0) ?
                      Object.keys(this.state.recaudaciones).map(key=>(
                      <div className="alcentro " key={key}>
                        <div className="col-xs-12 row" >
                          <div className="cuadro-borde col-xs-1  " id={"fila-"+key}><div className="margenes-padding">{indice++}</div></div>
                          <div className="cuadro-borde col-xs-3  " id={"fila2-"+key}><div className="margenes-padding">{this.state.recaudaciones[key].concepto}</div></div>
                          <div className="cuadro-borde col-xs-2  " id={"fila3-"+key}><div className="margenes-padding">{this.state.recaudaciones[key].numero}</div></div>
                          <div className="cuadro-borde col-xs-2  " id={"fila5-"+key}><div className="margenes-padding">{this.state.recaudaciones[key].moneda}</div></div>
                          <div className="cuadro-borde col-xs-2  " id={"fila7-"+key}><div className="margenes-padding">{this.state.recaudaciones[key].importe}</div></div>
                          <div className="cuadro-borde col-xs-2  " id={"fila9-"+key}><div className="margenes-padding">{this.state.recaudaciones[key].codAlum}</div></div>
                          
                        </div>
                      </div>  
                    )) : (

                    <div className="alcentro ">  
                      <div className="col-xs-12 row">
                          <div className="cuadro-borde col-xs-12">Sin datos de recibos</div>
                      </div>
                    </div>    
                    ))                
    }

    render(){

        return(
        <div>
            <h3>ASIGNACION DE FECHA DE ENVIO - MASIVO
                <ul id="nav-mobile" className=" row right  hide-on-med-and-down">
                    <li ><a className="seleccionar col" onClick={this.Regresar} >Regresar<i className="material-icons right">reply</i></a></li>
                </ul>
            </h3>
            
            <div className="SplitPane"> 
              <br/>
              <div className="SplitPane row">
              <div className="col-xs-4 row">
                    <h4 className="ml-6 subtitulo">Ingresar recibo</h4>
                    <div>
                      <NumeroRecibo Numeros={this.FiltrarNumeros} />
                     
                    </div>
                    
              </div>
              
              <div className="col-xs-8 ">            
              
                <div id="recibosMas">
                  <div className="alcentro ">
                    <div className="col-xs-12 row">
                    <div className="verdeagua cuadro-borde col-xs-1 "><b>N°</b></div>
                      <div className="verdeagua cuadro-borde col-xs-3 "><b>Concepto</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2 "><b>N° recibo</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2 "><b>Moneda</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2 "><b>Importe</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2 "><b>Cod Alumno</b></div>
                    </div> 
                  </div>
                  {this.recorrerRecaudaciones()}
                </div>
               

              </div >
              </div>
             
              <hr/>
              <br/>
              <h4 className="ml-3 subtitulo">Seleccionar fecha de envío</h4>
                                     

              <div align="center">
                <button onClick={this.AsignarPres} className="waves-effect waves-light btn-small">
                    Asignar</button>
                <button onClick={this.DesasignarPres} className="waves-effect waves-light btn-small btn-danger ml-3">
                    Desasignar</button>
              </div>
              <br/>
              <br/>
              <br/>
              <div className="row">
                <div className="row col-xs-12">
                  <label className="col-xs-2">Año</label>
                  <Select className="col-xs-2" 
                      placeholder="Seleccione un año"
                      name="selectipo"
                      id="selectipo"
                      value={this.state.anio_actual}
                      onChange={this.handleChangeSelectTipoAnio}
                    options={this.state.tipo_anio}
                  />
                  <label className="col-xs-2">Mes</label>
                  <Select className="col-xs-2" 
                      placeholder="Seleccione un mes"
                      name="selectipo"
                      id="selectipo"
                      value={this.state.mes_actual}
                      onChange={this.handleChangeSelectTipoMes}
                      options={this.state.tipo_mes}
                  />
                  <label className="col-xs-2">Semana</label>
                  <Select className="col-xs-2" 
                      placeholder="Seleccione una semana"
                      name="selectipo"
                      id="selectipo"
                      value={this.state.semana_actual}
                      onChange={this.handleChange7}
                      options={this.state.semanas}
                  />
                  
                </div>
              </div>
              <br/>
              <br/>
              <br/>
            </div>
            <footer>
            <div className="row center-xs centrar color">
              Proyecto SIGAP © 2019 v.1.3
            </div>
          </footer>
        </div>)
    }

}

export default AsignarReciboMasivo;