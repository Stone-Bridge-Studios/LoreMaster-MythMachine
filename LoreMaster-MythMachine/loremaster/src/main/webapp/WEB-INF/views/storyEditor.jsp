<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
    <title>MythMachine</title>
    <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
    <script src="storyEditor.js"></script>
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
        margin-top: 90px;
        margin-bottom: 90px;
    }

    .character-name {
        text-align: center;
    }

    .container {
        display: flex;
        
        justify-content: center;
        align-items: center;
        position: relative; 
        text-align: center;
    }

    #title {
        width: 300px;
        text-align: center;
    }

    textarea {
        border-radius: 20px;
        background-color: #f0e6ff;
        border: 1px solid #9370db; 
        padding: 10px;
        color: #6a5acd;       
        width: fit-content;
        font-size: 30px;
    }

    .suggestion-button {
        width: fit-content;
        color: #6a5acd;      
        border: 2px solid #9370db; 
        background-color: #f0e6ff;
        border-radius: 20px;  
        font-size: 21px;
        margin-bottom: 10px;
        margin-right: 20px;
    }


</style>
</head>
<body>

    <!-- Top Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/stories">MythMachine | Story Editor</a>
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

<!-- Genre Card -->
<div class="container">
    <div class="card text-white bg-dark mb-3" style="max-width: 20rem;">
        <div class="card-header">Enter any Genre here: </div>
        <div class="card-body">
            <input type="text" id="genre-box" placeholder="Genre">
            <button onclick="generateStory()">Generate</button>
            <button id="LM-buttom" onclick="useLMchar()">Use LM</button>
        </div>
        <p id="loading-tag"></p>
    </div>
</div>


    <!-- Story Textbox Card -->
    <div class="container">
        <div class="card text-white bg-primary mb-3" style="min-width: 70rem; min-height: 40rem;">
            <div class="card-header"><h1>Your Story: </h1></div><br>
            <div class="card-body">               
                <textarea id="storyTextBox" rows="9" cols="55" placeholder="Generate a story to begin"></textarea>
            </div>
        </div>      
    </div>   

    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <a href="/stories"><button class="selected">Stories</button></a>
        </div>
    </nav>

    
    <script src="\js\claudeAI.js"></script>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>    

</body>
</html>