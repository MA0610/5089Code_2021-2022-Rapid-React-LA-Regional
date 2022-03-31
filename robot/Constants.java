// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

//ramp rate
public static double rampRateTimeout = 0.4;


//drive
public static int FLMotor = 0; //0
public static int BLMotor = 1;
public static int FRMotor = 2;
public static int BRMotor = 3;

//intake
public static int intakeMotor = 10;

//arm
public static int rightArm = 4; 
public static int leftArm = 6;
//shooter
public static int shooterMotor1 = 9;
public static int shooterMotor2 = 8;

//hang
public static int hangMotor1 = 11;   //left
public static int hangMotor2 = 12;   //right

//transport 
public static int transportMotor1 = 5;
public static int transportMotor2 = 7;



//compressor
public static int Compressor = 0;

//solenoid 
public static int Extend = 1, Retract = 6;
public static int twoExtend = 0, twoRetract = 7;
public static int hangLockLeftExtend = 2, hangLockLeftRetract = 5;
public static int hangLockRightExtend = 3, hangLockRightRetract = 4;

//controllers
public static int driver = 0;
public static int coDriver = 1;

//airplane test
public static int testForward = 2;
public static int testTurn = 3;

}
