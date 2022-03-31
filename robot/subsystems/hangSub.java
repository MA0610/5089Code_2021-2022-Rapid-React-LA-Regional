// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class hangSub extends SubsystemBase {
  /** Creates a new hangSub. */
  CANSparkMax hang1,hang2;
  public hangSub() {

  hang1 = new CANSparkMax(Constants.hangMotor1,MotorType.kBrushless);
  hang2 = new CANSparkMax(Constants.hangMotor2,MotorType.kBrushless);


  hang1.setIdleMode(IdleMode.kBrake);
  hang2.setIdleMode(IdleMode.kBrake);

//check to see if current Limit is correct for neo type
  hang1.setSmartCurrentLimit(60);
  hang2.setSmartCurrentLimit(60);


  }

  public void hangUp(){
  hang1.set(1.0);
  hang2.set(-1.0);
 // System.out.println("left hang current"+hang2.getOutputCurrent());
 // System.out.println("right hang current"+hang1.getOutputCurrent());
  }
  /*
  public void rightHangUp(){
    hang2.set(1.0);
  }
  public void leftHangUp(){
    hang1.set(-1.0);
  }
  public void rightHangDown(){
    hang2.set(-1.0);
  }
  public void leftHangDown(){
    hang1.set(1.0);
  }
*/
  
  public void hangDown(){
    hang1.set(-1.0);
    hang2.set(1.0);
   // System.out.println("left hang current"+hang2.getOutputCurrent());
   // System.out.println("right hang current"+hang1.getOutputCurrent());
  }
  
  public void hangStop(){
    hang1.set(0.0);
    hang2.set(0.0);

  }

  public void rightHangStop(){
    hang1.set(0.0);
  }
  public void leftHangStop(){
    hang2.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
