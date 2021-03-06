package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "Yeet_Teli")

public class Yeet_Teli extends SuperDrive {

    double drive;
    double strafe;
    double rotate;

    double frontLeftPower;
    double backLeftPower;
    double frontRightPower;
    double backRightPower;
    boolean rightState = false;
    boolean rightToggle = false;
    boolean rightToggleOld = false;
    boolean leftToggle = false;
    boolean leftToggleOld = false;
    boolean overRideToggle = false;
    Super_Sensors_Servos_Motors sss;

    @Override
    public void runOpMode() {

        initialization(false);
        waitForStart();
        while (opModeIsActive()) {
            mecanumDrive();
            CollectRight();
            CollectLeft();
            CollectBack();
            Lift();
            FoundLeft();
            FoundRight();
            CollectLift();
            CapMec();


        }
    }

    boolean lastState = false;
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

           boolean state = gamepad1.left_trigger > .5;
           if(state && !lastState) {
               leftToggle = !leftToggle;
           }
           lastState = state;

        boolean state2 = gamepad1.right_trigger > .5;
        if(state2 && !rightState) {
            rightToggle = !rightToggle;
        }
        rightState = state2;


        if(leftToggle){
               leftBack.setPower(backLeftPower / 2);
               leftFront.setPower(frontLeftPower / 2);
               rightBack.setPower(backRightPower / 2);
               rightFront.setPower(frontRightPower / 2);
           }



           else if (rightToggle) {

            leftBack.setPower(backLeftPower / 3);
            leftFront.setPower(frontLeftPower / 3);
            rightBack.setPower(backRightPower / 3);
            rightFront.setPower(frontRightPower / 3);
        }

        else {
               leftBack.setPower(backLeftPower);
               leftFront.setPower(frontLeftPower);
               rightBack.setPower(backRightPower);
               rightFront.setPower(frontRightPower);
           }

    }

    public void FoundLeft (){
        if (gamepad1.right_bumper)
            FoundLeft.setPosition(.4);          //Gamepad 1
        else FoundLeft.setPosition(0);

    }

    public void FoundRight () {
        if (gamepad1.right_bumper)
            FoundRight.setPosition(0);              //Gamepad 1
        else FoundRight.setPosition(.4);

    }

    public void CollectRight (){
        if (gamepad2.left_bumper)
            CollectRight.setPower(1);
        else if (gamepad2.right_bumper)             //Gamepad 2
            CollectRight.setPower(-1);
        else CollectRight.setPower(0);

    }

    public void CollectLeft (){
        if (gamepad2.left_bumper)
            CollectLeft.setPower(-1);
        else if (gamepad2.right_bumper)     //Gamepad 2
            CollectLeft.setPower(1);
        else CollectLeft.setPower(0);

    }


    public void CollectBack (){
        if (gamepad2.left_trigger > .5)
            CollectBack.setPosition(0);
        else if (gamepad2.right_trigger > .5)                //Gamepad 2
            CollectBack.setPosition(.35);
        else CollectBack.setPosition(1);

    }

    public void Lift() {
        if (gamepad2.dpad_up )               //Gamepad 2
            Lift.setPower(1);
        else if (gamepad2.dpad_down && UpTouch.getState()) {
                Lift.setPower(-1);
        } else Lift.setPower(0);

    }

    public void CapMec(){
        if(gamepad2.y)
            CapMec.setPosition(1);    //Gamepad 2
        else CapMec.setPosition(0);

    }

    public void CollectLift (){
        if (gamepad2.a)
            CollectLift.setPower(-.85);       //Gamepad 2
        else if (gamepad2.x)
            CollectLift.setPower(.85);
        else CollectLift.setPower(0);
    }



}