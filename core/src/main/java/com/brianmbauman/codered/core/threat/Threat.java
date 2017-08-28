package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.Target;

/**
 * This abstract class represents all internal and external threats to the space ship.
 */
public abstract class Threat implements Target {
    public enum Ability{
        X,
        Y,
        Z
    }

    protected String name;
    protected int speed;
    protected int health;
    protected int distance;
    protected Trajectory trajectory;

    public Threat(){
        this.trajectory = Trajectory.getRandom();
    }

    public void act(){
        distance -= speed;

        trajectory.getActions().forEach((triggerPoint, ability) -> {
            if(distance < triggerPoint){
                switch (ability){
                    case X:
                        abilityX();
                        break;
                    case Y:
                        abilityY();
                        break;
                    case Z:
                        abilityZ();
                }
            }
        });
    }

    protected abstract void abilityX();

    protected abstract void abilityY();

    protected abstract void abilityZ();
}
