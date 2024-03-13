package com.stonebridge.loremaster.model.DTO;

public class AttributeDTO {
    private String name;
    private String desc;

    public AttributeDTO(int inputIndex, String inputName, String inputDesc) {
        name = inputName;
        desc = inputDesc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void setDesc(String inputDesc) {
        desc = inputDesc;
    }

}
