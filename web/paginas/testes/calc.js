$(function () {
    /*pega valor clicado e inseri no input*/
    $('.btnNumber').click(function () {
        console.log(this.value)
        $('#inputResult').val($('#inputResult').val() + this.value)
    });

    /*pega opera&ccedil;&atilde;o clicada e inseri no input*/
    $('.btnOperacao').click(function () {
        console.log(this.value)
        /*verifica se a tecla clicada é a LIMPAR, se sim apaga os valores do input*/
        if (this.value != 'LIMPAR') {
            $('#inputResult').val($('#inputResult').val() + this.value)
        } else {
            $('#inputResult').val('')
        }
    });

    /*calcula valores continos no input*/
    $('.btnResult').click(function () {
       $('#inputResult').val(eval($('#inputResult').val()))
    });

    $('.btnSalvar').click(function () {
        var lS = prompt("De um nome ao resultado para salvar.", "");
        localStorage.setItem(lS, $('#inputResult').val());
    })

    $('.btnListar').click(function () {
        var tamanho = localStorage.length;
        var chave = '';
        var valor = '';

        if (document.getElementById("tableResults").rows.length > 1) {
            for (var t = document.getElementById("tableResults").rows.length; t > 1; t--) {
                document.getElementById("tableResults").deleteRow(1);
            }
        }

        var numOfCols = document.getElementById("tableResults").rows[document.getElementById("tableResults").rows.length - 1].cells.length;
        for (var c = 0; c < tamanho; c++) {
            chave = localStorage.key(c);
            valor = localStorage.getItem(chave);

            var newRow = document.getElementById("tableResults").insertRow(document.getElementById("tableResults").rows.length);
            for (var j = 0; j < numOfCols; j++) {
                newCell = newRow.insertCell(j);
                if (j == 0) {
                    newCell.innerHTML = chave.toUpperCase();
                } else if (j == 1) {
                    newCell.innerHTML = valor;
                }
            }
        }

    })

    $('.btnApagar').click(function () {
        localStorage.clear()
    })
});
