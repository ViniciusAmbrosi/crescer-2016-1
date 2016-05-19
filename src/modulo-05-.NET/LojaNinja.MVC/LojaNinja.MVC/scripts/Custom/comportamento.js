'use scrict';

$(function () {
    $("#datepicker").datepicker({ dateFormat: "dd/mm/yy" });
    $("#camelao").click(function () {
        if ($("#camelao-div-bottom").position().left == -301) {
            $("#camelao-div-bottom").animate({ "left": "+=2500px" },"slow", function () { $("#camelao-div-bottom").css("display", "none") } )
        }
        else {
            $("#camelao-div-bottom").css("display", "block")
            $("#camelao-div-bottom").animate({ "left": "-=2500px" }, "slow")
        };
    });
});
