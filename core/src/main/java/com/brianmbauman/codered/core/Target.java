package com.brianmbauman.codered.core;

public interface Target {
    int getHealth();

    /**
     * Reduces health by damage until depleted.
     * If there is leftover damage, the amount is returned just in case the attack needs to know about overkill.
     *
     * @return Remaining damage that attack may apply to health.
     */
    int damageHealth(int damage);

    int healHealth(int healing);

    int getShield();

    /**
     * Reduces shield by damage until depleted.
     * If there is leftover damage, the amount is returned so the attack may then apply it to health.
     *
     * @return Remaining damage that attack may apply to health.
     */
    int damageShield(int damage);

    int healShield(int healing);

    boolean isDestroyed();

    boolean isTargetable();

    void setTargetable(boolean isTargetable);
}
