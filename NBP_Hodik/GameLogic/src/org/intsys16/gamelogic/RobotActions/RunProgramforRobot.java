/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intsys16.gamelogic.RobotActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "org.intsys16.gamelogic.RobotActions.RunProgramforRobot"
)
@ActionRegistration(
        iconBase = "org/intsys16/gamelogic/RobotActions/1.png",
        displayName = "#CTL_RunProgramforRobot"      
)
@ActionReference(path = "Menu/Robot", position = 3333)
@Messages("CTL_RunProgramforRobot=Выполнить программу")
public final class RunProgramforRobot implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
