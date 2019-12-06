package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class Super_Sensors_Servos_Motors extends LinearOpMode {


    public Servo Intake;

    public ColorSensor rechargedColor;

    public DcMotor Lift;
    public DcMotor Grabber;

    DigitalChannel DownTouch;


    public void initialization(boolean autonomous) {
    initGrabber();
    initIntake();
    initLift();
    initrechargedColor();
        initDownTouch();
    }

    //                                      Servos

    public void initIntake (){
        Intake = hardwareMap.servo.get("Intake");
        Intake.setPosition(0);

    }

    //----------------------------------------------------------------------------------

    //                                  Motors

    public void initLift (){
        Lift = hardwareMap.dcMotor.get("Lift");
        Lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void initGrabber (){
        Grabber = hardwareMap.dcMotor.get("Grabber");
        Grabber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


    public void initrechargedColor(){
        rechargedColor = hardwareMap.get(ColorSensor.class, "rechargedColor");

    }


    public void initDownTouch(){
        DownTouch = hardwareMap.get(DigitalChannel.class, "DownTouch");

        // set the digital channel to input.
        DownTouch.setMode(DigitalChannel.Mode.INPUT);
    }

    @Override
    public void waitForStart(){
        while(!(isStarted() || isStopRequested())){
            telemetry.addLine("ready to go!");
            telemetry.update();
        }
    }

}
