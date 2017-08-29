package com.brianmbauman.codered.core.threat;

import com.brianmbauman.codered.core.ability.Attack;

public class Gunship extends Threat {

    public Gunship(){
        this.speed  = 2;
        this.health = 5;
        this.shield = 2;
    }
    @Override
    protected void abilityX() {
       new Attack(2, target).execute();
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
