/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intsys16.gamelogic.JSONparser;
import org.intsys16.gamelogic.FieldControl.Coordinate;
import org.intsys16.gamelogic.FieldControl.Direction;
import org.intsys16.gamelogic.RobotsControl.Scores;

/**
 *
 * @author Daria Artemova
 */
public class robotsInfo {
    private String rName;
    private Coordinate coords;
    private Direction direction;
    private int health;
    private Scores score;
    robotsInfo(){
        
    }
    robotsInfo(String n, Coordinate c, Direction d, int hp, Scores s){
        rName = n;
        coords = c;
        direction = d;
        health = hp;
        score = s;
    }
    public String getRobotName(){
        return rName;
    }
    public Coordinate getRobotCoords(){
        return coords;
    }
    public Direction getRobotDirection(){
        return direction;
    }
    public int getRobotHealth(){
        return health;
    }
    public Scores getRobotScore(){
        return score;
    }
    public void setRobotName(String n){
        rName = n;
    }
    public void setRobotCoords(Coordinate c){
        coords = c;
    }
    public void setRobotDirection(Direction d){
        direction = d;
    }
    public void setRobotHealth(int hp){
        health = hp;
    }
    public void setRobotScore(Scores s){
        score = s;
    }  
}