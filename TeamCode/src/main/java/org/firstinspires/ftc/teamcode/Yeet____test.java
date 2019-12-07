package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "Yeet___test")

public class Yeet____test extends SuperDrive {

    double drive;
    double strafe;
    double rotate;

    double frontLeftPower;
    double backLeftPower;
    double frontRightPower;
    double backRightPower;
    Super_Sensors_Servos_Motors sss;

    @Override
    public void runOpMode() {

        initialization(false);
        waitForStart();
        while (opModeIsActive()) {
            mecanumDrive();
            Intake();
            Lift();
            Grabber();

        }
    }


    public void mecanumDrive() {


        //This is setup as a tank drive with strafing on the triggers of the controller.
        double lt = gamepad1.left_trigger;
        double rt = gamepad1.right_trigger;
        double ly = -gamepad1.left_stick_y;
        double ry = -gamepad1.right_stick_y;

        // double d = (ly + ry) / 2;
        //double s = rt - lt;
        //double r = (ly - ry) / 2;


        drive = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        // You might have to play with the + or - depending on how your motors are installed
        frontLeftPower = drive + strafe + rotate;
        backLeftPower = drive - strafe + rotate;
        frontRightPower = drive - strafe - rotate;
        backRightPower = drive + strafe - rotate;

           /* frontLeftPower = d + s + r;
            backLeftPower = d - s + r;
            frontRightPower = d - s - r;
            backRightPower = d + s - r;*/


           if (gamepad1.right_bumper){
               leftBack.setPower(backLeftPower);
               leftFront.setPower(frontLeftPower);
               rightBack.setPower(backRightPower);
               rightFront.setPower(frontRightPower);
           }
           else leftBack.setPower(backLeftPower / 2);
                leftFront.setPower(frontLeftPower / 2);
                rightBack.setPower(backRightPower / 2);
                rightFront.setPower(frontRightPower / 2);



    }

    public void Intake() {

        if (gamepad2.left_bumper) {
            Intake.setPosition(0);
        }

        else Intake.setPosition(.7);
    }

    public void Lift() {
        if (gamepad2.dpad_up)
            Lift.setPower(-1);
        else if (gamepad2.dpad_down && DownTouch.getState()) {
                Lift.setPower(1);
        } else Lift.setPower(0);


    }

    public void Grabber (){
        if (gamepad2.x){
            Grabber.setPower(.45);
        }
        else Grabber.setPower(0);

    }
}