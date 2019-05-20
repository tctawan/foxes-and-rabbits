package io.muzoo.ooc.ecosystems;

import java.util.List;

abstract public class Animal {

    protected int age;
    protected boolean alive;
    protected Location location;
    protected Field currentField;

    public Animal(){
        age = 0;
        alive = true;
    }

    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Check whether the rabbit is alive or not.
     *
     * @return true if the rabbit is still alive.
     */
    public boolean isAlive() {
        return this.alive;
    }

    public void setDead() {this.alive = false;}

    abstract public void act(Field updatedField, List newAnimals);
}
