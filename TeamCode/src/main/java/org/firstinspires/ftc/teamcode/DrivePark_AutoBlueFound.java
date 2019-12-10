package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Drive&Park Auto Blue Foundation Red Blocks")

public class DrivePark_AutoBlueFound extends SuperDrive {


    public void runOpMode () {

        initialization(true);

        waitForStart();

        driveleft(500,.6);
        driveBackwardEncoders(700,.4);

    }
}
