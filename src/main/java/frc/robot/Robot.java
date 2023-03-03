package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final Joystick m_controller = new Joystick(0);

  PWMSparkMax frontRight = new PWMSparkMax(RobotMap.frontRight);
  PWMSparkMax middleRight= new PWMSparkMax(RobotMap.middleRight);
  PWMSparkMax backRight = new PWMSparkMax(RobotMap.backRight);
  MotorControllerGroup m_right = new MotorControllerGroup(frontRight, middleRight, backRight);

  
  PWMSparkMax frontLeft = new PWMSparkMax(RobotMap.frontLeft);
  PWMSparkMax middleLeft = new PWMSparkMax(RobotMap.middleLeft);
  PWMSparkMax backLeft = new PWMSparkMax(RobotMap.backLeft);
  MotorControllerGroup m_left = new MotorControllerGroup(frontLeft, middleLeft, backLeft);

  // double solenoid 
  private final DoubleSolenoid doubleSolenoid_1 =
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7);

  private final DoubleSolenoid doubleSolenoid_2 =
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 6);

  private static final int kDoubleSolenoidForward = 5;
  private static final int kDoubleSolenoidReverse = 6;


  private final Timer m_timer = new Timer();
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left,m_right);
  // private Command m_autonomousCommand;
  // public static RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_left.setInverted(true);
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    // m_robotContainer = new RobotContainer();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    // CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_timer.restart();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 3 seconds
    if (m_timer.get() < 2.0) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.8, 0.0, false);
    } else if (m_timer.get() < 3.5){
      m_robotDrive.arcadeDrive(0.5,0.81, false); // stop robot
    }
  }

  @Override
  public void teleopInit() {


    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //m_robotContainer.autoIntake.execute();
    m_robotDrive.arcadeDrive(-m_controller.getY(), -m_controller.getX());


    if (m_controller.getRawButton(kDoubleSolenoidForward)) {
      doubleSolenoid_1.set(DoubleSolenoid.Value.kForward);
    } else if (m_controller.getRawButton(kDoubleSolenoidReverse)) {
      doubleSolenoid_2.set(DoubleSolenoid.Value.kReverse);
    }
  }

  @Override
  public void testInit() {
    // // Cancels all running commands at the start of test mode.
    // CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}