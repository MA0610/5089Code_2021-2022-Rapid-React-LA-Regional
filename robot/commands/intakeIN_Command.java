// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class intakeIN_Command extends CommandBase {
  /** Creates a new intakeCommand. */
 // CANSparkMax intakeMotor;
 DigitalInput bottomLimitSwitch = new DigitalInput(9);

  public intakeIN_Command() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mTransportSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //RobotContainer.mArmSub.armIn();
    RobotContainer.mIntakeSub.intakeIn();
    RobotContainer.mTransportSub.toShooter();
/*
    if(bottomLimitSwitch.get()==false){
      RobotContainer.mArmSub.stopArm();
    }
    else RobotContainer.mArmSub.armIn();
*/
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mIntakeSub.intakeStop();
//RobotContainer.mArmSub.stopArm();
RobotContainer.mTransportSub.stopTransport();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
