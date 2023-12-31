package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import org.firstinspires.ftc.teamcode.microcmd.Periodic;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class Trigger extends Button {
    private final DoubleSupplier value;

    public Trigger(DoubleSupplier value, double threshold) {
        super(() -> value.getAsDouble() > threshold);
        this.value = value;
    }

    public Trigger(DoubleSupplier value) {
        this(value, 0.5);
    }

    public void setThreshold(double threshold) {
        setEvent(() -> value.getAsDouble() > threshold);
    }

    public DoubleSupplier getValue() {
        return value;
    }

    // TODO implement hysteresis https://en.wikipedia.org/wiki/Hysteresis

}
