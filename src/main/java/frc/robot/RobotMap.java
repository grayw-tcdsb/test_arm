package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;

/** Add your docs here. */
public class RobotMap {

    // Drive station port
    public static final int frontLeft = 0;
    public static final int middleLeft = 1;
    public static final int backLeft = 2;
    public static final int frontRight = 9;
    public static final int middleRight = 8;
    public static final int backRight = 7;
    
    // Driver stick buttons
    public static final int fastRobotButton = 1;
    public static final int slowRobotButton = 2;
    public static final int defaultRobotSpeed = 3;
    public static final int sliderAxisPort = 3;
    
    // Joystick Ports
    public static final int driverStickPort = 0;
    public static final int operatorStickPort = 1;

    // Intake and Shooter Motor ports
    public static final int topShooterPort = 4;
    public static final int bottomShooterPort = 5;
    public static final int intakePort = 6;
    
    // Operator stick Buttons
    public static final int intakeButton = 1;
    public static final int shooterButton = 2;

    // DIO Ultrasonic sensor
    public static final int pingChannel = 0;
    public static final int echoChannel = 1;
    public static Ultrasonic ultrasonic = new Ultrasonic(pingChannel, echoChannel);

    // Analog Ultrasonic sensor
    public static final int frontUltrasonicChannel = 0;
    public static final int intakeUltrasonicChannel = 1;
    public static final AnalogInput frontUltrasonic = new AnalogInput(frontUltrasonicChannel);
    public static final AnalogInput intakeUltrasonic = new AnalogInput(intakeUltrasonicChannel);
    public static double getDistFromObj(){
        double rangeInMM = frontUltrasonic.getAverageVoltage()*1023;
        double rangeInInches = rangeInMM/25.4;
        return rangeInInches;
    }
    public static double getDistFromBall(){
        double rangeInMM = intakeUltrasonic.getAverageVoltage()*1023;
        double rangeInInches = rangeInMM/25.4;
        return rangeInInches;
    }
}