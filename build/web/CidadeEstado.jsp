<html>
    <head>
        <title>AJAX in Servlet using JQuery and JSON</title>
        <script src="resource/js/jquery-1.11.3.js" type="text/javascript"></script>

        <script>
            $(document).ready(function () {

                $('#sports').change(function (event) {
                    var sports = $("select#sports").val();
                    $.get('JsonServlet', {
                        sportsName: sports
                    }, function (response) {

                        var select = $('#player');
                        select.find('option').remove();
                        $.each(response, function (index, value) {
                            $('<option>').val(value).text(value).appendTo(select);
                        });
                    });
                });
            });
        </script>
    </head>
    <body>
        <h3>AJAX in Servlet using JQuery and JSON</h3>
        Select Favorite Sports:
        <select id="sports">
            <option>Select Sports</option>
            <option value="Football">Football</option>
            <option value="Cricket">Cricket</option>
        </select>
        <br /> <br /> 
        Select Favorite Player:
        <select id="player">
            <option>Select Player</option>
        </select>
    </body>
</html>