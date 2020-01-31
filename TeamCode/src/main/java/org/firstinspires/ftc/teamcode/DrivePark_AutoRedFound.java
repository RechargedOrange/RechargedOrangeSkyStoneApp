package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Drive&Park Auto Red Found blue blocks")

public class DrivePark_AutoRedFound extends SuperDrive {


    public void runOpMode (){

        initialization(true);

        waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait){idle(); }{
        }

        driveright(700,.6);
        driveBackwardEncoders(700,.4);


    }

}
