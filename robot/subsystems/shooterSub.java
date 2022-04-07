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


//shooter1.setNeutralMode(NeutralMode.Coast);
//shooter2.setNeutralMode(NeutralMode.Coast);



shooter1.setNeutralMode(NeutralMode.Brake);
shooter2.setNeutralMode(NeutralMode.Brake);

  }

 public void setShooterPower(){
   
//shooter1.setNeutralMode(NeutralMode.Coast);
//shooter2.setNeutralMode(NeutralMode.Coast);

  shooter1.set(ControlMode.PercentOutput, 0.45); //speed 0.33 for shooter angle that needed to be like 1.5 ft away from hub
shooter2.set(ControlMode.PercentOutput, 0.45);    //speed 0.42 BEFORE SHOOTER WAS SHOOTING BACKWARDS (8 inches away from hub)
                                                  //speed 0.45 backward shooter LA (unknown distance from hub)
 } 
public void lowShooter(){
  shooter1.set(ControlMode.PercentOutput, 0.22); //speed 20 seemed good for comp field
  shooter2.set(ControlMode.PercentOutput, 0.22);   //0.23 backward shooter LA first value (seemed a bit to high)\
                                                    //0.27 seemed to high (hit top most of time)
}

public void stopShooter(){
  shooter1.set(ControlMode.PercentOutput, 0.0);
  shooter2.set(ControlMode.PercentOutput, 0.0);
}

public void powerShooter(double power){
  shooter1.set(ControlMode.PercentOutput, power);
  shooter2.set(ControlMode.PercentOutput, power);
}

public void stopSpinning(){

//shooter1.setNeutralMode(NeutralMode.Brake);
//shooter2.setNeutralMode(NeutralMode.Brake);

//shooter1.set(ControlMode.PercentOutput, 0.0);
//shooter2.set(ControlMode.PercentOutput, 0.0);


}
public void keepBallIn(){
//shooter1.setNeutralMode(NeutralMode.Brake);
//shooter2.setNeutralMode(NeutralMode.Brake);

shooter1.set(ControlMode.PercentOutput, -0.1);
shooter2.set(ControlMode.PercentOutput, -0.1);

}
public void setBrake(){
  //shooter1.setNeutralMode(NeutralMode.Brake);
  //shooter2.setNeutralMode(NeutralMode.Brake);
}

public void setCoast(){
  //shooter1.setNeutralMode(NeutralMode.Coast);
//shooter2.setNeutralMode(NeutralMode.Coast);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
