package io.muzoo.ooc.ecosystems;

import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2002.10.28
 */
public class Rabbit extends Animal {
    // Characteristics shared by all rabbits (static fields).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 50;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.15;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 5;
    // A shared random number generator to control breeding.
    private static final Random rand = new Random();

    // Individual characteristics (instance fields).


    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     *
     * @param randomAge If true, the rabbit will have a random age.
     */
    public Rabbit(Field field,boolean randomAge) {
        super(field,randomAge);
    }

    /**
     * This is what the rabbit does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     *
     * @param updatedField The field to transfer to.
     * @param newRabbits   A list to add newly born rabbits to.
     */
    public void act(Field updatedField, List newRabbits) {
        incrementAge();
        if (alive) {
            int births = breed();
            giveBirth(births,updatedField,newRabbits);
            Location newLocation = updatedField.freeAdjacentLocation(location);
            // Only transfer to the updated field if there was a free location
            if (newLocation != null) {
                setLocation(newLocation);
                updatedField.place(this, newLocation);
            } else {
                // can neither move nor stay - overcrowding - all locations taken
                alive = false;
            }
        }
    }

    public Rabbit createNewAnimal(Field field, boolean randomAge){return new Rabbit(field,randomAge);}
    public int getMaxAge(){return MAX_AGE; }
    public double getBreedingProp(){return  BREEDING_PROBABILITY;}
    public int getMaxLitterSize(){return MAX_LITTER_SIZE;}
    public int getBreedingAge() { return BREEDING_AGE; }


}
