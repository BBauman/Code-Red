package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.ability.Attack;
import com.brianmbauman.codered.core.ability.Heal;

public class ArmoredGrappler extends Threat{
    @Override
    protected void abilityX() {
        new Attack(1, target).execute();
    }

    @Override
    protected void abilityY() {
        new Heal(1, this).execute();
    }

    @Override
    protected void abilityZ() {
        new Attack(4, target).execute();
    }

    @Override
    public boolean isTargetable() {
        return false;
    }

    @Override
    public void setTargetable(boolean isTargetable) {

    }
}
