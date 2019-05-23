package io.muzoo.ooc.ecosystems;

/**
 * A simple model of a fox.
 * Foxes age, move, eat rabbits, and die.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2002.10.28
 */
public class Fox extends Predator {
    private static final int BREEDING_AGE = 10;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.09;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 4;
    // A shared random number generator to control breeding.
    // Individual characteristics (instance fields).

    // The fox's food level, which is increased by eating rabbits.

    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with random age.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     */
    public Fox(Field field,boolean randomAge) {
        super(field,randomAge);
        currentField = field;
    }

    public Fox createNewAnimal(Field field, boolean randomAge){return new Fox(field,randomAge);}
    public int getMaxAge(){return MAX_AGE;}
    public double getBreedingProp(){return  BREEDING_PROBABILITY;}
    public int getMaxLitterSize(){return MAX_LITTER_SIZE;}
    public int getBreedingAge() { return BREEDING_AGE; }
    public int getRabbitFoodValue(){return RABBIT_FOOD_VALUE;}
    public int getFoxFoodValue(){return 0;}
}
