package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "Yeet___test")

public class Yeet____test extends SuperDrive {

        double drive ;
        double strafe;
        double rotate;


        double frontLeftPower;
        double backLeftPower;
        double frontRightPower;
        double backRightPower;

        @Override
        public void runOpMode() {

            initialization(false);
            waitForStart();
            while (opModeIsActive()) {
                mecanumDrive();
            }
        }


        public void mecanumDrive() {


            //This is setup as a tank drive with strafing on the triggers of the controller.
            double lt = gamepad1.left_trigger;
            double rt = gamepad1.right_trigger;
            double ly = -gamepad1.left_stick_y;
            double ry = -gamepad1.right_stick_y;

            double d = (ly + ry) / 2;
            double s = rt - lt;
            double r = (ly - ry) / 2;


            drive = -gamepad1.left_stick_y;
            strafe = gamepad1.left_stick_x;
            rotate = gamepad1.right_stick_x;

            // You might have to play with the + or - depending on how your motors are installed
        /*frontLeftPower = drive + strafe + rotate;
        backLeftPower = drive - strafe + rotate;
        frontRightPower = drive - strafe - rotate;
        backRightPower = drive + strafe - rotate;*/

            frontLeftPower = d + s + r;
            backLeftPower = d - s + r;
            frontRightPower = d - s - r;
            backRightPower = d + s - r;

            leftBack.setPower(-backLeftPower);
            leftFront.setPower(-frontLeftPower);
            rightBack.setPower(backRightPower);
            rightFront.setPower(frontRightPower);

        }

}
