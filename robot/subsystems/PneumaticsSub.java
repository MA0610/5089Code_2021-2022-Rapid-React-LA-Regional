// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSub extends SubsystemBase {
  /** Creates a new PneumaticsSub. */
  Compressor Compressor;
  DoubleSolenoid IN_OUT, Piston, LockHangLeft, LockHangRight;
  boolean Trigger;
  public PneumaticsSub() {


    IN_OUT = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,Constants.Extend,Constants.Retract);

    Piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,Constants.twoExtend,Constants.twoRetract);

    LockHangLeft = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.hangLockLeftExtend,Constants.hangLockLeftRetract);

    LockHangRight = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.hangLockRightExtend, Constants.hangLockRightRetract);
  }

  public void Compressor()
  {
    boolean pressureSwitch = Compressor.getPressureSwitchValue();
    
    if(pressureSwitch)
    {
      Compressor.start();
      //Compressor.enableDigital();
    }else
    {
      Compressor.stop();
      //Compressor.disable();
    }
  }

  public void Extend()
  {
  IN_OUT.set(Value.kForward);
  Piston.set(Value.kForward);
    Trigger = true;
  }

  public void Retract()
  {
   IN_OUT.set(Value.kReverse);
   Piston.set(Value.kReverse);

    Trigger = true;
  }

  public void LockLeft()
  {
    LockHangLeft.set(Value.kForward);
    Trigger = true;
  }

  public void UnlockLeft()
  {
    LockHangLeft.set(Value.kReverse);
    Trigger = true;
  }
  
  public void LockRight(){
    LockHangRight.set(Value.kForward);
    Trigger = true;
  }

  public void UnlockRight(){
    LockHangRight.set(Value.kReverse);
    Trigger = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
