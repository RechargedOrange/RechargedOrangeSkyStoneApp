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


        PID_driveBackwardEncoders(200,1,0);
        CollectLeft.setPower(1);
        CollectRight.setPower(-1);
        CollectBack.setPosition(1);

       PID_driveBackwardEncoders(1500,.3,0);
            pidTurn(90);
       PID_driveForwardEncoders(520,.5,90);
        CollectBack.setPosition(.0);
        sleep(1000);
        PID_driveBackwardEncoders(600,.5,90);
        driveright(2300,.5);
        PID_driveBackwardEncoders(3500,.3,90);
        driveleft(500,.5);
pidTurn(0);
//______________________________________________________________________________________________
        /*Lift.setPower(1);
        sleep(600);
        Lift.setPower(0);
        PID_driveForwardEncoders(700,.4,180);
        CollectBack.setPosition(1);
        sleep(500);
        PID_driveBackwardEncoders(700,.4,180);*/
        //pidTurn(0);
        PID_driveBackwardEncoders(800, .3,0);
        FoundLeft.setPosition(.4);FoundRight.setPosition(0);
        sleep(500);
        PID_driveForwardEncoders(900, .3,0);
        pidTurn(90);
        FoundLeft.setPosition(0);
        FoundRight.setPosition(.4);
        PID_driveBackwardEncoders(500,.7,90);
        PID_driveForwardEncoders(1000,.5,90);
        driveright(500,.5);
        if(state == LEFT_STATE){
            driveleft(1000,.5);
        }

             sleep(300000);}
    }

