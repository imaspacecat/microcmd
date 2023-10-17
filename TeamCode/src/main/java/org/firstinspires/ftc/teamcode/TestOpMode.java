package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.microcmd.InstantCmd;

public class TestOpMode extends OpMode {
    GamepadEx gamepad;

    @Override
    public void init() {
        gamepad = new GamepadEx(gamepad1);

        gamepad.a.held(new InstantCmd(() -> System.out.println("omg!!!")));

        gamepad.dpadDown.pressed(new InstantCmd(() -> System.out.println("i was pressed!")));

        gamepad.multiple(
                new InstantCmd(() -> System.out.println("its a party!!")),
                gamepad.a.held(),
                gamepad.b.pressed()
        );

    }

    @Override
    public void loop() {
        gamepad.update();
        Scheduler.run();
    }
}
