package org.firstinspires.ftc.teamcode.microcmd;

import java.util.function.BooleanSupplier;

public class FullCmd extends Cmd {
    private final Runnable init;
    private final Runnable run;
    private final Runnable terminate;
    private final BooleanSupplier isFinished;

    public FullCmd(Runnable init, Runnable run, Runnable terminate, BooleanSupplier isFinished) {
        this.init = init;
        this.run = run;
        this.terminate = terminate;
        this.isFinished = isFinished;
    }

    @Override
    protected void init() {
        init.run();
    }

    @Override
    public void run() {
        run.run();
    }

    @Override
    public void terminate() {
        terminate.run();
    }

    @Override
    public boolean isFinished() {
        return isFinished.getAsBoolean();
    }
}
