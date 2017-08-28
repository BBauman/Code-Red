package com.brianmbauman.codered.core.ability;

import com.brianmbauman.codered.core.Target;

public class Uncloak implements Ability {
    private Target target;

    public Uncloak(Target target){
        this.target = target;
    }

    @Override
    public void execute() {
        if(!target.isTargetable()){
            target.setTargetable(true);
        }
    }
}
