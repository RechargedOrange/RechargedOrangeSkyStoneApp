package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "AutoRedBlocks")

public class AutoRedBlocks extends SuperDrive {


public void runOpMode (){

    initialization(true);

    waitForStart();

    waitTimer.reset();

    while (waitTimer.seconds() < postDeployWait){idle(); }{
    }


    /*driveleft(3500,.3);
            sleep(2000);
    driveBackwardEncoders(1400, .6);
        FoundLeft.setPosition(0);
        FoundRight.setPosition(0);
    sleep(2000);
    driveForwardEncoders(1400, .6);
        FoundLeft.setPosition(1);
        FoundRight.setPosition(1);
    driveleft(1300,.4);
    driveBackwardEncoders(150,.5);
    driveleft(1200,.5);
     sleep(300000);*/



    PID_driveBackwardEncoders(100,.2,0);
    CollectBack.setPosition(.35);
    driveleft(3500,.3);
   // pidTurn(0);
    sleep(2000);
    PID_driveBackwardEncoders(1400, .3,0);
        FoundLeft.setPosition(0);
        FoundRight.setPosition(0);
    sleep(2000);
    PID_driveForwardEncoders(1400, .3,0);
    pidTurn(90);
        FoundLeft.setPosition(1);
        FoundRight.setPosition(1);
        PID_driveForwardEncoders(800,.3,90);
    driveright(800,.3);
    PID_driveForwardEncoders(1000,.5,90);
    pidTurn(1800);
    sleep(300000);
}




}
