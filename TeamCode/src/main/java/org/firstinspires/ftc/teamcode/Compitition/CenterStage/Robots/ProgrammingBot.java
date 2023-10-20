package org.firstinspires.ftc.teamcode.Compitition.CenterStage.Robots;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Compitition.CenterStage.Drivetrains.MecanumDrive;

public class ProgrammingBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    public IMU imu  = null;
    public double headingError  = 0;
    RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
    RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
    RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);


    public void initRobot(HardwareMap hardwareMap) {
        hwBot = hardwareMap;
        frontLeftMotor = hardwareMap.get(DcMotorEx.class, "front_left_motor");
        frontRightMotor = hardwareMap.get(DcMotorEx.class, "front_right_motor");
        rearLeftMotor = hardwareMap.get(DcMotorEx.class, "rear_left_motor");
        rearRightMotor = hardwareMap.get(DcMotorEx.class, "rear_right_motor");
//        frontLeftMotor=hwBot.dcMotor.get("front_left_motor");
//        frontRightMotor=hwBot.dcMotor.get("front_right_motor");
//        rearLeftMotor=hwBot.dcMotor.get("rear_left_motor");
//        rearRightMotor=hwBot.dcMotor.get("rear_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        imu = hwBot.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));

    }
}