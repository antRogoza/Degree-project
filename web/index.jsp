<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 18.02.2018
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel = "shortcut icon" href="images/icon%20(16).png" >
    <title>Aurea Mediocritas</title>

    <link href='/Aurea.css' rel='stylesheet' type='text/css'>
    <style type="text/css" media="all">@import "/Aurea.css";</style>
  </head>
  <body>
  <script>
      window.fbAsyncInit = function() {
          FB.init({
              appId      : '1910688979241099',
              xfbml      : true,
              version    : 'v2.12'
          });
          FB.getLoginStatus(function(response) {
              if (response.status === 'connected') {
                  document.getElementById('status').innerHTML = 'We are connected.';
                  document.getElementById('login').style.visibility = 'hidden';
              } else if (response.status === 'not_authorized') {
                  document.getElementById('status').innerHTML = 'We are not logged in.'
              } else {
                  document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
              }
          });
      };
      (function(d, s, id){
          var js, fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id)) {return;}
          js = d.createElement(s); js.id = id;
          js.src = "//connect.facebook.net/en_US/sdk.js";
          fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));

      // login with facebook with extra permissions
      function login() {
          FB.login(function(response) {
              if (response.status === 'connected') {
                  document.getElementById('status').innerHTML = 'We are connected.';
                  document.getElementById('login').style.visibility = 'hidden';
              } else if (response.status === 'not_authorized') {
                  document.getElementById('status').innerHTML = 'We are not logged in.'
              } else {
                  document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
              }
          }, {scope: 'public_profile,email,user_friends'});
      }

      // getting basic user info
      function getInfo() {
          FB.api('/me', 'GET', {fields: 'first_name,last_name,name,id'}, function(response) {
              document.getElementById('status').innerHTML = response.name;
          });
      }

      // posting on user timeline
      function id() {
          FB.api('/me','GET', {fields: 'first_name,last_name,name,id'}, function(response) {
              document.getElementById('status').innerHTML = response.id;
          });
      }

      function getPicture() {
          FB.api('/me', 'GET', {fields: 'first_name,last_name,name,id,picture.width(150).height(150)'}, function(response) {
              document.getElementById('status').innerHTML = "<img src='" + response.picture.data.url + "'>";
          });
      }


      function getFriends() {
          var massiv = [];
          var id = '';
          FB.api(
              '/me/friends',
              'GET',
              {},
              function(response) {
                 massiv = response.data;
                 for (var i = 0; i < massiv.length; i++){
                     id +=  massiv[i].name + " " ;
                 }
                  document.getElementById('status').innerHTML = id;
              }
          );
      }
  </script>

  <button onclick="getInfo()">Get Info</button>
  <button onclick="id()">ID</button>
  <button onclick="login()" id="login">Login</button>
  <button onclick="getPicture()">picture</button>
  <button onclick="getFriends()">friends</button>
  <form>
  <input type="button" value="main" onclick='location.href="http://localhost:8080/main"'>
  </form>
  <div id = "status"></div>
  <a href="#"
           id="auth-logoutlink"
           style="float:left;font-size: small;"
           onclick="FB.logout(function() { document.location.reload();});">

    [logout]
  </a>
  </body>
</html>
