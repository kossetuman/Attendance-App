 var date = new Date();

        var yyyy = date.getFullYear();
        var mm = ("0"+(date.getMonth()+1)).slice(-2);
        var dd = ("0"+date.getDate()).slice(-2);

    document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;