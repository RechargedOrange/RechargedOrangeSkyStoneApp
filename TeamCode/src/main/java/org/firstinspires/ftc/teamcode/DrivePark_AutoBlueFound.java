package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Drive&Park Auto Blue Foundation Red Blocks")

public class DrivePark_AutoBlueFound extends SuperDrive {


    public void runOpMode() {

        initialization(true);

        waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait) {
            idle();
        }
        {
        }

        sleep(25000);
        driveleft(200, .6);
       // driveBackwardEncoders(700, .4);

    }
}
