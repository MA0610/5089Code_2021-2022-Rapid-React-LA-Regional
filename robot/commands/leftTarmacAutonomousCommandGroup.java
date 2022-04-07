// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class leftTarmacAutonomousCommandGroup extends SequentialCommandGroup {
  /** Creates a new leftTarmacAutonomousCommandGroup. */
  public leftTarmacAutonomousCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    /*
    Pre-conditions: robot will be placed right in front of the hub with its back facing the ball of your color
    Description: this will shoot its' preload cargo, backup,
    turn right until it faces the cargo that was behind it, and it will drive forward and intake the ball
    */
    addCommands(new shooterAutonomousCommand(),new encoderCommand(-4, -4),new encoderCommand(7, -7),new driveAndIntake(4, 4));
  }
}
