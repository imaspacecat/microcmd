package org.firstinspires.ftc.teamcode.microcmd2;

import java.util.function.BooleanSupplier;

public class IfCmd extends FullCmd {
    public IfCmd(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        super(() -> {}, () -> {
            if (event.getAsBoolean()) {
                Scheduler.schedule(cmd);
            }
        }, () -> {}, isFinished
        );
    }
}
