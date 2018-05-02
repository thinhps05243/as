<%-- 
    Document   : curud
    Created on : Jan 12, 2018, 10:09:50 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo</title>
        <style>
            body{
                margin: 0;
                padding: 0;
                background: #fff;

                color: #fff;
                font-family: Arial;
                font-size: 12px;
            }

            .body{
                position: absolute;
                top: -20px;
                left: -20px;
                right: -40px;
                bottom: -40px;
                width: auto;
                height: auto;
                background-image: url(http://www.wallpapermaiden.com/image/2016/06/21/rem-close-up-re-zero-kara-hajimeru-isekai-seikatsu-anime-1456-resized.png);
                background-size: cover;
                -webkit-filter: blur(5px);
                z-index: 0;
            }

            .grad{
                position: absolute;
                top: -20px;
                left: -20px;
                right: -40px;
                bottom: -40px;
                width: auto;
                height: auto;
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
                z-index: 1;
                opacity: 0.7;
            }

            .header{
                position: absolute;
                top: calc(50% - 35px);
                left: calc(50% - 255px);
                z-index: 2;
            }

            .header div{
                float: left;
                color: #fff;
                font-family: 'Exo', sans-serif;
                font-size: 35px;
                font-weight: 200;
            }

            .header div span{
                color: #5379fa !important;
            }
            .login{
                position: absolute;
                top: calc(10% - 75px);
                left: calc(40% - 50px);
                height: 150px;
                width: 350px;
                padding: 10px;
                z-index: 2;
            }
            
            .login h2{
                font-size: 300%;
            }

            .login input[type=text]{
                width: 250px;
                height: 30px;
                background: transparent;
                border: 1px solid rgba(255,255,255,0.6);
                border-radius: 2px;
                color: mediumblue;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 4px;
            }

            .login button{
                width: 80px;
                height: 35px;
                background: #fff;
                border: 1px solid #fff;
                cursor: pointer;
                border-radius: 2px;
                color: #a18d6c;
                font-family: 'Exo', sans-serif;
                font-size: 16px;
                font-weight: 400;
                padding: 6px;
                margin-top: 10px;
            }

            .login button:hover{
                opacity: 0.6;
            }

            .login button:active{
                opacity: 0.3;
            }

            .login input[type=text]:focus{
                outline: none;
                border: 1px solid rgba(255,255,255,0.9);
            }

            .login input[type=password]:focus{
                outline: none;
                border: 1px solid rgba(255,255,255,0.9);
            }

            .login button:focus{
                outline: none;
            }

            ::-webkit-input-placeholder{
                color: rgba(255,255,255,0.6);
            }

            ::-moz-input-placeholder{
                color: rgba(255,255,255,0.6);
            </style>
        </style>
    </head>
    <body>
        <div class="body"></div>
        <div class="login">
        <h2 style="text-align: center;color: black">Thông tin chi tiết</h2>       
        <form action="demo.html"
              method="post" modelAttribute="stu" style="text-align: center">
            <h4 style="color:red ; text-align: center" >${errors}</h4>
            <div style="color: black;font-size: 150%">ID:</div>
            <c:set var="f" value="${stu}" ></c:set>
            <input value="${f.id}" name="id" style="text-align: center; height:30px" type="text" placeholder="Nhập id vào đây"/>   
            <br><br>
            <div style="color: black;font-size: 150%">Name:</div>
            <input value="${f.name}" name="name" style="text-align: center ; height:30px" type="text" placeholder="Nhập tên vào đây"/>
            <br><br>
            <div style="color: black;font-size: 150%">Description:</div>
            <input value="${f.decription}" name="decription" style="height:30px; text-align: center" type="text" placeholder="Nhập miêu tả vào đây"/>
            <br><br>
            <button type="submit" name="insert" >Insert</button>
            <button type="submit" name="update" >Update</button>
            <button type="submit" name="delete" >Delete</button>
            <button type="submit" >Reboot</button> 
             <% 
            %>
        </form>
                    
        
        <br><br>
        <hr><br>
                    
        <div>
        <form action="demo.html" method="post" modelAttribute="stu" >
            <input name="name1" placeholder="Nhập Name vào để kíêm tìm" type="text" />
            <button type="submit" name="find">Find</button>
        </form>
                        
        </div>
        
        <br>
        
        <table border="1" style="width:100% ">
            <tr style="background-color: white">
                <th style="color: red;height: 30px">ID</th>
                <th style="color: red;height: 30px">Name</th>
                <th style="color: red;height: 30px">Description</th>
                <th style="color: red;height: 30px">Option</th>
            </tr>
            <c:forEach var="a" items="${stus}">
                <tr>
                    <td style="text-align: center;height: 30px;color: black">${a.id}</td>
                    <td style="text-align: center;height: 30px;color: black">${a.name}</td>
                    <td style="text-align: center;height: 30px;color: black">${a.decription}</td>
                    <td style="text-align: center;height: 30px;color: black">
                        <a href="?edit&id=${a.id}"> Edit</a> ||
                        <a href="?delete&id=${a.id}"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
