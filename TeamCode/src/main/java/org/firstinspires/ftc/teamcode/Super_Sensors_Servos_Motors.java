package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class Super_Sensors_Servos_Motors extends LinearOpMode {

    public Servo Grabber;

    public ColorSensor rechargedColor;

    public DcMotor Steve;    //Steve is the intake



    public void initialization(boolean autonomous) {
    initGrabber();
    initSteve();
    initrechargedColor();

    }

    public void initGrabber (){
        Grabber = hardwareMap.servo.get("Grabber");
        Grabber.setPosition(0);


    }

    public void initSteve (){
        Steve = hardwareMap.dcMotor.get("Steve");  //Steve is the intake
    }

    public void initrechargedColor(){
        rechargedColor = hardwareMap.get(ColorSensor.class, "rechargedColor");

    }

    @Override
    public void waitForStart(){
        while(!(isStarted() || isStopRequested())){
            telemetry.addLine("waiting");
            telemetry.update();
        }
    }

}
