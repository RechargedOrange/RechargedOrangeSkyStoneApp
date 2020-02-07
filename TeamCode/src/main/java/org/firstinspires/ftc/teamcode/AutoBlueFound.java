package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "AutoBlueFound")

public class AutoBlueFound extends SuperDrive {

    @Override
    public void runOpMode() {

        initialization(true);

        waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait){idle(); }{

        }

       /* driveright(1300,.3);
            sleep(2000);
        driveBackwardEncoders(1400,.25);
            FoundLeft.setPosition(0);
            FoundRight.setPosition(0);
        sleep(2000);
        driveForwardEncoders(1400,.25);
            FoundLeft.setPosition(1);
            FoundRight.setPosition(1);
        driveleft(1300, .4);
        driveBackwardEncoders(150,.5);
        driveleft(1200,.3);
       // rotateRight(90,.4);
            sleep(300000);*/

        PID_driveBackwardEncoders(100,.2,0);
        driveright(1100,.3);
            sleep(2000);
            //pidTurn(0);
        PID_driveBackwardEncoders(1400,.5,0);
             FoundLeft.setPosition(0);
            FoundRight.setPosition(0);
        sleep(2000);
        PID_driveForwardEncoders(1400,.5,0);
         //     pidTurn(90);
                FoundLeft.setPosition(1);
                FoundRight.setPosition(1);
        CollectBack.setPosition(.35);
        pidTurn(90);
                PID_driveForwardEncoders(800, .5,90);

        driveleft(800,.3);
        PID_driveForwardEncoders(1000,.3,90);

        sleep(300000);

    }
}


//HOLLO JON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"