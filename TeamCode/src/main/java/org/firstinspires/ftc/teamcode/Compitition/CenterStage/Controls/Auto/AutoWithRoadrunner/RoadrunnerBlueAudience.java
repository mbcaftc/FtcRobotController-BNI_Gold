package org.firstinspires.ftc.teamcode.Compitition.CenterStage.Controls.Auto.AutoWithRoadrunner;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Compitition.CenterStage.Controls.Auto.AutoBlueAlliance;
import org.firstinspires.ftc.teamcode.Compitition.CenterStage.RoadRunner.drive.RoadrunMecanumDrive;
import org.firstinspires.ftc.teamcode.Compitition.CenterStage.RoadRunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.Compitition.CenterStage.Vision.TeamPropPosition;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

//@Config
@Disabled
@Autonomous(name = "RR: BLUE AUDIENCE")
public class RoadrunnerBlueAudience extends AutoBlueAlliance {


    public static final boolean USE_WEBCAM = true;
    public static int oneSecond = 1000;
    public TfodProcessor tFod;
    Pose2d blueAudienceStartPose = new Pose2d(-35, 60, 4.7);

    @Override
    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);

        initCamera();
        Bot.setLinearOp(this);
        Bot.planeLauncherServo.setPosition(1);
        startObjectDetectionPipeline(pipeline);
        telemetry.addLine("Starting Vision Pipeline");

        Bot.tuckPosition();

        RoadrunMecanumDrive drive = new RoadrunMecanumDrive(hardwareMap);
        // JDA: I need to Change this
        Pose2d startPose = blueAudienceStartPose;
        drive.setPoseEstimate(startPose);

        // JDA: I need to Change this
        TrajectorySequence trajSeqBlueLeft = drive.trajectorySequenceBuilder(startPose)
                .forward(24)
                .addDisplacementMarker(() -> {
                    Bot.collectorPosition();
                    Bot.rightWormgearDown(.6, 800);
                })
                .turn(Math.toRadians(-90))
                .forward(2)
                .back(.5)
                .addDisplacementMarker(() -> {
                    Bot.leftPixelClawOpen();
                })
                .back(9)
                .waitSeconds(1)
                .turn(Math.toRadians(90))
                .forward(24)
                .turn(Math.toRadians(-90))
                .forward(77)
                .addDisplacementMarker(()->{
                    Bot.rightWormgearUp(1,721);
                    Bot.autoPlacePosition();
                })
                .strafeRight(35)
                .build();

        // JDA: I need to Change this
        TrajectorySequence trajseqBlueMid = drive.trajectorySequenceBuilder(startPose)
                .forward(.5)
                .addDisplacementMarker(() -> {
                    Bot.collectorPosition();
                    Bot.rightWormgearDown(.6, 800);
                })
                .forward(30)
                .back(.5)
                .addDisplacementMarker(() -> {
                    Bot.leftPixelClawOpen();
                })
                .back(7.5)
                .strafeLeft(20)
                .waitSeconds(1)
                .forward(30)
                .turn(Math.toRadians(-90))
                .forward(90)
                .addDisplacementMarker(()->{
                    Bot.rightWormgearUp(1,721);
                    Bot.autoPlacePosition();
                })
                .strafeRight(30)
                .build();

        // JDA: I need to Change this
        TrajectorySequence trajBlueRight = drive.trajectorySequenceBuilder(startPose)
                .forward(24)
                .addDisplacementMarker(() -> {
                    Bot.collectorPosition();
                    Bot.rightWormgearDown(.6, 800);
                })
                .turn(Math.toRadians(-90))
                .forward(2)
                .back(.5)
                .addDisplacementMarker(() -> {
                    Bot.leftPixelClawOpen();
                })
                .back(9)
                .waitSeconds(1)
                .turn(Math.toRadians(90))
                .forward(24)
                .turn(Math.toRadians(-90))
                .forward(77)
                .addDisplacementMarker(()->{
                    Bot.rightWormgearUp(1,721);
                    Bot.autoPlacePosition();
                })
                .strafeRight(35)
                .build();

        telemetry.addLine("Robot Awaiting Start");
        telemetry.update();

        waitForStart();

        if(isStopRequested()) return;

        CameraDetection();

        if (teamPropPosition == TeamPropPosition.BLUE_LEFT) {
                telemetry.addLine("Executing Trajectory...");
                telemetry.update();
                drive.followTrajectorySequence(trajSeqBlueLeft);
                telemetry.addLine("Finished Trajectory...");
                telemetry.update();

                dropPixelBackdrop();
                parkAutoBlue();

                requestOpModeStop();

        }

        else if (teamPropPosition == TeamPropPosition.BLUE_MIDDLE) {
                telemetry.addLine("Executing Trajectory...");
                telemetry.update();
                drive.followTrajectorySequence(trajseqBlueMid);
                telemetry.addLine("Finished Trajectory...");
                telemetry.update();

                dropPixelBackdrop();
                parkAutoBlue();

                requestOpModeStop();
        }

        else if (teamPropPosition == TeamPropPosition.BLUE_RIGHT) {
                telemetry.addLine("Executing Trajectory...");
                telemetry.update();
                drive.followTrajectorySequence(trajBlueRight);
                telemetry.addLine("Finished Trajectory...");
                telemetry.update();

                dropPixelBackdrop();
                parkAutoBlue();

                requestOpModeStop();
        }
    }

    public void dropPixelBackdrop() {
         Bot.linearSlideExtend(.8,390);
         sleep(500);
         Bot.rightPixelClawClose();
         sleep(1500);
         Bot.linearSlideRetract(.8,200);
         sleep(200);
    }

    // This needs to part to right of Backdrop
     public void parkAutoBlue() {
        Bot.driveForward(0.8,2);
        Bot.strafeRight(0.6,1.5);
        Bot.driveBack(0.6,.5);
    }

}


