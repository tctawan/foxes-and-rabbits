package io.muzoo.ooc.ecosystems;

import java.util.List;

abstract public class Actor {
    protected Field currentField;
    protected Location location;

    public Actor(Field field){
        this.currentField = field;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    abstract void act(Field updatedField, List<Actor> newActors);
    abstract boolean isActive();
}
