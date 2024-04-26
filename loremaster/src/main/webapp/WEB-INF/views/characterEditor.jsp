<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="\css\dotspin.css">
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
            <a class="navbar-brand" href="/characters">LoreMaster | Character Attribute Editor</a>
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

    

    <!-- Attribute Card -->
    <div class="container">
        <div class="card text-white bg-primary mb-3" style="min-width: 70rem; min-height: 40rem;">
            <div class="card-header"><h1 id="attributeName">Attribute Name:</h1></div><br>
            <h4 id="attributeDesc" class="card-title">Primary card title</h4>
            <div class="card-body">               
                <textarea id="attTextBox" rows="9" cols="55" placeholder="Enter character attribute value"></textarea>
            </div>
        </div>      
    </div>     

    <!-- AI Suggestions Card -->
    <div class="container">        
        <div class="card text-white bg-primary mb-3" style="min-width: 70rem; min-height: 12rem;">
            <div class="card-header"><h4 id="ai-card-title">AI Suggestions</h4></div>
                <div class="row row-cols-auto justify-content-center">                                        
                    <div class="col">
                        <div style="margin-top: 22px;">     
                        <div id="card-box">
                            <button class="btn btn-sm btn-secondary" onclick="getAISuggestions()">Generate AI Suggestions</button>
                        </div>                                                                                 
                            <ul id="suggestion-box">

                            </ul>
                        </div>                                                    
                    </div>                                          
                </div>
            </div>                
        </div>   
    </div>  

    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <button id="cycleBack">Back</button>
            <button id="cycleNext">Next</button>
        </div>
    </nav>    

    <!-- AI Communications -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="\js\claudeAI.js"></script>

    <script>

        // Create List for selected Sheet's Attributes
        var sheetAttributes = JSON.parse('${characterSheetAttributes}');

        // Create List for Populated Attributes (Character Attributes)
        var characterAttributes = ('${characterAttributes}' == "-1") ? [] : JSON.parse('${characterAttributes}');
        
        if ((characterAttributes.length === 0)) {

            for (var i = 0; i < sheetAttributes.length; i++) { // TODO Add editing of existing characters here
                var ca = {
                    characterID : "-1", // Overwrite when saving to DB
                    attributeID : sheetAttributes[i].attributeID,
                    ca_value : "",
                    characterName : "" // Overwrite all when saving
                }            
                characterAttributes.push(ca);
            }
            
        }
        else {
            for (var i = 0; i < characterAttributes.length; i++) { 
                characterAttributes[i].ca_value = restoreQuotes(characterAttributes[i].ca_value);
            }            
        }

        var characterName = restoreQuotes('${characterName}');

        // Create Index for cycling through sheet attributes
        var aIndex = 0;

        // Add Button Listeners
        var cycleNextButton = document.getElementById("cycleNext");
        var cycleBackButton = document.getElementById("cycleBack");             
        cycleNextButton.addEventListener("click", function() {
            clearSuggestionButtons()
            restoreGenerateButton()
                if (currentEditor == "attribute") {
                    if (aIndex >= sheetAttributes.length - 1) {
                        editCharacterAttribute()
                        toCharacterFinalization()
                    }
                    else {
                        editCharacterAttribute()
                        aIndex++;
                        console.log(aIndex);
                        updateAttributeDisplay();
                    }
                }
                else {
                    saveCharacter();
                }
            });

        cycleBackButton.addEventListener("click", function() {
            clearSuggestionButtons()
            restoreGenerateButton()
            if (currentEditor == "attribute") {
                if (aIndex <= 0) {
                    editCharacterAttribute()
                    window.location.href = "/createCharacterSelectSheet";
                }
                else {
                    editCharacterAttribute()
                    aIndex--;
                    console.log(aIndex);
                    updateAttributeDisplay();
                }            
            }
            else {
                var attTextBox = document.getElementById("attTextBox");
                characterName = attTextBox.value;
                toCAttributeEditor();                    
            }
        });        

        // Start in attribute editor
        var currentEditor = ""
        toCAttributeEditor()

        function updateAttributeDisplay() {
            
            var attName = document.getElementById("attributeName");
            var attDesc = document.getElementById("attributeDesc");
            attName.innerHTML = restoreQuotes(sheetAttributes[aIndex].name);
            attDesc.innerHTML = restoreQuotes(sheetAttributes[aIndex].desc);

            var attTextBox = document.getElementById("attTextBox");
            attTextBox.value = characterAttributes[aIndex].ca_value;
        }

        function editCharacterAttribute() {
            var attTextBox = document.getElementById("attTextBox");
            // Edit Content
            characterAttributes[aIndex].ca_value = attTextBox.value;                        
        }

        function toCAttributeEditor() {
            // Alters the page to the attribute editor interface
            currentEditor = "attribute";

            // Get cycle button elements
            var cycleNextButton = document.getElementById("cycleNext");           
            cycleNextButton.innerHTML = "Next";
            updateAttributeDisplay();         

        }

        function toCharacterFinalization() {
            // Alters the page to the character finalization interface
            currentEditor = "finalization"

            // Headers & Textbox
            var attName = document.getElementById("attributeName");
            var attDesc = document.getElementById("attributeDesc");
            attName.innerHTML = "Enter Your Character's Name";
            attDesc.innerHTML = "You can change it later!";
            
            // Textbox
            attTextBox.value = characterName;

            // Button
            var cycleNextButton = document.getElementById("cycleNext");                        
            cycleNextButton.innerHTML = "Finish";

        }

        function saveCharacter() {
            // Update Server-Side Session List
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/saveCharacter", true);
            xhr.setRequestHeader("Content-Type", "application/json");

            var attTextBox = document.getElementById("attTextBox");
            
            // Update Character Names
            for (var i = 0; i < characterAttributes.length; i++) { // TODO Add editing of existing characters here
                characterAttributes[i].ca_value = replaceQuotes(characterAttributes[i].ca_value);
                characterAttributes[i].characterName =  attTextBox.value;
            }

            // Send List of Attributes
            xhr.send(JSON.stringify(characterAttributes));
            
            // Redirect to Finalization
            window.location.href = "/characters";

        }
 
        function replaceQuotes(str) {
            return str.replace(/'/g, '@').replace(/"/g, '%');
        }

        function restoreQuotes(str) {
            return str.replace(/@/g, "'").replace(/%/g, '"');
        }        

    </script>

</body>
</html>