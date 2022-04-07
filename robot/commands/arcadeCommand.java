// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class arcadeCommand extends CommandBase {
  /** Creates a new tankCommand. */
  Joystick driver;
  public arcadeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.maArcadeSub);
    driver = RobotContainer.driver;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.maArcadeSub.configRamp();

   //RobotContainer.maArcadeSub.setCoast(); 
  
  RobotContainer.maArcadeSub.setBrake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    double throttle = 0;
    double turn = 0;
    
    throttle = driver.getRawAxis(1);
    turn = driver.getRawAxis(2);
    
/*
    throttle = RobotContainer.testF.getRawAxis(1);
    turn = RobotContainer.testT.getRawAxis(0);
*/
    RobotContainer.maArcadeSub.setPower(throttle, turn);
    
    

/*
//tank drive command
  double Right_Side = RobotContainer.driver.getRawAxis(3); 
  double Left_Side = RobotContainer.driver.getRawAxis(1);

  RobotContainer.mTankSub.setRaw(-Right_Side, -Left_Side);
*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
