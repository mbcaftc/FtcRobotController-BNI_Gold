package org.firstinspires.ftc.teamcode.Compitition.FreightFrenzy.Controls.Autonomous.Tank.BlueShippingHubDuckStorageUnit;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Compitition.FreightFrenzy.Robots.TankBot;
import org.firstinspires.ftc.teamcode.Compitition.FreightFrenzy.mechanisms.TSELocation;

@Autonomous (name = "Tank: Blue: Shipping Hub: Ducks: Storage", group = "BLUE")

public class AutoBlueShippingHubDuckStorageUnit extends BlueShippingHubDuckStorageUnit {
    public TankBot Bot =  new TankBot();

    public long sleepTime = 250;

    public String Alliance;
    public String AutoPath;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);
//        Bot.initWebcam();
        Bot.setLinearOp(this);

        telemetry.addLine("WAITING FOR START >");
        telemetry.update();

//        Bot.detectBarcode();
        Alliance = "Blue";
        Bot.initRobot(hardwareMap);
        Bot.initWebcam();
        Bot.setLinearOp(this);

        telemetry.addLine("WAITING FOR START >");
        telemetry.addLine("All my telemetry will be on FTC Dashboard");
        telemetry.addLine("http://192.168.43.1:8080/dash");
        telemetry.update();

        Bot.detectBarcode();

        TSELocation location = null;


        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        FtcDashboard.getInstance().startCameraStream(Bot.webcam, 10);
        telemetry.addLine("WAITING FOR START >");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            sleep(1000);

            location = Bot.detectBarcode();  // uses webcam -- only midpoint telemetry shows
            sleep(sleepTime);
            DriveShippingHubScore(Bot, Alliance, location);  // use to test if robot functioning!
            sleep(sleepTime);
            ShippingHubToDuck(Bot, Alliance, location);
            sleep(sleepTime);
            spinDuckBlue(Bot);
            sleep(sleepTime);
            DuckSpinnerToStorageUnit (Bot);
            sleep(sleepTime);





            sleep(1000);


            requestOpModeStop();
        }
        idle();
    }
}
