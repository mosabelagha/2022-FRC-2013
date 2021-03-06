/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Attack3;
import org.usfirst.frc2022.Utils;

/**
 *
 * @author Emma Sloan
 */
public class ShooterCommand extends CommandBase {
    
    Attack3 attack3;
    double speed;
    
    public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        attack3 = oi.getAttack3();
        speed = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.setShooter(0);//stops motor by setting the speed to 0
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(attack3.GetButton(8).get()) {
            speed += .01;
        } else if (attack3.GetButton(6).get()) {
            speed -= .01;
        }
        speed = Utils.clamp(speed, 1, 0);
        shooter.setShooter(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.setShooter(0);
    }
}
