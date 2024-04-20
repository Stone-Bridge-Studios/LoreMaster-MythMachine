

// Editing Character Sheet Attributes with AJAX
function addAttribute(attributeID="-1",name="",desc="") {

    var attributeCount = document.getElementById("attList").getElementsByTagName('li').length;
    var listItem = document.createElement("li");

    // Attribute Name Texbox
    var nameTextBox = document.createElement("input");
    nameTextBox.id = "name";
    nameTextBox.type = "text";
    nameTextBox.value = name;
    nameTextBox.setAttribute("autocomplete","off");
    nameTextBox.className = "attribute-name-input";
    nameTextBox.placeholder = "Attribute Name"

    // Store Attribute ID
    nameTextBox.setAttribute("attributeID",attributeID)

    // Attribute Desc Texbox
    var descTextBox = document.createElement("input");
    descTextBox.id = "desc";
    descTextBox.type = "text";
    descTextBox.value = desc;
    descTextBox.setAttribute("autocomplete","off");
    descTextBox.className = "attribute-desc-input";
    descTextBox.placeholder = "An attribute to describe a character"

    // Delete Attribute Button
    var deleteAttributeButton = document.createElement("button");
    deleteAttributeButton.textContent = "X";
    deleteAttributeButton.id = attributeCount.toString();
    deleteAttributeButton.onclick = deleteAttribute;
    deleteAttributeButton.className = "x-button"

    // Add Items to unordred list
    listItem.appendChild(nameTextBox);
    listItem.appendChild(descTextBox);
    listItem.appendChild(deleteAttributeButton);

    // Add Texbox Attribute to List
    document.getElementById("attList").appendChild(listItem);

}

function deleteAttribute() {    
    var li = this.parentNode;
    li.parentNode.removeChild(li);
}

function saveAttributes() {

    var items = document.getElementById("attList").getElementsByTagName('input');

    // Get Attribute Names & IDs
    var names = [];
    var attributeIDs = [];
    for (var i = 0; i < items.length; i++) {
        if (items[i].id == "name") {
            names.push(items[i].value);
            attributeIDs.push(items[i].getAttribute("attributeID"));
        }
    }

    // Get Attribute Descriptions
    var descs = [];
    for (var i = 0; i < items.length; i++) {
        if (items[i].id == "desc") descs.push(items[i].value);
    }
    
    // Pack Attributes into list
    var attributeList = [];
    for (var i = 0; i < names.length; i++) {
        var attribute = {
            attributeID : attributeIDs[i],
            name : replaceQuotes(names[i]),
            desc : replaceQuotes(descs[i])
        }        
        attributeList.push(attribute);
    }

    // Update Server-Side Session List
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/saveAttributes", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    // Send List of Attributes
    xhr.send(JSON.stringify(attributeList));

    // Redirect to Finalization
    window.location.href = "/createSheetFinalization";

}

function loadExistingAttributes(existingAttributes) {
    
    var attributes = JSON.parse(existingAttributes);
    for (var i = 0; i < attributes.length; i++) {        
        addAttribute(attributes[i].attributeID,restoreQuotes(attributes[i].name),restoreQuotes(attributes[i].desc));
    }

}

function replaceQuotes(str) {
    return str.replace(/'/g, '@').replace(/"/g, '%');
}

function restoreQuotes(str) {
    return str.replace(/@/g, "'").replace(/%/g, '"');
}


