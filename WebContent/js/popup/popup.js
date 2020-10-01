function showPopup(pagina, idControl, pHeight, pWidth, pCenter, pHelp, pStatus ) {
   var atr = "dialogHeight:";
   if ( pHeight == null ) atr += "450"; else atr += pHeight;
   atr += "px;dialogWidth:";
   if ( pWidth == null ) atr += "670"; else atr += pWidth;
   atr += "px;center:";
   if ( pCenter == null ) atr += "Yes"; else atr += pCenter;
   atr += ";help:";
   if ( pHelp == null ) atr += "No"; else atr += pHelp;
   atr += ";resizable:";
   if ( pStatus == null ) atr += "Yes"; else atr += pStatus;
   atr += ";";
   document.getElementById(idControl).value=window.showModalDialog(pagina,"",atr); 
}