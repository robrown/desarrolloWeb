document.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"../js/jscal/calendar-win2k-cold-1.css\" title=\"win2k-cold-1\" />");
document.write("<script type=\"text/javascript\" src=\"../js/jscal/calendar.js\"></script" + ">");
document.write("<script type=\"text/javascript\" src=\"../js/jscal/lang/calendar-es.js\"></script" + ">");
document.write("<script type=\"text/javascript\" src=\"../js/jscal/calendar-setup.js\"></script" + ">");

function generar_cal(trig_a,trig_b) {
    Calendar.setup({
        inputField     :    trig_a,      // id of the input field
        ifFormat       :    "%Y-%m-%d",      // format of the input field
        showsTime      :    false,           // will display a time selector
        button         :    trig_b,   // trigger for the calendar (button ID)
        singleClick    :    false,           // double-click mode
        step           :    1                // show all years in drop-down boxes (instead of every other year as default)
    });
}