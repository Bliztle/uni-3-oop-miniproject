package com.bliztle.uni.oop;

public class Room {
    private final String id;

    public Room(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Room) {
            Room room = (Room) obj;
            return id.equals(room.id);
        }
        return false;
    }
}
