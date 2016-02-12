package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetAngle extends Command {
	
	private DriveSubsystem drive;
	private int angle, curangle, tolerance = 3;

    public SetAngle(int angle) {
        drive = DriveSubsystem.getInstance();
        requires(drive);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO set curangle to current angle
    	if(angle>curangle) drive.setLeft(0.25);
    	else drive.setRight(0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return curangle-angle<tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.setPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
