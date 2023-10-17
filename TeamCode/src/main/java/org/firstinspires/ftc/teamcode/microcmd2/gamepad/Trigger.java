package org.firstinspires.ftc.teamcode.microcmd2.gamepad;

import org.firstinspires.ftc.teamcode.microcmd2.Periodic;

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
