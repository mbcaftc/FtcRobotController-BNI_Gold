package org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.BlueLeft;

import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.AutoMain;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.StartPosition;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.TargetZone;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Robots.LabBot;

public abstract class BlueLeft extends AutoMain {
    public void driveToTargetZone (LabBot Bot, TargetZone target) {
        switch (target) {
            case A:
                Bot.driveForward(0.5,7.75);
                sleep(500);
                Bot.strafeRight(0.5,.5);
                sleep(500);
                ScoreWobble(Bot);
                sleep(500);
                break;
            case B:
                Bot.driveForward(.5,10.5);
                sleep(500);
                Bot.strafeRight(0.5,3.5);
                sleep(500);
                ScoreWobble(Bot);
                sleep(500);
                break;
            case C:
                Bot.driveForward(.5,12.5);
                sleep(500);
                Bot.strafeRight(0.5,.5);
                sleep(500);
                ScoreWobble(Bot);
                sleep(500);
                break;
        }
    }

    public void ParkLaunchLine (LabBot Bot, TargetZone target) {
        switch (target) {
            case A:
                Bot.gyroCorrection(45, .5);
//                No need to move - already parked on line ot score Wobble.
                break;
            case B:
                Bot.driveBackward(0.5, 2.5);
                sleep(250);
                break;
            case C:
                Bot.driveBackward(0.5, 4.5);
                sleep(250);
                break;
        }
    }
}
