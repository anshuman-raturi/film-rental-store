package com.cg.films.dto;

public class ActorDTO {
    private Long actorId;
    private String fullName;
 
    public ActorDTO(Long actorId, String fullName) {
        this.actorId = actorId;
        this.fullName = fullName;
    }
    public Long getActorId() {
        return actorId;
    }
    public String getFullName() {
        return fullName;
    }
}