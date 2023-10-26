import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.microcmd.gamepad.Stick;
import org.junit.Test;

public class GamepadTest {

    @Test
    public void trigger() {
        Gamepad a = new Gamepad();
        GamepadEx b = new GamepadEx(a);

        Stick stick = new Stick(() -> 2, () -> 2);
        stick.setDeadzone(0.1);

        Stick stick2 = new Stick(() -> 2, () -> 2);
        stick2.x.get();
        stick2.setDeadzone(0.1);
        stick2.y.setDeadzone(0.05);
        stick2.x.flip();
    }

    @Test
    public void stick() {
        Gamepad a = new Gamepad();
        GamepadEx gamepad = new GamepadEx(a);
        gamepad.leftStick.x.get();
        gamepad.leftStick.getX();

    }
}
