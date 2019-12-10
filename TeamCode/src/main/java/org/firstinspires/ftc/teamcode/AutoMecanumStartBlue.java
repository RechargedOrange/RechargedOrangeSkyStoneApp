package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "AutoMecamumStartBlue")

public class AutoMecanumStartBlue extends SuperDrive {

    @Override
    public void runOpMode() {

        initialization(true);

        waitForStart();

        driveright(1400,.5);
            Grabber.setPower(.3);
            sleep(2000);
        driveBackwardEncoders(1400,.25);
        sleep(2000);
        driveForwardEncoders(1400,.25);
            Grabber.setPower(-.3);
            sleep(500);
            Grabber.setPower(0);
        driveleft(1300, .3);
        driveBackwardEncoders(50,.5);
        driveleft(1000,.3);
            sleep(300000);
    }
}


//HOLLO JON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"