// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class backupDrive extends CommandBase {
  /** Creates a new backupDrive. */
  Timer time;
  public backupDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.maArcadeSub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = new Timer();
    time.reset();
    time.start();
    RobotContainer.maArcadeSub.setBrake();
    RobotContainer.maArcadeSub.disableRamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //SEE IF NEGATIVES NEED TO BE FIXED
    RobotContainer.maArcadeSub.setRaw(0.6, 0.6);
    if(time.get()>=0.1){     //was originally 0.05 (before ramp rate)
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    //  RobotContainer.maArcadeSub.setCoast();
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    time.stop();
  //  RobotContainer.maArcadeSub.setCoast();
  RobotContainer.maArcadeSub.configRamp();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time.get()>=0.051;
  }
}
