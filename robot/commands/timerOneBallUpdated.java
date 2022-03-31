// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class timerOneBallUpdated extends CommandBase {
  /** Creates a new timerOneBallUpdated. */
  Timer time;
  public timerOneBallUpdated() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.maArcadeSub);
    addRequirements(RobotContainer.mTransportSub);
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mShooterSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = new Timer();

    time.reset();
    time.start();
 
    RobotContainer.maArcadeSub.disableRamp();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    RobotContainer.mShooterSub.setShooterPower();

    if(time.get()>=2&&time.get()<=4.5){   //2 to 4.5
     // RobotContainer.mShooterSub.stopShooter();
      RobotContainer.mTransportSub.toShooter();

    }
    else if(time.get()>=4.6 && time.get()<=5.4){  //4.6 to 5.4
      RobotContainer.mTransportSub.stopTransport();
      RobotContainer.mShooterSub.stopShooter();
      RobotContainer.maArcadeSub.setRaw(-1.0, -1.0);   //goes backward
    }
    else {
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.mShooterSub.stopShooter();
    time.stop();
    RobotContainer.maArcadeSub.configRamp();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
