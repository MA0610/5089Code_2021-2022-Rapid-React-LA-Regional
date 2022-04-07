// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class shooterAutonomousCommand extends CommandBase {
  /** Creates a new shooterAutonomousCommand. */
  Timer time;
  public shooterAutonomousCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mShooterSub);
    addRequirements(RobotContainer.mTransportSub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  if(time.get()<2.5){
  RobotContainer.mShooterSub.setShooterPower();
  }
  else if(time.get()>=2.5){
  RobotContainer.mTransportSub.toShooter();
  }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mShooterSub.stopShooter();
    RobotContainer.mTransportSub.stopTransport();
    time.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (time.get()<5.0);
  }
}
