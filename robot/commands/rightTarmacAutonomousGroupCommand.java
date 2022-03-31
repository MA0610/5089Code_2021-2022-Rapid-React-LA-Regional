// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class rightTarmacAutonomousGroupCommand extends SequentialCommandGroup {
  /** Creates a new autonomousOne. */
  public rightTarmacAutonomousGroupCommand() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    /*
    Pre-conditions: robot must be right in front of hub, and be on "right tarmac" (look at game manual picture page 42)
    Description: this autonomous will shoot the ball, back up, turn to face the ball of your color and then grab it
    */
    addCommands(new encoderCommand(2, 2));
      //new shooterAutonomousCommand(),new encoderCommand(-5.0, -5.0),new encoderCommand(-7, 7),new driveAndIntake(4, 4));
  }
}
