package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous ( name = "AutoMecanumStartRed")

public class AutoMecanumStartRed extends SuperDrive {


    @Override
    public void runOpMode() {

        initialization(true);

         waitForStart();

    driveleft(1500, .3);
    Grabber.setPower(1);
        sleep(2000);
    driveBackwardEncoders(1400, .3);
    driveForwardEncoders(1400, .3);
    sleep(2000);
    driveBackwardEncoders(100,1);
    sleep(1000);
    Grabber.setPower(0);
   driveright(2300,.3);
        sleep(300000);



    }
}