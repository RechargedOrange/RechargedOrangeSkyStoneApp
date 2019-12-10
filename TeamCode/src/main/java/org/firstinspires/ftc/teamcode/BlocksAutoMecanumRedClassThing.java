package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "BlocksAutoMecanumRedClassThing")

public class BlocksAutoMecanumRedClassThing extends SuperDrive {


public void runOpMode (){

    initialization(true);

    waitForStart();


    driveright(3500,.3);
         Grabber.setPower(1);
            sleep(2000);
    driveBackwardEncoders(1400, .3);
    sleep(2000);
    driveForwardEncoders(1400, .3);
      Grabber.setPower(-3);
        sleep(2000);
       Grabber.setPower(0);
    driveright(1300,.3);
    driveBackwardEncoders(150,.5);
    driveright(1000,.5);
     sleep(300000);


}




}
