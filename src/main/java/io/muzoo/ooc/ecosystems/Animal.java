package io.muzoo.ooc.ecosystems;

import java.util.List;
import java.util.Random;

abstract public class Animal {

    protected int age;
    protected boolean alive;
    protected Location location;
    protected Field currentField;
    private static final Random rand = new Random();


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

    public boolean canBreed() {
        return age >= getBreedingAge();
    }

    public int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= getBreedingProp()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    public void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            alive = false;
        }
    }

    abstract public int getMaxAge();
    abstract public  double getBreedingProp();
    abstract public int getMaxLitterSize();
    abstract public  int getBreedingAge();

    abstract public void act(Field updatedField, List newAnimals);
}
