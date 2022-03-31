// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class timerTwoBallAuton extends CommandBase {
  /** Creates a new timerTwoBallAuton. */
  Timer time;
  int frontCount;
  int turnCount;
  
  public timerTwoBallAuton() {
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
    
    turnCount = 0;

    //RobotContainer.maArcadeSub.calibrateNavX();
    //RobotContainer.maArcadeSub.resetNavX();
    RobotContainer.maArcadeSub.resetTicks();
  
  time.reset();
    time.start();

    RobotContainer.maArcadeSub.disableRamp();
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

 RobotContainer.mShooterSub.setShooterPower();


 if(time.get()>=2&&time.get()<=4.5){
   RobotContainer.mShooterSub.stopShooter();
   RobotContainer.mTransportSub.toShooter();
 }
 else if(time.get()>=4.6 && time.get()<=4.8){
   RobotContainer.mTransportSub.stopTransport();
   RobotContainer.maArcadeSub.setRaw(1.0, 1.0);   //goes forward
   RobotContainer.mArmSub.armOut();
   RobotContainer.mIntakeSub.intakeIn();
   RobotContainer.mTransportSub.toShooter();
 }/*
 else if(RobotContainer.mArmSub.checkLimit()){
   RobotContainer.mArmSub.stopArm();
 }*/
 else if(time.get()>5.5&&time.get()<=5.6){
   RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
  // if(RobotContainer.mArmSub.checkLimit()){
    RobotContainer.mArmSub.stopArm();
  
  RobotContainer.maArcadeSub.setRaw(-1.0, -1.0);
  RobotContainer.mShooterSub.setShooterPower();
 }
 else if(time.get()>5.6 && time.get()<=6.3){
   RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
 }
else if(time.get()>6.3){
  RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
  RobotContainer.mTransportSub.stopTransport();
  RobotContainer.mShooterSub.stopShooter();
  RobotContainer.mArmSub.stopArm();
  RobotContainer.mIntakeSub.intakeStop();

}


    


    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.mShooterSub.stopShooter();
    RobotContainer.mArmSub.stopArm();
    RobotContainer.mIntakeSub.intakeStop();
    RobotContainer.maArcadeSub.configRamp();
    time.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
