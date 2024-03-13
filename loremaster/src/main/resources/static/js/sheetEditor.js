// Editing Character Sheet Attributes with AJAX

function addAttribute() {

    var attributeCount = document.getElementById("attList").getElementsByTagName('li').length;
    var listItem = document.createElement("li");

    // Attribute Name Texbox
    var nameTextBox = document.createElement("input");
    nameTextBox.id = "name";
    nameTextBox.type = "text";
    nameTextBox.value = "New Attribute";

    // Attribute Desc Texbox
    var descTextBox = document.createElement("input");
    descTextBox.id = "desc";
    descTextBox.type = "text";
    descTextBox.value = "An attribute to describe a character";    

    // Delete Attribute Button
    var deleteAttributeButton = document.createElement("button");
    deleteAttributeButton.textContent = "Delete";
    deleteAttributeButton.id = attributeCount.toString();
    deleteAttributeButton.onclick = deleteAttribute;

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

    // Get Attribute Names
    var names = [];
    for (var i = 0; i < items.length; i++) {
        if (items[i].id == "name") names.push(items[i].value);
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
            name : names[i],
            desc : descs[i]
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