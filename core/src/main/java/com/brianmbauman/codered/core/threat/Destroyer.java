package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.ability.Attack;

public class Destroyer extends Threat {
    @Override
    protected void abilityX() {
        new Attack(1, target, true).execute();
    }

    @Override
    protected void abilityY() {
        new Attack(2, target, true).execute();
    }

    @Override
    protected void abilityZ() {
        new Attack(2, target, true).execute();
    }

    @Override
    public boolean isTargetable() {
        return false;
    }

    @Override
    public void setTargetable(boolean isTargetable) {

    }
}
