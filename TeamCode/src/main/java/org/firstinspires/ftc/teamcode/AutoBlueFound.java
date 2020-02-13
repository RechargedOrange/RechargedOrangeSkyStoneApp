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
        driveright(1300,.5);
            sleep(2000);
            //pidTurn(0);
        PID_driveBackwardEncoders(1570,.35,0);
             FoundLeft.setPosition(.4); FoundRight.setPosition(0);
        sleep(2000);
        PID_driveForwardEncoders(1400,.3,0);
             pidTurn(90);
                FoundLeft.setPosition(0);
                FoundRight.setPosition(.4);
        CollectBack.setPosition(.35);
                PID_driveForwardEncoders(1000, .3,90);
                //_______________Part where we get the block_____
        /*        pidTurn(0);
        CollectLeft.setPower(-1);
        CollectRight.setPower(1);
        CollectBack.setPosition(1);
        PID_driveBackwardEncoders(1500,.3,0);
        pidTurn(90);
        PID_driveForwardEncoders(700,.3,90);
        PID_driveBackwardEncoders(700,.3,90);
        pidTurn(0);
        PID_driveForwardEncoders(1500,.3,0);
        PID_driveBackwardEncoders(100,.2,0);*/

        sleep(300000);

    }
}

