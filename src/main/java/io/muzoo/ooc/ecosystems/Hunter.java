package io.muzoo.ooc.ecosystems;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Actor {
    private static final int EXPECTED_KILLS = 8;
    private boolean active = true;

    public Hunter(Field field){
        super(field);
    }

    public void act(Field updatedField){
        act(updatedField, null);
    }
    public void act(Field updatedField, List newActor){
        int kills = 0;
        if (active) {
            // New foxes are born into adjacent locations.
            // Move towards the source of food if found.
            kills += hunt(currentField, location);
            if (kills < EXPECTED_KILLS) {  // no food found - move randomly
                Location newLocation = updatedField.freeAdjacentLocation(location);
                if(newLocation != null) {
                    setLocation(newLocation);
                    updatedField.place(this, newLocation);
                }
            }else{
                active = false;
            }
            currentField = updatedField;
        }
    }

    public int hunt(Field field, Location location){
        int kills = 0;
        Iterator adjacentLocations = field.adjacentLocations(location);
        while (adjacentLocations.hasNext()) {
            Location where = (Location) adjacentLocations.next();
            Object object = field.getObjectAt(where);
            if(object instanceof Animal){
                Animal animal = (Animal) object;
                if(animal.isAlive()){
                    kills++;
                    animal.setDead();
                }
            }
        }
        return kills;
    }
    public boolean isActive() { return active; }
}
