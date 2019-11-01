package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous ( name = "AutoMecanumStartRed")

public class AutoMecanumStartRed extends SuperDrive {


    @Override
    public void runOpMode() {

        initialization(true);

         waitForStart();

    driveleft(1500, .3);
    driveBackwardEncoders(1500, .3);
            Grabber.setPosition(1);
            sleep(2000);
    driveForwardEncoders(1500, .3);
    sleep(2000);
    driveBackwardEncoders(100,1);
    sleep(1000);
    Grabber.setPosition(0);
   /* while (rechargedColor.red() < 35 && opModeIsActive()) {
        rightBack.setPower(.1);
        rightFront.setPower(-.1);
        leftBack.setPower(-.1);
        leftFront.setPower(.1);
    }*/
   driveright(2300,.3);
        sleep(300000);



    }
}