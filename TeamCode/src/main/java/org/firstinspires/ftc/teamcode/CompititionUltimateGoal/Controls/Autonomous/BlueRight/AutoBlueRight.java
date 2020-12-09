package org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.BlueRight;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.StartPosition;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Controls.Autonomous.TargetZone;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Modules.EasyOpenCVWebcam;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Robots.CompetitionBot;
import org.firstinspires.ftc.teamcode.CompititionUltimateGoal.Robots.LabBot;


@Autonomous(name = "Remote:Blue:Right:", group = "BLUE")
//@Disabled

public class AutoBlueRight extends BlueRight {


    public CompetitionBot Bot = new CompetitionBot();
    public StartPosition startPosition = null;
    public TargetZone targetZone = null;
    public long sleepTime = 100;



    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap, "TeleOp", "auto");
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

            driveToLaunch (Bot);
            sleep(sleepTime);

            ScoreRings(Bot,targetZone);
            sleep(sleepTime);

            driveToZoneOne(Bot, targetZone);
            sleep(sleepTime);
//
            ScoreWobbleSensor(Bot);
            sleep(sleepTime);
//
//            driveToLeftWobble(Bot,targetZone);
//            sleep(sleepTime);
//
//            CollectDoubleWobble(Bot);
//            sleep(sleepTime);
//
//            driveToZoneTwo(Bot,targetZone);
//            sleep(sleepTime);
//
//            ScoreWobble(Bot);
//            sleep(sleepTime);
//
            ParkLaunchLine(Bot,targetZone);
            sleep(sleepTime);


            requestOpModeStop();

        }
        idle();
    }
}
