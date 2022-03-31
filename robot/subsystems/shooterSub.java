// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooterSub extends SubsystemBase {
  /** Creates a new shooterSub. */
  TalonFX shooter1,shooter2;
  public shooterSub() {
shooter1 = new TalonFX(Constants.shooterMotor1);
shooter2 = new TalonFX(Constants.shooterMotor2);


shooter1.setNeutralMode(NeutralMode.Coast);
shooter2.setNeutralMode(NeutralMode.Coast);



  }

 public void setShooterPower(){
   
shooter1.setNeutralMode(NeutralMode.Coast);
shooter2.setNeutralMode(NeutralMode.Coast);

  shooter1.set(ControlMode.PercentOutput, 0.42); //speed 33 for shooter angle that needed to be like 1.5 ft away from hub
shooter2.set(ControlMode.PercentOutput, 0.42);
 } 
public void lowShooter(){
  shooter1.set(ControlMode.PercentOutput, 0.23); //speed 20 seemed good for comp field
  shooter2.set(ControlMode.PercentOutput, 0.23);
}

public void stopShooter(){
  shooter1.set(ControlMode.PercentOutput, 0.0);
  shooter2.set(ControlMode.PercentOutput, 0.0);
}

public void powerShooter(double power){
  shooter1.set(ControlMode.PercentOutput, power);
  shooter2.set(ControlMode.PercentOutput, power);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
