package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public class BatteryTest extends OpMode {

    VoltageSensor voltageSensor;

    @Override
    public void init() {
        voltageSensor = hardwareMap.voltageSensor.iterator().next();
    }

    @Override
    public void loop() {
        telemetry.addLine(String.format("Voltage: %.1f", voltageSensor.getVoltage()));
        telemetry.update();
    }
}
