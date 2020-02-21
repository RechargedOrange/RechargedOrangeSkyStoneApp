package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "This Auto backs Up")

public class We_back_up extends SuperDrive {


    public void runOpMode (){

        initialization(true);

        waitForStart();

        waitTimer.reset();

        while (waitTimer.seconds() < postDeployWait){idle(); }{
        }

        PID_driveBackwardEncoders(300,.7,0);
        sleep(3000000);


    }

}
