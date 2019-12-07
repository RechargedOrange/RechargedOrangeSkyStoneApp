package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "BlockAutoMecanumBlueClassThing")

public class BlockAutoMecanumBlueClassThing extends SuperDrive {

    public void runOpMode() {

        initialization(true);

        waitForStart();


        driveright(3500, .5);

            Grabber.setPower(.5);
            sleep(1000);
        driveBackwardEncoders(1400, .5);
        driveForwardEncoders(1400, .5);
        Grabber.setPower(0);
            sleep(1000);


        driveleft(2300, .5);
        sleep(300000);
    }
}
