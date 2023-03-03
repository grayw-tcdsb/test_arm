// package frc.robot;

// import edu.wpi.first.wpilibj.GenericHID;
// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.subsystems.DriveSubsystem;
// import frc.robot.subsystems.PneumaticsSubsystem;
// // import frc.robot.commands.AutoIntake;



// // import frc.robot.commands.AutonomousCommand;



// // import frc.robot.commands.IntakeCommand;
// // import frc.robot.commands.ShooterCommand;
// // import frc.robot.subsystems.IntakeSubsystem;
// // import frc.robot.subsystems.ShooterSubsystem;

// /**
//  * This class is where the bulk of the robot should be declared. Since
//  * Command-based is a
//  * "declarative" paradigm, very little robot logic should actually be handled in
//  * the {@link Robot}
//  * periodic methods (other than the scheduler calls). Instead, the structure of
//  * the robot (including
//  * subsystems, commands, and button mappings) should be declared here.
//  */
// public class RobotContainer {

//   // The robot's subsystems and commands are defined here...
//   public DriveSubsystem driveSubsystem = new DriveSubsystem();
//   public PneumaticsSubsystem pneumaticssubsystem = new PneumaticsSubsystem(); 
//   //public IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
//   //public ShooterSubsystem shooterSubsystem = new ShooterSubsystem();


//   // Command m_autonomousCommand = new AutonomousCommand();
//   // AutonomousCommand autonomousCommand = new AutonomousCommand();


//   // Command m_autoIntake = new AutoIntake();
//   //AutoIntake autoIntake = new AutoIntake(); 
//   // AutonomousCommand autonomousCommand2 = new AutonomousCommand();
//   SendableChooser<Command> m_chooser = new SendableChooser<>();
//   Joystick driverStick = new Joystick(RobotMap.driverStickPort); 
//   Joystick operatorStick = new Joystick(RobotMap.operatorStickPort);
//   // public Object autonomousCommand;
  
//   // JoystickButton intake = new JoystickButton(operatorStick, RobotMap.intakeButton);
//   // JoystickButton shoot = new JoystickButton(operatorStick, RobotMap.shooterButton);
//   public Joystick getDriverStick() {
//     return driverStick;
//   }

//   public Joystick getOperatorStick() {
//     return operatorStick;
//   }
//   /**
//    * The container for the robot. Contains subsystems, OI devices, and commands.
//    */
//   public RobotContainer() {
//     // Create choices for autonomous functions in the Smart Dashboard


//     // m_chooser.setDefaultOption("Autonomous Command", m_autonomousCommand);


//     //m_chooser.addOption("Auto Intake", m_autoIntake);
//     SmartDashboard.putData(m_chooser);
//     // Configure the button bindings
//     configureButtonBindings();
//   }

//   /**
//    * Use this method to define your button->command mappings. Buttons can be
//    * created by
//    * instantiating a {@link GenericHID} or one of its subclasses ({@link
//    * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
//    * it to a {@link
//    * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
//    */
//   private void configureButtonBindings() {
//     //intake.whileHeld(new IntakeCommand());
//     //shoot.whileHeld(new ShooterCommand());
//   }

//   /**
//    * Use this to pass the autonomous command to the main {@link Robot} class.
//    *
//    * @return the command to run in autonomous
//    */
//   public Command getAutonomousCommand() {
//     // An ExampleCommand will run in autonomous
//     return m_chooser.getSelected();
//   }
// }