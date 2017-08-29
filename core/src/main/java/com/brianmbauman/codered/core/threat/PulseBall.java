package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.ability.Attack;
import com.brianmbauman.codered.core.ship.Zone;

public class PulseBall extends Threat {
    @Override
    protected void abilityX() {
        for(Zone zone : Zone.values()){
            new Attack(1, zone).execute();
        }
    }

    @Override
    protected void abilityY() {
        for(Zone zone : Zone.values()){
            new Attack(1, zone).execute();
        }
    }

    @Override
    protected void abilityZ() {
        for(Zone zone : Zone.values()){
            new Attack(2, zone).execute();
        }
    }

    @Override
    public boolean isTargetable() {
        return false;
    }

    @Override
    public void setTargetable(boolean isTargetable) {

    }
}
