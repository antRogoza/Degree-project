<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 2/23/2018
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel = "shortcut icon" href="images/icon%20(16).png" >
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <title>Aurea Mediocritas</title>

    <link href='/Aurea.css' rel='stylesheet' type='text/css'>
    <style type="text/css" media="all">@import "/Aurea.css";</style>

</head>
<body>
<div id = "header">

        <div id = "logo">
        <img width="24" height="24" src="images/icon(36).png" alt="Libra">
        </div>

        <div id = "logo-text">
         Aurea Mediocritas
        </div>

        <div id="list">
          <select>
            <option value="uk">ENG</option>
            <option value="ua">УКР</option>
          </select>
        </div>
</div>
<div id="body">
    <div id="left-side">
        <div id="info"></div>
        <div id="map">
            <script>
                var map;
                function initMap() {
                    map = new google.maps.Map(document.getElementById('map'), {
                        center: {lat: -34.397, lng: 150.644},
                        zoom: 8
                    });
                }
            </script>
            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmw_DIgB-mWon6Efv9xsEt2nvHIrsHn0c&callback=initMap"async defer></script>
        </div>
    </div>
    <div id="right-side">
        <div id="grups">
            <div id = "status"></div>

        </div>
        <div id="message-button"></div>
        <div id="grup-members"></div>
        <div id="message-box"></div>
    </div>
</div>
</body>
</html>
