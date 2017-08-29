package com.brianmbauman.codered.core.ability;

import com.brianmbauman.codered.core.Target;

public class Heal implements Ability{
    private int power;
    private Target target;

    public Heal(int power, Target target){
        this.power = power;
        this.target = target;
    }

    @Override
    public void execute() {
        target.healHealth(power);
    }
}
