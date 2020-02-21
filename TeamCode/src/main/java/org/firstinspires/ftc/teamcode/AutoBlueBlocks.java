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


        PID_driveBackwardEncoders(200,.4,0);
        CollectLeft.setPower(1);
        CollectRight.setPower(-1);
        CollectBack.setPosition(1);
       PID_driveBackwardEncoders(1450,.3,0);
            pidTurn(90);
       PID_driveForwardEncoders(570,.3,90);
        CollectBack.setPosition(.0);
        sleep(1000);
        PID_driveBackwardEncoders(600,.3,90);
        driveright(1500,.5);
        PID_driveBackwardEncoders(2700,.6,90);
pidTurn(0);


        PID_driveBackwardEncoders(1300, .3,0);
        FoundLeft.setPosition(.4);FoundRight.setPosition(0);
        sleep(2000);
        PID_driveForwardEncoders(1200, .3,0);
        pidTurn(90);
        FoundLeft.setPosition(0);
        FoundRight.setPosition(.4);
        PID_driveForwardEncoders(1000,.5,90);
        driveright(500,.5);
        if(state == LEFT_STATE){
            driveleft(1000,.5);
        }
        /* pidTurn(180);
        PID_driveForwardEncoders(400,.5,90);
        Lift.setPower(.3);
          sleep(500);
        Lift.setPower(0);
        PID_driveForwardEncoders(500,.5,90);
            CollectLeft.setPower(0);
             CollectRight.setPower(0);
        Lift.setPower(-.2);
         sleep(500);
         pidTurn(0);
        PID_driveForwardEncoders(1000,.5,90);*/





       // PID_driveForwardEncoders(1200,.5,90);
        //________________________________________________________________________________________
       /* PID_driveBackwardEncoders(100,.8,0);
        driveright(3500,.3);

            sleep(2000);
        PID_driveBackwardEncoders(1570, .3,0);
             FoundLeft.setPosition(.4);FoundRight.setPosition(0);
        sleep(2000);
             pidTurn(90);
       PID_driveForwardEncoders(1400, .3,90);
                FoundLeft.setPosition(0);
             FoundRight.setPosition(.4);*/
       // PID_driveForwardEncoders(1000,.5,90);

             sleep(300000);}
    }

