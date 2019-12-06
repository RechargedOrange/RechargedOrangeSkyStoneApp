package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Autonomous(name = "TestClass")

public class TestClass extends SuperDrive {


    @Override
    public void runOpMode() {

        initialization(true);

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("Front Right Encoder", rightFront.getCurrentPosition());
            telemetry.addData("Back Right Encodor", rightBack.getCurrentPosition());
            telemetry.addData("Back left Encodor", leftBack.getCurrentPosition());
            telemetry.addData("Front Left Encodor", leftFront.getCurrentPosition());

            telemetry.addData("The Color Sencor", rechargedColor.blue());        // it ws 40

            telemetry.addData("Ze IMU", globalAngle);

            telemetry.update();

        }

          //  driveleft (1000, .2);  //Does not go at all
     //   driveright(1000,.2);
         driveForwardEncoders(500, .2);
        //driveBackwardEncoders(1000,.2);
        //rotateLeft(180, .1);
        //rotateRight(180,.1);
   // Grabber.setPosition(.7);
        sleep(30000);




    }
}