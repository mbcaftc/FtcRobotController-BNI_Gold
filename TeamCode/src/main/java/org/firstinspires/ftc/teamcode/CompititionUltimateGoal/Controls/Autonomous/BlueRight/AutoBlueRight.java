package org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.BlueRight;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.StartPosition;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.TargetZone;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Modules.EasyOpenCVWebcam;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Robots.CompetitionBot;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Robots.LabBot;


@Autonomous(name = "Remote:Blue:Right:", group = "BLUE")

public class AutoBlueRight extends BlueRight {


    public CompetitionBot Bot = new CompetitionBot();
    public StartPosition startPosition = null;
    public TargetZone targetZone = null;
    public long sleepTime = 100;



    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap, "TeleOp");
        Bot.initCamera();
        Bot.setLinearOp(this);


        startPosition = StartPosition.BlueRight;


        waitForStart();


        while (opModeIsActive()){

            targetZone = detectStarterStack(Bot);
            telemetry.addData("SAMPLING VALUE #: ", Bot.pipeline.avg1);
            telemetry.addData("NUMBER OF RINGS: ", Bot.pipeline.position);
            telemetry.addData("TARGET ZONE: ", targetZone);
            telemetry.update();

            Bot.webcam.closeCameraDevice();

            targetZone = detectStarterStack(Bot);
            sleep(sleepTime);

            driveToTargetZone (Bot, targetZone);
            sleep(sleepTime);

//            ScoreWobble(Bot);
//            sleep(sleepTime);

            ParkLaunchLine(Bot,targetZone);
            sleep(sleepTime);


            requestOpModeStop();

        }
        idle();
    }
}