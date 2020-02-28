package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@Config
public abstract class SuperDrive extends Super_Sensors_Servos_Motors {

    public DcMotor leftBack;
    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor rightBack;

    public BNO055IMU imu;
    public float imuStartingPosition;

    double frontlefttarget = 0;
    double frontrighttarget = 0;
    double backrighttarget = 0;
    double backlefttarget = 0;

    public static double kP = 0.05;
    public static double kI = 0.0;                              // these will be used in the PID methods
    public static double kD = 0.0;

    Orientation lastAngles = new Orientation();
    double globalAngle, power = .30, correction;



    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()){

        }
    }

    public void initialization(boolean autonomous) {
        super.initialization(autonomous);
        initDrive();

        if (autonomous) {
            telemetry.addLine("imu init");
            telemetry.update();
            initiate_imu();

            telemetry.addLine("drive Init");
            telemetry.update();
            //initDrive(


            leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

           /* leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
*/
            leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            
        } else {
            leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        }
        telemetry.addLine("Finished init - ready to go captain!");
        telemetry.update();
    }

    public void initiate_imu() {

        telemetry.addLine("Initiating IMU");
        telemetry.update();

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        while (opModeIsActive()) {

            imuStartingPosition = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES).firstAngle;

        }
    }

    public void initDrive() {

        leftBack = hardwareMap.dcMotor.get("leftBack");
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    public void powerDriveTrain(double leftPower, double rightPower) {

        double max = 1.0;
        max = Math.max(max, Math.abs(leftPower));
        max = Math.max(max, Math.abs(rightPower));
        leftPower /= max;
        rightPower /= max;

        leftBack.setPower(leftPower);
        leftFront.setPower(leftPower);
        rightBack.setPower(rightPower);
        rightFront.setPower(rightPower);

    }

    public void driveForwardEncoders(double distance, double power) {
        backlefttarget = (leftBack.getCurrentPosition() + distance);
        backrighttarget = (rightBack.getCurrentPosition() + distance);
        frontlefttarget = (leftFront.getCurrentPosition() + distance);
        frontrighttarget = (rightFront.getCurrentPosition() + distance);

        while (leftBack.getCurrentPosition() < backlefttarget
                /*&& leftFront.getCurrentPosition() < frontlefttarget
                && rightBack.getCurrentPosition() < backrighttarget
                && rightFront.getCurrentPosition() < frontrighttarget*/ && opModeIsActive()) {

            leftBack.setPower(power);
            leftFront.setPower(power);
            rightBack.setPower(power);
            rightFront.setPower(power);

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

    public void PID_driveForwardEncoders(double distance, double power, double angle) {

        backlefttarget = (leftBack.getCurrentPosition() + distance);
        backrighttarget = (rightBack.getCurrentPosition() + distance);
        frontlefttarget = (leftFront.getCurrentPosition() + distance);              //Create a number called motorNameTarget. This will be a bigger number
        frontrighttarget = (rightFront.getCurrentPosition() + distance);            //Than the current position of the motor, since the motor counts up as it goes forward


        IMUstraightDouble(angle);

        while (leftBack.getCurrentPosition() < backlefttarget                   //while we have not reached the target we just set, keep running
                && leftFront.getCurrentPosition() < frontlefttarget
                && rightBack.getCurrentPosition() < backrighttarget
                && rightFront.getCurrentPosition() < frontrighttarget && opModeIsActive()) {

            double turn = IMUstraightDouble(angle);
            powerDriveTrain((power + turn), (power - turn));
            telemetry.update();
        }


        DriveOff();
    }


    public void driveBackwardEncoders(double distance, double power) {

        backlefttarget = (leftBack.getCurrentPosition() - distance);
        backrighttarget = (rightBack.getCurrentPosition() - distance);
        frontlefttarget = (leftFront.getCurrentPosition() - distance);
        frontrighttarget = (rightFront.getCurrentPosition() - distance);

        while (leftBack.getCurrentPosition() > backlefttarget
               /* && leftFront.getCurrentPosition() > frontlefttarget
                && rightBack.getCurrentPosition() > backrighttarget
                && rightFront.getCurrentPosition() > frontrighttarget*/ && opModeIsActive()) {
            leftBack.setPower(-power);
            leftFront.setPower(-power);
            rightBack.setPower(-power);
            rightFront.setPower(-power);

            telemetry.addData("left back", leftBack.getCurrentPosition());
            telemetry.addData("left front", leftFront.getCurrentPosition());
            telemetry.addData("right back", rightBack.getCurrentPosition());
            telemetry.addData("right front", rightFront.getCurrentPosition());

            telemetry.update();

        }
        DriveOff();
    }

    public void PID_driveBackwardEncoders(double distance, double power, double angle) {
        backlefttarget = (leftBack.getCurrentPosition() - distance);
        backrighttarget = (rightBack.getCurrentPosition() - distance);
        frontlefttarget = (leftFront.getCurrentPosition() - distance);              //Create a number called motorNameTarget. This will be a bigger number
        frontrighttarget = (rightFront.getCurrentPosition() - distance);            //Than the current position of the motor, since the motor counts up as it goes forward


        IMUstraightDouble(angle);

        while (leftBack.getCurrentPosition() >  backlefttarget                   //while we have not reached the target we just set, keep running
                && leftFront.getCurrentPosition() > frontlefttarget
                && rightBack.getCurrentPosition() > backrighttarget
                && rightFront.getCurrentPosition() > frontrighttarget && opModeIsActive()) {

            double turn = IMUstraightDouble(angle);
            powerDriveTrain((-power + turn), (-power - turn));
            telemetry.update();
        }


        DriveOff();
    }

    public void driveleft(double distance, double power) {
        leftFront.setPower(-power);
        leftBack.setPower(power);
        rightFront.setPower(power);
        rightBack.setPower(-power);

        backlefttarget = (leftBack.getCurrentPosition() + distance);
        backrighttarget = (rightBack.getCurrentPosition() - distance);
        frontlefttarget = (leftFront.getCurrentPosition() - distance);
        frontrighttarget = (rightFront.getCurrentPosition() + distance);

        while (/*leftFront.getCurrentPosition() > frontlefttarget
               &&*/ leftBack.getCurrentPosition() < backlefttarget
               /* && rightFront.getCurrentPosition() < frontrighttarget
                && rightBack.getCurrentPosition() > backrighttarget*/ && opModeIsActive()) {

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

    public void driveright(double distance, double power) {
        leftFront.setPower(power);
        leftBack.setPower(-power);
        rightFront.setPower(-power);
        rightBack.setPower(power);

        backlefttarget = (leftBack.getCurrentPosition() - distance);
        backrighttarget = (rightBack.getCurrentPosition() + distance);
        frontlefttarget = (leftFront.getCurrentPosition() + distance);
        frontrighttarget = (rightFront.getCurrentPosition() - distance);

        while (//leftFront.getCurrentPosition() < frontlefttarget
                /*&&*/ leftBack.getCurrentPosition() > backlefttarget
               /* && rightFront.getCurrentPosition() > frontrighttarget
                *//*&&*//* rightBack.getCurrentPosition() < backrighttarget*/ && opModeIsActive()) {

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

    public void rotateLeft(double targetAngle, double power) {
        leftBack.setPower(-power);
        leftFront.setPower(-power);
        rightBack.setPower(power);
        rightFront.setPower(power);

        while (opModeIsActive() && getAngle() < targetAngle) {
            telemetry.addData("curentAngle", getAngle());
            telemetry.addData("targetAngle", targetAngle);
            telemetry.update();
        }
        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);

    }

    public void rotateRight(double targetAngle, double power) {
        leftBack.setPower(power);
        leftFront.setPower(power);
        rightBack.setPower(-power);
        rightFront.setPower(-power);

        while (opModeIsActive() && getAngle() > targetAngle) {
            telemetry.addData("curentAngle", getAngle());
            telemetry.addData("targetAngle", targetAngle);
            telemetry.update();
        }
        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
    }

//______________________________________PID stuff___________________________________________________


    public void resetAngle() {
        lastAngles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        globalAngle = 0;
    }

    public double getAngle() {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double deltaAngle = angles.firstAngle - lastAngles.firstAngle;

        if (deltaAngle < -180)
            deltaAngle += 360;
        else if (deltaAngle > 180)
            deltaAngle -= 360;

        globalAngle += deltaAngle;

        lastAngles = angles;

        return globalAngle;
    }

    PIDController pid = new PIDController(new PIDCoefficients(kP, kI, kD));


    public double IMUstraightDouble(double targetAngle) {

        double currentAngle = getAngle();
        pid.setCoeffs(new PIDCoefficients(kP, kI, kD));
        return pid.update(currentAngle - targetAngle);
    }

public void DriveOff(){

        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
}

    public void pidTurn(double angle){
        pidTurn(angle, 2.0);
    }
    public void pidTurn(double angle, double threshold){
        IMUstraightDouble(angle);
        ElapsedTime timer = new ElapsedTime();
        while(timer.seconds() < 3.0 /*Math.abs(angle - getAngle()) > threshold && opModeIsActive()*/){
            double turn = IMUstraightDouble(angle);
            powerDriveTrain(turn, -turn);
        }
    }



}
