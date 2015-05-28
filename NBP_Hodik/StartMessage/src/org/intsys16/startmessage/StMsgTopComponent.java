/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intsys16.startmessage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.intsys16.startmessage//StMsg//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "StMsgTopComponent",
        iconBase = "org/intsys16/startmessage/stpage24.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "properties_st", openAtStartup = true)
@ActionID(category = "Window", id = "org.intsys16.startmessage.StMsgTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StMsgAction",
        preferredID = "StMsgTopComponent"
)
@Messages({
    "CTL_StMsgAction=Show start message",
    "CTL_StMsgTopComponent=Start Message",
    "HINT_StMsgTopComponent=This is a Start Message window",
    /* for controller class */
    "CTL_StartText=The Earth is in danger, "
            + "and Robots will be sent to "
            + "the newly found planets in search "
            + "of a life. Are you able to write "
            + "appropriate programs for them so "
            + "they could succeed and save "
            + "the inhabitans of the Earth?"
})
public final class StMsgTopComponent extends TopComponent {

    private static JFXPanel fxPanel;
    private StMessageWindowController controller;
    
    public StMsgTopComponent() {
        initComponents();
        setName(Bundle.CTL_StMsgTopComponent());
        setToolTipText(Bundle.HINT_StMsgTopComponent());        
        setLayout(new BorderLayout());
        /** @todo why none of them works (even via windows manager in controller) */
//        setBounds(new Rectangle(getX() + 100, getY(), 180, getHeight()));
//        setSize(new Dimension(180, getHeight()))     
        init();     
    }
    
    public void init() {
        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);        
        Platform.setImplicitExit(false);
        Platform.runLater(() -> createScene());      
    }
    
    private void createScene() {
        try {
            URL location = getClass().getResource("StMessageWindow.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            Parent root = (Parent) fxmlLoader.load(location.openStream());
            fxPanel.setScene(new Scene(root));
            controller = (StMessageWindowController) fxmlLoader.getController();

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
