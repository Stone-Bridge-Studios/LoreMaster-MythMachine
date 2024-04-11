
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>

<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\style.css">
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
            }
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
            .bottom-nav button:hover,
            .bottom-nav button.selected {
                background-color: #777;
            }
            .center-buttons {
                display: flex;
                justify-content: center;
                align-items: center;
            }    
        </style>
        
    </head>
    <body>

        <header>
            <nav>
              <div class="logo">
                <img src="\images\loremaster_icon.jpg" alt="App Logo">
                <span>LoreMaster Character Creator | Sheet Attribute Editor</span>
              </div>
              <div class="profile-icon">
                <span>${userName}</span>
                <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture"></a>
              </div>
            </nav>
          </header>        

        <div>
            <!-- Attributes Will Be Appended Here -->
            <ul id="attList">
                
            </ul>            
        </div>
        

        <button onclick="addAttribute()">Add Attribute</button>
    
        <div class="bottom-nav">
            <a href="/sheets"><button>Back</button></a>
            <button onclick="saveAttributes()">Next</button>
            <!--</a>-->
        </div>                
        
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