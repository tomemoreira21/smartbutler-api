package com.ai.dto;

public class ChatRequestDTO {
    private Integer utilizadorId;
    private String message;

    public ChatRequestDTO(Integer id, String message) {
        this.utilizadorId = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

     public Integer getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(Integer utilizadorID) {
        this.utilizadorId = utilizadorID;
    }



    
}
