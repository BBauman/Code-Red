package com.brianmbauman.codered.core.ability;

import com.brianmbauman.codered.core.Target;

public class DrainShield implements Ability {
    private Target target;

    public DrainShield(Target target){
        this.target = target;
    }

    @Override
    public void execute() {
        target.damageShield(target.getShield());
    }
}
