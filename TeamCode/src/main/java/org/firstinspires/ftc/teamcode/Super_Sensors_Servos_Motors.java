package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

public abstract class Super_Sensors_Servos_Motors extends LinearOpMode {


    public CRServo CollectRight;
    public CRServo CollectLeft;

    public Servo CollectBack;
    public Servo FoundRight;
    public Servo FoundLeft;

    public DcMotor Lift;
    public DcMotor CollectLift;

    DigitalChannel DownTouch;
    DigitalChannel UpTouch;

    double postDeployWait;
    boolean lastButtonState = false;
    Orientation lastAngles = new Orientation();
    double globalAngle, turnPower = .30, correction;
    public ElapsedTime waitTimer = new ElapsedTime();
  //  MasterVision vision;

    public BNO055IMU imu;


    public void initialization(boolean autonomous) {
    initLift();
    initCollectLeft();
    initCollectRight();
    initCollectBack();
        initDownTouch();
        initFoundRight();
        initFoundLeft();
        initCollectLift();
        initUpTouch();
    }

    //                                      Servos


    public void initCollectRight(){
        CollectRight = hardwareMap.crservo.get("CollectRight");
    }

    public void initCollectLeft (){
        CollectLeft = hardwareMap.crservo.get("CollectLeft");
    }

    public void initCollectBack (){
        CollectBack = hardwareMap.servo.get("CollectBack");
    }

    public void initFoundRight () {FoundRight = hardwareMap.servo.get("FoundRight");}

    public void initFoundLeft () {FoundLeft = hardwareMap.servo.get("FoundLeft");}

    //----------------------------------------------------------------------------------

    //                                  Motors

    public void initLift (){
        Lift = hardwareMap.dcMotor.get("Lift");
        Lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void initCollectLift (){
        CollectLift = hardwareMap.dcMotor.get("CollectLift");
        CollectLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


    public void initDownTouch(){
        DownTouch = hardwareMap.get(DigitalChannel.class, "DownTouch");

        // set the digital channel to input.
        DownTouch.setMode(DigitalChannel.Mode.INPUT);
    }

    public void initUpTouch(){
        UpTouch = hardwareMap.get(DigitalChannel.class, "UpTouch");

        // set the digital channel to input.
        UpTouch.setMode(DigitalChannel.Mode.INPUT);


    }

    //________________________________Scan 4 Skystones stuff_____________________________







    public void waitTime() {
        telemetry.addData("Wait time seconds", postDeployWait);
        telemetry.addLine("x to increment 1.0 seconds");
        telemetry.addLine("y to decrement 1.0 seconds");
        telemetry.addLine("lb to increment 0.1 seconds");
        telemetry.addLine("rb to decrement 0.1 seconds");

        boolean x = gamepad1.x;
        boolean y = gamepad1.y;
        boolean lb = gamepad1.left_bumper;                                  // converts gamepad buttons into booleans
        boolean rb = gamepad1.right_bumper;
        boolean buttonState = x || y || lb || rb;
        //check button states
        if (buttonState && !lastButtonState) {
            if (x)
                postDeployWait += 1.0;
            if (y)
                postDeployWait -= 1.0;
            if (lb)
                postDeployWait += 0.1;
            if (rb)
                postDeployWait -= 0.1;
        }

        postDeployWait = Range.clip(postDeployWait, 0.0, 30.0);        //make sure that the wait numbers do not go below 0.0 and not above 30
        // seconds

        lastButtonState = buttonState;                           // it resets the last button stated so it can be used next time

        telemetry.update();                                     // makes the drive coach able to see the numbers

    }


    @Override
    public void waitForStart(){
        while(!(isStarted() || isStopRequested())){

            waitTime();

           // telemetry.addLine("ready to go!");
            telemetry.update();
        }
    }

}
