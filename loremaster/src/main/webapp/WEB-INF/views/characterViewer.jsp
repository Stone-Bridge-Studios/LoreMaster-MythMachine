<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>

<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
    </head>
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
            margin-top: 120px;
            margin-bottom: 190px;
        }
    
        .character-name {
            text-align: center;
        }
    
        .profile-pic-container {
            position: relative;
            display: inline-block;
        }
    
        .edit-pic-btn {
            position: absolute;
            top: 3px;
            left: 120px;
        }    
        
        ul {            
            list-style: none;
            text-align: center;
            margin-right: 28px;
            font-size: 24px;
        }
       

    </style>
    </head>
<body>

    <!-- Top Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/characters">LoreMaster | Viewing ${characterName}</a>
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


    <!-- Character View Card, Claude AI used to improve -->
    <div class="container mt-20">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">${characterName}</h2>
                    </div>
                    <div class="card-body text-center">                        
                        <div class="profile-pic-container">
                            <img src="\images\character.jpg" alt="Character Image">
                            <button class="btn btn-sm btn-primary edit-pic-btn">Edit Picture</button>
                        </div>

                         

                        <div class="row justify-content-center mt-4">
                        </div>
                    </div>
                        <!-- Character Attributes Will Be Displayed Here -->
                        <ul id="charAttList">
            
                        </ul>                        
                </div>
            </div>
        </div>
    </div>    


    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <a href="/characters"><button>Back</button></a>
        </div>
    </nav>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>        

    <script>

        // Get the character & sheet attributes to display
        var sheetAttributes = JSON.parse('${characterSheetAttributes}');
        var characterAttributes = JSON.parse('${characterAttributes}');

        // Append to <ul>
        for (var i = 0; i < sheetAttributes.length; i++) {
            appendDisplayAtt(sheetAttributes[i],characterAttributes[i]);
        }

        function appendDisplayAtt(sheetAtt,charAtt) {

            var displayItem = document.createElement("li");                        
            var displayText = document.createElement("p");
            displayText.innerHTML = restoreQuotes(sheetAtt.name) + " : " + restoreQuotes(charAtt.ca_value);
            displayItem.appendChild(displayText);

            document.getElementById("charAttList").appendChild(displayItem);
        }

        function restoreQuotes(str) {
            return str.replace(/@/g, "'").replace(/%/g, '"');
        }        

    </script>

</body>
</html>