package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import org.firstinspires.ftc.teamcode.microcmd.Periodic;

import java.util.function.DoubleSupplier;

public class Trigger implements Periodic {
    private final DoubleSupplier value;

    public Trigger(DoubleSupplier value) {
        this.value = value;
    }

    @Override
    public void update() {

    }
}
