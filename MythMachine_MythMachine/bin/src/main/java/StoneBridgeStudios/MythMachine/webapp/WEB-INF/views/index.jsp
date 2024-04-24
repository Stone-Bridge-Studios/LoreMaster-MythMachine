<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Welcome</title>
   <!-- Add some basic styling puple -->
   <style>
       body {
           font-family: Arial, sans-serif;
           margin: 0;
           padding: 0;
           background-color: #f4f4f4;
           text-align: center; /* Center align text by default */
       }
       .container {
           width: 80%;
           margin: auto; /* Center align the container */
           overflow: hidden; /* Clear floats */
       }
       header {
           background: #50b3a2;
           color: white;
           padding-top: 30px;
           min-height: 70px;
           border-bottom: #e8491d 3px solid;
       }
       header a {
           color: #ffffff;
           text-decoration: none;
           text-transform: uppercase;
           font-size: 16px;
       }
       header ul {
           padding: 0;
           list-style: none;
       }
       header li {
           float: left;
           display: inline;
           padding: 0 20px 0 20px;
       }
       header #branding {
           float: left;
       }
       header #branding h1 {
           margin: 0;
       }
       header nav {
           float: right;
           margin-top: 10px;
       }
       header .highlight, header .current a {
           color: #e8491d;
           font-weight: bold;
       }
       header a:hover {
           color: #ffffff;
           font-weight: bold;
       }
   </style>
   </head>
   <body>
   <header>
       <div class="container">
           <div id="branding">
               <h1><span class="highlight">Myth Machine</span> Web App</h1>
           </div>
           <nav>
               <ul>
                   <li class="current"><a href="index.jsp">Home</a></li>
                   <!--  Add more navigation links here -->
               </ul>
           </nav>
       </div>
   </header>
   
   <div class="container">
       <h2>${message}</h2>
       <!-- Add the image below -->
       <img src="<c:url value='/resources/images/my_image.jpg'/>" alt="My Image">
       <!-- Add more here -->
   </div>
   
   </body>
   </html>