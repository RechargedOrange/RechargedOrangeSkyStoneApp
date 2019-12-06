package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "BlocksAutoMecanumRedClassThing")

public class BlocksAutoMecanumRedClassThing extends SuperDrive {


public void runOpMode (){

    initialization(true);

    waitForStart();

  /*  driveleft(700,.3);
    driveForwardEncoders(1000,.25);
    Intake.setPosition(0);
    sleep(1500);
    Lift.setPower(1);
    sleep(500);
    Lift.setPower(0);
    driveBackwardEncoders(1000,.25);*/
    driveright(3500,.3);
   // rotateLeft(180,.2);
    driveBackwardEncoders(1500, .3);
    Grabber.setPower(1);
    sleep(2000);
    driveForwardEncoders(1500, .3);
    sleep(2000);
    Grabber.setPower(0);
    driveright(2300,.3);
    sleep(300000);


}




}
