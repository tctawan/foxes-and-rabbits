package io.muzoo.ooc.ecosystems;

import java.util.List;
import java.util.Random;

abstract public class Animal extends Actor {

    protected int age;
    protected boolean alive;

    private static final Random rand = new Random();

    public Animal(Field field,boolean randomAge){
        super(field);
        age = 0;
        alive = true;
        if (randomAge) {
            age = rand.nextInt(getMaxAge());
        }
    }

    /**
     * Check whether the rabbit is alive or not.
     *
     * @return true if the rabbit is still alive.
     */
    public boolean isActive(){return isAlive();}
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

    public void giveBirth(int births, Field updatedField, List newAnimals){
        for (int b = 0; b < births; b++) {
            Animal newAnimal = createNewAnimal(updatedField, false);
            newAnimals.add(newAnimal);
            Location loc = updatedField.randomAdjacentLocation(location);
            newAnimal.setLocation(loc);
            updatedField.place(newAnimal, loc);
        }
    }

    abstract public Animal createNewAnimal(Field field , boolean randomAge);
    abstract public int getMaxAge();
    abstract public  double getBreedingProp();
    abstract public int getMaxLitterSize();
    abstract public  int getBreedingAge();
}
