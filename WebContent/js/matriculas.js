function procesarCliente() {
    var cadCliente=document.getElementById('xcodc').value;
    var arreglo = new Array();
    document.getElementById('xcodc').value="";
    document.getElementById('xnomc').value="";
    if(cadCliente != "undefined") {
        arreglo=cadCliente.split("#");
        document.getElementById('xcodc').value=arreglo[0];
        document.getElementById('xnomc').value=decodificar(arreglo[1]);
    }
}

function procesarCursos() {
    var cadCurso=document.getElementById('temporal').value;
    var arreglo = new Array();
    var total=0;
    if(cadCurso != "undefined") {
        var nro=adFila();
        arreglo=cadCurso.split("#");
        document.getElementById('txtCod'+nro).value=arreglo[0];
        document.getElementById('txtNom'+nro).value=decodificar(arreglo[1]);
        document.getElementById('txtCos'+nro).value=arreglo[2];

        if(nro==1)
            document.getElementById('txtTotal').value=arreglo[2];
        else{
            for(var i=1;i<=nro;i++){
                total=total + (document.getElementById('txtCos'+i).value)*1;
            }
            document.getElementById('txtTotal').value=total;
        }
    }
}

function decodificar( cad ) {
    var rpta="";
    for(var xc=0; xc<cad.length; xc++) {
        var car=cad.substr(xc,1);
        if(car=='+')
            rpta +=" ";
        else
            rpta += car;
    }
    return rpta;
}

function adFila() {
    var tbl = document.getElementById('listado');
    var lastRow = tbl.rows.length;

    // if there's no header row in the table, then iteration = lastRow + 1
    var iteration = lastRow;
    var row = tbl.insertRow(lastRow);

    // Seleccionar cell
    var selCell = row.insertCell(0);
    var el = document.createElement('input');
    el.type = 'checkbox';
    el.name = 'cbx'+iteration;
    el.id = 'cbx'+iteration;
    selCell.appendChild(el);

    // Nro cell
    var cellLeft = row.insertCell(1);
    var textNode = document.createTextNode(iteration);
    cellLeft.appendChild(textNode);

    // Codigo cell
    var codCell = row.insertCell(2);
    el = document.createElement('input');
    el.type = 'text';
    el.name = 'txtCod'+iteration;
    el.id ='txtCod'+iteration;
    el.size = 10;
    codCell.appendChild(el);

    // Nombre cell
    var nomCell = row.insertCell(3);
    el = document.createElement('input');
    el.type = 'text';
    el.name = 'txtNom'+iteration;
    el.id = 'txtNom'+iteration;
    el.size = 40;
    nomCell.appendChild(el);

    // Costo cell
   var costCell = row.insertCell(4);
   el = document.createElement('input');
   el.type = 'text';
   el.name = 'txtCos'+iteration;
   el.id = 'txtCos'+iteration;
   el.size = 20;
   costCell.appendChild(el);

   return iteration;
}

function eliminarFila( fila ) {
    var tbl = document.getElementById('listado');
    tbl.deleteRow(fila);
}

function eliminarFilas(  ) {
    var controles = document.getElementsByTagName("input");
    var checkboxes = Array();
    var contCbx = 0;
    for( var xc=0 ; xc < controles.length ; xc++ ) {
        if ( controles[xc].type.toLowerCase() == "checkbox" ) {
            checkboxes[contCbx] = controles[xc];
            contCbx++;
        }
    }
    for( xc=checkboxes.length-1 ; xc >= 0 ; xc-- ) {
        cbx = checkboxes[ xc ];
        if ( cbx.checked ) {
            var nomCbx = checkboxes[xc].name;
            var fila = nomCbx.substr(3);
            eliminarFila( fila );
        }
    }
    reenumerarFilas();
}

function reenumerarFilas() {
    var filas  = document.getElementById('listado').rows;
    for( var xc = 1 ; xc < filas.length ; xc++ ) {
        var celdas = filas[xc].cells;
        celdas[1].innerHTML = xc;
    }
    renombrarControles();
}

function renombrarControles() {
    var controles = document.getElementsByTagName("input");
    var contCod = 0;
    var contNom = 0;
    var contCos = 0;
    var contCbx = 0;
    for( var xc=0 ; xc < controles.length ; xc++ ) {
        if ( controles[xc].name.toLowerCase().substr(0,6) == 'txtcod' ) {
            contCod++;
            controles[xc].name = 'txtCod' + contCod;
            controles[xc].id = 'txtCod' + contCod;
        }
        else if ( controles[xc].name.toLowerCase().substr(0,6) == "txtnom" ) {
            contNom++;
            controles[xc].name = 'txtNom' + contNom;
            controles[xc].id = 'txtNom' + contNom;
        }
        else if ( controles[xc].name.toLowerCase().substr(0,6) == "txtcos" ) {
            contCos++;
            controles[xc].name = 'txtCos' + contCos;
            controles[xc].id = 'txtCos' + contCos;
        }
        else if ( controles[xc].name.toLowerCase().substr(0,3) == "cbx" ) {
            contCbx++;
            controles[xc].name = 'cbx' + contCbx;
            controles[xc].id = 'cbx' + contCbx;
        }
    }
    recalcularTotal();
}

function recalcularTotal() {
    var filas  = document.getElementById('listado').rows;
    var total = 0;

    for(var i=1;i<filas.length;i++){
        total = total + ((document.getElementById( "txtCos" + i ).value)*1);
    }
    document.getElementById('txtTotal').value=total;
}

function grabar(opcion) {
    document.getElementById('xfilas').value = document.getElementById('listado').rows.length;
    if(opcion==1)
        document.getElementById('accion').value="GRABAR";
    if(opcion==0)
        document.getElementById('accion').value="CANCELAR";
    document.getElementById('matriculas').submit();
}
