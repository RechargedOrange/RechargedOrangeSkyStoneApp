package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous ( name = "AutoRedFound")

public class AutoRedFound extends SuperDrive {


    @Override
    public void runOpMode() {

        initialization(true);

         waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait){idle(); }{
        }

    /*driveleft(1300, .3);
        sleep(2000);
    driveBackwardEncoders(1400, .6);
            FoundLeft.setPosition(0);
            FoundRight.setPosition(0);
    sleep(2000);
    pidTurn(0);
    driveForwardEncoders(1400, .6);
         sleep(2000);
            FoundLeft.setPosition(1);
            FoundRight.setPosition(1);
        driveright(1300,.4);
        driveBackwardEncoders(150,.5);
        driveright(1200,.25);
        sleep(300000);
*/





   /* PID_driveBackwardEncoders(100,1,0);
        driveleft(1100, .65);
       //pidTurn(0);
        sleep(2000);
        PID_driveBackwardEncoders(1400, .65,0);
            FoundLeft.setPosition(0);
            FoundRight.setPosition(0);
        sleep(2000);
        PID_driveForwardEncoders(1400, .6,0);
        sleep(2000);
     //   pidTurn(90);
              FoundLeft.setPosition(1);
              FoundRight.setPosition(1);
        CollectBack.setPosition(.35);
        pidTurn(90);
              PID_driveForwardEncoders(800,.3,90);
        driveright(800,.3);
        PID_driveForwardEncoders(1000,1,90);*/
        //--------------------------------------------------------------
        CollectLeft.setPower(-1);
        CollectRight.setPower(1);
        CollectBack.setPosition(1);
        PID_driveBackwardEncoders(1500,.3,0);
        pidTurn(90);
        PID_driveForwardEncoders(700,.3,90);
        PID_driveBackwardEncoders(700,.3,90);
        pidTurn(0);
        PID_driveForwardEncoders(1500,.3,0);
        PID_driveBackwardEncoders(100,.2,0);
        sleep(300000);

    }
}