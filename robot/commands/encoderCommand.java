// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class encoderCommand extends CommandBase {
  /** Creates a new encoderCommand. */
  double leftCount, rightCount;

  //the input would be the number of rotations you want them to do
  public encoderCommand(double leftEncoderCount, double rightEncoderCount) {
    // Use addRequirements() here to declare subsystem dependencies.
 addRequirements(RobotContainer.maArcadeSub);

 //2048 ticks = 1 rotation for TalonFX Integrated Sensors
 leftCount  = leftEncoderCount * 2048;
rightCount = rightEncoderCount * 2048;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
leftCount += RobotContainer.maArcadeSub.getLeftEncoderCount();
rightCount += RobotContainer.maArcadeSub.getRightEncoderCount();

RobotContainer.maArcadeSub.setEncoderTarget(leftCount, rightCount);


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {






  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.maArcadeSub.onTarget();

  }
}
