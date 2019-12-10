package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Drive&Park Auto Red Blocks Blue Found")

public class DrivePark_AutoRedBlocks extends SuperDrive {


    public void runOpMode (){

        initialization(true);

        waitForStart();

        driveright(500,.6);
        driveBackwardEncoders(700,.4);


    }

}
