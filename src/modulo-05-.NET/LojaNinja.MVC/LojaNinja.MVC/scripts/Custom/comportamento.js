'use scrict';

$(function () {
    $("#datepicker").datepicker({ dateFormat: "dd/mm/yy" });

    $("#camelao").click(function () {
        //$("#camelao-div-bottom").css("left", "2000px")
        $("#camelao-div-bottom").animate({"left": "+=2500px"}, "slow" )
        //$(".block").animate({ "left": "+=50px" }, "slow");
});
});

