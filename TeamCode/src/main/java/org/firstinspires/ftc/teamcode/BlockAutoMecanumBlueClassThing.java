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
        driveBackwardEncoders(1400, .25);
        sleep (1000);
        driveForwardEncoders(1400, .25);
             Grabber.setPower(-3);
            sleep(1000);
              Grabber.setPower(0);

        driveleft(1300, .5);
        driveBackwardEncoders(150,.5);
        driveleft(1000,.5);
        sleep(300000);
    }
}




/*I see you, Hacker!*/