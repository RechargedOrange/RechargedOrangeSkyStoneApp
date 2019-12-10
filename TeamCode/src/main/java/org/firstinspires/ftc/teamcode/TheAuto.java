package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "The Auto")

public class TheAuto extends SuperDrive {

    public void runOpMode (){


        initialization(true);

        waitForStart();

        driveBackwardEncoders(1200,.4);
        driveright(2000,.3);
        driveForwardEncoders(1200,.4);
        driveright(1500,.4);
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
        driveBackwardEncoders(1200,.3);
        driveright(1000,.5);
        sleep(300000);
    }


}
