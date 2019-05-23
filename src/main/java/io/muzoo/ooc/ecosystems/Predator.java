package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

abstract public class Predator extends Animal {

    private static final Random rand = new Random();
    private int foodLevel;

    public Predator(Field field,boolean randomAge){
        super(field,randomAge);
        if (randomAge) {
            foodLevel = rand.nextInt(getRabbitFoodValue());
        } else {
            foodLevel = getRabbitFoodValue();
        }
    }

    public void act(Field updatedField, List newFoxes) {
        incrementAge();
        incrementHunger();
        if (alive) {
            // New foxes are born into adjacent locations.
            int births = breed();
            giveBirth(births,updatedField,newFoxes);
            // Move towards the source of food if found.
            Location newLocation = findFood(currentField, location);
            if (newLocation == null) {  // no food found - move randomly
                newLocation = updatedField.freeAdjacentLocation(location);
            }
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                // can neither move nor stay - overcrowding - all locations taken
                alive = false;
            }
            currentField = updatedField;
        }
    }

    private Location findFood(Field field, Location location) {
        Iterator adjacentLocations = field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = getRabbitFoodValue();
                    return where;
                }
            }else if (animal instanceof Fox && this instanceof Tiger) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = getFoxFoodValue();
                    return where;
                }
            }
        }
        return null;
    }



    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            alive = false;
        }
    }

    abstract public int getRabbitFoodValue();
    abstract public int getFoxFoodValue();
}
