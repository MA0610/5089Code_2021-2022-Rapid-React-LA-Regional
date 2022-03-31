// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.PneumaticsDEPLOYCommand;
import frc.robot.commands.PneumaticsRETRACTCommand;
import frc.robot.commands.rightTarmacAutonomousGroupCommand;
import frc.robot.commands.intakeIN_Command;
import frc.robot.commands.intakeOUT_Command;
import frc.robot.commands.leftTarmacAutonomousCommandGroup;
import frc.robot.commands.lowShooter;
import frc.robot.commands.lowShooterCommand;
import frc.robot.commands.rightHangDown;
import frc.robot.commands.rightHangUp;
import frc.robot.commands.shooterCommand;
import frc.robot.commands.timerOneBall;
import frc.robot.commands.timerOneBallUpdated;
import frc.robot.commands.timerTwoBallAuton;
import frc.robot.commands.arcadeCommand;
import frc.robot.commands.armInCommand;
import frc.robot.commands.armJoystick;
import frc.robot.commands.armOutCommand;
import frc.robot.commands.backupDrive;
import frc.robot.commands.backupLeftTarmacAuton;
import frc.robot.commands.backupRightTarmacAuton;
import frc.robot.commands.hangDown;
import frc.robot.commands.hangUp;
import frc.robot.commands.transportBackCommand;
import frc.robot.commands.transportForwardCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PneumaticsSub;
import frc.robot.subsystems.hangSub;
import frc.robot.subsystems.intakeSub;
import frc.robot.subsystems.shooterSub;
import frc.robot.subsystems.arcadeSub;
import frc.robot.subsystems.armSub;
import frc.robot.subsystems.transportSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static arcadeSub maArcadeSub = new arcadeSub();

  public static shooterSub mShooterSub = new shooterSub();

  public static hangSub mHangSub = new hangSub();

  public static transportSub mTransportSub = new transportSub();

  public static intakeSub mIntakeSub = new intakeSub();

  public static PneumaticsSub mPneumaticsSub = new PneumaticsSub();

  public static armSub mArmSub = new armSub();


//autonomous declarations
//ones for Ventura
public static backupRightTarmacAuton mBackupRightTarmacAuton = new backupRightTarmacAuton();
public static backupLeftTarmacAuton mBackupLeftTarmacAuton = new backupLeftTarmacAuton();

//timer ome ball
public static timerOneBall mTimerOneBall = new timerOneBall();

public static timerOneBallUpdated mTimerOneBallUpdated = new timerOneBallUpdated();

//may not work
public static rightTarmacAutonomousGroupCommand mRightTarmacAutonomousGroupCommand = new rightTarmacAutonomousGroupCommand();
public static leftTarmacAutonomousCommandGroup mLeftTarmacAutonomousCommandGroup = new leftTarmacAutonomousCommandGroup();


  public static Joystick driver = new Joystick(Constants.driver);

  public static Joystick coDriver = new Joystick(Constants.coDriver);


  public static Joystick testF = new Joystick(Constants.testTurn);
  public static Joystick testT = new Joystick(Constants.testForward);



  //Josie & Matthew controls

  //driver
 // JoystickButton shooter = new JoystickButton(driver, 6);  //1
 // JoystickButton lowShooter = new JoystickButton(driver, 5);

  JoystickButton hangUp = new JoystickButton(driver, 4 ); //5
  JoystickButton hangDown = new JoystickButton(driver, 2);  //6

  JoystickButton backUp = new JoystickButton(driver, 3);

  JoystickButton extend = new JoystickButton(driver, 8);  //8
  JoystickButton retract = new JoystickButton(driver, 6); //7

  //coDriver
   JoystickButton transport = new JoystickButton(coDriver, 6); //6
   JoystickButton transportBack = new JoystickButton(coDriver, 8);  //8
 
   JoystickButton intakeIn = new JoystickButton(coDriver, 2);
   JoystickButton intakeOut = new JoystickButton(coDriver, 3);
 
   JoystickButton shooter = new JoystickButton(coDriver, 7);  //5
   JoystickButton lowShooter = new JoystickButton(coDriver, 5); //7


  // JoystickButton armOut = new JoystickButton(coDriver, 1);
  // JoystickButton armIn = new JoystickButton(coDriver, 4);
 
//Nolan & Josh controls
/*


//coDriver
  JoystickButton shooter = new JoystickButton(driver, 6);  //1
  JoystickButton lowShooter = new JoystickButton(driver, 5);


  JoystickButton transport = new JoystickButton(coDriver, 6);
  JoystickButton transportBack = new JoystickButton(coDriver, 8);

  JoystickButton intakeIn = new JoystickButton(coDriver, 7);
  JoystickButton intakeOut = new JoystickButton(coDriver, 5);

  JoystickButton armOut = new JoystickButton(coDriver, 1);
  JoystickButton armIn = new JoystickButton(coDriver, 4);


  JoystickButton hangUp = new JoystickButton(driver, 4 ); //5
  JoystickButton hangDown = new JoystickButton(driver, 2);  //6

  JoystickButton backUp = new JoystickButton(driver, 3);

  JoystickButton extend = new JoystickButton(driver, 8);  //7
   JoystickButton retract = new JoystickButton(driver, 7); //8



*/

  //JoystickButton rightHangUp = new JoystickButton(driver, 2);   //6
  //JoystickButton rightHangDown = new JoystickButton(driver, 3);  //8

  //JoystickButton leftHangUp = new JoystickButton(driver, 6);  //5
  //JoystickButton lefthangDown = new JoystickButton(driver, 8);   //7


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
maArcadeSub.setDefaultCommand(new arcadeCommand());
mArmSub.setDefaultCommand(new armJoystick());
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

shooter.whileHeld(new shooterCommand());
lowShooter.whileHeld(new lowShooter());

transport.whileHeld(new transportForwardCommand());
transportBack.whileHeld(new transportBackCommand());

intakeIn.whileHeld(new intakeIN_Command());
intakeOut.whileHeld(new intakeOUT_Command());

//deployPneumatics.whenPressed(new PneumaticsDEPLOYCommand());
//retractPneumatics.whenPressed(new PneumaticsRETRACTCommand());


hangUp.whileHeld(new hangUp());
hangDown.whileHeld(new hangDown());

backUp.whenPressed(new backupDrive());
/*rightHangUp.whileHeld(new rightHangUp());
rightHangDown.whileHeld(new rightHangDown());

leftHangUp.whileHeld(new hangUp());
rightHangDown.whileHeld(new hangDown());
*/

//armIn.whileHeld(new armInCommand());
//armOut.whileHeld(new armOutCommand());


extend.whenPressed(new PneumaticsDEPLOYCommand());
retract.whenPressed(new PneumaticsRETRACTCommand());


}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous

    //good autonomous
    //new timerOneBall();

    return new timerOneBallUpdated();
  }
}
