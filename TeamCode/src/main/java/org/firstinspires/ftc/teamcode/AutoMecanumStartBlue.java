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
                 Grabber.setPosition(1);
                 sleep(2000);
        driveForwardEncoders(1400,.5);
                Grabber.setPosition(0);
        sleep(2000);
        /*while (rechargedColor.blue()< 30){
            rightBack.setPower(-.1);
            rightFront.setPower(.1);
            leftBack.setPower(.1);
            leftFront.setPower(-.1);*/

       // }
        driveleft(2300, .3);
        sleep(300000);
    }
}
