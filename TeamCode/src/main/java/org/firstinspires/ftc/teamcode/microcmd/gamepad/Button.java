package org.firstinspires.ftc.teamcode.microcmd.gamepad;

import org.firstinspires.ftc.teamcode.microcmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Periodic;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;


import java.util.function.BooleanSupplier;

import static org.firstinspires.ftc.teamcode.microcmd.gamepad.Button.ButtonState.*;


public class Button implements Periodic {
    private final BooleanSupplier event;
    private boolean isDown = false;
    private boolean wasDown = false;
    private ButtonState currentState = NONE;
    private ButtonState previousState = NONE;

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

    public BooleanSupplier held() {
        return () -> currentState == HELD;
    }

    public void held(Cmd cmd) {
        Scheduler.scheduleIf(cmd, held());
    }

    public BooleanSupplier pressed() {
        return () -> currentState == PRESSED;
    }

    public void pressed(Cmd cmd) {
        Scheduler.scheduleIf(cmd, pressed());
    }

    public BooleanSupplier released() {
        return () -> currentState == RELEASED;
    }

    public void released(Cmd cmd) {
        Scheduler.scheduleIf(cmd, released());
    }

    public BooleanSupplier pressedAndReleased() {
        return () -> currentState == PRESSED_AND_RELEASED;
    }

    public void pressedAndReleased(Cmd cmd) {
        Scheduler.scheduleIf(cmd, pressedAndReleased());
    }
}