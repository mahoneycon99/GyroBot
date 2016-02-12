package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
	private Talon leftSide;
	private Talon rightSide;
	private static DriveSubsystem instance;
	
	public DriveSubsystem(){
		leftSide = new Talon(RobotMap.leftSide);
		rightSide = new Talon(RobotMap.rightSide);
	}
	
	public double boundsCheck(double power){
		if(power>1) power=1;
		if(power<-1) power=-1;
		return power;
	}
	
	public void setPower(double power){
		leftSide.set(boundsCheck(power));
		rightSide.set(boundsCheck(power));
	}
	
	public void setLeft(double power){
		leftSide.set(boundsCheck(power));
		rightSide.set(boundsCheck(-power));
	}
	
	public void setRight(double power){
		leftSide.set(boundsCheck(-power));
		rightSide.set(boundsCheck(power));
	}
	
	public static DriveSubsystem getInstance(){
		if(instance==null) instance = new DriveSubsystem();
		return instance;
	}

    public void initDefaultCommand() {
        
    	
    }
}

