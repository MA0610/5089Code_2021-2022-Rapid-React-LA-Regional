// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class timerTwoBallAuton extends CommandBase {
  /** Creates a new timerTwoBallAuton. */
  Timer time;
  int frontCount;
  int turnCount;
  int valueStep;
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


    time.reset();
    time.start();
   RobotContainer.maArcadeSub.setBrake();;
    RobotContainer.maArcadeSub.disableRamp();
  
   // RobotContainer.maArcadeSub.calibrateNavX();
    //RobotContainer.maArcadeSub.resetNavX();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

    
    RobotContainer.mShooterSub.setShooterPower();
    RobotContainer.mShooterSub.powerShooter(0.45);   //starts flywheel to let it get to proper velocity

    if(time.get()>=3&&time.get()<=6.5){   //2 to 4.5
     // RobotContainer.mShooterSub.stopShooter();
      RobotContainer.mTransportSub.toShooter();    //shoots preload cargo

    }
    else if(time.get()>=6.6 && time.get()<=7.2){  //4.6 to 5.4
      RobotContainer.mTransportSub.stopTransport();
      RobotContainer.mShooterSub.stopShooter();
      RobotContainer.mArmSub.armIn();                //brings out arm

      RobotContainer.mShooterSub.setBrake();
      RobotContainer.mIntakeSub.intakeIn();
      RobotContainer.mTransportSub.toShooter();
     // RobotContainer.mShooterSub.keepBallIn();  //brings ball all the way in without letting it spill out

      RobotContainer.maArcadeSub.setRaw(0.6, 0.6);   //goes forward & stops indexer and shooter
    }
    else if(time.get()>= 7.3 &&time.get()<7.9){
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
      RobotContainer.mArmSub.stopArm();
    }
    else if(time.get()>=8 && time.get()<=8.2) {
    RobotContainer.mArmSub.armOut();
    }
    else if(time.get()>8.3 && time.get()<=8.4){
     RobotContainer.mArmSub.stopArm(); 
     //
     RobotContainer.maArcadeSub.setRaw(-0.6, -0.6);
     //
     //RobotContainer.mTransportSub.awayShooter();
     RobotContainer.mTransportSub.toShooter();
     
     RobotContainer.mShooterSub.setShooterPower();
    }
    else if(time.get()>8.9 && time.get()<=9.0){
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    }
    else if(time.get()>11 &&time.get()<=15){
      RobotContainer.mShooterSub.stopShooter();
      RobotContainer.mTransportSub.stopTransport();
    }
    /*
    else if(turnCount==0 && RobotContainer.maArcadeSub.getNavXAngle() <1){
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
      turnCount++;
      RobotContainer.maArcadeSub.setRaw(-0.6, -0.6);         ///REALLY ONLY NEED BACKUP (PROB USE GYROSCOPE)

      
    }
    */
    /*
    else if(time.get()>8.7 && time.get()<=8.8){
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    
    }
    */
    /*
    else if(time.get()>8.6 && time.get()<=8.7){
      RobotContainer.maArcadeSub.setRaw(-0.6, -0.6);         ///REALLY ONLY NEED BACKUP (PROB USE GYROSCOPE)

    }
    else if(time.get()>8.9 && time.get()<=9.0){     //8.5-8.6
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.mShooterSub.stopShooter();
    RobotContainer.mIntakeSub.intakeStop();
    RobotContainer.mShooterSub.setShooterPower();
    }
    else if(time.get()>11 && time.get()<=11.1){
    RobotContainer.mTransportSub.toShooter();
    }
    else if(time.get()>13.0 && time.get()<=15){
      RobotContainer.mShooterSub.stopShooter();
      RobotContainer.mTransportSub.stopTransport();
      RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
      RobotContainer.mArmSub.stopArm();
      RobotContainer.mIntakeSub.intakeStop();
    }
*/
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.mShooterSub.stopShooter();
    RobotContainer.mShooterSub.stopShooter();
    RobotContainer.mTransportSub.stopTransport();
    RobotContainer.maArcadeSub.setRaw(0.0, 0.0);
    RobotContainer.mArmSub.stopArm();
    RobotContainer.mIntakeSub.intakeStop();
    time.stop();
    RobotContainer.maArcadeSub.configRamp();
    RobotContainer.maArcadeSub.setBrake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   // return false;
   return (time.get()>=11.5);
  }
}
