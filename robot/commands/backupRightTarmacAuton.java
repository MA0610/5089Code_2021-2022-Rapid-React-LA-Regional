// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class backupRightTarmacAuton extends CommandBase {
  /** Creates a new backupRightTarmacAuton. */
  int frontCount = 0;
  int turnCount = 0;
  Timer time;
  
  public backupRightTarmacAuton() {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(RobotContainer.maArcadeSub);
  addRequirements(RobotContainer.mTransportSub);
  addRequirements(RobotContainer.mArmSub);
  addRequirements(RobotContainer.mIntakeSub);
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.maArcadeSub.calibrateNavX();
    RobotContainer.maArcadeSub.resetNavX();
    RobotContainer.maArcadeSub.resetTicks();

    RobotContainer.maArcadeSub.setBrake();
    time = new Timer();

  time.reset();
  time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
   //starts the shooter at the start of autonomous

    RobotContainer.mShooterSub.setShooterPower();
    if(time.get()>=1.5){
      //feeds the ball from indexer to shooter (already spinning at good speed)
      RobotContainer.mTransportSub.toShooter();
    }
    else if(time.get()>=1.6&&time.get()<2.0){
      //stops the indexer motors and starts moving backwards
      RobotContainer.mTransportSub.stopTransport();
      RobotContainer.maArcadeSub.setRaw(1.0, -1.0);
    }

else if(RobotContainer.maArcadeSub.getLeftEncoderCount()>=(5*2048)&&frontCount==0){
  //stops once it backs up enough to turn RIGHT
  RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    frontCount++;
    RobotContainer.maArcadeSub.resetTicks();
  RobotContainer.maArcadeSub.setRaw(-1.0, 1.0);
  }
//stops turning once the robot has made a 180 degree turn 
 else if(RobotContainer.maArcadeSub.getNavXAngle()>179){
  RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
 RobotContainer.maArcadeSub.setRaw(1.0, 1.0); 
 turnCount++;
 RobotContainer.maArcadeSub.resetTicks();

  }
  else if(RobotContainer.maArcadeSub.getLeftEncoderCount()>=(6*2048)&&frontCount==1){
  RobotContainer.mArmSub.armOut();
  RobotContainer.mTransportSub.toShooter();
  RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
  frontCount++;
  time.reset();
  time.start();
}
  else if(time.get()>=2.0){
  RobotContainer.mTransportSub.stopTransport();
  RobotContainer.maArcadeSub.setRaw(-1.0, 1.0);
}
//need to turn around and head back to hub before shooting
  else if(turnCount==1 &&RobotContainer.maArcadeSub.getNavXAngle()<=0){
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
  turnCount++;
  RobotContainer.maArcadeSub.resetTicks();
  RobotContainer.maArcadeSub.setRaw(1.0, 1.0);
  }

else if(RobotContainer.maArcadeSub.getLeftEncoderCount()>=(6*2048)&&frontCount==2){
RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
time.reset();
time.start();
}
  //need to reset timer and change values accordingly
  else if(time.get()<0.7){
  RobotContainer.mTransportSub.awayShooter();
  RobotContainer.mShooterSub.setShooterPower();
  }
  else if(time.get()>2.0){
  RobotContainer.mTransportSub.toShooter();
  }
  /*
  else if(time.get()>6.0 && time.get()<8.0){
  RobotContainer.mShooterSub.stopShooter();
  RobotContainer.mTransportSub.stopTransport();
  }
*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    RobotContainer.mArmSub.stopArm();
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.mShooterSub.stopShooter();

time.stop();
time.reset();
//RobotContainer.maArcadeSub.setCoast();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
