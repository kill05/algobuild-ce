package com.github.kill05.algobuildce.package_a.c.a;

public final class ExecutionOptions {

    private boolean trace = true;
    private boolean step = true;
    private int clockSpeed = 500;

    public boolean isTraceEnabled() {
        return this.trace;
    }

    public void setTraceEnabled(boolean enabled) {
        this.trace = enabled;
    }

    public boolean isStepEnabled() {
        return this.step;
    }

    public void setStepEnabled(boolean enabled) {
        this.step = enabled;
    }

    public int getClockSpeed() {
        return this.clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = Math.min(10000, Math.max(1, clockSpeed));
    }
}
