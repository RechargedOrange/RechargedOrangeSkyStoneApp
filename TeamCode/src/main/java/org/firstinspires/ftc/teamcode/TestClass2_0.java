package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


//@Autonomous(name = "TestClass2.0")


public class TestClass2_0 extends SuperDrive {

    @Override
    public void runOpMode() {


        initialization(true);

        waitForStart();
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);





                backlefttarget = (leftBack.getCurrentPosition() - 5000);
                backrighttarget = (rightBack.getCurrentPosition() + 5000);
                frontlefttarget = (leftFront.getCurrentPosition() + 5000);
                frontrighttarget = (rightFront.getCurrentPosition() - 5000);

        leftBack.setPower(-.5);
        leftFront.setPower(.5);
        rightBack.setPower(.5);
        rightFront.setPower(-.5);

                while (leftBack.getCurrentPosition() > backlefttarget
                       // && leftFront.getCurrentPosition() < frontlefttarget
                    ///    && rightBack.getCurrentPosition() < backrighttarget
                    /*  && rightFront.getCurrentPosition() < frontrighttarget*/ && opModeIsActive()) {

                    leftBack.setPower(-.5);
                    leftFront.setPower(.5);
                    rightBack.setPower(.5);
                    rightFront.setPower(-.5);

                    telemetry.addData("left back", leftBack.getCurrentPosition());
                    telemetry.addData("left front", leftFront.getCurrentPosition());
                    telemetry.addData("right back", rightBack.getCurrentPosition());
                    telemetry.addData("right front", rightFront.getCurrentPosition());

                    telemetry.update();
                }
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);



        }






    }

