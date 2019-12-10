package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous ( name = "AutoMecanumStartRed")

public class AutoMecanumStartRed extends SuperDrive {


    @Override
    public void runOpMode() {

        initialization(true);

         waitForStart();

    driveleft(1400, .3);
      Grabber.setPower(.5);
        sleep(2000);
    driveBackwardEncoders(1400, .3);
    sleep(2000);
    driveForwardEncoders(1400, .3);
         sleep(2000);
        Grabber.setPower(-3);
       sleep(1000);
        Grabber.setPower(0);
        driveright(2300,.3);
        driveBackwardEncoders(150,.5);
        driveright(1000,.5);
        sleep(300000);



    }
}