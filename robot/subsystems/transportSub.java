// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class transportSub extends SubsystemBase {
  /** Creates a new transportSub. */
  VictorSPX transport1,transport2;
  public transportSub() {

    transport1 = new VictorSPX(Constants.transportMotor1);
    transport2 = new VictorSPX(Constants.transportMotor2);

  }
  public void awayShooter(){
   transport1.set(ControlMode.PercentOutput, 0.5);   //0.4 
   transport2.set(ControlMode.PercentOutput, -0.5);  //-0.4
  }
  public void toShooter(){
    transport1.set(ControlMode.PercentOutput, -0.65); //-0.9
    transport2.set(ControlMode.PercentOutput, 0.65); //0.9
  }
  public void stopTransport(){
    transport1.set(ControlMode.PercentOutput, 0.0); 
    transport2.set(ControlMode.PercentOutput, 0.0); 

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
