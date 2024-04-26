
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>

<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
        <style>

            .bottom-nav {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 100%;
                background-color: #333;
                display: flex;
                justify-content: space-around;
                padding: 10px 0;
            }
        
            .bottom-nav button {
                background-color: #555;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
        
            .bottom-nav button:hover, .bottom-nav button.selected {
                background-color: #777;
            }
        
            .profile-nav {
                right: 30px;
                margin-top: -28px;
                position: fixed;
            }
        
            .container {
                margin-top: 90px;
                margin-bottom: 90px;
            }
        
            .character-name {
                text-align: center;
            }

            ul {
                list-style: none;
            }

            li {
                list-style: none;
            }
        
            .attribute-name-input {
                border-top-left-radius: 10px; 
                border-bottom-left-radius: 10px;
                background-color: #f0e6ff;
                border: 1px solid #9370db; 
                padding: 10px;
                color: #6a5acd; 
            }          

            .attribute-desc-input {
                background-color: #f0e6ff;
                border: 1px solid #9370db; 
                padding: 10px;
                color: #6a5acd;  
                margin-bottom: 12px;        
                width: 400px;      
            }             
 
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                position: relative; 
            }

            #add-button {
                position: absolute;
                bottom: -30px;
                left: 50%;
                transform: translateX(-50%); 
            }
                
            .x-button {
                background-color: #e74c3c;
                color: white;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                transition: background-color 0.3s ease;                
                border-top-right-radius: 10px; 
                border-bottom-right-radius: 10px;                                                   
            }

            #add-button {                
                width: 434px;
                display: flex;
                justify-content: center;
                align-items: center;                 
                position: absolute;
                bottom: -30px;
                left: 50%;                
                margin-top: 90px;
            }
         

        </style>
        
    </head>
    <body>

        <!-- Top Navbar -->
        <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/characters">LoreMaster | Sheet Attribute Editor</a>
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <div class="profile-nav">
                                <span>${userName}</span>
                                <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture" width="56" height="56"></a>
                            </div>
                        </li>
                    </ul>
            </div>
        </nav>       

        <div class="container">
             
            <div class="content-wrapper">
                <!-- Attributes Will Be Appended Here -->
                <ul id="attList">
                    <button id="add-button" class="btn btn-success" onclick="addAttribute()">Add Attribute</button>
                </ul>
            </div>
            
        </div>
        
        
    
        <div class="bottom-nav">
            <!--</a>-->
        </div>                
        
        <!-- Bottom Navbar -->
        <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
            <div class="bottom-nav">
                <a href="/sheets"><button>Back</button></a>
                <button onclick="saveAttributes()">Next</button>
            </div>
        </nav>           

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>        

        <script src="\js\sheetEditor.js"></script>

        <script>
            window.onload = function() {
                
                if ('${sheetTargetID}' != -1) {
                    loadExistingAttributes('${editAttributes}');
                }
            }
        </script>

    </body>
</html>