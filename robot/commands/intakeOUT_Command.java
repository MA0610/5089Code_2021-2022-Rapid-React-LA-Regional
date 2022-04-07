// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class intakeOUT_Command extends CommandBase {
  /** Creates a new intakeOUT_Command. */
  DigitalInput topLimitSwitch = new DigitalInput(8);

  public intakeOUT_Command() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mArmSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.mIntakeSub.intakeOut();
  //  RobotContainer.mArmSub.armOut();
  /*  
    if(topLimitSwitch.get()==false){
      RobotContainer.mArmSub.stopArm();
    }
    else RobotContainer.mArmSub.armOut();
    */
      }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
RobotContainer.mIntakeSub.intakeStop();
//RobotContainer.mArmSub.stopArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
