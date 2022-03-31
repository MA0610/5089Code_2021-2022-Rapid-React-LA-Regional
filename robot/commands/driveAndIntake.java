// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class driveAndIntake extends CommandBase {
  /** Creates a new driveAndIntake. */
  double leftCount, rightCount;

  public driveAndIntake(double leftEncoderCount, double rightEncoderCount) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.maArcadeSub);

    leftCount  = leftEncoderCount *2048;
    rightCount = rightEncoderCount *2048;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    leftCount += RobotContainer.maArcadeSub.getLeftEncoderCount();
    rightCount += RobotContainer.maArcadeSub.getRightEncoderCount();
    
    RobotContainer.mIntakeSub.intakeIn();
    RobotContainer.maArcadeSub.setEncoderTarget(leftCount, rightCount);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mIntakeSub.intakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.maArcadeSub.onTarget();
  }
}
