package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.ability.Attack;

public class Fighter extends Threat {
    @Override
    protected void abilityX() {
        new Attack(1, target).execute();
    }

    @Override
    protected void abilityY() {
        new Attack(2, target).execute();
    }

    @Override
    protected void abilityZ() {
        new Attack(3, target).execute();
    }

    @Override
    public boolean isTargetable() {
        return false;
    }

    @Override
    public void setTargetable(boolean isTargetable) {

    }
}
