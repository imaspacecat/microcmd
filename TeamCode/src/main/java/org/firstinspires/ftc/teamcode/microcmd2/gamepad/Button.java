package org.firstinspires.ftc.teamcode.microcmd2.gamepad;

import org.firstinspires.ftc.teamcode.microcmd2.Cmd;
import org.firstinspires.ftc.teamcode.microcmd2.IfCmd;
import org.firstinspires.ftc.teamcode.microcmd2.Periodic;
import org.firstinspires.ftc.teamcode.microcmd2.Scheduler;

import java.util.function.BooleanSupplier;

import static org.firstinspires.ftc.teamcode.microcmd2.gamepad.Button.ButtonState.*;


public class Button implements Periodic {
    private final BooleanSupplier event;
    protected boolean isDown = false;
    protected boolean wasDown = false;
    protected ButtonState currentState = NONE;
    protected ButtonState previousState = NONE;

    public Button(BooleanSupplier event) {
        this.event = event;
    }

    enum ButtonState {
        NONE, HELD, PRESSED, RELEASED, PRESSED_AND_RELEASED
    }

    @Override
    public void update() {
        wasDown = isDown;
        isDown = event.getAsBoolean();

        if (isDown && wasDown) {
            currentState = HELD;
        } else if (isDown) {
            currentState = PRESSED;
        } else if (wasDown) {
            currentState = RELEASED;
        } else if (previousState == PRESSED && currentState == RELEASED) {
            currentState = PRESSED_AND_RELEASED;
        } else {
            currentState = NONE;
        }

        previousState = currentState;
    }

    public void scheduleIf(Cmd cmd, BooleanSupplier event) {
        Scheduler.schedule(new IfCmd(cmd, event, () -> false));
    }

    public BooleanSupplier held() {
        return () -> currentState == HELD;
    }

    public void held(Cmd cmd) {
        scheduleIf(cmd, held());
    }

    public BooleanSupplier pressed() {
        return () -> currentState == PRESSED;
    }

    public void pressed(Cmd cmd) {
        scheduleIf(cmd, pressed());
    }

    public BooleanSupplier released() {
        return () -> currentState == RELEASED;
    }

    public void released(Cmd cmd) {
        scheduleIf(cmd, released());
    }

    public BooleanSupplier pressedAndReleased() {
        return () -> currentState == PRESSED_AND_RELEASED;
    }

    public void pressedAndReleased(Cmd cmd) {
        scheduleIf(cmd, pressedAndReleased());
    }
}