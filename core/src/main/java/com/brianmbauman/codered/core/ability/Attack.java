package com.brianmbauman.codered.core.ability;

import com.brianmbauman.codered.core.Target;

public class Attack implements Ability{
    private int power;
    private Target target;
    private boolean healthStrong;

    public Attack(int power, Target target){
        this(power, target, false);
    }

    public Attack(int power, Target target, boolean healthStrong){
        this.power          = power;
        this.target         = target;
        this.healthStrong   = healthStrong;
    }

    @Override
    public void execute(){
        if(target.isTargetable()){
            int remainingDamage = target.damageShield(power);

            if(healthStrong){
                remainingDamage *= 2;
            }

            target.damageHealth(remainingDamage);
        }
    }
}
