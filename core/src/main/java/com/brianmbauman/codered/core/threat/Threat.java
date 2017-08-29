package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.Target;
import com.brianmbauman.codered.core.ship.Zone;

/**
 * This abstract class represents all internal and external threats to the space ship.
 *
 * Threats each possess 3 active abilities, and any number of passive abilities:
 * Active Abilities:
 * <ul>
 *     <li>Attack - Deal damage X to target(s) Y</li>
 *     <ul>
 *         <li>Attack may be penetrating - Damage bypasses shields</li>
 *         <li>Attack may be hull-rending - Damage that gets through shields is doubled</li>
 *     </ul>
 *     <li>Restore Health - Restore health X to target(s) Y</li>
 *     <li>Drain Health</li> - Remove health X to target(s) Y</li>
 *     <li>Drain Shield - Reduce target(s) X shields by value Y</li>
 *     <li>Restore Shield - Restore shield X to target(s) Y</li>
 *     <li>Set Shield - Set shield(s) X to value Y</li>
 *     <li>Uncloak - Removes all untargetable effects from target X</li>
 *     <li>Change Speed - Change speed of target(s) X by value Y</li>
 *     <li>Add Passive Ability - Adds a passive ability X to target Y</li>
 *     <li>Kill - Destroy target(s) X</li>
 *     <li>Delay - Delay target(s) X </li>
 *     <li>Knock Out - Knock out target(s) X</li>
 * </ul>
 *
 * Passive Abilities:
 * <ul>
 *     <li>Pulse vulnerable - Set shields to 0 when hit with pulse weapon, then return to normal next turn.</li>
 *     <li>Untargetable - Unable to be targeted by X weapon type(s) or while Y distance(s)</li>
 *     <li>Immune - Able to be targeted by X weapon type(s), but unable to be hit</li>
 *     <li>Invulnerability - Blocks all damage first X hit(s)</li>
 *     <li>Reinforce Weapons - Other threats X gain attack increase Y</li>
 *     <li>Reinforce Shields - Other threats X gain shield increase Y</li>
 *     <li>Hasten - Other threats X move Y tick(s) closer</li>
 *     <li>Deadswitch - On destruction, automatically launch attack with damage X against target(s) Y, possibly based on triggers passed</li>
 *     <li>Robust - Cannot take more than X damage per turn</li>
 *     <li>Revenge - On damage, automatically launch attack with damage X against target(s) Y</li>
 *     <li>Decoy - All weapons of type(s) X must target Y</li>
 *     <li>Absorbing - On damage by rocket, increase shield by X</li>
 *     <li>Point Defense - Takes more damage from interceptors, but knocks out pilot</li>
 * </ul>
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
    protected int shield;
    protected int distance;
    protected Trajectory trajectory;
    protected Zone target;

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

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int damageHealth(int damage) {
        if(damage > health){
            health = 0;
            return damage - health;
        } else{
            health -= damage;
            return 0;
        }
    }

    @Override
    public void healHealth(int healing) {
        health += healing;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public int damageShield(int damage) {
        if(damage > shield){
            shield = 0;
            return damage - shield;
        } else{
            shield -= damage;
            return 0;
        }
    }

    @Override
    public void healShield(int healing) {
        shield += healing;
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }
}
