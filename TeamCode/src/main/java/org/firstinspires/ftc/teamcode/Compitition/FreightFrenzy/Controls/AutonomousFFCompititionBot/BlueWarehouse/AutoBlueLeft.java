package org.firstinspires.ftc.teamcode.Compitition.FreightFrenzy.Controls.AutonomousFFCompititionBot.BlueWarehouse;

import org.firstinspires.ftc.teamcode.Compitition.FreightFrenzy.Robots.EightWheelBot;
import org.firstinspires.ftc.teamcode.Compitition.ZCompititionUltimateGoal.Controls.Autonomous.StartPosition;
import org.firstinspires.ftc.teamcode.Compitition.ZCompititionUltimateGoal.Controls.Autonomous.TargetZone;

public class AutoBlueLeft extends BlueLeft {


    public EightWheelBot Bot = new EightWheelBot();
    public StartPosition startPosition = null;
    public TargetZone targetZone = null;
    public int sleepTime = 250;


    @Override
    public void runOpMode() throws InterruptedException {


        requestOpModeStop();
    }


}