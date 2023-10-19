function transfer(data1,data2,data3){
    $("#exampleModal").on("shown.bs.modal",function (){
        $("#matchingName").val(data1);
        $("#nickname").val(data2);
        $("#introduce").val(data3);
    })
}