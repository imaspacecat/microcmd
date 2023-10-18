package org.firstinspires.ftc.teamcode.microcmd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Scheduler2 {
    private static final List<Cmd> cmds = new ArrayList<>();
    private static final List<Cmd> toSchedule = new ArrayList<>();

    public static void schedule(Cmd cmd) {
        System.out.println("cmd = " + cmd);
        Iterator<Cmd> iter = cmds.iterator();
        Iterator<Cmd> toIter = toSchedule.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            System.out.println(cmd.getGroup());
            System.out.println(next.getGroup());
            if (cmd.getGroup() != null && cmd.getGroup().equals(next.getGroup())) {
                next.terminate();
                iter.remove();
            }
        }

        cmd.init();
        toSchedule.add(cmd);
    }

    public static void run() {
        cmds.addAll(toSchedule);
        toSchedule.clear();

        Iterator<Cmd> iter = cmds.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            if (next.isFinished()) {
                next.terminate();
                iter.remove();
            }
        }

        cmds.forEach(Cmd::run);
    }

    public static List<Cmd> getCmds() {
        return cmds;
    }
}