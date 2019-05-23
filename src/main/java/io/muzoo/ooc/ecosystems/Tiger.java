package io.muzoo.ooc.ecosystems;

public class Tiger extends Predator{
    private static final int BREEDING_AGE = 10;
    private static final int MAX_AGE = 180;
    private static final double BREEDING_PROBABILITY = 0.05;
    private static final int MAX_LITTER_SIZE = 1;
    private static final int RABBIT_FOOD_VALUE = 3;
    private static final int FOX_FOOD_VALUE = 5;

    public Tiger(Field field,boolean randomAge) {
        super(field,randomAge);
    }


    public Tiger createNewAnimal(Field field, boolean randomAge){return new Tiger(field,randomAge);}
    public int getMaxAge(){return MAX_AGE;}
    public double getBreedingProp(){return  BREEDING_PROBABILITY;}
    public int getMaxLitterSize(){return MAX_LITTER_SIZE;}
    public int getBreedingAge() { return BREEDING_AGE; }
    public int getRabbitFoodValue(){return RABBIT_FOOD_VALUE;}
    public int getFoxFoodValue(){return FOX_FOOD_VALUE;}

}
