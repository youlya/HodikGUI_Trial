/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intsys16.editorwindow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.intsys16.GameObjectUtilities.AbstractProgram;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.Lookups;
import org.openide.windows.TopComponent;

/**
 *
 * @author Julia
 */
public class ProgramNode extends AbstractProgram implements Serializable, Lookup.Provider {
    private String progName;
    private StringProperty progText = new SimpleStringProperty(this, "programText", "");
    private String path;
    private Boolean state;
    private Lookup lookup;
    TopComponent editor;
    
    public ProgramNode(String progName, String progText, String path) {
        this.progName = progName;
        this.progText.set(progText);
        this.path = path;
        this.state = false;
        lookup = Lookups.singleton(this);
    }
    @Override
    public ArrayList<String> getSequence(){
        return new ArrayList<String>(Arrays.asList(getProgramText().split("\n")));
    }
    @Override
    public String getProgramName() {
        return progName;
    }
    @Override
    public String getProgramPath() {
        return path;
    }
        @Override
    public void setDebugStat(Boolean state){
        this.state = state;
    }
    @Override
    public Boolean getDebugStat(){
        return state;
    }
    @Override
    public void setProgramPath(String path) {
        this.path = path;
    }
    @Override
    public void setEditorTC(TopComponent editor) {
        this.editor = editor;
    }
    @Override
    public TopComponent getEditorTC() {
        return editor;
    }
    @Override
    public String getProgramText() {
        return progText.get();
    }
    @Override
    public void setProgramName(String progName) {
        this.progName = progName;
    }
    @Override
    public void  setProgramText(String progText) {
        this.progText.set(progText);
    }
    @Override
    public void addLineToProgram(String line) {
        this.progText.set(getProgramText() + "\n" + line);
        
    }
    @Override
    public Lookup getLookup() {
        return lookup;
    }
    @Override
    public StringProperty programTextProperty() { 
       // progText.toString().toLowerCase();

        return progText; 
    }
    
    @Override
    public StringProperty setProgramTextProperty(String str) { 
        progText.setValue(str);
        return progText;
    }
    
}
