package org.firstinspires.ftc.teamcode.Compitition.PowerPlay.controls.Autonomus.Test.GyroDriveTest.BlueLeftPark;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Compitition.PowerPlay.Robots.CompetionBot;
import org.firstinspires.ftc.teamcode.Compitition.PowerPlay.Robots.StraferBot;
import org.firstinspires.ftc.teamcode.Compitition.PowerPlay.controls.Autonomus.Test.GyroDriveTest.AutoTargetZone;

@Autonomous (name = "GyroDrive Test - giughui")
public class AutoBlueLeftPark extends BlueLeftPark {

    public CompetionBot Bot = new CompetionBot();

    public StraferBot BotStrafer = new StraferBot();

    public AutoTargetZone targetZone = null;

    public boolean isCompetition = true;

    @Override
    public void runOpMode() throws InterruptedException {

        if (isCompetition == true) {
            Bot.initRobot(hardwareMap);

            Bot.setLinearOp(this);

        } else {

            BotStrafer.initRobot(hardwareMap);

            BotStrafer.setLinearOp(this);

        }

        // Initialize WebCam and Create Image Processing Pipeline
        initializePipeline();

        //targetZone = AutoTargetZone.A;
        Bot.openGrabberArms();

        telemetry.addLine("WAITING FOR START >");
        telemetry.addData("TARGET ZONE: ", TargetZone);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            Bot.turretPlatform.setPower(0);

            // Find Tags During the Init Loop
//            while (!isStarted() && !isStopRequested()) {
//                findTag();
//                sleep(20);
//            }

            //detect tags in auto main

            detectTags();

            if (isCompetition == true) {

                Bot.extendGrabberLift(0.6);

                sleep(125);

                Bot.stopGrabberLift();

                sleep(sleepTime);

                Bot.closeGrabberArms();

                sleep(1000);

                Bot.extendGrabberLift(.8);

                sleep(600);

                Bot.stopGrabberLift();

                Bot.extendGrabberLift(0.4);

            }

            //targetZone = DetectSleaveImage(Bot);

            telemetry.addData("TARGET ZONE: ", TargetZone);
            telemetry.update();

            sleep(1000);

            if (isCompetition == true) {

                parkplace(Bot, TargetZone);
                sleep(1000);

            }

            idle();
            requestOpModeStop();
        }
    }
}
