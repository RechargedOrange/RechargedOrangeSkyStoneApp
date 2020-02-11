package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "AutoBlueBlocks")

public class AutoBlueBlocks extends SuperDrive {

    public void runOpMode() {

        initialization(true);

        waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait){idle(); }{
        }

/*sleep(1000);
        driveBackwardEncoders(1400, .6);
        FoundLeft.setPosition(0);
        FoundRight.setPosition(0);
        sleep(1000);
        driveForwardEncoders(1400, .6);
        sleep(1000);
        FoundLeft.setPosition(1);
        FoundRight.setPosition(1);

        driveleft(1300, .4);
        driveBackwardEncoders(150, .5);
        driveleft(1200, .5);
        sleep(300000);*/



// driveright(3500, .5);


        PID_driveBackwardEncoders(100,.4,0);
        CollectLeft.setPower(-1);
        CollectRight.setPower(1);
        CollectBack.setPosition(1);
       PID_driveBackwardEncoders(1500,.3,0);
            pidTurn(90);
       PID_driveForwardEncoders(700,.3,90);
        PID_driveBackwardEncoders(700,.3,90);
             pidTurn(0);
        PID_driveForwardEncoders(1500,.5,0);
             //________________________________________________________________________________________
        driveright(3500,.3);
            sleep(2000);
        PID_driveBackwardEncoders(1400, .3,0);
             FoundLeft.setPosition(0);FoundRight.setPosition(0);
        sleep(2000);
             pidTurn(90);
       PID_driveForwardEncoders(1400, .3,90);
                FoundLeft.setPosition(1);
             FoundRight.setPosition(1);
        PID_driveForwardEncoders(800,.3,90);
        driveleft(800,.3);
        PID_driveForwardEncoders(1000,.5,90);

             sleep(300000);}
    }

