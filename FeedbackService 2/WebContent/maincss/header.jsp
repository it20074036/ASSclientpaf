<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ElectroGrid (EG)</title>
<link href="image/d.jpg" rel ="icon" type= "image/icon">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  background-image: url('image/bg.jpg');
  font-family:Comic Sans MS, Comic Sans, cursive;
}

.header {
  overflow: hidden;
  background-color: #ededed;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  margin-top:3px;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 16px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  margin-top:-10px;
  font-size: 20px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;    
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;

  }
}

.logo img{
 width:50px;
 height:50px;
 margin-bottom:10px;
}

/*fsf*/

.bgimg {
  background-color:#cbcbcb;
  height: 100%;
  background-position: center;
  background-size: cover;
  border-radius: 5px 30px 5px 30px;
  border:2px solid #000;
  position: relative;
  color: #000;
}
.form{
  margin:20px 30px 20px 30px;
  
}
.form input{
border-radius:10px;
border:1px solid #7c7c7c;

}

.container{
 width-max:6000px;
  width: 100%;
  background-color: #ededed;
  box-shadow: -10px -8px 4px #a8a8a8;
  margin: 30px 50px 70px 60px;
  padding: 25px 30px;
  border-radius: 20px;
}



.table{
margin:20px 20px 40px 40px;
border:2px sloid;
border-radius:8px;
 display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
 
}

</style>
</head>
<body>

<div class="header">
  <a href="index.jsp" class="logo">ElectroGrid (EG)</a>

  </div>
</div>

</body>
</html>
