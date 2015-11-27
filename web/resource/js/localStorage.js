var $localS = jQuery.noConflict();

$localS(function () {
    $localS('#btnSalvar').click(function () {
        var d = new Date();
        var n = d.getTime();
        localStorage.setItem(n, "Nome:" +$localS('#nome').val() + " --||-- Ano: "+$localS('#ano').val()
                + " --||-- ID PAis: " + $localS('#pais').val() + " --||-- ID Tipo Trab: " +  $localS('#id_tipoTrab').val());
    });
});
