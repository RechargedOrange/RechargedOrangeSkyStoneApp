package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "AutoMecamumStartBlue")

public class AutoMecanumStartBlue extends SuperDrive {

    @Override
    public void runOpMode() {

        initialization(true);

        waitForStart();

        driveright(1500,.5);
        driveBackwardEncoders(1400,.5);
                 Grabber.setPower(1);
                 sleep(2000);
        driveForwardEncoders(1400,.5);
                Grabber.setPower(0);
        sleep(2000);


       // }
        driveleft(2300, .3);
        sleep(300000);
    }
}
