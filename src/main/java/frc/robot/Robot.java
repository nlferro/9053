// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
* The VM is configured to automatically run this class, and to call the
functions corresponding to
* each mode, as described in the TimedRobot documentation. If you change
the name of this class or
* the package after creating this project, you must also update the
manifest file in the resource
* directory.
*/
public class Robot extends TimedRobot {
public static final int kResourceType_RevSparkMaxCAN;
private CANSparkMax m_leftmotor1 = new CANSparkMax(2, MotorType.kBrushed);
private CANSparkMax m_rightmotor1 = new CANSparkMax(3,
MotorType.kBrushed);
private CANSparkMax m_leftatrasmotor2 = new CANSparkMax(10,
MotorType.kBrushed);
private CANSparkMax m_rightatrasmotor2 = new CANSparkMax(4,
MotorType.kBrushed);
private Spark m_gancho1 = new Spark(4); //der
private Spark m_gancho2 = new Spark(5); //izq
private CANSparkMax m_bandas1 = new CANSparkMax(6, MotorType.kBrushed);//arriba
private CANSparkMax m_bandas2 = new CANSparkMax(7,
MotorType.kBrushed); //abajo
public Robot() {
}
public Robot(double period) {
super(period);
}
private Joystick driverJoystick = new Joystick(0);
private Joystick operatorJoystick = new Joystick(1);
private double startTime;
/**
* This function is run when the robot is first started up and should be
used for any
* initialization code.
*/
@Override
public void robotInit() {
//m_rightDrive.setInverted(true);
}
/** This function is run once each time the robot enters autonomous mode.
*/
@Override
public void autonomousInit() {
startTime = Timer.getFPGATimestamp();
}
/** This function is called periodically during autonomous. */
@Override
public void autonomousPeriodic() {
double time = Timer.getFPGATimestamp();
if (time - startTime < 2.5){
m_leftmotor1.set(0.4);
m_rightmotor1.set(-0.4);
m_leftatrasmotor2.set(0.4);
m_rightatrasmotor2.set(-0.4);


} else {
    m_leftmotor1.set(0);
    m_rightmotor1.set(0);
    m_leftatrasmotor2.set(0);
    m_rightatrasmotor2.set(0);
}
}
/** This function is called once each time the robot enters teleoperated
mode. */
@Override
public void teleopInit() {}
/** This function is called periodically during teleoperated mode. */
@Override
public void teleopPeriodic() {
//chassis
double speed = driverJoystick.getRawAxis(5)* 0.6;
double turn = -driverJoystick.getRawAxis(4) * 0.7;
double vel = driverJoystick.getRawAxis(5)* 0.6;
double rotar = -driverJoystick.getRawAxis(4) * 0.7;
double speed1 = driverJoystick.getRawAxis(5)* 0.6;
double turn1 = -driverJoystick.getRawAxis(4) * 0.7;
double vel1 = driverJoystick.getRawAxis(5)* 0.6;
double rotar1 = -driverJoystick.getRawAxis(4) * 0.7;
// motores de los ganchos
double adelante =-operatorJoystick .getRawAxis(2)*0.5;
double atras = -operatorJoystick .getRawAxis(3)*0.5;
double adelante2 = operatorJoystick.getRawAxis(2)*0.5;
double atras2 = operatorJoystick.getRawAxis(3)*0.5;
//bandas sparkmax (se debe cambiar de axes a botones)
double arriba =-operatorJoystick .getRawAxis(2)*0.5;
double abajo = -operatorJoystick .getRawAxis(3)*0.5;
double arriba1 = operatorJoystick.getRawAxis(2)*0.5;
double abajo1 = operatorJoystick.getRawAxis(3)*0.5;
//chasis
double left = speed + turn;
double right = turn - speed;
double izq = vel + rotar ;
double dere = rotar - vel ;
double left3 = speed1 + turn1;
double right3 = turn1 - speed1;
double izq3 = vel1 + rotar1 ;
double dere3 = rotar1 - vel1;
//CHASSIS
m_leftmotor1.set(left);
m_leftmotor1.set(left);
m_rightmotor1.set(right);
m_rightmotor1.set(right);
m_leftmotor1.set(izq);
m_leftmotor1.set(izq);
m_rightmotor1.set(dere);
m_rightmotor1.set(dere);
// motores de atras del chasis
m_leftatrasmotor2.set(left3);
m_leftatrasmotor2.set(left3);
m_rightatrasmotor2.set(right3);
m_rightatrasmotor2.set(right3);
m_leftatrasmotor2.set(izq3);
m_leftatrasmotor2.set(izq3);
m_rightatrasmotor2.set(dere3);
m_rightatrasmotor2.set(dere3);
// motores del gancho
double adel = adelante+ atras ;
double atra= atras- adelante ;
double adels = adelante2 + atras2 ;
double atrass= atras2- adelante2 ;
// bandas
double arri = arriba+ abajo ;
double aba= abajo- arriba ;
double arri1 = arriba1 + abajo1 ;
double aba1= abajo1- arriba1 ;
//m_adelantemotor1.set(adel);
m_gancho1.set(adel);
m_gancho1.set (atra);
m_gancho2.set(atrass);
m_gancho2.set(adels);
// badnas
m_bandas1.set(arri);
m_bandas1.set (aba);
m_bandas2.set(arri1);
m_bandas2.set(aba1);
//m_adelantemotor2.set(adels);
//m_adelantemotor2.set(atrass);
//m_adelantemotor2.set(atrass);
//martDashboard.putNumber("turn", turn);
//SmartDashboard.putNumber("speed", speed);
// SmartDashboard.putNumber("der", right);
//SmartDashboard.putNumber("izq", left);
}
/** This function is called once each time the robot enters test mode. */
@Override
public void testInit() {}
/** This function is called periodically during test mode. */
@Override public void testPeriodic() {}
}
