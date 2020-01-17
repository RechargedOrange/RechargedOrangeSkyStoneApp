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


        driveright(3500, .5);

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



        PID_driveBackwardEncoders(100,.2,0);
        CollectBack.setPosition(.35);
        driveright(3500, .5);
          //  pidTurn(0);
             sleep(1000);
        PID_driveBackwardEncoders(1400, .25,0);
            FoundLeft.setPosition(0);
            FoundRight.setPosition(0);
             sleep (1000);
        PID_driveForwardEncoders(1400, .25,0);
               sleep(1000);
               pidTurn(90);
                FoundLeft.setPosition(1);
                FoundRight.setPosition(1);
            PID_driveForwardEncoders(8000,.3,90);
        driveleft(1300, .5);
        PID_driveForwardEncoders(1000,.5,0);
        pidTurn(180);
             sleep(300000);}
    }




/*I see you, Hacker!*/