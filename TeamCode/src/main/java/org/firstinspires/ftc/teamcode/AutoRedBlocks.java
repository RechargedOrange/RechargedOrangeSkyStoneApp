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



    PID_driveBackwardEncoders(200,.4,0);
    CollectLeft.setPower(1);
    CollectRight.setPower(-1);
    CollectBack.setPosition(1);
    PID_driveBackwardEncoders(1450,.3,0);
    pidTurn(-90);
    PID_driveForwardEncoders(570,.3,-90);
    CollectBack.setPosition(0);
    sleep(1000);
    PID_driveBackwardEncoders(600,3,-90);
    driveleft(100,.5);
    PID_driveBackwardEncoders(2600,1,-90);
    driveright(500,.5);
    pidTurn(0);


    PID_driveBackwardEncoders(1200, .4,0);
    FoundLeft.setPosition(.4);FoundRight.setPosition(0);
    sleep(2000);
    PID_driveForwardEncoders(1000, .4,0);
    pidTurn(-90);
    PID_driveBackwardEncoders(1400,.5,-90);
    FoundLeft.setPosition(0);
    FoundRight.setPosition(.4);
    PID_driveBackwardEncoders(500,.7,90);
    PID_driveForwardEncoders(1300,.5,-90);
    driveleft(550,.5);
    if(state == RIGHT_STATE){
        driveright(1000,.5);
    }


    sleep(300000);
    }

}
