<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
    <title>LoreMaster Character Creator</title>
    <link rel="stylesheet" type="text/css" href="\css\style.css">
</head>
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

    #attributeName {
        display: block; /* Ensures each paragraph is on its own line */
        margin-bottom: 0; /* Removes default bottom margin */
    }

    #attributeDesc {
        display: block;
        margin-top: 0; /* Removes default top margin */
    }    

</style>
</head>
<body>

    <header>
        <nav>
          <div class="logo">
            <img src="\images\loremaster_icon.jpg" alt="App Logo">
            <span>LoreMaster Character Creator | Character Editor</span>
          </div>
          <div class="profile-icon">
            <span>${userName}</span>
            <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture"></a>
          </div>
        </nav>
      </header>    

    <h1 id="attributeName">Attribute Name:</h1>
    <h3 id="attributeDesc">This attribute is very attribute.</h3>

    <textarea id="attTextBox" rows="4" cols="50"></textarea>

    <div class="bottom-nav">
        <button id="cycleBack">Back</button>
        <button id="cycleNext">Next</button>
    </div>

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
                    ca_value : "Enter character value",
                    characterName : "" // Overwrite all when saving
                }            
                characterAttributes.push(ca);
            }
            
        }

        var characterName = '${characterName}';

        // Create Index for cycling through sheet attributes
        var aIndex = 0;

        // Add Button Listeners
        var cycleNextButton = document.getElementById("cycleNext");
        var cycleBackButton = document.getElementById("cycleBack");             
        cycleNextButton.addEventListener("click", function() {
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
            attName.innerHTML = sheetAttributes[aIndex].name;
            attDesc.innerHTML = sheetAttributes[aIndex].desc;

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
                characterAttributes[i].characterName =  attTextBox.value;
            }

            // Send List of Attributes
            xhr.send(JSON.stringify(characterAttributes));
            
            // Redirect to Finalization
            window.location.href = "/characters";

        }
 
    </script>

</body>
</html>