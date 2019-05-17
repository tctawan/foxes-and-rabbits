package io.muzoo.ooc.ecosystems;

public class Animal {

    protected int age;
    protected boolean alive;
    protected Location location;

    public Animal(){
        age = 0;
        alive = true;
    }
    
    public Location getLocation(){
        return this.location;
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
}
